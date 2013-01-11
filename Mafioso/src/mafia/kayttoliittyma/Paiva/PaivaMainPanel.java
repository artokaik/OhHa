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
import mafia.sovelluslogiikka.sekalaista.Aanestys;
import mafia.sovelluslogiikka.Ohjaus;
import mafia.sovelluslogiikka.peli.Paiva;

/**
 *
 * @author Arto
 */
public class PaivaMainPanel extends JPanel{

    private Ohjaus ohjaus;
    private Kayttis kayttis;

    /**
     *
     * @param ohjaus
     * @param kayttis
     */
    public PaivaMainPanel(Ohjaus ohjaus, Kayttis kayttis) {
        this.ohjaus = ohjaus;
        this.kayttis=kayttis;
        this.setPreferredSize(new Dimension(kayttis.getKeskustaMitat()));
    }
    
    /**
     *
     * @param aanestys
     */
    public void luo(Aanestys aanestys){
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        JLabel tuloksetKentta = new JLabel(aanestys.toString());       
        JButton seuraava = new JButton();
        if(aanestys.getAanestamatta().size()>0){
            seuraava = new JButton("Jatka äänestykseen");
            ToimintoAanestyksenKaynnistys kaynnista = new ToimintoAanestyksenKaynnistys(ohjaus, this, seuraava, kayttis);
            seuraava.addActionListener(kaynnista);
        } else if (aanestys.haeTulokset().size()>1) {
            seuraava = new JButton("Jatka seuraavaan äänestykseen");
            ohjaus.uusiAanestys(ohjaus.getAanestyksenTulokset());  
            ToimintoAanestyksenKaynnistys kaynnista = new ToimintoAanestyksenKaynnistys(ohjaus, this, seuraava, kayttis);
            seuraava.addActionListener(kaynnista);
        } else {
            ohjaus.asetaLynkatut(aanestys.haeTulokset());
            seuraava = new JButton("Lopeta päivä");
            ToimintoLopetaPaiva lopetus = new ToimintoLopetaPaiva(ohjaus, kayttis);
            seuraava.addActionListener(lopetus);           
        }
        this.add(tuloksetKentta);
        this.add(seuraava);
    }
//
//    public Paiva getPaiva() {
//        return paiva;
//    }

    
}
