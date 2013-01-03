/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.sovelluslogiikka;

import java.util.ArrayList;

/**
 *
 * @author Arto
 */
public class Paiva implements Vaihe {

    private ArrayList<Pelaaja> pelaajat;
    private ArrayList<Aanestys> aanestykset;
    private ArrayList<Pelaaja> lynkattu;   //Tällä hetkellä vain yksi lynkataan, mutta tätä ehkä pystytään säätämään myöhemmin. Siksi ArrayList

    public Paiva(ArrayList<Pelaaja> pelaajat) {
        this.pelaajat = pelaajat;
        this.aanestykset = new ArrayList<Aanestys>();
        lynkattu = new ArrayList<Pelaaja>();
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

    public ArrayList<Pelaaja> pelaa(Saannot saannot) {
        ArrayList<Pelaaja> tapettavat = tappoAanestys(saannot);
        for (Pelaaja pelaaja : tapettavat) {
            pelaajat.remove(pelaaja);
            lynkattu.add(pelaaja);
        }
        ArrayList<Pelaaja> hengissa = (ArrayList<Pelaaja>) pelaajat.clone();
        return hengissa;
    }

    public ArrayList<Pelaaja> tappoAanestys(Saannot saannot) {
        ArrayList<Pelaaja> ehdokkaat = (ArrayList<Pelaaja>) this.pelaajat.clone();
        for (int i = 0; i < saannot.getAanestykset().size(); i++) {
            ehdokkaat = this.aanestysKierros(saannot.getAanestykset().get(i), ehdokkaat);
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
        tuloste += lynkattu;
        return tuloste;
    }
}
