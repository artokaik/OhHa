/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.sovelluslogiikka;

/**
 *
 * @author Arto
 */
import java.util.*;
import mafia.kayttoliittyma.Ohjaus;

public class Aanestys {

    private ArrayList<Aani> aanet;
    private ArrayList<Pelaaja> ehdokkaat;

    public Aanestys(ArrayList<Pelaaja> ehdokkaat) {
        this.ehdokkaat = ehdokkaat;
        this.aanet = new ArrayList<Aani>();

    }

    public void lisaaAani(Pelaaja aanestaja, Pelaaja aanestetty) {
        Aani aani = new Aani(aanestaja, aanestetty);
        aanet.add(aani);
    }

    public Pelaaja haeEhdokas(String nimi) {
        for (Pelaaja pelaaja : ehdokkaat) {
            if (pelaaja.getNimi().equals(nimi)) {
                return pelaaja;
            }
        }
        return null;
    }

    public ArrayList<Pelaaja> getEhdokkaat() {
        return ehdokkaat;
    }

    private HashMap<Pelaaja, Integer> laskeTulokset() {
        HashMap<Pelaaja, Integer> tulokset = new HashMap<Pelaaja, Integer>();
        for (Aani aani : aanet) {
            if (tulokset.containsKey(aani.getAanestetty())) {
                tulokset.put(aani.getAanestetty(), tulokset.get(aani.getAanestetty()) + 1);
            } else {
                tulokset.put(aani.getAanestetty(), 1);
            }
        }
        return tulokset;
    }

    public ArrayList<Pelaaja> haeTulokset(int maara) {
        HashMap<Pelaaja, Integer> tulokset = laskeTulokset();
        int raja = this.laskeRaja(maara, tulokset);
        ArrayList<Pelaaja> jatkoon = new ArrayList<Pelaaja>();
        for (Pelaaja ehdokas : ehdokkaat) {
            if (tulokset.containsKey(ehdokas)) {
                if (tulokset.get(ehdokas) >= raja) {
                    jatkoon.add(ehdokas);
                }
            }
        }
        return jatkoon;
    }

    private int laskeRaja(int maara, HashMap<Pelaaja, Integer> tulokset) {
        Collection aanimaarat = tulokset.values();
        ArrayList<Integer> aanimaaria = new ArrayList<Integer>();
        for (Object object : aanimaarat) {
            aanimaaria.add((Integer) object);
        }
        Collections.sort(aanimaaria);
        int raja = aanimaaria.get(Math.max(0, aanimaaria.size() - maara));
        return raja;
    }

    public void suorita(ArrayList<Pelaaja> aanestajat, ArrayList<Pelaaja> ehdokkaat) {
        Ohjaus ohjaus = new Ohjaus();
        for (Pelaaja pelaaja : aanestajat) {
            Aani aani = ohjaus.aanesta(pelaaja, ehdokkaat);
            aanet.add(aani);
        }
    }

    @Override
    public String toString() {
        String tuloste = ehdokkaat + "\nÄänestäjä: äänestetty";
        for (Aani aani : aanet) {
            tuloste += aani + "\n";
        }
        return tuloste;

    }
}
