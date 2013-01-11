/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.kayttoliittyma.pelaajanvalitsija;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import mafia.kayttoliittyma.KayttisKuuntelija;
import mafia.sovelluslogiikka.Ohjaus;
import mafia.sovelluslogiikka.sekalaista.Pelaaja;

/**
 *
 * @author Arto
 */
public class PelaajanValitsijaPanel extends JPanel{


    private ActionListener okNapinToiminto;

    /**
     *
     * @param valittavana
     * @param okNapinToiminto
     * @param kuuntelija
     * @param otsikko
     */
    public PelaajanValitsijaPanel(ArrayList<Pelaaja> valittavana, ActionListener okNapinToiminto, KayttisKuuntelija kuuntelija, String otsikko) { 
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.setPreferredSize(new Dimension(500,400));
        
        JLabel otsikkoLabel = new JLabel(otsikko);
        this.add(otsikkoLabel);
        
        JLabel valittu = new JLabel();
        JButton valitseNappi = new JButton("OK");
        valitseNappi.addActionListener(okNapinToiminto);
        if(!valittavana.isEmpty()){
            valitseNappi.setEnabled(false);
        }
        for (Pelaaja pelaaja : valittavana) {
            JButton pelaajaNappi = new JButton(pelaaja.getNimi());
            ToimintoValitsePelaaja toiminto = new ToimintoValitsePelaaja(pelaaja, valittu, kuuntelija, valitseNappi);
            pelaajaNappi.addActionListener(toiminto);
            this.add(pelaajaNappi);
        }
        JLabel teksti = new JLabel("Valittu:");
        this.add(teksti);
        this.add(valittu);
        this.add(valitseNappi);
    }


    
    
}
