/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import mafia.kayttoliittyma.KayttisPeliRakentaja.KayttisPeliRakentajaMainPanel;

/**
 *
 * @author Arto
 */
public class Kayttis implements Runnable {

    private JFrame frame;

    public Kayttis() {
    }

    @Override
    public void run() {
        frame = new JFrame("Mafioso");
        frame.setPreferredSize(new Dimension(300, 400));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);


    }

    public void luoKomponentit(Container container) {
        KayttisPanel panel = new KayttisPanel();
        container.add(panel);


    }
    
    public void korvaaKeskusta(JPanel panel){
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.revalidate();
    }
}
