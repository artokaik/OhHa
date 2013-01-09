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

/**
 *
 * @author Arto
 */
public class Kayttis implements Runnable {

    private JFrame frame;
    private JPanel vasen;
    private JPanel oikea;
    private JPanel keskusta;
    private JPanel ylin;
    private JPanel alin;

    public Kayttis() {
        vasen = new JPanel();
        oikea = new JPanel();
        ylin = new JPanel();
        alin = new JPanel();
        keskusta = new JPanel();


    }

    @Override
    public void run() {
        frame = new JFrame("Mafioso");
        frame.setPreferredSize(new Dimension(300, 400));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
        KayttisMainMenu menu = new KayttisMainMenu(this);
        keskusta = menu.getPanel();
        frame.getContentPane().add(keskusta, BorderLayout.CENTER);
        keskusta.revalidate();
    }

    public void luoKomponentit(Container container) {
        container.setLayout(new BorderLayout());
        container.add(vasen, BorderLayout.WEST);
        container.add(keskusta, BorderLayout.CENTER);
        container.add(oikea, BorderLayout.EAST);
        container.add(ylin, BorderLayout.NORTH);
        container.add(alin, BorderLayout.SOUTH);
    }

    public JFrame getFrame() {
        return frame;
    }

    public JPanel getVasen() {
        return vasen;
    }

    public JPanel getOikea() {
        return oikea;
    }

    public JPanel getKeskusta() {
        return keskusta;
    }

    public JPanel getYlin() {
        return ylin;
    }

    public JPanel getAlin() {
        return alin;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public void setVasen(JPanel vasen) {
        this.vasen = vasen;
        vasen.revalidate();
    }

    public void setOikea(JPanel oikea) {
        this.oikea = oikea;
        oikea.revalidate();
    }

    public void setKeskusta(JPanel keskusta) {
        this.keskusta = keskusta;
        keskusta.revalidate();
    }

    public void setYlin(JPanel ylin) {
        this.ylin = ylin;
        ylin.revalidate();
    }

    public void setAlin(JPanel alin) {
        this.alin = alin;
        alin.revalidate();
    }
}
