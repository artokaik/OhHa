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

/**
 *
 * @author Arto
 */
public class ToimintoKerroYksiRooli implements ActionListener{
    private Ohjaus ohjaus;
    private Kayttis kayttis;
    private KayttisKuuntelija kuuntelija;
    
    /**
     *
     * @param ohjaus
     * @param kayttis
     * @param kuuntelija
     */
    public ToimintoKerroYksiRooli(Ohjaus ohjaus, Kayttis kayttis, KayttisKuuntelija kuuntelija){
        this.ohjaus=ohjaus;
        this.kayttis=kayttis;
        this.kuuntelija = kuuntelija;
    }
    
    public void actionPerformed(ActionEvent ae){
        KerroRooliPanel panel = new KerroRooliPanel(kuuntelija.getPelaaja(), kayttis, ohjaus);
        kayttis.korvaaKeskusta(panel);
    }
}
