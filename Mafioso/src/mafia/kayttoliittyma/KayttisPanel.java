/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.kayttoliittyma;

import java.awt.BorderLayout;
import javax.swing.JPanel;

/**
 *
 * @author Arto
 */
public class KayttisPanel extends JPanel {
    
    public KayttisPanel(){
        this.setLayout(new BorderLayout());
        MainMenuPanel menu = new MainMenuPanel(this);
        this.add(menu, BorderLayout.CENTER);
    }
    
        public void korvaaKeskusta(JPanel panel){
        this.add(panel, BorderLayout.CENTER);
        this.revalidate();
    }
}
