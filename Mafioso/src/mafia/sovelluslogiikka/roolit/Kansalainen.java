package mafia.sovelluslogiikka.roolit;

import java.util.ArrayList;
import mafia.sovelluslogiikka.Pelaaja;
import mafia.sovelluslogiikka.Yo;

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
     *
     * @param yo
     * @return
     */
    public String getRooliSelitys(Yo yo) {
        return "Olet Kansalainen, et tee mitään, paina OK";
    }

    /**
     *
     * @param yo
     */
    public void toimi(Yo yo) {
    }

    public String toimi(Yo yo, Pelaaja valittu) {
        return "Et tehnyt mitään koska olit tavallinen kansalainen";
    }

    /**
     *
     * @param pelaajat
     * @param itse
     * @return
     */
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
