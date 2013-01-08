/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.kayttoliittyma.Aanestys;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import mafia.sovelluslogiikka.Aanestys;

/**
 *
 * @author Arto
 */
public class ToimintoAanestyksenKaynnistys implements ActionListener {
    private Aanestys aanestys;

    
    public ToimintoAanestyksenKaynnistys(Aanestys aanestys) {
        this.aanestys=aanestys;
    }
    
        @Override
    public void actionPerformed(ActionEvent ae) {
        KayttisAanestajanValitsija valitsija = new KayttisAanestajanValitsija(aanestys);
        valitsija.run();
        
    }
}
