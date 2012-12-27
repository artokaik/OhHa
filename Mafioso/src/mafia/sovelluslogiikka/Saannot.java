/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.sovelluslogiikka;

/**
 *
 * @author Arto
 */
public class Saannot {

    private boolean paivaEnsin;

    public Saannot() {
        paivaEnsin = true;
    }

    public boolean getPaivaEnsin() {
        return paivaEnsin;
    }

    public void asetaPaivaEnsin() {
        paivaEnsin = true;
    }

    public void asetaYoEnsin() {
        paivaEnsin = false;
    }

    @Override
    public String toString() {
        String saannot = "";
        saannot += alkaakoPaivallaToString();
        return saannot;
    }

    public String alkaakoPaivallaToString() {
        String saannot = "";
        if (paivaEnsin) {
            saannot += "Peli alkaa päivällä.\n";
        } else {
            saannot += "Peli alkaa yöllä.\n";
        }
        return saannot;
    }
}
