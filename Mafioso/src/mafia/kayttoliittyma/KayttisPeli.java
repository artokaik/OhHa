/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import mafia.kayttoliittyma.Aanestys.KayttisAanestysTulokset;
import mafia.sovelluslogiikka.Aanestys;
import mafia.sovelluslogiikka.Paiva;
import mafia.sovelluslogiikka.peli.Peli;

/**
 *
 * @author Arto
 */
public class KayttisPeli implements Runnable {

    private JFrame frame;
    private Peli peli;

    public KayttisPeli(Peli peli) {
        this.peli = peli;
    }

    @Override
    public void run() {
        frame = new JFrame("Mafioso-peli");
        frame.setPreferredSize(new Dimension(300, 400));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);

    }

    public void luoKomponentit(Container container) {
        container.setLayout(new BorderLayout());
        JPanel keskusta = new JPanel();
        JButton uusiVaihe = new JButton("Käynnistä seuraava vaihe");
        if (peli.getSaannot().getPaivaEnsin()) {
            Paiva paiva = new Paiva(peli.getPelaajat());
            KayttisAanestysTulokset tulokset = new KayttisAanestysTulokset(paiva);
            Aanestys aanestys = new Aanestys(peli.getPelaajat(), peli.getPelaajat());
            tulokset.luo(aanestys);
            keskusta = tulokset.getPanel();
        }

        container.add(keskusta, BorderLayout.CENTER);
        container.add(uusiVaihe, BorderLayout.SOUTH);

    }
}
