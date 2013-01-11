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
import mafia.sovelluslogiikka.Pelaaja;
import mafia.sovelluslogiikka.Yo;

/**
 *
 * @author Arto
 */
public class ToimintoVahvistaValinta implements ActionListener {

    private Pelaaja vuorossa;
    private Yo yo;
    private KayttisKuuntelija valittu;
    private Kayttis kayttis;

    public ToimintoVahvistaValinta(Pelaaja vuorossa, Yo yo, KayttisKuuntelija valittu, Kayttis kayttis) {
        this.vuorossa = vuorossa;
        this.yo = yo;
        this.valittu = valittu;
        this.kayttis = kayttis;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Ohjaus.poistaPelaajaVuorolistalta(yo, vuorossa);
        String tapahtuma = Ohjaus.toimi(vuorossa, valittu.getPelaaja(), yo);
        VahvistaTapahtunutPanel vahvistus = new VahvistaTapahtunutPanel(tapahtuma, yo, kayttis);
        kayttis.korvaaKeskusta(vahvistus);
        yo.poistaPelaamattomista(vuorossa);
        
    }
}
