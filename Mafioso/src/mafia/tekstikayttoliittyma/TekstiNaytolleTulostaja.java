/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.tekstikayttoliittyma;

import mafia.sovelluslogiikka.*;

/**
 *
 * @author Arto
 */
public class TekstiNaytolleTulostaja {
    
    /**
     *
     */
    public TekstiNaytolleTulostaja(){
        
    }
    
    /**
     *
     * @param vaihe
     */
    public void tulostaVaiheenTapahtumat(Vaihe vaihe){
        System.out.println(vaihe.kerroTapahtumat());
    }
    
        /**
     *
     * @param voittaja
     */
    public void julistaVoittaja(String voittaja){
        System.out.println(voittaja + " voittivat pelin!");
    }
}
