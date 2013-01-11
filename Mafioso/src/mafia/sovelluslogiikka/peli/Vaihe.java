
package mafia.sovelluslogiikka.peli;

import mafia.sovelluslogiikka.peli.Saannot;
import java.util.ArrayList;
import mafia.sovelluslogiikka.sekalaista.Pelaaja;


/**
 * Vaihe-rajapinnan toteuttavia luokkia ovat Paiva ja Yo.
 * 
 * @author Arto
 */
public interface Vaihe {

    /**
     * Palauttaa listan hengissä olevista pelaajista
     * @return
     */
    public ArrayList<Pelaaja> getPelaajat();
//    public Pelaaja haePelaaja(String nimi);
    /**
     * Palauttaa vaiheen tapahtumat tekstimuodossa (kuka tapettiin).
     * @return
     */
    public String kerroTapahtumat();
    /**
     * Luo ja palauttaa seuraavan vaiheen (Yo palauttaa Paivan ja Paiva Yon)
     * @return
     */
    public Vaihe luoSeuraavaVaihe();
    

}
