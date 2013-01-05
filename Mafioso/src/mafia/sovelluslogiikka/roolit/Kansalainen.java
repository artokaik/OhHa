
package mafia.sovelluslogiikka.roolit;

import mafia.sovelluslogiikka.Yo;


public class Kansalainen implements Rooli{
    private final String roolinimi = "Kansalainen";
    private final boolean pahis = false;

    
    public Kansalainen(){  
    }
    
    public void toimi(Yo yo){        
    }
    
    public boolean onkoPahis(){
        return pahis;
    }
    
    public String getRoolinimi(){
        return this.roolinimi;
    }
    
}
