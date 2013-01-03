/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.sovelluslogiikka;

import java.util.ArrayList;


public interface Vaihe {

    public ArrayList<Pelaaja> pelaa(Saannot saannot);
    public ArrayList<Pelaaja> getPelaajat();
//    public Pelaaja haePelaaja(String nimi);
    public String kerroTapahtumat();
    
}
