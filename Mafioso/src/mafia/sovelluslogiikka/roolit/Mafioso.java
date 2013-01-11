package mafia.sovelluslogiikka.roolit;

import java.util.ArrayList;
import mafia.sovelluslogiikka.sekalaista.Pelaaja;
import mafia.sovelluslogiikka.peli.Yo;

/**
 * Mafioso-luokka toteuttaa Rooli-rajapinnan. Mafiosot ovat pahiksia, jotka
 * pyrkivät joka yö tappamaan yhden pelaajista.
 *
 * @author Arto
 */
public class Mafioso implements Rooli {

    private final String roolinimi = "Mafioso";
    private final boolean pahis = true;

    /**
     *
     */
    public Mafioso() {
    }

    /**
     * Palauttaa Stringinä tiedon siitä, kenet pelaajista on parametrina annettuna yönä asetettu ammuttavaksi vai onko ketään.
     * @param yo
     * @return
     */
    @Override
    public String getRooliSelitys(Yo yo) {
        String tuloste = "Olet Mafioso, tällä hetkellä ammuttavana ";
        if(yo.getAmmuttu()==null){
            tuloste += "ei ole kukaan";
        } else {
            tuloste += "on " + yo.getAmmuttu().getNimi();
        }
        tuloste += ", valitse kenet haluat ampua.";
        return tuloste;
    }

    /**
     * Asettaa parametrina annetun pelaajan ammutuksi parametrina annettuna yönä ja palauttaa Stringinä lauseen, joka kertoo että pelaajaa on ammuttu.
     * @param yo
     * @param valittu 
     * @return  
     */
    @Override
    public String toimi(Yo yo, Pelaaja valittu) {
        String tuloste = "Pelaaja, jota ammuit on " + valittu;
        yo.asetaAmmuttu(valittu);
        return tuloste;
    }

    /**
     *
     * @return
     */
    public boolean onkoPahis() {
        return pahis;
    }

    public Mafioso kopioi() {
        return new Mafioso();
    }

    /**
     *
     * @return
     */
    public String getRoolinimi() {
        return this.roolinimi;
    }

    /**
     * Kopioi parametrina annetun listan, poistaa kopiosta kaikki hyvikset ja palauttaa näin saadun listan (Mafioso ei voi ampua pahiksia).
     * @param pelaajat
     * @param itse
     * @return
     */
    @Override
    public ArrayList<Pelaaja> getVaihtoehdot(ArrayList<Pelaaja> pelaajat, Pelaaja itse) {
        ArrayList<Pelaaja> hyvikset = (ArrayList<Pelaaja>) pelaajat.clone();
        ArrayList<Pelaaja> poistettavat = new ArrayList<Pelaaja>();
        for (Pelaaja pelaaja : hyvikset) {
            if (pelaaja.getRooli().onkoPahis()) {
                poistettavat.add(pelaaja);
            }
        }
        for (Pelaaja pelaaja : poistettavat) {
            hyvikset.remove(pelaaja);
        }
        return hyvikset;
    }

    @Override
    public String toString() {
        return this.roolinimi;
    }
}
