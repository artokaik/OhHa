/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.kayttoliittyma.Paiva;

import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import mafia.kayttoliittyma.Kayttis;
import mafia.sovelluslogiikka.Paiva;

/**
 *
 * @author Arto
 */
public class PaivanTapahtumatPanel extends JPanel {
    private Paiva paiva;
    private Kayttis kayttis;
    
    public PaivanTapahtumatPanel(Paiva paiva, Kayttis kayttis){
        this.paiva = paiva;
        this.kayttis = kayttis;
        
        this.setPreferredSize(new Dimension(kayttis.getKeskustaMitat()));
        
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        JLabel tapahtumat = new JLabel(paiva.kerroTapahtumat());
        this.add(tapahtumat);
        
        JButton jatka = new JButton("Jatka");
        ToimintoSeuraavaanYohon toiminto = new ToimintoSeuraavaanYohon(paiva, kayttis);
        jatka.addActionListener(toiminto);
       
        this.add(jatka);
        
    }
}
