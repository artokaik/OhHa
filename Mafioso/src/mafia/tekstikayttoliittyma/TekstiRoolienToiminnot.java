/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.tekstikayttoliittyma;

import java.util.*;
import mafia.sovelluslogiikka.*;

public class TekstiRoolienToiminnot {

    private Scanner lukija;

    public TekstiRoolienToiminnot() {
        lukija = new Scanner(System.in);
    }

    public void etsivaToimii(ArrayList<Pelaaja> pelaajat) {
        System.out.println("Olet Etsivä.");
        TekstiPelaajanValitsija valitsija = new TekstiPelaajanValitsija();
        Pelaaja tarkastettava = valitsija.valitse(pelaajat);
        if (tarkastettava.getRooli().onkoPahis()) {
            System.out.println(tarkastettava + " on Mafioso!");
        } else {
            System.out.println(tarkastettava + " ei ole Mafioso.");
        }
    }

    public Pelaaja mafiosoToimii(ArrayList<Pelaaja> pelaajat, Yo yo) {
        System.out.println("Olet Mafioso.");
        if (yo.getAmmuttu()!=null){
            System.out.println("Tällä hetkellä tapettavana on " + yo.getAmmuttu() + ".");
        }
        TekstiPelaajanValitsija valitsija = new TekstiPelaajanValitsija();
        Pelaaja tapettava = valitsija.valitse(pelaajat);
        return tapettava;
    }

    public Pelaaja suojelijaToimii(ArrayList<Pelaaja> pelaajat) {
        System.out.println("Olet suojelija.");
        TekstiPelaajanValitsija valitsija = new TekstiPelaajanValitsija();
        Pelaaja suojeltava = valitsija.valitse(pelaajat);
        return suojeltava;
    }
}
