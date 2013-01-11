/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.kayttoliittyma.Paiva;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import mafia.kayttoliittyma.Kayttis;
import mafia.kayttoliittyma.KayttisKuuntelija;
import mafia.kayttoliittyma.PelaajanValitsijaPanel;
import mafia.sovelluslogiikka.Ohjaus;

/**
 *
 * @author Arto
 */
public class ToimintoValitseAanestaja implements ActionListener{
    private KayttisKuuntelija aanestaja;
//    private Aanestys aanestys;
    private PaivaMainPanel tulokset;
    private Kayttis kayttis;
    private Ohjaus ohjaus;

    
    public ToimintoValitseAanestaja( KayttisKuuntelija aanestaja, PaivaMainPanel tulokset, Kayttis kayttis, Ohjaus ohjaus){
//        this.aanestys = aanestys;
        this.aanestaja = aanestaja;
        this.tulokset=tulokset;
        this.kayttis=kayttis;
        this.ohjaus = ohjaus;

    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        KayttisKuuntelija kuuntelija = new KayttisKuuntelija();
        ohjaus.setToimija(aanestaja.getPelaaja());
        
        ToimintoSuljePelaajanValitsin annaAani = new ToimintoSuljePelaajanValitsin(ohjaus,kuuntelija, tulokset, kayttis);
        
        PelaajanValitsijaPanel valitsija = new PelaajanValitsijaPanel(ohjaus.haeEhdokkaat(aanestaja.getPelaaja()), annaAani, kuuntelija,  "Valitse äänestettävä");
        kayttis.korvaaKeskusta(valitsija);
        
    }
        
        
    }