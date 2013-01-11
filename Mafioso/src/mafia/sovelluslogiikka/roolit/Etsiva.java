/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.sovelluslogiikka.roolit;

import java.util.ArrayList;
import mafia.sovelluslogiikka.sekalaista.Pelaaja;
import mafia.sovelluslogiikka.peli.Yo;


/**
 *Etsivä-luokka toteuttaa rajapinnan rooli. Etsivä on hyvisten puolella oleva hahmo, joka voi joka yö tarkistaa yhden pelaajan, jolloin ohjelma kertoo onko tarkistettu pelaaja Mafioso vai ei.
 * 
 * @author Arto
 */
public class Etsiva implements Rooli {

    private final String roolinimi = "Etsivä";
    private final boolean pahis = false;

    /**
     *
     */
    public Etsiva() {
    }
    
    /**
     * Palauttaa roolin selityksen String-muuttujana. Vaatii parametrikseen Yo-olion, mutta ei tee parametrilla mitään.
     * @param yo
     * @return
     */
    public String getRooliSelitys(Yo yo){
        return "Olet etsivä, valitse pelaaja jonka haluat tarkastaa?";
    }

    /**
     * Palauttaa tiedon siitä, onko parametrina annettu pelaaja hyvis vai pahis.
     * @param yo
     * @param pelaaja 
     * @return  
     */
    @Override
    public String toimi(Yo yo, Pelaaja pelaaja) {
        String tuloste = "";
        if(pelaaja.getRooli().onkoPahis()){
            tuloste += pelaaja.getNimi() + " on pahis!";
        } else {
            tuloste += pelaaja.getNimi() + " ei ole pahis!";
        }
        return tuloste;
    }
    
    /**
     * Ottaa parametrina annetusta pelaajalistasta kopion, poistaa kopiosta parametrina annetun pelaajan ja palauttaa näin saadun listan (listan pelaajista, jotka Etsivä voi tarkastaa)
     * @param pelaajat
     * @param itse
     * @return
     */
    @Override
    public ArrayList<Pelaaja> getVaihtoehdot(ArrayList<Pelaaja> pelaajat, Pelaaja itse){
        ArrayList<Pelaaja> vaihtoehdot = (ArrayList<Pelaaja>) pelaajat.clone();
        vaihtoehdot.remove(itse);
        return vaihtoehdot;
    }
    
    @Override
    public Etsiva kopioi(){
        return new Etsiva();
    }

    /**
     * 
     * @return
     */
    @Override
    public boolean onkoPahis() {
        return pahis;
    }

    /**
     *
     * @return
     */
    @Override
    public String getRoolinimi() {
        return this.roolinimi;
    }
    
    @Override
    public String toString() {
        return this.roolinimi;
    }
}
