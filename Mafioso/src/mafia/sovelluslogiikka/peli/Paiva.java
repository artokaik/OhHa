package mafia.sovelluslogiikka.peli;

import mafia.sovelluslogiikka.peli.Saannot;
import java.util.ArrayList;
import mafia.sovelluslogiikka.sekalaista.Aanestys;
import mafia.sovelluslogiikka.sekalaista.Pelaaja;

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
     *Konstruktori saa parametrinaan listan hengissä olevista pelaajista.
     * @param pelaajat
     */
    public Paiva(ArrayList<Pelaaja> pelaajat) {
        this.pelaajat = (ArrayList<Pelaaja>) pelaajat.clone();
        this.aanestykset = new ArrayList<Aanestys>();
        lynkattavat = new ArrayList<Pelaaja>();
    }
    
    /**
     * Lisää parametrina annetun Aanestyksen äänestyslistaan ja palauttaa true jos onnistuu, muuten false.
     * @param aanestys
     * @return
     */
    public boolean lisaaAanestys(Aanestys aanestys){
        return this.aanestykset.add(aanestys);
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