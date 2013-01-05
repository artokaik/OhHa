
package mafia.sovelluslogiikka.roolit;

import mafia.kayttoliittyma.Ohjaus;
import mafia.sovelluslogiikka.Pelaaja;
import mafia.sovelluslogiikka.Yo;

public class Suojelija implements Rooli{
    private final String roolinimi = "Suojelija";
    private final boolean pahis = false;

    
    public Suojelija(){
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
