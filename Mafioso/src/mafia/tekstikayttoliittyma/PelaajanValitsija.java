/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.tekstikayttoliittyma;

import mafia.sovelluslogiikka.*;
import java.util.*;

/**
 *
 * @author Arto
 */
public class PelaajanValitsija implements PelaajanValitseva {

    private Scanner lukija;

    public PelaajanValitsija() {
        lukija = new Scanner(System.in);
    }

    public Pelaaja valitsePelaaja(ArrayList<Pelaaja> pelaajat) {
        Pelaaja valittu = null;
        while (valittu == null) {
            System.out.println("Valitse pelaaja");
            String nimi = lukija.nextLine();
            for (Pelaaja pelaaja : pelaajat) {
                if (pelaaja.getNimi().equals(nimi)) {
                    valittu = pelaaja;
                }
            }
        }
        return valittu;
    }
}
