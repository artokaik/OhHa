package mafia.sovelluslogiikka.roolit;

import java.util.ArrayList;
import mafia.turhat.kayttoliittyma.Ohjaus;
import mafia.sovelluslogiikka.Pelaaja;
import mafia.sovelluslogiikka.Yo;

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
     *
     * @param yo
     * @return
     */
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
     *
     * @param yo
     * @param valittu 
     * @return  
     */
    public String toimi(Yo yo, Pelaaja valittu) {
        String tuloste = "Pelaaja, jota ammuit on " + valittu;
        yo.asetaTapettava(valittu);
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
     *
     * @param pelaajat
     * @param itse
     * @return
     */
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
