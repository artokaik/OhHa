package mafia.sovelluslogiikka;

import mafia.sovelluslogiikka.peli.Saannot;
import java.util.ArrayList;
import mafia.kayttoliittyma.Ohjaus;

/**
 * Yo-luokka toteuttaa Vaihe-rajapinnan. Yo-oliolla on kaksi ArrayList<Pelaaja> -muuttujaa, joista 'pelaajat' on lista mukana olevista pelaajista ja 'vuoroPelaamatta' lista pelaajista, joiden vuoroa ei yön aikana vielä ole pelattu.
 * 
 * Yo-olio tuntee myös ammutun ja suojellun pelaajan.
 *
 * @author Arto
 */
public class Yo implements Vaihe {

    private ArrayList<Pelaaja> pelaajat;
    private ArrayList<Pelaaja> vuoroPelaamatta;
    private Pelaaja ammuttu;
    private Pelaaja suojeltu;

    /**
     *
     * @param pelaajat
     */
    public Yo(ArrayList<Pelaaja> pelaajat) {
        this.pelaajat = pelaajat;
        this.vuoroPelaamatta = (ArrayList<Pelaaja>) pelaajat.clone();
    }

    /**
     *
     * @param pelaaja
     * @return
     */
    public boolean asetaTapettava(Pelaaja pelaaja) {
        if (pelaajat.contains(pelaaja)) {
            ammuttu = pelaaja;
            return true;
        }
        return false;
    }

    /**
     *
     * @param pelaaja
     * @return
     */
    public boolean asetaSuojeltu(Pelaaja pelaaja) {
        if (pelaajat.contains(pelaaja)) {
            suojeltu = pelaaja;
            return true;
        }
        return false;
    }


    /**
     *
     */
    public void tapaAmmutut() {
        if (suojeltu == null || !suojeltu.equals(ammuttu)) {
            pelaajat.remove(ammuttu);
        }
    }

    /**
     *
     * @return
     */
    public Paiva luoSeuraavaVaihe() {
        Paiva paiva = new Paiva(pelaajat);
        return paiva;
    }

    /**
     *
     * @return
     */
    public String kerroTapahtumat() {
        String tuloste = "";
        if (this.ammuttu.equals(this.suojeltu)) {
            tuloste = "Kukaan ei kuollut!";
        } else {
            tuloste = ammuttu + " kuoli!";
        }
        tuloste += "\n Seuraavaksi vuorossa päivä ja äänestys:";
        return tuloste;

    }

    //getterit ja setterit;
    /**
     *
     * @param pelaajat
     */
    public void setPelaajat(ArrayList<Pelaaja> pelaajat) {
        this.pelaajat = pelaajat;
    }

    /**
     *
     * @param vuoroPelaamatta
     */
    public void setVuoroPelaamatta(ArrayList<Pelaaja> vuoroPelaamatta) {
        this.vuoroPelaamatta = vuoroPelaamatta;
    }

    /**
     *
     * @return
     */
    public ArrayList<Pelaaja> getVuoroPelaamatta() {
        return vuoroPelaamatta;
    }

    /**
     *
     * @return
     */
    public Pelaaja getSuojeltu() {
        return suojeltu;
    }

    /**
     *
     * @return
     */
    public ArrayList<Pelaaja> getPelaajat() {
        return pelaajat;
    }

    /**
     *
     * @return
     */
    public Pelaaja getAmmuttu() {
        return ammuttu;
    }

}


//    public Pelaaja haePelaaja(String nimi) {
//        for (Pelaaja pelaaja : pelaajat) {
//            if (pelaaja.getNimi().equals(nimi)) {
//                return pelaaja;
//            }
//        }
//        return null;
//    }

//    /**
//     *
//     * @param saannot
//     * @return
//     */
//    public ArrayList<Pelaaja> pelaa(Saannot saannot) {
//        while (!vuoroPelaamatta.isEmpty()) {
//            pelaaYksiVuoro();
//        }
//        this.tapaAmmutut();
//        ArrayList<Pelaaja> hengissa = (ArrayList<Pelaaja>) pelaajat.clone();
//        return hengissa;
//    }

//    public void pelaaYksiVuoro() {
//        Ohjaus ohjaus = new Ohjaus();
//        Pelaaja pelaaja = ohjaus.valitsePelaaja(vuoroPelaamatta);
//        pelaaja.toimiRoolinMukaan(this);
//        vuoroPelaamatta.remove(pelaaja);
//    }

