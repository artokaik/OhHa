/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.kayttoliittyma;

import mafia.kayttoliittyma.mainMenu.MainMenuPanel;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author Arto
 */
public class Kayttis implements Runnable {

    private JFrame frame;
    private JPanel keskusta;
    private Dimension keskustaMitat;


    public Kayttis() {
        keskusta = new JPanel();
        keskustaMitat = new Dimension (550,520);
    }

    @Override
    public void run() {
        frame = new JFrame("Mafioso");
        frame.setPreferredSize(new Dimension(800, 600));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);


    }

    public void luoKomponentit(Container container) {
        container.setLayout(new BorderLayout());
        MainMenuPanel menu = new MainMenuPanel(this);
        keskusta.add(menu);
        container.add(keskusta, BorderLayout.CENTER);


    }
        public void korvaaKeskusta(JPanel panel){
        keskusta.removeAll();
        keskusta = new JPanel();
        
        frame.getContentPane().add(keskusta, BorderLayout.CENTER);
        keskusta.add(panel);
        frame.revalidate();
    }
    
//    public void korvaaKeskusta(JPanel panel){
//        frame.getContentPane().removeAll();
//        frame.getContentPane().add(panel, BorderLayout.CENTER);
//        frame.revalidate();
//    }

    public JFrame getFrame() {
        return frame;
    }

    public Dimension getKeskustaMitat() {
        return keskustaMitat;
    }
    
    
}
