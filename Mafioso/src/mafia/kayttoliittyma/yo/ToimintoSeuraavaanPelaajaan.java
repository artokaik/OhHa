/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.kayttoliittyma.yo;

import mafia.kayttoliittyma.KayttisKuuntelija;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import mafia.kayttoliittyma.Kayttis;
import mafia.kayttoliittyma.pelaajanvalitsija.PelaajanValitsijaPanel;
import mafia.sovelluslogiikka.Ohjaus;
import mafia.sovelluslogiikka.sekalaista.Pelaaja;
import mafia.sovelluslogiikka.peli.Yo;

/**
 *
 * @author Arto
 */
public class ToimintoSeuraavaanPelaajaan implements ActionListener {

    private Ohjaus ohjaus;
    private Kayttis kayttis;

    /**
     *
     * @param ohjaus
     * @param kayttis
     */
    public ToimintoSeuraavaanPelaajaan(Ohjaus ohjaus, Kayttis kayttis) {
        this.kayttis = kayttis;
        this.ohjaus = ohjaus;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        KayttisKuuntelija kuuntelija = new KayttisKuuntelija();
        ToimintoValitseToimija toiminto = new ToimintoValitseToimija(ohjaus, kuuntelija, kayttis);
        PelaajanValitsijaPanel seuraavaYo = new PelaajanValitsijaPanel(ohjaus.haePelaamatta(), toiminto, kuuntelija, "Valitse vuorossa oleva pelaaja");
        kayttis.korvaaKeskusta(seuraavaYo);
//        YoMainPanel panel = new YoMainPanel(kayttis, yo);
//        panel.luoKomponentit();
//        kayttis.korvaaKeskusta(panel);


    }
}