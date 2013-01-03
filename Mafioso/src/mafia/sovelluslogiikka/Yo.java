/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.sovelluslogiikka;

import java.util.ArrayList;
import mafia.kayttoliittyma.Ohjaus;

public class Yo implements Vaihe {

    private ArrayList<Pelaaja> pelaajat;
    private ArrayList<Pelaaja> pelaamatta;
    private Pelaaja ammuttu;
    private Pelaaja suojeltu;

    public Yo(ArrayList<Pelaaja> pelaajat) {
        this.pelaajat = pelaajat;
        this.pelaamatta = pelaajat;
    }

    public ArrayList<Pelaaja> getPelaajat() {
        return pelaajat;
    }
    
    public Pelaaja getAmmuttu(){
        return ammuttu;
    }

    public Pelaaja haePelaaja(String nimi) {
        for (Pelaaja pelaaja : pelaajat) {
            if (pelaaja.getNimi().equals(nimi)) {
                return pelaaja;
            }
        }
        return null;
    }

    public boolean setTapettava(Pelaaja pelaaja) {
        if (pelaajat.contains(pelaaja)) {
            ammuttu = pelaaja;
            return true;
        }
        return false;
    }

    public boolean setSuojeltu(Pelaaja pelaaja) {
        if (pelaajat.contains(pelaaja)) {
            suojeltu = pelaaja;
            return true;
        }
        return false;
    }

    public ArrayList<Pelaaja> pelaa(Saannot saannot) {
        Ohjaus ohjaus = new Ohjaus();
        while(!pelaamatta.isEmpty()){
            Pelaaja pelaaja = ohjaus.valitsePelaaja(pelaamatta);
            pelaaja.toimiRoolinMukaan(this);
            pelaamatta.remove(pelaaja);
        }
        this.tapaAmmutut();
        ArrayList<Pelaaja> hengissa = (ArrayList<Pelaaja>) pelaajat.clone();
        return pelaajat;
    }

    public void tapaAmmutut() {
        if (suojeltu == null || !suojeltu.equals(ammuttu)) {
            pelaajat.remove(ammuttu);
        }
    }
}
