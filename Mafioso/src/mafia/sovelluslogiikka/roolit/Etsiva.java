/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.sovelluslogiikka.roolit;

import mafia.kayttoliittyma.Ohjaus;
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
     */
    public void toimi(Yo yo) {
        Ohjaus ohjaus = new Ohjaus();
        ohjaus.etsivaToimii(yo.getPelaajat());
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
