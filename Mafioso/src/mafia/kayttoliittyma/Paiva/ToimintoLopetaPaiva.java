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
import mafia.sovelluslogiikka.Paiva;
import mafia.sovelluslogiikka.Yo;

/**
 *
 * @author Arto
 */
public class ToimintoLopetaPaiva implements ActionListener{
    private Paiva paiva;
    private Kayttis kayttis;
    
    public ToimintoLopetaPaiva(Paiva paiva,  Kayttis kayttis){
        this.kayttis = kayttis;
        this.paiva = paiva;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        paiva.tapaLynkattavat();
        Yo yo = paiva.luoSeuraavaVaihe();
        PaivanTapahtumatPanel tapahtumat = new PaivanTapahtumatPanel(paiva, kayttis);
        kayttis.korvaaKeskusta(tapahtumat);
        
    }
    
}
