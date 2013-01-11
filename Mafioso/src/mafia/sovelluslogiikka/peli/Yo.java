package mafia.sovelluslogiikka.peli;

import mafia.sovelluslogiikka.peli.Paiva;
import mafia.sovelluslogiikka.peli.Vaihe;
import java.util.ArrayList;
import mafia.sovelluslogiikka.sekalaista.Pelaaja;

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
     * Konstruktori saa parametrinaan listan hengissä olevista pelaajista.
     * @param pelaajat
     */
    public Yo(ArrayList<Pelaaja> pelaajat) {
        this.pelaajat = (ArrayList<Pelaaja>) pelaajat.clone();
        this.vuoroPelaamatta = (ArrayList<Pelaaja>) pelaajat.clone();
    }

    /**
     * Asettaa parametrina annetun pelaajan ammutuksi mikäli pelaaja on yhä mukana pelissä.
     * @param pelaaja
     * @return
     */
    public boolean asetaAmmuttu(Pelaaja pelaaja) {
        if (pelaajat.contains(pelaaja)) {
            ammuttu = pelaaja;
            return true;
        }
        return false;
    }
    
    /**
     * Poistaa parametrina annetun pelaajan pelaamattomien pelaajien listasta.
     * @param pelaaja
     * @return
     */
    public boolean poistaPelaamattomista(Pelaaja pelaaja){
        return vuoroPelaamatta.remove(pelaaja);
    }

    /**
     * Asettaa parametrina annetun pelaajan suojelluksi mikäli pelaaja on yhä mukana pelissä.
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
     * Poistaa ammutun pelaajan pelaajalistasta mikäli tätä ei ole suojeltu.
     */
    public void tapaAmmutut() {
        if (suojeltu == null || !suojeltu.equals(ammuttu)) {
            pelaajat.remove(ammuttu);
        }
    }

    /**
     * Palauttaa uuden Paivan hengissä olevilla pelaajilla.
     * @return
     */
    public Paiva luoSeuraavaVaihe() {
        Paiva paiva = new Paiva(pelaajat);
        return paiva;
    }

    /**
     * Palauttaa Stringinä yön tapahtumat (kuka kuoli/kuoliko kukaan).
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

