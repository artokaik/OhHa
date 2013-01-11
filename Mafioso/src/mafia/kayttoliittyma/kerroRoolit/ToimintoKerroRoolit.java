/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.kayttoliittyma.kerroRoolit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import mafia.kayttoliittyma.Kayttis;
import mafia.kayttoliittyma.KayttisKuuntelija;
import mafia.kayttoliittyma.PeliPanel;
import mafia.sovelluslogiikka.Ohjaus;
import mafia.sovelluslogiikka.peli.Peli;
import mafia.sovelluslogiikka.peli.PeliRakentaja;

/**
 *
 * @author Arto
 */
public class ToimintoKerroRoolit implements ActionListener {

    private Ohjaus ohjaus;
    private Kayttis kayttis;
    private PeliRakentaja rakentaja;

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
            KayttisKuuntelija kuuntelija = new KayttisKuuntelija();
            RoolienKertojaPanel roolienKertoja = new RoolienKertojaPanel(ohjaus, kayttis, kuuntelija);
            kayttis.korvaaKeskusta(roolienKertoja);
        }
    }
}
