package mafia.sovelluslogiikka.roolit;

import java.util.ArrayList;
import mafia.sovelluslogiikka.sekalaista.Pelaaja;
import mafia.sovelluslogiikka.peli.Yo;

/**
 * Etsivä-luokka toteuttaa rajapinnan rooli. Etsivä on hyvisten puolella oleva
 * hahmo, joka ei tee yöllä mitään.
 *
 * @author Arto
 */
public class Kansalainen implements Rooli {

    private final String roolinimi = "Kansalainen";
    private final boolean pahis = false;

    /**
     *
     */
    public Kansalainen() {
    }

    /**
     * Palauttaa String-oliossa tiedon siitä, ettei kansalainen tee yöllä mitään. Vaatii parametrikseen Yo-muuttujan, muttei tavitse muuttujaa mihinkään.
     * @param yo
     * @return
     */
    @Override
    public String getRooliSelitys(Yo yo) {
        return "Olet Kansalainen, et tee mitään, paina OK";
    }

    /**
     * Palauttaa String-oliossa tiedon siitä, ettei kansalainen tehnyt mitään.
     * @param yo
     */
    @Override
    public String toimi(Yo yo, Pelaaja valittu) {
        return "Et tehnyt mitään koska olit tavallinen kansalainen";
    }

    /**
     * Palauttaa tyhjän ArrayListin.
     * @param pelaajat
     * @param itse
     * @return
     */
    @Override
    public ArrayList<Pelaaja> getVaihtoehdot(ArrayList<Pelaaja> pelaajat, Pelaaja itse) {
        ArrayList<Pelaaja> vaihtoehdot = new ArrayList<Pelaaja>();
        return vaihtoehdot;
    }

    /**
     *
     * @return
     */
    public boolean onkoPahis() {
        return pahis;
    }

    /**
     *
     * @return
     */
    public String getRoolinimi() {
        return this.roolinimi;
    }

    public Kansalainen kopioi() {
        return new Kansalainen();
    }

    @Override
    public String toString() {
        return this.roolinimi;
    }
}
