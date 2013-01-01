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
    private HashMap<Pelaaja, Integer> tulokset;
    
    public Aanestys(){
        this.aanet = new ArrayList<Aani>();
        this.tulokset = new HashMap<Pelaaja, Integer>();
    }
    
    public Pelaaja suorita(ArrayList<Pelaaja> pelaajat){
        PelaajanHakija hakija = new PelaajanHakija();
        for (Pelaaja pelaaja : pelaajat) {
            Aani aani = new Aani(pelaaja, hakija.valitsePelaaja(pelaajat));
            aanet.add(aani);
            if(tulokset.containsKey(aani.getAanestetty())){
                tulokset.put(aani.getAanestetty(), tulokset.get(aani.getAanestetty())+1);
            }
        }
        return null;
    }
    
 
}
