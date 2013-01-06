/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.sovelluslogiikka.peli;

import java.util.ArrayList;

/**
 *
 * @author Arto
 */
public class Saannot {

    private boolean paivaEnsin;
    private ArrayList<Integer> aanestykset;

    /**
     *
     */
    public Saannot() {
        paivaEnsin = true;
        aanestykset = new ArrayList<Integer>();
        aanestykset.add(2);
        aanestykset.add(1);
    }

    /**
     *
     * @return
     */
    public boolean getPaivaEnsin() {
        return paivaEnsin;
    }
    
    /**
     *
     * @return
     */
    public ArrayList<Integer> getAanestykset(){
        return aanestykset;
    }

    /**
     *
     */
    public void asetaPaivaEnsin() {
        paivaEnsin = true;
    }

    /**
     *
     */
    public void asetaYoEnsin() {
        paivaEnsin = false;
    }

    @Override
    public String toString() {
        String saannot = "";
        saannot += alkaakoPaivallaToString();
        saannot += aanestyksetToString();
        return saannot;
    }

    /**
     *
     * @return
     */
    public String alkaakoPaivallaToString() {
        String saannot = "";
        if (paivaEnsin) {
            saannot += "Peli alkaa päivällä.\n";
        } else {
            saannot += "Peli alkaa yöllä.\n";
        }
        return saannot;
    }
    
    /**
     *
     * @return
     */
    public String aanestyksetToString(){
        String saannot = "";
        saannot += "Jokaisena päivänä äänestyskierroksia on vähintään " + aanestykset.size() +"\n";
        if (aanestykset.size()>1){
            saannot += "Jokaisen äänestyskierroksen jälkeen pelaajia on jäljellä seuraavasti:\n";
            for (int i = 0; i < aanestykset.size(); i++) {
                int n = i+1;
                saannot+= n + ". kierros: " + aanestykset.get(i) +"\n";               
            }
        }
        return saannot;
    }
}
