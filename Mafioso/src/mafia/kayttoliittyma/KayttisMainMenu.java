/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.kayttoliittyma;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Arto
 */
public class KayttisMainMenu {
    private JPanel panel;
    private Kayttis kayttis;
    
    public KayttisMainMenu(Kayttis kayttis){
        panel = new JPanel();
        panel.add(teeUusiPeliNappi());
        this.kayttis = kayttis;
    }
    
    public JButton teeUusiPeliNappi(){
        JButton nappi = new JButton("Uusi peli");
        ToimintoUusiPeliRakentaja toiminto = new ToimintoUusiPeliRakentaja(kayttis);
        nappi.addActionListener(toiminto);
        return nappi;
    }

    public JPanel getPanel() {
        return panel;
    }
    
}
