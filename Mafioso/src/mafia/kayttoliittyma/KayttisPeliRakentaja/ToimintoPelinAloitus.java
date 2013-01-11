/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.kayttoliittyma.KayttisPeliRakentaja;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import mafia.kayttoliittyma.Kayttis;
import mafia.kayttoliittyma.PeliPanel;
import mafia.sovelluslogiikka.Ohjaus;

/**
 * 
 * @author Arto
 */
public class ToimintoPelinAloitus implements ActionListener {

    private Ohjaus ohjaus;
    private Kayttis kayttis;

    public ToimintoPelinAloitus(Ohjaus ohjaus, Kayttis kayttis) {
        this.ohjaus= ohjaus;
        this.kayttis=kayttis;
    }

    public void actionPerformed(ActionEvent ae) {

            PeliPanel peliKayttis = new PeliPanel(ohjaus, kayttis);
            kayttis.korvaaKeskusta(peliKayttis);

        }
    }

