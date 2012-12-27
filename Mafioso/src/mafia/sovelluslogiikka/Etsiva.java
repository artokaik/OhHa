/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.sovelluslogiikka;

/**
 *
 * @author Arto
 */
public class Etsiva implements Rooli{
    private String roolinimi;
    private boolean pahis;
    private int tarkkuus;
    
    public Etsiva(){
        roolinimi = "Etsivä";
        pahis = false;
        tarkkuus = 100;
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
