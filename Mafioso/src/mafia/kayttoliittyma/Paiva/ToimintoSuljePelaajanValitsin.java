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
    private Pelaaja aanestaja;
    private Aanestys aanestys;
    private PaivaMainPanel tulokset;
    private Kayttis kayttis;

    public ToimintoSuljePelaajanValitsin(Aanestys aanestys, Pelaaja aanestaja, KayttisKuuntelija kuuntelija, PaivaMainPanel tulokset, Kayttis kayttis) {
        this.aanestys = aanestys;
        this.kuuntelija = kuuntelija;
        this.aanestaja = aanestaja;
        this.tulokset = tulokset;
        this.kayttis=kayttis;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (kuuntelija.getPelaaja() != null) {
            Ohjaus.lisaaAani(aanestys, aanestaja, kuuntelija.getPelaaja());
            if (Ohjaus.haeAanestamatta(aanestys).size() > 0) {
                kuuntelija = new KayttisKuuntelija();
                ToimintoValitseAanestaja valitseAanestaja = new ToimintoValitseAanestaja(aanestys, kuuntelija, tulokset, kayttis);
                PelaajanValitsijaPanel valitsija = new PelaajanValitsijaPanel(Ohjaus.haeAanestamatta(aanestys), valitseAanestaja, kuuntelija, "Valitse äänestäjä");
                kayttis.korvaaKeskusta(valitsija);
            } else {
                
                tulokset.luo(aanestys);
                tulokset.revalidate();
                tulokset.repaint();
                kayttis.korvaaKeskusta(tulokset);
            }

        }


    }
}
