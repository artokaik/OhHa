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
import mafia.sovelluslogiikka.Yo;

/**
 *
 * @author Arto
 */
public class YonTapahtumatPanel extends JPanel {
    private Yo yo;
    private Kayttis kayttis;
    
    public YonTapahtumatPanel(Yo yo, Kayttis kayttis){
        this.yo = yo;
        this.kayttis = kayttis;
        this.setPreferredSize(new Dimension(kayttis.getKeskustaMitat()));
        
        this.setLayout(new GridLayout(2,1));
        JLabel tapahtumat = new JLabel(yo.kerroTapahtumat());
        this.add(tapahtumat);
        
        JButton jatka = new JButton("Jatka");
        ToimintoSeuraavaanPaivaan toiminto = new ToimintoSeuraavaanPaivaan(yo, kayttis);
        jatka.addActionListener(toiminto);
       
        this.add(jatka);
        
    }
}
