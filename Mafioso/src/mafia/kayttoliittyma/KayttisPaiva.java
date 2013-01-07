/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.kayttoliittyma;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import mafia.sovelluslogiikka.Paiva;

/**
 *
 * @author Arto
 */
public class KayttisPaiva {
    private JPanel panel;
    private Paiva paiva;
    
    public KayttisPaiva(Paiva paiva){
        this.paiva = paiva;
    }
    
    public JPanel haeJPanel(){
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(300, 400));
        panel.setLayout(new GridLayout(3,1));
        
        JLabel tulokset = new JLabel();
        panel.add(tulokset);
        
        JButton aanestykseen = new JButton("Äänestykseen");
        panel.add(aanestykseen);
        panel.setVisible(true);
        return panel;
    }
    
}
