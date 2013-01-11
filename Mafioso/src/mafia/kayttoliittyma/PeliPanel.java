/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JPanel;
import mafia.kayttoliittyma.Paiva.PaivaMainPanel;
import mafia.kayttoliittyma.yo.ToimintoValitseToimija;
import mafia.sovelluslogiikka.Aanestys;
import mafia.sovelluslogiikka.Ohjaus;
import mafia.sovelluslogiikka.Paiva;
import mafia.sovelluslogiikka.Yo;
import mafia.sovelluslogiikka.peli.Peli;

/**
 *
 * @author Arto
 */
public class PeliPanel extends JPanel {

    private Ohjaus ohjaus;
    private Kayttis kayttis;

    public PeliPanel(Ohjaus ohjaus, Kayttis kayttis) {
        this.ohjaus = ohjaus;
        this.kayttis = kayttis;
        this.setPreferredSize(new Dimension(kayttis.getKeskustaMitat()));

        
        this.setLayout(new BorderLayout());
        JPanel keskusta = new JPanel();
        if (ohjaus.getSaannot().getPaivaEnsin()) {
            keskusta = teePaiva();
        } else {
            keskusta = teeYo();
        }
        this.add(keskusta, BorderLayout.CENTER);

    }

    public JPanel teePaiva() {
        Paiva paiva = new Paiva(ohjaus.getKaikkiPelaajat());
        ohjaus.setPaiva(paiva);
        PaivaMainPanel tulokset = new PaivaMainPanel(ohjaus, kayttis);
        ohjaus.luoEnsimmainenAanestys();
        tulokset.luo(ohjaus.getAanestys());
        return tulokset;
    }
    
        public JPanel teeYo() {
              Yo yo = new Yo(ohjaus.getKaikkiPelaajat());
              KayttisKuuntelija kuuntelija = new KayttisKuuntelija();
              ToimintoValitseToimija toiminto = new ToimintoValitseToimija(yo,kuuntelija, kayttis);
              PelaajanValitsijaPanel yoPanel = new PelaajanValitsijaPanel(ohjaus.getKaikkiPelaajat(), toiminto, kuuntelija, "Valitse vuorossa oleva pelaaja");
        return yoPanel;
    }
}
