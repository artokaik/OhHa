/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.kayttoliittyma.sekalaiset;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import mafia.kayttoliittyma.Kayttis;
import mafia.kayttoliittyma.KayttisPeliRakentaja.ToimintoPelinAloitus;
import mafia.sovelluslogiikka.Ohjaus;
import mafia.sovelluslogiikka.sekalaista.Pelaaja;

/**
 *
 * @author Arto
 */
public class KerroRooliPanel extends JPanel{
    
    private Ohjaus ohjaus;
    private Kayttis kayttis;
    
    
    /**
     *
     * @param pelaaja
     * @param kayttis
     * @param ohjaus
     */
    public KerroRooliPanel(Pelaaja pelaaja, Kayttis kayttis, Ohjaus ohjaus){
        this.ohjaus=ohjaus;
        this.kayttis=kayttis;
        String teksti = "Olet " + ohjaus.kerroRooli(pelaaja);
        JLabel rooli = new JLabel(teksti);
        
        this.add(rooli);
        ToimintoTakaisinRoolienKertojaan kertoja = new ToimintoTakaisinRoolienKertojaan(ohjaus, kayttis);
        JButton seuraava = new JButton("Seuraava pelaaja");
        seuraava.addActionListener(kertoja);
        this.add(seuraava);
        
        
    }
    
}
