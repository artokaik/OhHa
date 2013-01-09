package mafia.sovelluslogiikka;

import mafia.sovelluslogiikka.peli.Saannot;
import java.util.ArrayList;

/**
 *Paiva-luokka toteuttaa Vaihe-rajapinnan ja kuvaa toista pelin vaiheista (toinen on Yo). 
 * 
 * Oliomuuttujaan pelaajat (ArrayList<Pelaaja>) tallennetaan aluksi mukana olevat pelaajat. Kun päivän lopuksi yksi pelaajista poistetaan pelistä, tämä poistetaan myös pelaajat-listalta.
 * 
 * Oliomuuttujaan aanestykset (ArrayList<Aanestys>) tallennetaan lynkkausäänestyksen kierrokset. Säännöistä riippuen yhtenä päivänä äänestyksiä voi olla useita. 
 * 
 * Oliomuuttujaan lynkattavat (ArrayList<lynkattavat>) tallennetaan päivän aikana lynkattavat pelaajat. Lynkattavia on lähtökohtaisesti yksi, mutta listan käyttäminen mahdollistaa erilaisten sääntövarianttien toteuttamisen tulevaisuudessa.
 * @author Arto
 */
public class Paiva implements Vaihe {

    private ArrayList<Pelaaja> pelaajat;
    private ArrayList<Aanestys> aanestykset;
    private ArrayList<Pelaaja> lynkattavat;   //Tällä hetkellä vain yksi lynkataan, mutta tätä ehkä pystytään säätämään myöhemmin. Siksi ArrayList

    /**
     *
     * @param pelaajat
     */
    public Paiva(ArrayList<Pelaaja> pelaajat) {
        this.pelaajat = (ArrayList<Pelaaja>) pelaajat.clone();
        this.aanestykset = new ArrayList<Aanestys>();
        lynkattavat = new ArrayList<Pelaaja>();
    }

    /**
     * Poistaa lynkattaviksi asetetut pelaajat pelaaja-listasta.
     */
    public void tapaLynkattavat(){
        for (Pelaaja pelaaja : lynkattavat) {
            pelaajat.remove(pelaaja);
        }
    }

    
    /**
     * Palauttaa Yo-olion, johon on lisätty kaikki hengissä olevat pelaajat.
     * @return
     */
    public Yo luoSeuraavaVaihe(){
        Yo yo = new Yo(pelaajat);
        return yo;
    }

    @Override
    public String toString() {
        String tuloste = "";
        int n = 1;
        for (Aanestys aanestys : aanestykset) {
            tuloste += "Äänestys " + n + ":\n";
            tuloste += aanestys + "\n";
        }
        tuloste += "\nJäljellä olevat pelaajat:\n";
        tuloste += pelaajat + "\n";
        tuloste += "Seuraavaksi vuorossa yö.";
        return tuloste;
    }

    /**
     * Palayttaa lynkatut pelaajat Stringinä.
     * @return
     */
    public String kerroTapahtumat() {
        String tuloste = "Tapetut pelaajat:\n";
        tuloste += lynkattavat;
        return tuloste;
    }

    //setterit ja getterit
    /**
     *
     * @param pelaajat
     */
    public void setPelaajat(ArrayList<Pelaaja> pelaajat) {
        this.pelaajat = pelaajat;
    }

    /**
     *
     * @param aanestykset
     */
    public void setAanestykset(ArrayList<Aanestys> aanestykset) {
        this.aanestykset = aanestykset;
    }

    /**
     *
     * @param lynkattu
     */
    public void setLynkattu(ArrayList<Pelaaja> lynkattu) {
        this.lynkattavat = lynkattu;
    }

    /**
     *
     * @return
     */
    public ArrayList<Pelaaja> getLynkattu() {
        return lynkattavat;
    }

    /**
     *
     * @return
     */
    public ArrayList<Aanestys> getAanestykset() {
        return this.aanestykset;
    }

    /**
     *
     * @return
     */
    public ArrayList<Pelaaja> getPelaajat() {
        return pelaajat;
    }
    

    
}
//
//    /**
//     *
//     * @param saannot
//     * @return
//     */
//    public ArrayList<Pelaaja> pelaa(Saannot saannot) {
//        lynkattavat = lynkkausAanestys(saannot);
//        tapaLynkattavat();
//        ArrayList<Pelaaja> hengissa = (ArrayList<Pelaaja>) pelaajat.clone();
//        return hengissa;
//    }
//    
//    public Pelaaja haePelaaja(String nimi) {
//        for (Pelaaja pelaaja : pelaajat) {
//            if (pelaaja.getNimi().equals(nimi)) {
//                return pelaaja;
//            }
//        }
//        return null;
//    }

//    /**
//     *
//     * @param saannot
//     * @return
//     */
//    public ArrayList<Pelaaja> lynkkausAanestys(Saannot saannot) {
//        ArrayList<Pelaaja> ehdokkaat = (ArrayList<Pelaaja>) this.pelaajat.clone();
//        for (int i = 0; i < saannot.getAanestykset().size(); i++) {
//            int valittavienMaara = saannot.getAanestykset().get(i);
//            ehdokkaat = this.aanestysKierros(valittavienMaara, ehdokkaat);
//        }
//        while (ehdokkaat.size() > 1) {
//            ehdokkaat = this.aanestysKierros(1, ehdokkaat);
//        }
//        return ehdokkaat;
//    }
//
//    /**
//     *
//     * @param maara
//     * @param ehdokkaat
//     * @return
//     */
//    public ArrayList<Pelaaja> aanestysKierros(int maara, ArrayList<Pelaaja> ehdokkaat) {
//        Aanestys aanestys = new Aanestys(pelaajat, ehdokkaat);
//        aanestys.suorita(pelaajat, ehdokkaat);
//        ehdokkaat = aanestys.haeTulokset(maara);
//        aanestykset.add(aanestys);
//        return ehdokkaat;
//
//    }