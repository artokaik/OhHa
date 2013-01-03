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
    private Pelaaja ammuttu;
    private Pelaaja suojeltu;

    public Yo(ArrayList<Pelaaja> pelaajat) {
        this.pelaajat = pelaajat;
    }

    public ArrayList<Pelaaja> getPelaajat() {
        return pelaajat;
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

    public ArrayList<Pelaaja> pelaa() {
        for (Pelaaja pelaaja : pelaajat) {
            pelaaja.toimiRoolinMukaan(this);
        }
        this.tapaAmmutut();
        return pelaajat;
    }

    public void tapaAmmutut() {
        if (!suojeltu.equals(ammuttu)){
            pelaajat.remove(ammuttu);
        }
    }
}
