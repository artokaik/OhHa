/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.kayttoliittyma.Paiva;

import mafia.kayttoliittyma.KayttisKuuntelija;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import mafia.kayttoliittyma.Kayttis;
import mafia.kayttoliittyma.PelaajanValitsijaPanel;
import mafia.sovelluslogiikka.Aanestys;
import mafia.sovelluslogiikka.Ohjaus;
import mafia.sovelluslogiikka.Pelaaja;

/**
 *
 * @author Arto
 */
public class ToimintoSuljePelaajanValitsin implements ActionListener {

    private KayttisKuuntelija kuuntelija;
    private Ohjaus ohjaus;
    private PaivaMainPanel tulokset;
    private Kayttis kayttis;

    public ToimintoSuljePelaajanValitsin(Ohjaus ohjaus, KayttisKuuntelija kuuntelija, PaivaMainPanel tulokset, Kayttis kayttis) {

        this.kuuntelija = kuuntelija;
        this.ohjaus = ohjaus;
        this.tulokset = tulokset;
        this.kayttis = kayttis;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (kuuntelija.getPelaaja() != null) {
            ohjaus.lisaaAani( kuuntelija.getPelaaja());
            if (ohjaus.haeAanestamatta().size() > 0) {
                kuuntelija = new KayttisKuuntelija();
                ToimintoValitseAanestaja valitseAanestaja = new ToimintoValitseAanestaja(kuuntelija, tulokset, kayttis, ohjaus);
                PelaajanValitsijaPanel valitsija = new PelaajanValitsijaPanel(ohjaus.haeAanestamatta(), valitseAanestaja, kuuntelija, "Valitse äänestäjä");
                kayttis.korvaaKeskusta(valitsija);
            } else {

                tulokset.luo(ohjaus.getAanestys());
                tulokset.revalidate();
                tulokset.repaint();
                kayttis.korvaaKeskusta(tulokset);
            }

        }


    }
}
