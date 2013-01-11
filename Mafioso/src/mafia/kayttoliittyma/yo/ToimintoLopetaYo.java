/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.kayttoliittyma.yo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import mafia.kayttoliittyma.Kayttis;
import mafia.sovelluslogiikka.Ohjaus;
import mafia.sovelluslogiikka.Paiva;
import mafia.sovelluslogiikka.Yo;

/**
 *
 * @author Arto
 */
public class ToimintoLopetaYo implements ActionListener{
    private Yo yo;
    private Kayttis kayttis;
    
    public ToimintoLopetaYo(Yo yo,  Kayttis kayttis){
        this.kayttis = kayttis;
        this.yo = yo;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Ohjaus.tapaAmmutut(yo);
        YonTapahtumatPanel tapahtumat = new YonTapahtumatPanel(yo, kayttis);
        kayttis.korvaaKeskusta(tapahtumat);
        
    }
    
}
