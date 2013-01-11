/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.kayttoliittyma.sekalaiset;

import javax.swing.JButton;
import javax.swing.JPanel;
import mafia.kayttoliittyma.Kayttis;
import mafia.kayttoliittyma.KayttisKuuntelija;
import mafia.kayttoliittyma.KayttisPeliRakentaja.ToimintoPelinAloitus;
import mafia.kayttoliittyma.pelaajanvalitsija.PelaajanValitsijaPanel;
import mafia.sovelluslogiikka.Ohjaus;

/**
 *
 * @author Arto
 */
public class RoolienKertojaPanel extends JPanel{
    
    private Ohjaus ohjaus;
    private Kayttis kayttis;
    
    
    /**
     *
     * @param ohjaus
     * @param kayttis
     */
    public RoolienKertojaPanel(Ohjaus ohjaus, Kayttis kayttis){
        this.ohjaus=ohjaus;
        this.kayttis=kayttis;
        KayttisKuuntelija kuuntelija = new KayttisKuuntelija();
        
        ToimintoKerroYksiRooli kerroRooli = new ToimintoKerroYksiRooli(ohjaus, kayttis, kuuntelija);
        this.add(new PelaajanValitsijaPanel(ohjaus.getKaikkiPelaajat(), kerroRooli, kuuntelija, "Kenen rooli kerrotaan"));
        ToimintoPelinAloitus aloitus = new ToimintoPelinAloitus(ohjaus, kayttis);
        JButton jatkaPeliin = new JButton("Jatka peliin");
        jatkaPeliin.addActionListener(aloitus);
        this.add(jatkaPeliin);
        
    }
    
}
