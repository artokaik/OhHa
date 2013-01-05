package mafia.sovelluslogiikka;

import mafia.sovelluslogiikka.peli.Saannot;
import java.util.ArrayList;

public class Paiva implements Vaihe {

    private ArrayList<Pelaaja> pelaajat;
    private ArrayList<Aanestys> aanestykset;
    private ArrayList<Pelaaja> lynkattavat;   //Tällä hetkellä vain yksi lynkataan, mutta tätä ehkä pystytään säätämään myöhemmin. Siksi ArrayList

    public Paiva(ArrayList<Pelaaja> pelaajat) {
        this.pelaajat = pelaajat;
        this.aanestykset = new ArrayList<Aanestys>();
        lynkattavat = new ArrayList<Pelaaja>();
    }

    public ArrayList<Pelaaja> pelaa(Saannot saannot) {
        lynkattavat = tappoAanestys(saannot);
        tapaLynkattavat();
        ArrayList<Pelaaja> hengissa = (ArrayList<Pelaaja>) pelaajat.clone();
        return hengissa;
    }
    
    public void tapaLynkattavat(){
        for (Pelaaja pelaaja : lynkattavat) {
            pelaajat.remove(pelaaja);
        }
    }

    public ArrayList<Pelaaja> tappoAanestys(Saannot saannot) {
        ArrayList<Pelaaja> ehdokkaat = (ArrayList<Pelaaja>) this.pelaajat.clone();
        for (int i = 0; i < saannot.getAanestykset().size(); i++) {
            int valittavienMaara = saannot.getAanestykset().get(i);
            ehdokkaat = this.aanestysKierros(valittavienMaara, ehdokkaat);
        }
        while (ehdokkaat.size() > 1) {
            ehdokkaat = this.aanestysKierros(1, ehdokkaat);
        }
        return ehdokkaat;
    }

    public ArrayList<Pelaaja> aanestysKierros(int maara, ArrayList<Pelaaja> ehdokkaat) {
        Aanestys aanestys = new Aanestys(ehdokkaat);
        aanestys.suorita(pelaajat, ehdokkaat);
        ehdokkaat = aanestys.haeTulokset(maara);
        aanestykset.add(aanestys);
        return ehdokkaat;

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

    public String kerroTapahtumat() {
        String tuloste = "Tapetut pelaajat:\n";
        tuloste += lynkattavat;
        return tuloste;
    }

    //setterit ja getterit
    public void setPelaajat(ArrayList<Pelaaja> pelaajat) {
        this.pelaajat = pelaajat;
    }

    public void setAanestykset(ArrayList<Aanestys> aanestykset) {
        this.aanestykset = aanestykset;
    }

    public void setLynkattu(ArrayList<Pelaaja> lynkattu) {
        this.lynkattavat = lynkattu;
    }

    public ArrayList<Pelaaja> getLynkattu() {
        return lynkattavat;
    }

    public ArrayList<Aanestys> getAanestykset() {
        return this.aanestykset;
    }

    public ArrayList<Pelaaja> getPelaajat() {
        return pelaajat;
    }
    
//    public Pelaaja haePelaaja(String nimi) {
//        for (Pelaaja pelaaja : pelaajat) {
//            if (pelaaja.getNimi().equals(nimi)) {
//                return pelaaja;
//            }
//        }
//        return null;
//    }
    
}
