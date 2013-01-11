/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.kayttoliittyma.sekalaiset;

import mafia.kayttoliittyma.pelaajanvalitsija.PelaajanValitsijaPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JPanel;
import mafia.kayttoliittyma.Kayttis;
import mafia.kayttoliittyma.KayttisKuuntelija;
import mafia.kayttoliittyma.Paiva.PaivaMainPanel;
import mafia.kayttoliittyma.yo.ToimintoValitseToimija;
import mafia.sovelluslogiikka.sekalaista.Aanestys;
import mafia.sovelluslogiikka.Ohjaus;
import mafia.sovelluslogiikka.peli.Paiva;
import mafia.sovelluslogiikka.peli.Yo;
import mafia.sovelluslogiikka.peli.Peli;

/**
 *
 * @author Arto
 */
public class PeliPanel extends JPanel {
    
    private Ohjaus ohjaus;
    private Kayttis kayttis;
    
    /**
     *
     * @param ohjaus
     * @param kayttis
     */
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
    
    /**
     *
     * @return
     */
    public JPanel teePaiva() {
        Paiva paiva = (Paiva) ohjaus.siirrySeuraavaanVaiheeseen();
        ohjaus.setPaiva(paiva);
        PaivaMainPanel tulokset = new PaivaMainPanel(ohjaus, kayttis);
        ohjaus.luoEnsimmainenAanestys();
        tulokset.luo(ohjaus.getAanestys());
        return tulokset;
    }
    
    /**
     *
     * @return
     */
    public JPanel teeYo() {
        Yo yo = (Yo) ohjaus.siirrySeuraavaanVaiheeseen();
        ohjaus.setYo(yo);
        KayttisKuuntelija kuuntelija = new KayttisKuuntelija();
        ToimintoValitseToimija toiminto = new ToimintoValitseToimija(ohjaus, kuuntelija, kayttis);
        PelaajanValitsijaPanel yoPanel = new PelaajanValitsijaPanel(ohjaus.getKaikkiPelaajat(), toiminto, kuuntelija, "Valitse vuorossa oleva pelaaja");
        return yoPanel;
    }
}
