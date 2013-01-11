/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.kayttoliittyma.yo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import mafia.kayttoliittyma.Kayttis;
import mafia.kayttoliittyma.KayttisKuuntelija;
import mafia.sovelluslogiikka.Ohjaus;
import mafia.sovelluslogiikka.sekalaista.Pelaaja;
import mafia.sovelluslogiikka.peli.Yo;

/**
 *
 * @author Arto
 */
public class ToimintoVahvistaValinta implements ActionListener {

    private Ohjaus ohjaus;
    private KayttisKuuntelija valittu;
    private Kayttis kayttis;

    /**
     *
     * @param ohjaus
     * @param valittu
     * @param kayttis
     */
    public ToimintoVahvistaValinta(Ohjaus ohjaus, KayttisKuuntelija valittu, Kayttis kayttis) {
        this.ohjaus = ohjaus;
        this.valittu = valittu;
        this.kayttis = kayttis;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        ohjaus.poistaPelaajaYonVuorolistalta();
        String tapahtuma = ohjaus.toimi(valittu.getPelaaja());
        VahvistaTapahtunutPanel vahvistus = new VahvistaTapahtunutPanel(tapahtuma, ohjaus, kayttis);
        kayttis.korvaaKeskusta(vahvistus);
        ohjaus.poistaPelaajaYonVuorolistalta();
        
    }
}
