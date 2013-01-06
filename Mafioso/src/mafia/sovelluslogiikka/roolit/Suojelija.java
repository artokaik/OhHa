
package mafia.sovelluslogiikka.roolit;

import mafia.kayttoliittyma.Ohjaus;
import mafia.sovelluslogiikka.Pelaaja;
import mafia.sovelluslogiikka.Yo;

/**
 *
 * @author Arto
 */
public class Suojelija implements Rooli{
    private final String roolinimi = "Suojelija";
    private final boolean pahis = false;

    
    /**
     *
     */
    public Suojelija(){
    }
    
    /**
     *
     * @param yo
     */
    public void toimi(Yo yo){
        Ohjaus ohjaus = new Ohjaus();
        Pelaaja suojeltu = ohjaus.suojelijaToimii(yo.getPelaajat());
        yo.asetaSuojeltu(suojeltu);
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
}
