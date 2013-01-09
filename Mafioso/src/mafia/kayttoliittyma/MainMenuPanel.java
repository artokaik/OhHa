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
public class MainMenuPanel extends JPanel{
   
    private KayttisPanel kayttis;
    
    public MainMenuPanel(KayttisPanel kayttis){
        
        this.add(teeUusiPeliNappi());
        this.kayttis = kayttis;
    }
    
    public JButton teeUusiPeliNappi(){
        JButton nappi = new JButton("Uusi peli");
        ToimintoUusiPeliRakentaja toiminto = new ToimintoUusiPeliRakentaja(kayttis);
        nappi.addActionListener(toiminto);
        return nappi;
    }


    
}
