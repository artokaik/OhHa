package mafia.sovelluslogiikka.roolit;

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
     */
    public void toimi(Yo yo) {
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
    
    public Kansalainen kopioi(){
        return new Kansalainen();
    }

    @Override
    public String toString() {
        return this.roolinimi;
    }
}
