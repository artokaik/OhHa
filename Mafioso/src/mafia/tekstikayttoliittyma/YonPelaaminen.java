/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.tekstikayttoliittyma;

import java.util.*;
import mafia.sovelluslogiikka.*;

public class YonPelaaminen implements VaiheenPelaaminen {

    private Yo yo;
    private ArrayList<Pelaaja> pelaamatta;
    private Scanner lukija;

    public YonPelaaminen(Yo yo) {
        this.yo = yo;
        this.pelaamatta = yo.getPelaajat();
        lukija = new Scanner(System.in);
    }

    public PaivanPelaaminen pelaa() {    
        while (!pelaamatta.isEmpty()) {
            this.pelaaYksiVuoro();
        }
        yo.tapaAmmutut();
        ArrayList<Pelaaja> hengissa =(ArrayList<Pelaaja>) yo.getPelaajat().clone();
        return new PaivanPelaaminen(new Paiva(hengissa));
    }

    public void pelaaYksiVuoro() {
        while (true) {
            System.out.println("Anna nimesi:");
            String nimi = lukija.nextLine();
            Pelaaja vuorossa = yo.haePelaaja(nimi);
            if (pelaamatta.contains(vuorossa)) {
                vuorossa.getRooli().toimi(yo);
                pelaamatta.remove(vuorossa);
                break;
            } else {
                System.out.println("Nimeäsi ei löydy, tällä kierroksella vuorossa ovat vielä seuraavat:");
                System.out.println(pelaamatta);
            }
        }
    }
}
