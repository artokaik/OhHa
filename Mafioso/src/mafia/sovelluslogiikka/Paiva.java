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
    private Aanestys aanestys;
    private Vaihe seuraava;

    public Paiva(ArrayList<Pelaaja> pelaajat) {
        this.pelaajat = pelaajat;
    }
    
    public void pelaa(){
        aanestys = new Aanestys();
        Pelaaja tapettu = aanestys.suorita(pelaajat);
        pelaajat.remove(tapettu);
        Yo yo = new Yo(pelaajat);
    }
}
