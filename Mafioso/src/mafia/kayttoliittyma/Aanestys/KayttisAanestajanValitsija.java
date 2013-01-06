/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.kayttoliittyma.Aanestys;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import mafia.sovelluslogiikka.Aanestys;
import mafia.sovelluslogiikka.Pelaaja;

/**
 *
 * @author Arto
 */
public class KayttisAanestajanValitsija implements Runnable {

    private JFrame frame;
    private Aanestys aanestys;

    public KayttisAanestajanValitsija(Aanestys aanestys){
        this.aanestys = aanestys;    
    }

    @Override
    public void run() {
        frame = new JFrame("Pelaajan valitsija");
        frame.setPreferredSize(new Dimension(300, 400));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);



    }

    public void luoKomponentit(Container container) {
        container.setLayout(new GridLayout(aanestys.getAanestamatta().size() + 4, 1));
        JLabel otsikko = new JLabel("Valitse äänestäjä");
        container.add(otsikko);
        JLabel valittu = new JLabel();
        for (Pelaaja pelaaja : aanestys.getAanestamatta()) {
            JButton pelaajaNappi = new JButton(pelaaja.getNimi());
            KayttisToimintoValitseAanestaja toiminto = new KayttisToimintoValitseAanestaja(aanestys,pelaaja,pelaajaNappi);
            pelaajaNappi.addActionListener(toiminto);
            container.add(pelaajaNappi);
        }
        JLabel teksti = new JLabel("Valittu:");
        JButton suljeNappi = new JButton("OK");
//        KayttisSuljePelaajanValitsinToiminto sulje = new KayttisSuljePelaajanValitsinToiminto(this.frame);
//        suljeNappi.addActionListener(sulje);

        container.add(teksti);
        container.add(valittu);
        container.add(suljeNappi);

    }
}
