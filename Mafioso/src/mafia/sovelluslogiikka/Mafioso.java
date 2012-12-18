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

    public Mafioso(){
        roolinimi = "Mafioso";
    }
    
    public void toimi(Yo yo){
        
    }
    
    public String getRoolinimi(){
        return this.roolinimi;
    }
    
}
