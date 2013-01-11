/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.sovelluslogiikka;

import java.util.ArrayList;
import mafia.sovelluslogiikka.peli.Peli;

/**
 *
 * @author Arto
 */
public class Ohjaus {

    public Ohjaus() {
    }

    public static void tapaLynkatut(Paiva paiva) {
        paiva.tapaLynkattavat();
    }

    public static void tapaAmmutut(Yo yo) {
        yo.tapaAmmutut();
    }

    public static boolean jatkuuko(Vaihe vaihe) {
        return Peli.jatkuuko(vaihe.getPelaajat());
    }

    public static ArrayList<Pelaaja> haePelaajat(Vaihe vaihe) {
        return vaihe.getPelaajat();
    }

    public static Vaihe luoSeuraavaVaihe(Vaihe vaihe) {
        return vaihe.luoSeuraavaVaihe();
    }

    public static Aanestys ensimmainenAanestys(Paiva paiva) {
        return new Aanestys(paiva.getPelaajat(), paiva.getPelaajat());
    }

    public static String toimi(Pelaaja toimija, Pelaaja valittu, Yo tapahtumaAika) {
        return toimija.getRooli().toimi(tapahtumaAika, valittu);
    }

    public static ArrayList<Pelaaja> haeEhdokkaat(Aanestys aanestys, Pelaaja pelaaja) {
        return aanestys.getAanestettavat(pelaaja);
    }

    public static ArrayList<Pelaaja> haeAanestamatta(Aanestys aanestys) {
        return aanestys.getAanestamatta();
    }

    public static void lisaaAani(Aanestys aanestys, Pelaaja aanestaja, Pelaaja aanestettava) {
        aanestys.lisaaAani(aanestaja, aanestettava);
    }

    public static ArrayList<Pelaaja> getValittavanaYolla(Pelaaja pelaaja, Yo yo) {
        return pelaaja.getRooli().getVaihtoehdot(yo.getPelaajat(), pelaaja);
    }
    
    public static String getRooliSelitys(Pelaaja pelaaja, Yo yo){
        return pelaaja.getRooli().getRooliSelitys(yo);
    }
    
    public static boolean poistaPelaajaVuorolistalta(Yo yo, Pelaaja vuorossa){
        return yo.poistaPelaamattomista(vuorossa);
    }
    
    public static ArrayList<Pelaaja> haePelaamatta(Yo yo){
        return yo.getVuoroPelaamatta();
    }
}
