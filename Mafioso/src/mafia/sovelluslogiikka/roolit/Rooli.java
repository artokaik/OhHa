
package mafia.sovelluslogiikka.roolit;

import java.util.ArrayList;
import mafia.sovelluslogiikka.sekalaista.Pelaaja;
import mafia.sovelluslogiikka.peli.Yo;

/**
 *
 * @author Arto
 */
public interface Rooli {
    
    /**
     *
     * @param yo
     * @param valittu
     * @return  
     */
    public String toimi(Yo yo, Pelaaja valittu);
    /**
     *
     * @return
     */
    public boolean onkoPahis();
    /**
     *
     * @return
     */
    public String getRoolinimi();
        /**
     *
     * @return
     */
    public Rooli kopioi();
    
    /**
     *
     * @param pelaajat
     * @param itse
     * @return
     */
    public ArrayList<Pelaaja> getVaihtoehdot(ArrayList<Pelaaja> pelaajat, Pelaaja itse);
    
    /**
     *
     * @param yo
     * @return
     */
    public String getRooliSelitys(Yo yo);
}
