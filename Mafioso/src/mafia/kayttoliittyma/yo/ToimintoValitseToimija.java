/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.kayttoliittyma.yo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import mafia.kayttoliittyma.Kayttis;
import mafia.kayttoliittyma.KayttisKuuntelija;
import mafia.kayttoliittyma.PelaajanValitsijaPanel;
import mafia.sovelluslogiikka.Ohjaus;
import mafia.sovelluslogiikka.Pelaaja;
import mafia.sovelluslogiikka.Yo;

/**
 *
 * @author Arto
 */
public class ToimintoValitseToimija implements ActionListener {

    private Yo yo;
    private KayttisKuuntelija kuuntelija;
    private Kayttis kayttis;

    public ToimintoValitseToimija(Yo yo, KayttisKuuntelija kuuntelija, Kayttis kayttis) {
        this.kayttis = kayttis;
        this.yo = yo;
        this.kuuntelija = kuuntelija;

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (!Ohjaus.haePelaamatta(yo).isEmpty()) {
            KayttisKuuntelija kuuntelija2 = new KayttisKuuntelija();
            ToimintoVahvistaValinta valitunVahvistus = new ToimintoVahvistaValinta(kuuntelija.getPelaaja(), yo, kuuntelija2, kayttis);
            PelaajanValitsijaPanel valitsijaPanel = new PelaajanValitsijaPanel(Ohjaus.getValittavanaYolla(kuuntelija.getPelaaja(), yo), valitunVahvistus, kuuntelija2, Ohjaus.getRooliSelitys(kuuntelija.getPelaaja(), yo));
            kayttis.korvaaKeskusta(valitsijaPanel);
        } else {
            Ohjaus.tapaAmmutut(yo);
            YonTapahtumatPanel tapahtumat = new YonTapahtumatPanel(yo, kayttis);
            kayttis.korvaaKeskusta(tapahtumat);
        }

    }
}