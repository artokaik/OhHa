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
    
    public void paivita(Aanestys aanestys){
        panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));
        JLabel tuloksetKentta = new JLabel(aanestys.toString());
        panel.add(tuloksetKentta);
        JButton seuraava = new JButton();
        if(aanestys.getAanestamatta().size()>0){
            
        } else if (aanestys.haeTulokset().size()>1) {
            seuraava = new JButton("Jatka seuraavaan äänestykseen");
            Aanestys uusiKierros = new Aanestys(paiva.getPelaajat(), aanestys.haeTulokset());
            KayttisToimintoAanestyksenKaynnistys kaynnista = new KayttisToimintoAanestyksenKaynnistys(uusiKierros);
            seuraava.addActionListener(kaynnista);
            panel.add(seuraava);
        } else {
            seuraava = new JButton("Jatka seuraavaan yöhön");
        }
        panel.add(seuraava);
    }

    public JPanel getPanel() {
        return panel;
    }
    
}
