/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.sovelluslogiikka;

/**
 *
 * @author Arto
 */
public class Suojelija implements Rooli{
    private String roolinimi;
    private boolean pahis;
    private int tarkkuus;
    
    public Suojelija(){
        roolinimi = "Suojelija";
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
