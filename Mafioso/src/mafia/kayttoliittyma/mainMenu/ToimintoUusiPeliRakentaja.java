/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.kayttoliittyma.mainMenu;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import mafia.kayttoliittyma.Kayttis;
import mafia.kayttoliittyma.KayttisPeliRakentaja.PeliRakentajaMainPanel;

/**
 *
 * @author Arto
 */
public class ToimintoUusiPeliRakentaja implements ActionListener{
    private Kayttis kayttis;
    
    public ToimintoUusiPeliRakentaja(Kayttis kayttis){
        this.kayttis=kayttis;
    }
    
        @Override
    public void actionPerformed(ActionEvent ae) {
            PeliRakentajaMainPanel rakentaja = new PeliRakentajaMainPanel(kayttis);
            JPanel panel = rakentaja.luo();          
            kayttis.korvaaKeskusta(panel);
    }
}
