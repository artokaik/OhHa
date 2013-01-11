package mafia.sovelluslogiikka.sekalaista;

import mafia.sovelluslogiikka.sekalaista.Aani;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

/**
 * Äänestys-luokka kuvaa yhtä äänestyskierrosta. Oliomuuttujina ovat ehdokkaat 
 * (ArrayList<Pelaaja>), pelaajat, jotka eivät vielä ole äänestäneet ja annetut äänet (ArrayList<Aani>). Neljäs oliomuuttuja on jatkoon menevien minimimäärä, joka oletusarvoisesti on 1.
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
     * @param aanestajat 
     * @param ehdokkaat
     */
    public Aanestys(ArrayList<Pelaaja> aanestajat, ArrayList<Pelaaja> ehdokkaat) {
        this.aanestamatta = (ArrayList<Pelaaja>) aanestajat.clone();
        this.ehdokkaat = (ArrayList<Pelaaja>) ehdokkaat.clone();
        this.aanet = new ArrayList<Aani>();
        this.jatkoonMenijat = 1;
    }
    
    /**
     * 
     * @return
     */
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
     * Mikäli äänestäjä ei ole jo äänestänyt tässä äänestyksessä, lisää äänen, poistaa pelaajan aanestamatta-listalta ja palauttaa true. Muuten palauttaa false;
     * @param aanestaja
     * @param aanestetty
     * @return
     */
    public boolean lisaaAani(Pelaaja aanestaja, Pelaaja aanestetty) {
        if(aanestamatta.remove(aanestaja)){
            Aani aani = new Aani(aanestaja, aanestetty);
            aanet.add(aani);
            return true;
        }
        return false;
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
    

    
        /**
     * Laskee parametrina annetuista tuloksista äänimäärän, joka tarvitaan jatkoon menemiseen. Palauttaa tuon äänimäärän.
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
    


    
    @Override
    public String toString() {
        if (aanestamatta.size() > 0) {
            return "";
        }
        String tuloste = ehdokkaat + "\n" + "Äänestäjä: äänestetty"+"\n";
        for (Aani aani : aanet) {
            tuloste += aani + "\n";
        }
        
        tuloste += "Valittu: " + haeTulokset();
        return tuloste;
        
    }

    public void setJatkoonMenijat(int jatkoonMenijat) {
        this.jatkoonMenijat = jatkoonMenijat;
    }
}



