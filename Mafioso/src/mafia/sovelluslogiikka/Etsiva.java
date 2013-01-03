/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.sovelluslogiikka;

import mafia.kayttoliittyma.Ohjaus;
import java.util.*;

public class Etsiva implements Rooli {

    private String roolinimi;
    private boolean pahis;

    public Etsiva() {
        roolinimi = "Etsivä";
        pahis = false;
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
