/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.kayttoliittyma.Paiva;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import mafia.kayttoliittyma.Kayttis;
import mafia.sovelluslogiikka.Aanestys;
import mafia.sovelluslogiikka.Pelaaja;

/**
 *
 * @author Arto
 */
public class AanestajanValitsijaPanel extends JPanel {

    private Aanestys aanestys;
    private PaivaMainPanel tulokset;
    private Kayttis kayttis;

    public AanestajanValitsijaPanel(Aanestys aanestys, PaivaMainPanel tulokset, Kayttis kayttis){
        this.aanestys = aanestys;    
        this.tulokset = tulokset;
        this.kayttis = kayttis;
        this.setPreferredSize(new Dimension(kayttis.getKeskustaMitat()));
    }



    public void luoKomponentit() {
        this.setLayout(new GridLayout(aanestys.getAanestamatta().size() + 4, 1));
        
        JLabel otsikko = new JLabel("Valitse äänestäjä");
        this.add(otsikko);
        
        JLabel valittu = new JLabel();
        for (Pelaaja pelaaja : aanestys.getAanestamatta()) {
            JButton pelaajaNappi = new JButton(pelaaja.getNimi());
            ToimintoValitseAanestaja toiminto = new ToimintoValitseAanestaja(aanestys,pelaaja,pelaajaNappi);
            pelaajaNappi.addActionListener(toiminto);
            this.add(pelaajaNappi);
        }
        JLabel teksti = new JLabel("Valittu:");
        
        JButton suljeNappi = new JButton("OK");
        ToimintoLopetaAanestys sulje = new ToimintoLopetaAanestys(aanestys, this, tulokset, kayttis);
        suljeNappi.addActionListener(sulje);

        this.add(teksti);
        this.add(valittu);
        this.add(suljeNappi);

    }
}
