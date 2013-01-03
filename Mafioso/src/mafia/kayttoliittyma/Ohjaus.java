/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.kayttoliittyma;

import java.util.*;
import mafia.sovelluslogiikka.*;
import mafia.tekstikayttoliittyma.*;

public class Ohjaus {

    private TekstiRoolienToiminnot toiminnot;
    private TekstiNaytolleTulostaja tulostaja;

    public Ohjaus() {
        toiminnot = new TekstiRoolienToiminnot();
        tulostaja = new TekstiNaytolleTulostaja();
    }

    public Pelaaja valitsePelaaja(ArrayList<Pelaaja> pelaajat) {
        TekstiPelaajanValitsija valitsija = new TekstiPelaajanValitsija();
        return valitsija.valitse(pelaajat);
    }

    public Aani aanesta(Pelaaja pelaaja, ArrayList<Pelaaja> pelaajat) {
        TekstiAanestys aanestys = new TekstiAanestys();
        return aanestys.aanesta(pelaaja, pelaajat);
    }

    public void etsivaToimii(ArrayList<Pelaaja> pelaajat) {
        toiminnot.etsivaToimii(pelaajat);
    }

    public Pelaaja mafiosoToimii(ArrayList<Pelaaja> pelaajat, Yo yo) {
        return toiminnot.mafiosoToimii(pelaajat, yo);
    }

    public Pelaaja suojelijaToimii(ArrayList<Pelaaja> pelaajat) {
        return toiminnot.suojelijaToimii(pelaajat);
    }
    
    public void tulostaTapahtumat(Vaihe vaihe){
        tulostaja.tulostaVaiheenTapahtumat(vaihe);
    }
    
    public void julistaVoittaja(String voittaja){
        tulostaja.julistaVoittaja(voittaja);
    }
}
