package mafia.sovelluslogiikka.roolit;

import java.util.ArrayList;
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
     * @return
     */
    public String getRooliSelitys(Yo yo) {
        return "Olet suojelija, ketä haluat suojella mafiosoilta?";
    }

    /**
     *
     * @param yo
     * @param valittu
     * @return  
     */
    public String toimi(Yo yo, Pelaaja valittu) {
        String tuloste = "Suojeltu pelaaja on " + valittu.getNimi();
        yo.asetaSuojeltu(valittu);
        return tuloste;
    }

    /**
     *
     * @param pelaajat
     * @param itse
     * @return
     */
    public ArrayList<Pelaaja> getVaihtoehdot(ArrayList<Pelaaja> pelaajat, Pelaaja itse) {
        ArrayList<Pelaaja> vaihtoehdot = (ArrayList<Pelaaja>) pelaajat.clone();
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

    public Suojelija kopioi() {
        return new Suojelija();
    }

    @Override
    public String toString() {
        return this.roolinimi;
    }
}
