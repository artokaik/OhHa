/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.kayttoliittyma.Paiva;

import mafia.kayttoliittyma.yo.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import mafia.kayttoliittyma.Kayttis;
import mafia.kayttoliittyma.Paiva.PaivaMainPanel;
import mafia.sovelluslogiikka.Ohjaus;
import mafia.sovelluslogiikka.peli.Paiva;
import mafia.sovelluslogiikka.peli.Yo;

/**
 *
 * @author Arto
 */
public class ToimintoLopetaPaiva implements ActionListener{
    private Ohjaus ohjaus;
    private Kayttis kayttis;
    
    /**
     *
     * @param ohjaus
     * @param kayttis
     */
    public ToimintoLopetaPaiva(Ohjaus ohjaus,  Kayttis kayttis){
        this.kayttis = kayttis;
        this.ohjaus = ohjaus;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        ohjaus.tapaLynkatut();
        PaivanTapahtumatPanel tapahtumat = new PaivanTapahtumatPanel(ohjaus, kayttis);
        kayttis.korvaaKeskusta(tapahtumat);
        
    }
    
}
