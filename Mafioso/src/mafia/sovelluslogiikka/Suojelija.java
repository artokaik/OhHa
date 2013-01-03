/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.sovelluslogiikka;

import mafia.kayttoliittyma.Ohjaus;
import java.util.*;

public class Suojelija implements Rooli{
    private String roolinimi;
    private boolean pahis;

    
    public Suojelija(){
        roolinimi = "Suojelija";
        pahis = false;
    }
    
    public void toimi(Yo yo){
        Ohjaus ohjaus = new Ohjaus();
        Pelaaja suojeltu = ohjaus.suojelijaToimii(yo.getPelaajat());
        yo.setSuojeltu(suojeltu);
    }
    
    public boolean onkoPahis(){
        return pahis;
    }
    
    public String getRoolinimi(){
        return this.roolinimi;
    }
}
