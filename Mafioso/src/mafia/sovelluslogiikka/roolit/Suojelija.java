package mafia.sovelluslogiikka.roolit;

import mafia.kayttoliittyma.Ohjaus;
import mafia.sovelluslogiikka.Pelaaja;
import mafia.sovelluslogiikka.Yo;

/**
 * Suojelija-luokka toteuttaa rajapinnan rooli. Suojelija on hyvisten puolella
 * oleva hahmo, joka voi joka yöllä suojella yhtä pelaajaa. Mikäli Mafiosot
 * koittavat tappaa suojellun pelaajan, kukaan ei kuole yöllä.
 *
 * @author Arto
 */
public class Suojelija implements Rooli {

    private final String roolinimi = "Suojelija";
    private final boolean pahis = false;

    /**
     *
     */
    public Suojelija() {
    }

    /**
     *
     * @param yo
     */
    public void toimi(Yo yo) {
        Ohjaus ohjaus = new Ohjaus();
        Pelaaja suojeltu = ohjaus.suojelijaToimii(yo.getPelaajat());
        yo.asetaSuojeltu(suojeltu);
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
    
    public Suojelija kopioi(){
        return new Suojelija();
    }

    @Override
    public String toString() {
        return this.roolinimi;
    }
}
