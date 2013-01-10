/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.kayttoliittyma.Paiva;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import mafia.kayttoliittyma.Kayttis;
import mafia.sovelluslogiikka.Aanestys;

/**
 *
 * @author Arto
 */
public class ToimintoLopetaAanestys implements ActionListener {

    private JPanel panel;
    private Aanestys aanestys;
    private PaivaMainPanel tulokset;
    private Kayttis kayttis;

    public ToimintoLopetaAanestys(Aanestys aanestys, JPanel panel, PaivaMainPanel tulokset, Kayttis kayttis) {
        this.aanestys = aanestys;
        this.panel = panel;
        this.tulokset = tulokset;
        this.kayttis = kayttis;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (aanestys.getAanestamatta().isEmpty()) {
            tulokset.luo(aanestys);
            tulokset.revalidate();
            tulokset.repaint();
            kayttis.korvaaKeskusta(tulokset);
            
        }
    }
}
