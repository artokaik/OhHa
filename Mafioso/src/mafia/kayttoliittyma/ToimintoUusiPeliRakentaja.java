/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import mafia.kayttoliittyma.KayttisPeliRakentaja.KayttisPeliRakentajaMainPanel;

/**
 *
 * @author Arto
 */
public class ToimintoUusiPeliRakentaja implements ActionListener{
    private KayttisPanel kayttis;
    
    public ToimintoUusiPeliRakentaja(KayttisPanel kayttis){
        this.kayttis=kayttis;
    }
    
        @Override
    public void actionPerformed(ActionEvent ae) {
            KayttisPeliRakentajaMainPanel rakentaja = new KayttisPeliRakentajaMainPanel();
            JPanel panel = rakentaja.luo();
            
            kayttis.korvaaKeskusta(panel);
    }
}
