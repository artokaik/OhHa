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
import mafia.kayttoliittyma.PelaajanValitsijaPanel;
import mafia.kayttoliittyma.PelinLopetusPanel;
import mafia.sovelluslogiikka.Ohjaus;
import mafia.sovelluslogiikka.Paiva;
import mafia.sovelluslogiikka.Yo;

/**
 *
 * @author Arto
 */
public class ToimintoSeuraavaanYohon  implements ActionListener{
    private Paiva paiva;
    private Kayttis kayttis;
    
    public ToimintoSeuraavaanYohon(Paiva paiva,  Kayttis kayttis){
        this.kayttis = kayttis;
        this.paiva = paiva;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Yo yo = (Yo) Ohjaus.luoSeuraavaVaihe(paiva);
        if(Ohjaus.jatkuuko(yo)){
              KayttisKuuntelija kuuntelija = new KayttisKuuntelija();
              ToimintoValitseToimija toiminto = new ToimintoValitseToimija(yo,kuuntelija, kayttis);
              PelaajanValitsijaPanel seuraavaYo = new PelaajanValitsijaPanel(Ohjaus.haePelaajat(yo), toiminto, kuuntelija, "Valitse vuorossa oleva pelaaja");
//            YoMainPanel seuraavaYo = new YoMainPanel(kayttis, yo);
//            seuraavaYo.luoKomponentit();
            kayttis.korvaaKeskusta(seuraavaYo);
        } else {
            PelinLopetusPanel lopetus = new PelinLopetusPanel(yo,kayttis);
            kayttis.korvaaKeskusta(lopetus);
        }
        
        
        
    }
}