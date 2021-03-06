/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.kayttoliittyma.Paiva;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import mafia.kayttoliittyma.Kayttis;
import mafia.kayttoliittyma.KayttisKuuntelija;
import mafia.kayttoliittyma.pelaajanvalitsija.PelaajanValitsijaPanel;
import mafia.sovelluslogiikka.sekalaista.Aanestys;
import mafia.sovelluslogiikka.Ohjaus;

/**
 *
 * @author Arto
 */
public class ToimintoAanestyksenKaynnistys implements ActionListener {

    private Ohjaus ohjaus;
    private PaivaMainPanel tulokset;
    private JButton nappi;
    private Kayttis kayttis;

    /**
     *
     * @param ohjaus
     * @param tulokset
     * @param nappi
     * @param kayttis
     */
    public ToimintoAanestyksenKaynnistys(Ohjaus ohjaus, PaivaMainPanel tulokset, JButton nappi, Kayttis kayttis) {
        this.ohjaus = ohjaus;
        this.tulokset = tulokset;
        this.nappi = nappi;
        this.kayttis = kayttis;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        KayttisKuuntelija kuuntelija = new KayttisKuuntelija();
        ToimintoValitseAanestaja valitseAanestaja = new ToimintoValitseAanestaja(kuuntelija, tulokset, kayttis, ohjaus);
        PelaajanValitsijaPanel valitsija = new PelaajanValitsijaPanel(ohjaus.haeAanestamatta(), valitseAanestaja, kuuntelija, "Valitse äänestäjä");
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
