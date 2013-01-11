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
import mafia.kayttoliittyma.pelaajanvalitsija.PelaajanValitsijaPanel;
import mafia.sovelluslogiikka.Ohjaus;
import mafia.sovelluslogiikka.sekalaista.Pelaaja;
import mafia.sovelluslogiikka.peli.Yo;

/**
 *
 * @author Arto
 */
public class ToimintoValitseToimija implements ActionListener {

    private Ohjaus ohjaus;
    private KayttisKuuntelija kuuntelija;
    private Kayttis kayttis;

    /**
     *
     * @param ohjaus
     * @param kuuntelija
     * @param kayttis
     */
    public ToimintoValitseToimija(Ohjaus ohjaus, KayttisKuuntelija kuuntelija, Kayttis kayttis) {
        this.kayttis = kayttis;
        this.ohjaus = ohjaus;
        this.kuuntelija = kuuntelija;

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        ohjaus.setToimija(kuuntelija.getPelaaja());
        if (!ohjaus.haePelaamatta().isEmpty()) {
            KayttisKuuntelija kuuntelija2 = new KayttisKuuntelija();
            ToimintoVahvistaValinta valitunVahvistus = new ToimintoVahvistaValinta(ohjaus, kuuntelija2, kayttis);
            PelaajanValitsijaPanel valitsijaPanel = new PelaajanValitsijaPanel(ohjaus.getValittavanaYolla(kuuntelija.getPelaaja()), valitunVahvistus, kuuntelija2, ohjaus.getRooliSelitys(kuuntelija.getPelaaja()));
            kayttis.korvaaKeskusta(valitsijaPanel);
        } else {
            ohjaus.tapaAmmutut();
            YonTapahtumatPanel tapahtumat = new YonTapahtumatPanel(ohjaus, kayttis);
            kayttis.korvaaKeskusta(tapahtumat);
        }

    }
}