/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.sovelluslogiikka.roolit;

import java.util.ArrayList;

/**
 *
 * @author Arto
 */
public class Roolilista {
    private ArrayList<Rooli> roolit;

    public Roolilista() {
        roolit = new ArrayList<Rooli>();
        roolit.add(new Etsiva());
        roolit.add(new Kansalainen());
        roolit.add(new Mafioso());
        roolit.add(new Suojelija());
    }

    public ArrayList<Rooli> getRoolit() {
        return roolit;
    }
    
    
}
