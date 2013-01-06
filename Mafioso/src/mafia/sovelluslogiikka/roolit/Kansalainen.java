
package mafia.sovelluslogiikka.roolit;

import mafia.sovelluslogiikka.Yo;


/**
 *
 * @author Arto
 */
public class Kansalainen implements Rooli{
    private final String roolinimi = "Kansalainen";
    private final boolean pahis = false;

    
    /**
     *
     */
    public Kansalainen(){  
    }
    
    /**
     *
     * @param yo
     */
    public void toimi(Yo yo){        
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
