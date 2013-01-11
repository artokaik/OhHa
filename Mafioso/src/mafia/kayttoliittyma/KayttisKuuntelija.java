/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.kayttoliittyma;

import mafia.sovelluslogiikka.sekalaista.Pelaaja;

/**
 *
 * @author Arto
 */
public class KayttisKuuntelija {
    private Pelaaja pelaaja;
    
    /**
     *
     */
    public KayttisKuuntelija(){
        pelaaja = null;
        
    }

    /**
     *
     * @return
     */
    public Pelaaja getPelaaja() {
        return pelaaja;
    }

    /**
     *
     * @param pelaaja
     */
    public void setPelaaja(Pelaaja pelaaja) {
        this.pelaaja = pelaaja;
    }


 

    
}
