/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.kayttoliittyma.yo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import mafia.kayttoliittyma.Kayttis;
import mafia.kayttoliittyma.KayttisKuuntelija;
import mafia.kayttoliittyma.PelaajanValitsijaPanel;
import mafia.sovelluslogiikka.Ohjaus;
import mafia.sovelluslogiikka.Pelaaja;
import mafia.sovelluslogiikka.Yo;

/**
 *
 * @author Arto
 */
public class ToimintoValitseToimija1 implements ActionListener{
    private Yo yo;
    private Pelaaja pelaaja;
    private JButton nappi; 
    private Kayttis kayttis;
    
    public ToimintoValitseToimija1(Yo yo, Pelaaja pelaaja, JButton nappi, Kayttis kayttis){
        this.kayttis = kayttis;
        this.yo = yo;
        this.pelaaja = pelaaja;
        this.nappi = nappi;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        KayttisKuuntelija kuuntelija = new KayttisKuuntelija();
        ToimintoVahvistaValinta valitunVahvistus = new ToimintoVahvistaValinta(pelaaja, yo, kuuntelija, kayttis);
        PelaajanValitsijaPanel valitsijaPanel = new PelaajanValitsijaPanel(Ohjaus.getValittavanaYolla(pelaaja,yo),valitunVahvistus,kuuntelija, Ohjaus.getRooliSelitys(pelaaja, yo));
        kayttis.korvaaKeskusta(valitsijaPanel);
        nappi.setEnabled(false);        
        
    }
        
        
    }