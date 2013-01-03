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
public class Paiva implements Vaihe {

    private ArrayList<Pelaaja> pelaajat;
    private ArrayList<Aanestys> aanestykset;

    public Paiva(ArrayList<Pelaaja> pelaajat) {
        this.pelaajat = pelaajat;
        this.aanestykset = new ArrayList<Aanestys>();
    }
    
    public ArrayList<Aanestys> getAanestykset(){
        return this.aanestykset;
    }

    public ArrayList<Pelaaja> getPelaajat() {
        return pelaajat;
    }
    
    public Pelaaja haePelaaja(String nimi){
        for (Pelaaja pelaaja : pelaajat) {
            if (pelaaja.getNimi().equals(nimi)){
                return pelaaja;
            }
        }
        return null;
    }

    public ArrayList<Pelaaja> pelaa() {
        

        return null;
    }
}
