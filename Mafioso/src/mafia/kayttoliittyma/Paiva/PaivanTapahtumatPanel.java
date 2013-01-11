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
import mafia.sovelluslogiikka.Ohjaus;

/**
 *
 * @author Arto
 */
public class PaivanTapahtumatPanel extends JPanel {
    private Ohjaus ohjaus;
    private Kayttis kayttis;
    
    /**
     *
     * @param ohjaus
     * @param kayttis
     */
    public PaivanTapahtumatPanel(Ohjaus ohjaus, Kayttis kayttis){
        this.ohjaus = ohjaus;
        this.kayttis = kayttis;
        
        this.setPreferredSize(new Dimension(kayttis.getKeskustaMitat()));
        
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        JLabel tapahtumat = new JLabel(ohjaus.kerroTuoreetTapahtumat());
        this.add(tapahtumat);
        
        JButton jatka = new JButton("Jatka");
        ToimintoSeuraavaanYohon toiminto = new ToimintoSeuraavaanYohon(ohjaus, kayttis);
        jatka.addActionListener(toiminto);
       
        this.add(jatka);
        
    }
}
