/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.sovelluslogiikka;

import java.util.ArrayList;

/**
 *
 * @author Arto
 */
public class Yo implements Vaihe {

    private ArrayList<Pelaaja> pelaajat;

    public Yo(ArrayList<Pelaaja> pelaajat) {
        this.pelaajat = pelaajat;
    }

    public void pelaa() {
        for (Pelaaja pelaaja : pelaajat) {
            pelaaja.getRooli().toimi(this);
        }
    }
}
