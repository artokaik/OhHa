/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.kayttoliittyma.Aanestys;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import mafia.sovelluslogiikka.Aanestys;
import mafia.sovelluslogiikka.Pelaaja;

/**
 *
 * @author Arto
 */
public class ToimintoSuljeAanestys implements ActionListener {

    private JFrame frame;
    private Aanestys aanestys;
    private KayttisAanestysTulokset tulokset;

    public ToimintoSuljeAanestys(Aanestys aanestys, JFrame frame, KayttisAanestysTulokset tulokset) {
        this.aanestys = aanestys;
        this.frame = frame;
        this.tulokset = tulokset;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (aanestys.getAanestamatta().isEmpty()) {
            tulokset.luo(aanestys);
            tulokset.getPanel().revalidate();
            tulokset.getPanel().repaint();

            frame.dispose();
        }
    }
}
