/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.kayttoliittyma.yo;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import mafia.kayttoliittyma.Kayttis;
import mafia.sovelluslogiikka.Ohjaus;

/**
 *
 * @author Arto
 */
public class YonTapahtumatPanel extends JPanel {
    private Ohjaus ohjaus;
    private Kayttis kayttis;
    
    /**
     *
     * @param ohjaus
     * @param kayttis
     */
    public YonTapahtumatPanel(Ohjaus ohjaus, Kayttis kayttis){
        this.ohjaus = ohjaus;
        this.kayttis = kayttis;
        this.setPreferredSize(new Dimension(kayttis.getKeskustaMitat()));
        
        this.setLayout(new GridLayout(2,1));
        JLabel tapahtumat = new JLabel(ohjaus.kerroTuoreetTapahtumat());
        this.add(tapahtumat);
        
        JButton jatka = new JButton("Jatka");
        ToimintoSeuraavaanPaivaan toiminto = new ToimintoSeuraavaanPaivaan(ohjaus, kayttis);
        jatka.addActionListener(toiminto);
       
        this.add(jatka);
        
    }
}
