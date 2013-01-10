/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.kayttoliittyma.Paiva;

import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import mafia.kayttoliittyma.Kayttis;
import mafia.sovelluslogiikka.Aanestys;
import mafia.sovelluslogiikka.Paiva;

/**
 *
 * @author Arto
 */
public class PaivaMainPanel extends JPanel{

    private Paiva paiva;
    private Kayttis kayttis;

    public PaivaMainPanel(Paiva paiva, Kayttis kayttis) {
        this.paiva=paiva;
        this.kayttis=kayttis;
        this.setPreferredSize(new Dimension(kayttis.getKeskustaMitat()));
    }
    
    public void luo(Aanestys aanestys){
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        JLabel tuloksetKentta = new JLabel(aanestys.toString());       
        JButton seuraava = new JButton();
        if(aanestys.getAanestamatta().size()>0){
            seuraava = new JButton("Jatka äänestykseen");
            ToimintoAanestyksenKaynnistys kaynnista = new ToimintoAanestyksenKaynnistys(aanestys, this, seuraava, kayttis);
            seuraava.addActionListener(kaynnista);
        } else if (aanestys.haeTulokset().size()>1) {
            seuraava = new JButton("Jatka seuraavaan äänestykseen");
            Aanestys uusiKierros = new Aanestys(paiva.getPelaajat(), aanestys.haeTulokset());        
            ToimintoAanestyksenKaynnistys kaynnista = new ToimintoAanestyksenKaynnistys(uusiKierros, this, seuraava, kayttis);
            seuraava.addActionListener(kaynnista);
        } else {
            paiva.setLynkattu(aanestys.haeTulokset());
            seuraava = new JButton("Lopeta päivä");
            ToimintoLopetaPaiva lopetus = new ToimintoLopetaPaiva(paiva, kayttis);
            seuraava.addActionListener(lopetus);           
        }
        this.add(tuloksetKentta);
        this.add(seuraava);
    }

    public Paiva getPaiva() {
        return paiva;
    }

    
}
