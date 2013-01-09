package mafia.sovelluslogiikka;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import mafia.kayttoliittyma.Ohjaus;

/**
 * Äänestys-luokka kuvaa yhtä äänestyskierrosta. Oliomuuttujina ovat ehdokkaat 
 * (ArrayList<Pelaaja>), pelaajat, jotka eivät vielä ole äänestäneet ja annetut äänet (ArrayList<Aani>).
 *
 * @author Arto
 */
public class Aanestys {
    
    private ArrayList<Pelaaja> aanestamatta;
    private ArrayList<Aani> aanet;
    private ArrayList<Pelaaja> ehdokkaat;
    private int jatkoonMenijat;

    /**
     *
     * @param ehdokkaat
     */
    public Aanestys(ArrayList<Pelaaja> aanestajat, ArrayList<Pelaaja> ehdokkaat) {
        this.aanestamatta = (ArrayList<Pelaaja>) aanestajat.clone();
        this.ehdokkaat = (ArrayList<Pelaaja>) ehdokkaat.clone();
        this.aanet = new ArrayList<Aani>();
        this.jatkoonMenijat = 1;
    }
    
    public ArrayList<Pelaaja> getAanestamatta() {
        return aanestamatta;
    }
    
    /**
     * Pelauttaa ehdokkaat ilman parametrina annettua pelaaja. Toisin sanoen ehdokkaat, joita parametrina annettu pelaaja voi äänestää.
     * @param pelaaja
     * @return
     */
    public ArrayList<Pelaaja> getAanestettavat(Pelaaja pelaaja) {
        ArrayList<Pelaaja> aanestettavat = (ArrayList<Pelaaja>) ehdokkaat.clone();
        aanestettavat.remove(pelaaja);
        return aanestettavat;
    }

    /**
     *
     * @return
     */
    public ArrayList<Aani> getAanet() {
        return aanet;
    }

    /**
     * Mikäli äänestäjä ei ole jo äänestänyt tässä äänestyksessä, lisää äänen ja palauttaa true. Muuten palauttaa false;
     * @param aanestaja
     * @param aanestetty
     * @return
     */
    public boolean lisaaAani(Pelaaja aanestaja, Pelaaja aanestetty) {
        aanestamatta.remove(aanestaja);
        Aani aani = new Aani(aanestaja, aanestetty);
        for (Aani aani1 : aanet) {
            if (aani1.getAanestaja().equals(aani.getAanestaja())) {
                return false;
            }
        }
        aanet.add(aani);
        return true;
    }

    /**
     * Vaihtaa parametrina annetun äänestäjän antaman äänen parametrina annetulle pelaajalle. Palauttaa true jos onnistuu, muuten false.
     * @param aanestaja
     * @param aanestetty
     * @return
     */
    public boolean vaihdaAani(Pelaaja aanestaja, Pelaaja aanestetty) {
        for (Aani aani1 : aanet) {
            if (aani1.getAanestaja().equals(aanestaja)) {
                aani1.setAanestetty(aanestetty);
                return true;
            }
        }
        return false;
    }

    /**
     * Palauttaa parametrina annetun pelaajan saamien äänten lukumäärän.
     * @param pelaaja
     * @return
     */
    public int laskeAanimaara(Pelaaja pelaaja) {
        int maara = 0;
        for (Aani aani : aanet) {
            if (aani.getAanestetty().equals(pelaaja)) {
                maara++;
            }
        }
        return maara;
    }


    /**
     *
     * @return
     */
    public ArrayList<Pelaaja> getEhdokkaat() {
        return ehdokkaat;
    }
     /**
     * Palauttaa pelaajien äänimäärät HashMap<Pelaaja, Integer> -oliona.
     * @return
     */
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
     * Palauttaa ArrayListin pelaajista jotka menevät äänestyksestä jatkoon.
     * @param maara
     * @return
     */
    public ArrayList<Pelaaja> haeTulokset() {
        if (aanet.isEmpty()) {
            return ehdokkaat;
        }
        HashMap<Pelaaja, Integer> tulokset = laskeTulokset();
        int raja = this.laskeRaja(tulokset);
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
    
        public ArrayList<Pelaaja> haeTulokset(int maara) {
        if (aanet.isEmpty()) {
            return ehdokkaat;
        }
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
    
        /**
     * Palauttaa äänimäärän, joka tarvitaan jatkoon menemiseen.
     * @param tulokset
     * @return
     */
    private int laskeRaja(HashMap<Pelaaja, Integer> tulokset) {
        Collection aanimaarat = tulokset.values();
        ArrayList<Integer> aanimaaria = new ArrayList<Integer>();
        for (Object object : aanimaarat) {
            aanimaaria.add((Integer) object);
        }
        Collections.sort(aanimaaria);
        int raja = aanimaaria.get(Math.max(0, aanimaaria.size() - jatkoonMenijat));
        return raja;
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

//
    
    @Override
    public String toString() {
        if (aanestamatta.size() > 0) {
            return "";
        }
        String tuloste = ehdokkaat + "\nÄänestäjä: äänestetty";
        for (Aani aani : aanet) {
            tuloste += aani + "\n";
        }
        return tuloste;
        
    }
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
//     *
//     * @param aanestajat
//     * @param ehdokkaat
//     */
//    public void suorita(ArrayList<Pelaaja> aanestajat, ArrayList<Pelaaja> ehdokkaat) {
//        Ohjaus ohjaus = new Ohjaus();
//        for (Pelaaja pelaaja : aanestajat) {
//            Aani aani = ohjaus.aanesta(pelaaja, ehdokkaat);
//            aanet.add(aani);
//        }
//    }
