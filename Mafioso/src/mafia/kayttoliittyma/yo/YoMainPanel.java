/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.kayttoliittyma.yo;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import mafia.kayttoliittyma.Kayttis;
import mafia.kayttoliittyma.KayttisKuuntelija;
import mafia.sovelluslogiikka.Pelaaja;
import mafia.sovelluslogiikka.Yo;

/**
 *
 * @author Arto
 */
public class YoMainPanel extends JPanel {

    private Kayttis kayttis;
    private Yo yo;


    public YoMainPanel(Kayttis kayttis, Yo yo){
        this.kayttis = kayttis;
        this.yo = yo;
        this.setPreferredSize(new Dimension(kayttis.getKeskustaMitat()));

    }


    public void luoKomponentit() {
        this.setLayout(new GridLayout(yo.getPelaajat().size() + 4, 1));
        
        JLabel otsikko = new JLabel("Valitse vuorossa oleva pelaaja");
        this.add(otsikko);
        
        JLabel valittu = new JLabel();
        for (Pelaaja pelaaja : yo.getPelaajat()) {
            JButton pelaajaNappi = new JButton(pelaaja.getNimi());
            ToimintoValitseToimija toiminto = new ToimintoValitseToimija(yo,pelaaja,pelaajaNappi, kayttis);
            pelaajaNappi.addActionListener(toiminto);
            if(!yo.getVuoroPelaamatta().contains(pelaaja)){
                pelaajaNappi.setEnabled(false);
            }
            this.add(pelaajaNappi);
        }
        
        JButton suljeNappi = new JButton("OK");
        ToimintoLopetaYo sulje = new ToimintoLopetaYo(yo, kayttis);
        suljeNappi.addActionListener(sulje);
        if(!yo.getVuoroPelaamatta().isEmpty()){
            suljeNappi.setEnabled(false);
        }
        
        this.add(valittu);
        this.add(suljeNappi);

    }
}
