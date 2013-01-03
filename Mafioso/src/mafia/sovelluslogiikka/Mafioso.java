/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.sovelluslogiikka;

import mafia.kayttoliittyma.Ohjaus;
import java.util.*;

public class Mafioso implements Rooli{
    private String roolinimi;
    private boolean pahis;

    public Mafioso(){
        roolinimi = "Mafioso";
        pahis = true;
    }
    
    public void toimi(Yo yo){
        
        Ohjaus ohjaus = new Ohjaus();
        Pelaaja tapettava = ohjaus.valitsePelaaja(this.getHyvikset(yo.getPelaajat()));
        yo.setTapettava(tapettava);
    }
    
    public boolean onkoPahis(){
        return pahis;
    }
    
    public String getRoolinimi(){
        return this.roolinimi;
    }
    
    private ArrayList<Pelaaja> getHyvikset(ArrayList<Pelaaja> pelaajat){
        ArrayList<Pelaaja> hyvikset = (ArrayList<Pelaaja>) pelaajat.clone();
        ArrayList<Pelaaja> poistettavat = new ArrayList<Pelaaja>();
        for (Pelaaja pelaaja : hyvikset) {
            if (pelaaja.getRooli().onkoPahis()){
                poistettavat.add(pelaaja);
            }
        }
        for (Pelaaja pelaaja : poistettavat) {
            hyvikset.remove(pelaaja);
        }
        return hyvikset;
    }
}
