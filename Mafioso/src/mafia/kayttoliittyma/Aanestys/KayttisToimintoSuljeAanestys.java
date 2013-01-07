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
public class KayttisToimintoSuljeAanestys implements ActionListener{
    
    private JFrame frame;
    private Aanestys aanestys;

    public KayttisToimintoSuljeAanestys(Aanestys aanestys, JFrame frame) {
        this.aanestys = aanestys;
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (aanestys.getAanestamatta().isEmpty()) {
            frame.dispose();
        }
    }
}
