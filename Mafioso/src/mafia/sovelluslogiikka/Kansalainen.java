/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.sovelluslogiikka;

/**
 *
 * @author Arto
 */
public class Kansalainen implements Rooli{
    private String roolinimi;
    private boolean pahis;

    
    public Kansalainen(){
        roolinimi = "Kansalainen";
        pahis = false;
  
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
