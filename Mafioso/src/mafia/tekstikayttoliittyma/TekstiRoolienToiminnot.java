/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.tekstikayttoliittyma;

import java.util.*;
import mafia.sovelluslogiikka.*;

/**
 *
 * @author Arto
 */
public class TekstiRoolienToiminnot {

    private Scanner lukija;

    /**
     *
     */
    public TekstiRoolienToiminnot() {
        lukija = new Scanner(System.in);
    }

    /**
     *
     * @param pelaajat
     */
    public void etsivaToimii(ArrayList<Pelaaja> pelaajat) {
        System.out.println("Olet Etsivä, kenet tarkastat?");
        TekstiPelaajanValitsija valitsija = new TekstiPelaajanValitsija();
        Pelaaja tarkastettava = valitsija.valitse(pelaajat);
        if (tarkastettava.getRooli().onkoPahis()) {
            System.out.println(tarkastettava + " on Mafioso!");
        } else {
            System.out.println(tarkastettava + " ei ole Mafioso.");
        }
    }

    /**
     *
     * @param pelaajat
     * @param yo
     * @return
     */
    public Pelaaja mafiosoToimii(ArrayList<Pelaaja> pelaajat, Yo yo) {
        System.out.println("Olet Mafioso, kenet haluat tappaa?");
        if (yo.getAmmuttu()!=null){
            System.out.println("Tällä hetkellä tapettavana on " + yo.getAmmuttu() + ".");
        }
        TekstiPelaajanValitsija valitsija = new TekstiPelaajanValitsija();
        Pelaaja tapettava = valitsija.valitse(pelaajat);
        return tapettava;
    }

    /**
     *
     * @param pelaajat
     * @return
     */
    public Pelaaja suojelijaToimii(ArrayList<Pelaaja> pelaajat) {
        System.out.println("Olet suojelija, ketä suojelet?");
        TekstiPelaajanValitsija valitsija = new TekstiPelaajanValitsija();
        Pelaaja suojeltava = valitsija.valitse(pelaajat);
        return suojeltava;
    }
}
