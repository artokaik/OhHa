/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.kayttoliittyma.KayttisPeliRakentaja;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import mafia.kayttoliittyma.KayttisPeli;
import mafia.sovelluslogiikka.peli.Peli;
import mafia.sovelluslogiikka.peli.PeliRakentaja;

/**
 *
 * @author Arto
 */
public class ToimintoPelinAloitus implements ActionListener {

    private PeliRakentaja rakentaja;

    public ToimintoPelinAloitus(PeliRakentaja rakentaja) {
        this.rakentaja = rakentaja;
    }

    public void actionPerformed(ActionEvent ae) {
        if (rakentaja.onkoValmis()) {
            Peli peli = rakentaja.teePeli();
            KayttisPeli kayttis = new KayttisPeli(peli);
            kayttis.run();
        }
    }
}
