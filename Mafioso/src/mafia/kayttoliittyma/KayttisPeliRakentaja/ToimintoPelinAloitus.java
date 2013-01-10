/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.kayttoliittyma.KayttisPeliRakentaja;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import mafia.kayttoliittyma.Kayttis;
import mafia.kayttoliittyma.PeliPanel;
import mafia.sovelluslogiikka.peli.Peli;
import mafia.sovelluslogiikka.peli.PeliRakentaja;

/**
 *
 * @author Arto
 */
public class ToimintoPelinAloitus implements ActionListener {

    private PeliRakentaja rakentaja;
    private Kayttis kayttis;

    public ToimintoPelinAloitus(PeliRakentaja rakentaja, Kayttis kayttis) {
        this.rakentaja = rakentaja;
        this.kayttis=kayttis;
    }

    public void actionPerformed(ActionEvent ae) {
        if (rakentaja.onkoValmis()) {
            Peli peli = rakentaja.teePeli();
            PeliPanel peliKayttis = new PeliPanel(peli, kayttis);
            peliKayttis.aseta();
            kayttis.korvaaKeskusta(peliKayttis);

        }
    }
}
