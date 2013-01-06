/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.tekstikayttoliittyma;

import java.util.ArrayList;
import java.util.Scanner;
import mafia.sovelluslogiikka.Pelaaja;


/**
 *
 * @author Arto
 */
public class TekstiPelaajanValitsija {

    private Scanner lukija;

    /**
     *
     */
    public TekstiPelaajanValitsija() {
        lukija = new Scanner(System.in);
    }

    /**
     *
     * @param pelaajat
     * @return
     */
    public Pelaaja valitse(ArrayList<Pelaaja> pelaajat) {
        while (true) {
            System.out.println("Anna nimi:");
            String nimi = lukija.nextLine();
            Pelaaja pelaaja = haePelaaja(nimi, pelaajat);
            if (pelaaja == null) {
                System.out.println("Valitse uudestaan, vaihtoehdot:");
                System.out.println(pelaajat);
            } else {
                return pelaaja;
            }
        }
    }

    /**
     *
     * @param nimi
     * @param pelaajat
     * @return
     */
    public static Pelaaja haePelaaja(String nimi, ArrayList<Pelaaja> pelaajat) {
        for (Pelaaja pelaaja : pelaajat) {
            if (pelaaja.getNimi().equals(nimi)) {
                return pelaaja;
            }
        }
        return null;
    }
}

