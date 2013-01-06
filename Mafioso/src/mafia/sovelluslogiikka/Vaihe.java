
package mafia.sovelluslogiikka;

import mafia.sovelluslogiikka.peli.Saannot;
import java.util.ArrayList;


public interface Vaihe {

    public ArrayList<Pelaaja> pelaa(Saannot saannot);
    public ArrayList<Pelaaja> getPelaajat();
//    public Pelaaja haePelaaja(String nimi);
    public String kerroTapahtumat();
    public Vaihe luoSeuraavaVaihe();
    
}
