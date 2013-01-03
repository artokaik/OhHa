/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.kayttoliittyma;

import java.util.*;
import mafia.sovelluslogiikka.*;
import mafia.tekstikayttoliittyma.*;

public class Ohjaus {

    public Ohjaus() {
    }

    public Pelaaja valitsePelaaja(ArrayList<Pelaaja> pelaajat) {
        TekstiPelaajanValitsija valitsija = new TekstiPelaajanValitsija();
        return valitsija.valitse(pelaajat);
    }

    public Aani aanesta(Pelaaja pelaaja, ArrayList<Pelaaja> pelaajat) {
        TekstiAanestys aanestys = new TekstiAanestys();
        return aanestys.aanesta(pelaaja, pelaajat);
    }
}
