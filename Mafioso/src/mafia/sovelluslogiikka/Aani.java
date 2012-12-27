/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.sovelluslogiikka;

/**
 *
 * @author Arto
 */
public class Aani {
    private Pelaaja aanestaja;
    private Pelaaja aanestetty;
    
    public Aani(Pelaaja aanestaja, Pelaaja aanestetty){
        this.aanestaja = aanestaja;
        this.aanestetty = aanestetty;
    }
    
    public Pelaaja getAanestaja(){
        return this.aanestaja;
    }
    
    public Pelaaja getAanestetty(){
        return this.aanestetty;
    }
}
