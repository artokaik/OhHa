/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.kayttoliittyma.yo;

import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import mafia.kayttoliittyma.Kayttis;
import mafia.sovelluslogiikka.Yo;

/**
 *
 * @author Arto
 */
public class VahvistaTapahtunutPanel extends JPanel {
    
    private String tapahtuma;
    private Yo yo;
    private Kayttis kayttis;
    

    public VahvistaTapahtunutPanel(String tapahtuma, Yo yo, Kayttis kayttis) {
        this.tapahtuma = tapahtuma;
        this.yo = yo;
        this.kayttis=kayttis;
        this.setPreferredSize(new Dimension(kayttis.getKeskustaMitat()));
        
        JLabel teksti = new JLabel(tapahtuma);
        this.add(teksti);
        
        JButton seuraava = new JButton("Seuraava pelaaja");
        ToimintoSeuraavaanPelaajaan toiminto = new ToimintoSeuraavaanPelaajaan(yo,kayttis);
        seuraava.addActionListener(toiminto);
        this.add(seuraava);
    }
}