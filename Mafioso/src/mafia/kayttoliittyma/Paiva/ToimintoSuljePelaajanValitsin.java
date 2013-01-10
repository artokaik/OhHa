/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.kayttoliittyma.Paiva;

import mafia.kayttoliittyma.KayttisKuuntelija;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import javax.swing.JFrame;
import mafia.sovelluslogiikka.Aanestys;
import mafia.sovelluslogiikka.Pelaaja;

/**
 *
 * @author Arto
 */
public class ToimintoSuljePelaajanValitsin implements ActionListener {

    private JFrame frame;
    private KayttisKuuntelija kuuntelija;
    private Pelaaja aanestaja;
    private Aanestys aanestys;

    public ToimintoSuljePelaajanValitsin(Aanestys aanestys, JFrame frame, Pelaaja aanestaja, KayttisKuuntelija kuuntelija) {
        this.aanestys = aanestys;
        this.frame = frame;
        this.kuuntelija = kuuntelija;
        this.aanestaja = aanestaja;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (kuuntelija.getPelaaja() != null) {
            aanestys.lisaaAani(aanestaja, kuuntelija.getPelaaja());
            frame.dispose();
        }


    }
}
