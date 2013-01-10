/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JPanel;
import mafia.kayttoliittyma.Paiva.PaivaMainPanel;
import mafia.kayttoliittyma.yo.YoMainPanel;
import mafia.sovelluslogiikka.Aanestys;
import mafia.sovelluslogiikka.Paiva;
import mafia.sovelluslogiikka.Yo;
import mafia.sovelluslogiikka.peli.Peli;

/**
 *
 * @author Arto
 */
public class PeliPanel extends JPanel {

    private Peli peli;
    private Kayttis kayttis;

    public PeliPanel(Peli peli, Kayttis kayttis) {
        this.peli = peli;
        this.kayttis = kayttis;
        this.setPreferredSize(new Dimension(kayttis.getKeskustaMitat()));
    }

    public void aseta() {
        
        luoKomponentit();

    }

    public void luoKomponentit() {
        this.setLayout(new BorderLayout());
        JPanel keskusta = new JPanel();
        if (peli.getSaannot().getPaivaEnsin()) {
            keskusta = teePaiva();
        } else {
            keskusta = teeYo();
        }
        this.add(keskusta, BorderLayout.CENTER);

    }

    public JPanel teePaiva() {
        Paiva paiva = new Paiva(peli.getPelaajat());
        PaivaMainPanel tulokset = new PaivaMainPanel(paiva, kayttis);
        Aanestys aanestys = new Aanestys(peli.getPelaajat(), peli.getPelaajat());
        tulokset.luo(aanestys);
        return tulokset;
    }
    
        public JPanel teeYo() {
        Yo yo = new Yo(peli.getPelaajat());
        YoMainPanel yoPanel = new YoMainPanel(kayttis,yo);
        yoPanel.luoKomponentit();
        return yoPanel;
    }
}
