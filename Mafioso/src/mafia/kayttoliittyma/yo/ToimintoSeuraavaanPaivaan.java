/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.kayttoliittyma.yo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import mafia.kayttoliittyma.Kayttis;
import mafia.kayttoliittyma.Paiva.PaivaMainPanel;
import mafia.kayttoliittyma.PelinLopetusPanel;
import mafia.sovelluslogiikka.Aanestys;
import mafia.sovelluslogiikka.Ohjaus;
import mafia.sovelluslogiikka.Paiva;
import mafia.sovelluslogiikka.Yo;
import mafia.sovelluslogiikka.peli.Peli;

/**
 *
 * @author Arto
 */
public class ToimintoSeuraavaanPaivaan  implements ActionListener{
    private Yo yo;
    private Kayttis kayttis;
    
    public ToimintoSeuraavaanPaivaan(Yo yo,  Kayttis kayttis){
        this.kayttis = kayttis;
        this.yo = yo;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Paiva paiva = (Paiva) Ohjaus.luoSeuraavaVaihe(yo);
        if(Ohjaus.jatkuuko(paiva)){
            PaivaMainPanel seuraavaPaiva = new PaivaMainPanel(paiva, kayttis);
            seuraavaPaiva.luo(Ohjaus.ensimmainenAanestys(paiva));
            kayttis.korvaaKeskusta(seuraavaPaiva);
        } else {
            PelinLopetusPanel lopetus = new PelinLopetusPanel(paiva,kayttis);          
            kayttis.korvaaKeskusta(lopetus);
        }
        
        
        
    }
}