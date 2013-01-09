/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.kayttoliittyma.Aanestys;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import mafia.sovelluslogiikka.Aanestys;
import mafia.sovelluslogiikka.Paiva;

/**
 *
 * @author Arto
 */
public class KayttisAanestysTulokset {

    private JPanel panel;
    private Paiva paiva;

    public KayttisAanestysTulokset(Paiva paiva) {
        this.paiva=paiva;
        panel = new JPanel();
    }
    
    public void luo(Aanestys aanestys){
        panel.setLayout(new GridLayout(3, 1));
        JLabel tuloksetKentta = new JLabel(aanestys.toString());       
        JButton seuraava = new JButton();
        if(aanestys.getAanestamatta().size()>0){
            seuraava = new JButton("Jatka äänestykseen");
            ToimintoAanestyksenKaynnistys kaynnista = new ToimintoAanestyksenKaynnistys(aanestys, this);
            seuraava.addActionListener(kaynnista);
        } else if (aanestys.haeTulokset().size()>1) {
            seuraava = new JButton("Jatka seuraavaan äänestykseen");
            Aanestys uusiKierros = new Aanestys(paiva.getPelaajat(), aanestys.haeTulokset());
            ToimintoAanestyksenKaynnistys kaynnista = new ToimintoAanestyksenKaynnistys(uusiKierros, this);
            seuraava.addActionListener(kaynnista);
        } else {
            seuraava = new JButton("Jatka seuraavaan yöhön");
        }
        panel.add(tuloksetKentta);
        panel.add(seuraava);
    }

    public Paiva getPaiva() {
        return paiva;
    }

    public JPanel getPanel() {
        return panel;
    }
    
}
