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
import mafia.sovelluslogiikka.Ohjaus;

/**
 *
 * @author Arto
 */
public class VahvistaTapahtunutPanel extends JPanel {
    
    private String tapahtuma;
    private Ohjaus ohjaus;
    private Kayttis kayttis;
    

    /**
     *
     * @param tapahtuma
     * @param ohjaus
     * @param kayttis
     */
    public VahvistaTapahtunutPanel(String tapahtuma, Ohjaus ohjaus, Kayttis kayttis) {
        this.tapahtuma = tapahtuma;
        this.ohjaus = ohjaus;
        this.kayttis=kayttis;
        this.setPreferredSize(new Dimension(kayttis.getKeskustaMitat()));
        
        JLabel teksti = new JLabel(tapahtuma);
        this.add(teksti);
        
        JButton seuraava = new JButton("Seuraava pelaaja");
        ToimintoSeuraavaanPelaajaan toiminto = new ToimintoSeuraavaanPelaajaan(ohjaus,kayttis);
        seuraava.addActionListener(toiminto);
        this.add(seuraava);
    }
}