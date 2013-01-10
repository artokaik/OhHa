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
public class ToimintoValitseToimija implements ActionListener{
    private Yo yo;
    private Pelaaja pelaaja;
    private JButton nappi; 
    private Kayttis kayttis;
    
    public ToimintoValitseToimija(Yo yo, Pelaaja pelaaja, JButton nappi, Kayttis kayttis){
        this.kayttis = kayttis;
        this.yo = yo;
        this.pelaaja = pelaaja;
        this.nappi = nappi;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        YoVuoroPanel panel = new YoVuoroPanel(kayttis, yo, pelaaja);
        kayttis.korvaaKeskusta(panel);
        nappi.setEnabled(false);        
        
    }
        
        
    }