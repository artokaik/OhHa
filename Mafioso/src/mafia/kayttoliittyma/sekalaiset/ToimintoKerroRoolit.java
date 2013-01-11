/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.kayttoliittyma.sekalaiset;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import mafia.kayttoliittyma.Kayttis;
import mafia.kayttoliittyma.KayttisKuuntelija;
import mafia.sovelluslogiikka.Ohjaus;
import mafia.sovelluslogiikka.peli.Peli;
import mafia.sovelluslogiikka.PeliRakentaja;

/**
 *
 * @author Arto
 */
public class ToimintoKerroRoolit implements ActionListener {

    private Ohjaus ohjaus;
    private Kayttis kayttis;
    private PeliRakentaja rakentaja;

    /**
     *
     * @param rakentaja
     * @param kayttis
     */
    public ToimintoKerroRoolit(PeliRakentaja rakentaja, Kayttis kayttis) {
        this.rakentaja=rakentaja;
        this.kayttis = kayttis;
            
    }
    

    public void actionPerformed(ActionEvent ae) {
        if (rakentaja.onkoValmis()) {
            this.ohjaus = new Ohjaus(rakentaja.teePeli()); 
//            Peli peli = rakentaja.teePeli();
//            PeliPanel peliKayttis = new PeliPanel(ohjaus, kayttis);
//            kayttis.korvaaKeskusta(peliKayttis); 
            
            RoolienKertojaPanel roolienKertoja = new RoolienKertojaPanel(ohjaus, kayttis);
            kayttis.korvaaKeskusta(roolienKertoja);
        }
    }
}
