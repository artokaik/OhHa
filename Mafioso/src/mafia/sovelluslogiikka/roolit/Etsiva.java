/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.sovelluslogiikka.roolit;

import mafia.kayttoliittyma.Ohjaus;
import mafia.sovelluslogiikka.Yo;


public class Etsiva implements Rooli {

    private final String roolinimi = "Etsivä";
    private final boolean pahis = false;

    public Etsiva() {
    }

    public void toimi(Yo yo) {
        Ohjaus ohjaus = new Ohjaus();
        ohjaus.etsivaToimii(yo.getPelaajat());
    }

    public boolean onkoPahis() {
        return pahis;
    }

    public String getRoolinimi() {
        return this.roolinimi;
    }
}
