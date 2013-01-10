/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.kayttoliittyma.yo;

import mafia.kayttoliittyma.KayttisKuuntelija;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import mafia.kayttoliittyma.Kayttis;
import mafia.sovelluslogiikka.Pelaaja;
import mafia.sovelluslogiikka.Yo;

/**
 *
 * @author Arto
 */
public class ToimintoSeuraavaanPelaajaan implements ActionListener{
    private Yo yo;
    private Kayttis kayttis;
    
    public ToimintoSeuraavaanPelaajaan(Yo yo, Kayttis kayttis){
        this.kayttis = kayttis;
        this.yo = yo;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        YoMainPanel panel = new YoMainPanel(kayttis, yo);
        panel.luoKomponentit();
        kayttis.korvaaKeskusta(panel);
              
        
    }
        
        
    }