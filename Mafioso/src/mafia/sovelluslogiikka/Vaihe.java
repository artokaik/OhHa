
package mafia.sovelluslogiikka;

import mafia.sovelluslogiikka.peli.Saannot;
import java.util.ArrayList;


/**
 * Vaihe-rajapinnan toteuttavia luokkia ovat Paiva ja Yo.
 * 
 * @author Arto
 */
public interface Vaihe {

//    /**
//     *
//     * @param saannot
//     * @return
//     */
//    public ArrayList<Pelaaja> pelaa(Saannot saannot);
    /**
     *
     * @return
     */
    public ArrayList<Pelaaja> getPelaajat();
//    public Pelaaja haePelaaja(String nimi);
    /**
     *
     * @return
     */
    public String kerroTapahtumat();
    /**
     *
     * @return
     */
    public Vaihe luoSeuraavaVaihe();
    
}
