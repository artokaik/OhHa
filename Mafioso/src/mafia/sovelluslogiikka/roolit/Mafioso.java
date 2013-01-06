
package mafia.sovelluslogiikka.roolit;

import java.util.ArrayList;
import mafia.kayttoliittyma.Ohjaus;
import mafia.sovelluslogiikka.Pelaaja;
import mafia.sovelluslogiikka.Yo;

/**
 * Mafioso-luokka toteuttaa Rooli-rajapinnan. Mafiosot ovat pahiksia, jotka pyrkivät joka yö tappamaan yhden pelaajista.
 * 
 * @author Arto
 */
public class Mafioso implements Rooli{
    private final String roolinimi = "Mafioso";
    private final boolean pahis = true;

    /**
     *
     */
    public Mafioso(){
    }
    
    /**
     *
     * @param yo
     */
    public void toimi(Yo yo){
        Ohjaus ohjaus = new Ohjaus();
        Pelaaja tapettava = ohjaus.mafiosoToimii(getHyvikset(yo.getPelaajat()), yo);
        yo.asetaTapettava(tapettava);
    }
    
    /**
     *
     * @return
     */
    public boolean onkoPahis(){
        return pahis;
    }
    
    /**
     *
     * @return
     */
    public String getRoolinimi(){
        return this.roolinimi;
    }
    
    private ArrayList<Pelaaja> getHyvikset(ArrayList<Pelaaja> pelaajat){
        ArrayList<Pelaaja> hyvikset = (ArrayList<Pelaaja>) pelaajat.clone();
        ArrayList<Pelaaja> poistettavat = new ArrayList<Pelaaja>();
        for (Pelaaja pelaaja : hyvikset) {
            if (pelaaja.getRooli().onkoPahis()){
                poistettavat.add(pelaaja);
            }
        }
        for (Pelaaja pelaaja : poistettavat) {
            hyvikset.remove(pelaaja);
        }
        return hyvikset;
    }
}
