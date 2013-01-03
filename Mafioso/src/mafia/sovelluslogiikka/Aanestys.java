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
    
    public Pelaaja suorita(ArrayList<Pelaaja> pelaajat){
        Ohjaus ohjaus = new Ohjaus();
        for (Pelaaja pelaaja : pelaajat) {
            Aani aani = ohjaus.aanesta(pelaaja, pelaajat);
            aanet.add(aani);
        }
        for (Aani aani : aanet) {
            System.out.println(aani); 
        }
        return null;
    }
}
