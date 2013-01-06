
package mafia.sovelluslogiikka.roolit;

import mafia.sovelluslogiikka.Yo;

/**
 *
 * @author Arto
 */
public interface Rooli {
    
    /**
     *
     * @param yo
     */
    public void toimi(Yo yo);
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
}
