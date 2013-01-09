/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.kayttoliittyma;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import mafia.kayttoliittyma.Aanestys.ToimintoSuljePelaajanValitsin;
import mafia.kayttoliittyma.Aanestys.ToimintoValitseAanestettava;
import mafia.sovelluslogiikka.Aanestys;
import mafia.sovelluslogiikka.Pelaaja;

/**
 *
 * @author Arto
 */
public class KayttisPelaajanValitsija {

    private JPanel panel;
    private ArrayList<Pelaaja> valittavana;
    private KayttisKuuntelija kuuntelija;
    private JButton valitseNappi;

    public KayttisPelaajanValitsija(ArrayList<Pelaaja> pelaajat, JButton valitseNappi, KayttisKuuntelija kuuntelija) {
        valittavana = pelaajat;
        this.valitseNappi = valitseNappi;
        this.kuuntelija = kuuntelija; 
        panel = luo();
    }

    public JPanel luo() {
        panel = new JPanel();
        panel.setLayout(new GridLayout(valittavana.size() + 2, 1));
        panel.setPreferredSize(new Dimension(600,300));
        JLabel valittu = new JLabel();
        for (Pelaaja pelaaja : valittavana) {
            JButton pelaajaNappi = new JButton(pelaaja.getNimi());
            ToimintoValitsePelaaja toiminto = new ToimintoValitsePelaaja(pelaaja, valittu, kuuntelija, valitseNappi);
            pelaajaNappi.addActionListener(toiminto);
            panel.add(pelaajaNappi);
        }
        JLabel teksti = new JLabel("Valittu:");
        panel.add(teksti);
        panel.add(valittu);

        
        return panel;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public void setValittavana(ArrayList<Pelaaja> valittavana) {
        this.valittavana = valittavana;
    }

    public void setKuuntelija(KayttisKuuntelija kuuntelija) {
        this.kuuntelija = kuuntelija;
    }

    public void setValitseNappi(JButton valitseNappi) {
        this.valitseNappi = valitseNappi;
    }
    
    
}
