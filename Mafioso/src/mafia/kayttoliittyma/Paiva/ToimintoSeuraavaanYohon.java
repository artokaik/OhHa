/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.kayttoliittyma.Paiva;

import mafia.kayttoliittyma.yo.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import mafia.kayttoliittyma.Kayttis;
import mafia.kayttoliittyma.KayttisKuuntelija;
import mafia.kayttoliittyma.pelaajanvalitsija.PelaajanValitsijaPanel;
import mafia.kayttoliittyma.sekalaiset.PelinLopetusPanel;
import mafia.sovelluslogiikka.Ohjaus;
import mafia.sovelluslogiikka.peli.Paiva;
import mafia.sovelluslogiikka.peli.Yo;

/**
 *
 * @author Arto
 */
public class ToimintoSeuraavaanYohon  implements ActionListener{
    private Ohjaus ohjaus;
    private Kayttis kayttis;
    
    /**
     *
     * @param ohjaus
     * @param kayttis
     */
    public ToimintoSeuraavaanYohon(Ohjaus ohjaus,  Kayttis kayttis){
        this.kayttis = kayttis;
        this.ohjaus = ohjaus;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Yo yo = (Yo) ohjaus.siirrySeuraavaanVaiheeseen();
        ohjaus.setYo(yo);
        if(ohjaus.jatkuuko()){
              KayttisKuuntelija kuuntelija = new KayttisKuuntelija();
              ToimintoValitseToimija toiminto = new ToimintoValitseToimija(ohjaus,kuuntelija, kayttis);
              PelaajanValitsijaPanel seuraavaYo = new PelaajanValitsijaPanel(ohjaus.elossaOlevat(), toiminto, kuuntelija, "Valitse vuorossa oleva pelaaja");
//            YoMainPanel seuraavaYo = new YoMainPanel(kayttis, yo);
//            seuraavaYo.luoKomponentit();
            kayttis.korvaaKeskusta(seuraavaYo);
        } else {
            PelinLopetusPanel lopetus = new PelinLopetusPanel(yo,kayttis);
            kayttis.korvaaKeskusta(lopetus);
        }
        
        
        
    }
}