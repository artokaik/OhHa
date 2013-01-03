/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.sovelluslogiikka;

import java.util.ArrayList;

/**
 *
 * @author Arto
 */
public class Yo implements Vaihe {
    private ArrayList<Pelaaja> pelaajat;
    private ArrayList<Pelaaja> ammutut;

    public Yo(ArrayList<Pelaaja> pelaajat) {
        this.pelaajat = pelaajat;
    }
    
    public ArrayList<Pelaaja> getPelaajat(){
        return pelaajat;
    }
    
    public boolean setTapettava(Pelaaja pelaaja){
        if(pelaajat.contains(pelaaja)){
            ammutut.add(pelaaja);
            return true;
        }
        return false;
    }

    public ArrayList<Pelaaja> pelaa() {
        for (Pelaaja pelaaja : pelaajat) {
            pelaaja.toimiRoolinMukaan(this);
        }
        this.tapaAmmutut();
        return pelaajat;
    }
    
    public void tapaAmmutut(){
        for (Pelaaja pelaaja : ammutut) {
            this.pelaajat.remove(pelaaja);
            
        }
    }
}
