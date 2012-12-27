/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.sovelluslogiikka;

/**
 *
 * @author Arto
 */
public class Mafioso implements Rooli{
    private String roolinimi;
    private boolean pahis;

    public Mafioso(){
        roolinimi = "Mafioso";
        pahis = true;
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
