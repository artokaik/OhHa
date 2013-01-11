/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.kayttoliittyma.yo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import mafia.kayttoliittyma.Kayttis;
import mafia.kayttoliittyma.Paiva.PaivaMainPanel;
import mafia.kayttoliittyma.sekalaiset.PelinLopetusPanel;
import mafia.sovelluslogiikka.Ohjaus;
import mafia.sovelluslogiikka.peli.Paiva;

/**
 *
 * @author Arto
 */
public class ToimintoSeuraavaanPaivaan  implements ActionListener{
    private Ohjaus ohjaus;
    private Kayttis kayttis;
    
    /**
     *
     * @param ohjaus
     * @param kayttis
     */
    public ToimintoSeuraavaanPaivaan(Ohjaus ohjaus,  Kayttis kayttis){
        this.kayttis = kayttis;
        this.ohjaus = ohjaus;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Paiva paiva = (Paiva) ohjaus.siirrySeuraavaanVaiheeseen();
        ohjaus.setPaiva(paiva);
        if(ohjaus.jatkuuko()){
            PaivaMainPanel seuraavaPaiva = new PaivaMainPanel(ohjaus, kayttis);
            ohjaus.luoEnsimmainenAanestys();
            seuraavaPaiva.luo(ohjaus.getAanestys());
            kayttis.korvaaKeskusta(seuraavaPaiva);
        } else {
            PelinLopetusPanel lopetus = new PelinLopetusPanel(paiva,kayttis);          
            kayttis.korvaaKeskusta(lopetus);
        }
        
        
        
    }
}