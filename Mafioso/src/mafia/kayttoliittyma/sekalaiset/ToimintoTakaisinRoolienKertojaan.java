/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.kayttoliittyma.sekalaiset;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import mafia.kayttoliittyma.Kayttis;
import mafia.sovelluslogiikka.Ohjaus;

/**
 *
 * @author Arto
 */
public class ToimintoTakaisinRoolienKertojaan implements ActionListener {

    private Ohjaus ohjaus;
    private Kayttis kayttis;

    /**
     *
     * @param ohjaus
     * @param kayttis
     */
    public ToimintoTakaisinRoolienKertojaan(Ohjaus ohjaus, Kayttis kayttis) {
        this.ohjaus = ohjaus;
        this.kayttis = kayttis;

    }

    public void actionPerformed(ActionEvent ae) {


        RoolienKertojaPanel roolienKertoja = new RoolienKertojaPanel(ohjaus, kayttis);
        kayttis.korvaaKeskusta(roolienKertoja);

    }
}
