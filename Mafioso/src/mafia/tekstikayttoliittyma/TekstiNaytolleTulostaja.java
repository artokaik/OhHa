/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.tekstikayttoliittyma;

import mafia.sovelluslogiikka.*;

public class TekstiNaytolleTulostaja {
    
    public TekstiNaytolleTulostaja(){
        
    }
    
    public void tulostaVaiheenTapahtumat(Vaihe vaihe){
        System.out.println(vaihe.kerroTapahtumat());
    }
    
        public void julistaVoittaja(String voittaja){
        System.out.println(voittaja + " voittivat pelin!");
    }
}
