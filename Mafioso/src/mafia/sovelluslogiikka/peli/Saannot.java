/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.sovelluslogiikka.peli;

import java.util.ArrayList;

/**
 * Saannot-luokka tuo peliin muunneltavuutta.
 * Boolean-muuttuja paivaEnsin määrittää alkaako peli yöllä vai päivällä.
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



}
