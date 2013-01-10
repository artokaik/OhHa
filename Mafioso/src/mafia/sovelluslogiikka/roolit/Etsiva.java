/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.sovelluslogiikka.roolit;

import java.util.ArrayList;
import mafia.sovelluslogiikka.Pelaaja;
import mafia.sovelluslogiikka.Yo;


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
     *
     * @param yo
     * @return
     */
    public String getRooliSelitys(Yo yo){
        return "Olet etsivä, valitse pelaaja jonka haluat tarkastaa?";
    }

    /**
     *
     * @param yo
     * @param pelaaja 
     * @return  
     */
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
     *
     * @param pelaajat
     * @param itse
     * @return
     */
    public ArrayList<Pelaaja> getVaihtoehdot(ArrayList<Pelaaja> pelaajat, Pelaaja itse){
        ArrayList<Pelaaja> vaihtoehdot = (ArrayList<Pelaaja>) pelaajat.clone();
        vaihtoehdot.remove(itse);
        return vaihtoehdot;
    }
    
    
    public Etsiva kopioi(){
        return new Etsiva();
    }

    /**
     *
     * @return
     */
    public boolean onkoPahis() {
        return pahis;
    }

    /**
     *
     * @return
     */
    public String getRoolinimi() {
        return this.roolinimi;
    }
    
    @Override
    public String toString() {
        return this.roolinimi;
    }
}
