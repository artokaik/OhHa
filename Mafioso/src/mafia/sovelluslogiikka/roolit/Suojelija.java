package mafia.sovelluslogiikka.roolit;

import java.util.ArrayList;
import mafia.sovelluslogiikka.sekalaista.Pelaaja;
import mafia.sovelluslogiikka.peli.Yo;

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
    @Override
    public String getRooliSelitys(Yo yo) {
        return "Olet suojelija, ketä haluat suojella mafiosoilta?";
    }

    /**
     * Asettaa parametrina annetun pelaajan suojelluksi parametrina annettuna yönä ja palauttaa tiedon tästä Stringinä.
     * @param yo
     * @param valittu
     * @return  
     */
    @Override
    public String toimi(Yo yo, Pelaaja valittu) {
        String tuloste = "Suojeltu pelaaja on " + valittu.getNimi();
        yo.asetaSuojeltu(valittu);
        return tuloste;
    }

    /**
     * Palauttaa kopion parametrina annetusta listasta.
     * @param pelaajat
     * @param itse
     * @return
     */
    @Override
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
