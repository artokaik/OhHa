/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.sovelluslogiikka;

/**
 *
 * @author Arto
 */
import java.util.*;

public class Aanestys {
    private ArrayList<Aani> aanet;
    
    public Aanestys(){
        this.aanet = new ArrayList<Aani>();
    }
    
    public Pelaaja suorita(ArrayList<Pelaaja> pelaajat){
        PelaajanHakija hakija = new PelaajanHakija();
        for (Pelaaja pelaaja : pelaajat) {
            Aani aani = new Aani(pelaaja, hakija.valitsePelaaja(pelaajat));
            aanet.add(aani);
        }
        return null;
    }
}
