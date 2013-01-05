
package mafia.sovelluslogiikka.roolit;

import java.util.ArrayList;
import mafia.kayttoliittyma.Ohjaus;
import mafia.sovelluslogiikka.Pelaaja;
import mafia.sovelluslogiikka.Yo;

public class Mafioso implements Rooli{
    private final String roolinimi = "Mafioso";
    private final boolean pahis = true;

    public Mafioso(){
    }
    
    public void toimi(Yo yo){
        Ohjaus ohjaus = new Ohjaus();
        Pelaaja tapettava = ohjaus.mafiosoToimii(getHyvikset(yo.getPelaajat()), yo);
        yo.setTapettava(tapettava);
    }
    
    public boolean onkoPahis(){
        return pahis;
    }
    
    public String getRoolinimi(){
        return this.roolinimi;
    }
    
    private ArrayList<Pelaaja> getHyvikset(ArrayList<Pelaaja> pelaajat){
        ArrayList<Pelaaja> hyvikset = (ArrayList<Pelaaja>) pelaajat.clone();
        ArrayList<Pelaaja> poistettavat = new ArrayList<Pelaaja>();
        for (Pelaaja pelaaja : hyvikset) {
            if (pelaaja.getRooli().onkoPahis()){
                poistettavat.add(pelaaja);
            }
        }
        for (Pelaaja pelaaja : poistettavat) {
            hyvikset.remove(pelaaja);
        }
        return hyvikset;
    }
}
