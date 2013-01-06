
package mafia.sovelluslogiikka;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import mafia.kayttoliittyma.Ohjaus;

/**
 *Äänestys-luokka kuvaa yhtä äänestyskierrosta. Oliomuuttujina ovat ehdokkaat (ArrayList<Pelaaja>) ja annetut äänet (ArrayList<Aani>).
 * @author Arto
 */
public class Aanestys {

    private ArrayList<Aani> aanet;
    private ArrayList<Pelaaja> ehdokkaat;

    /**
     *
     * @param ehdokkaat
     */
    public Aanestys(ArrayList<Pelaaja> ehdokkaat) {
        this.ehdokkaat = ehdokkaat;
        this.aanet = new ArrayList<Aani>();
    }

    /**
     *
     * @return
     */
    public ArrayList<Aani> getAanet() {
        return aanet;
    }

    /**
     *
     * @param aanestaja
     * @param aanestetty
     * @return
     */
    public boolean lisaaAani(Pelaaja aanestaja, Pelaaja aanestetty) {
        Aani aani = new Aani(aanestaja, aanestetty);
        for (Aani aani1 : aanet) {
            if (aani1.getAanestaja().equals(aani.getAanestaja())){
                return false;
            }
        }
        aanet.add(aani);
        return true;
    }
    
    
    /**
     *
     * @param aanestaja
     * @param aanestetty
     * @return
     */
    public boolean vaihdaAani(Pelaaja aanestaja, Pelaaja aanestetty) {
        for (Aani aani1 : aanet) {
            if (aani1.getAanestaja().equals(aanestaja)){
                aani1.setAanestetty(aanestetty);
                return true;
            }
        }
        return false;
    }
    
    /**
     *
     * @param pelaaja
     * @return
     */
    public int laskeAanimaara(Pelaaja pelaaja){
        int maara = 0;
        for (Aani aani : aanet) {
            if (aani.getAanestetty().equals(pelaaja)){
                maara++;
            }
        }
        return maara;
    }
//
//    public Pelaaja haeEhdokas(String nimi) {
//        for (Pelaaja pelaaja : ehdokkaat) {
//            if (pelaaja.getNimi().equals(nimi)) {
//                return pelaaja;
//            }
//        }
//        return null;
//    }

    /**
     *
     * @return
     */
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

    /**
     *
     * @param maara
     * @return
     */
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

    /**
     *
     * @param aanestajat
     * @param ehdokkaat
     */
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
