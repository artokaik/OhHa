/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.kayttoliittyma;

import java.util.*;
import mafia.sovelluslogiikka.*;
import mafia.tekstikayttoliittyma.*;

/**
 *
 * @author Arto
 */
public class Ohjaus {

    private TekstiRoolienToiminnot toiminnot;
    private TekstiNaytolleTulostaja tulostaja;

    /**
     *
     */
    public Ohjaus() {
        toiminnot = new TekstiRoolienToiminnot();
        tulostaja = new TekstiNaytolleTulostaja();
    }

    /**
     *
     * @param pelaajat
     * @return
     */
    public Pelaaja valitsePelaaja(ArrayList<Pelaaja> pelaajat) {
        TekstiPelaajanValitsija valitsija = new TekstiPelaajanValitsija();
        return valitsija.valitse(pelaajat);
    }

    /**
     *
     * @param pelaaja
     * @param pelaajat
     * @return
     */
    public Aani aanesta(Pelaaja pelaaja, ArrayList<Pelaaja> pelaajat) {
        TekstiAanestys aanestys = new TekstiAanestys();
        return aanestys.aanesta(pelaaja, pelaajat);
    }

    /**
     *
     * @param pelaajat
     */
    public void etsivaToimii(ArrayList<Pelaaja> pelaajat) {
        toiminnot.etsivaToimii(pelaajat);
    }

    /**
     *
     * @param pelaajat
     * @param yo
     * @return
     */
    public Pelaaja mafiosoToimii(ArrayList<Pelaaja> pelaajat, Yo yo) {
        return toiminnot.mafiosoToimii(pelaajat, yo);
    }

    /**
     *
     * @param pelaajat
     * @return
     */
    public Pelaaja suojelijaToimii(ArrayList<Pelaaja> pelaajat) {
        return toiminnot.suojelijaToimii(pelaajat);
    }
    
    /**
     *
     * @param vaihe
     */
    public void tulostaTapahtumat(Vaihe vaihe){
        tulostaja.tulostaVaiheenTapahtumat(vaihe);
    }
    
    /**
     *
     * @param voittaja
     */
    public void julistaVoittaja(String voittaja){
        tulostaja.julistaVoittaja(voittaja);
    }
}
