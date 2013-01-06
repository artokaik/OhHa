/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.tekstikayttoliittyma;

import java.util.*;
import mafia.sovelluslogiikka.*;

/**
 *
 * @author Arto
 */
public class TekstiAanestys {

    private Scanner lukija;

    /**
     *
     */
    public TekstiAanestys() {
        lukija = new Scanner(System.in);
    }
    
    /**
     *
     * @param aanestaja
     * @param pelaajat
     * @return
     */
    public Aani aanesta(Pelaaja aanestaja, ArrayList<Pelaaja> pelaajat){
        ArrayList<Pelaaja> vaihtoehdot = (ArrayList<Pelaaja>) pelaajat.clone();
        vaihtoehdot.remove(aanestaja);
        System.out.println(aanestaja + ", ole hyvä ja valitse, ketä äänestät");
        TekstiPelaajanValitsija valitsija = new TekstiPelaajanValitsija();
        Pelaaja aanestetty = valitsija.valitse(vaihtoehdot);
        Aani aani = new Aani(aanestaja, aanestetty);
        return aani;
        
    }
}
