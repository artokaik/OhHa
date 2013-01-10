/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.kayttoliittyma.Paiva;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import mafia.kayttoliittyma.Kayttis;
import mafia.sovelluslogiikka.Aanestys;

/**
 *
 * @author Arto
 */
public class ToimintoAanestyksenKaynnistys implements ActionListener {

    private Aanestys aanestys;
    private PaivaMainPanel tulokset;
    private JButton nappi;
    private Kayttis kayttis;

    public ToimintoAanestyksenKaynnistys(Aanestys aanestys, PaivaMainPanel tulokset, JButton nappi, Kayttis kayttis) {
        this.aanestys = aanestys;
        this.tulokset = tulokset;
        this.nappi = nappi;
        this.kayttis = kayttis;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        AanestajanValitsijaPanel valitsija = new AanestajanValitsijaPanel(aanestys, tulokset, kayttis);
        valitsija.luoKomponentit();
        kayttis.korvaaKeskusta(valitsija);
        nappi.setEnabled(false);

    }

//    @Override
//    public void actionPerformed(ActionEvent ae) {
//        KayttisAanestajanValitsija valitsija = new KayttisAanestajanValitsija(aanestys, tulokset);
//        valitsija.run();
//        nappi.setEnabled(false);
//
//    }
}
