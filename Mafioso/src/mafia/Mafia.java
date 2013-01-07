package mafia;

import mafia.kayttoliittyma.KayttisPeli;
import mafia.sovelluslogiikka.peli.Peli;
import mafia.tekstikayttoliittyma.TekstiPelinLuoja;

/**
 *
 * @author Arto
 */
public class Mafia {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {


//        System.out.println("huomio!");
//        ArrayList<Pelaaja> pelaajat = new ArrayList<Pelaaja>();
//        Pelaaja a = new Pelaaja("Arto");
//        Pelaaja b = new Pelaaja("Ossi");
//        Pelaaja c = new Pelaaja("Iina");
//        Pelaaja d = new Pelaaja("d");
//        Pelaaja e = new Pelaaja("e");
//        Pelaaja f = new Pelaaja("f");
//        Pelaaja g = new Pelaaja("g");
//        Pelaaja h = new Pelaaja("h");
//        Pelaaja i = new Pelaaja("i");
//        pelaajat.add(a);
//        pelaajat.add(b);
//        pelaajat.add(c);
//        pelaajat.add(d);
//        pelaajat.add(e);
//        pelaajat.add(f);
//        pelaajat.add(g);
//        pelaajat.add(h);
//        pelaajat.add(i);
//        Aanestys aanestys = new Aanestys(pelaajat,pelaajat);
//        KayttisAanestajanValitsija valinta = new KayttisAanestajanValitsija(aanestys);
//        valinta.run();


        TekstiPelinLuoja luoja = new TekstiPelinLuoja();
        Peli peli = luoja.luoPeli();
        KayttisPeli peliKayttis = new KayttisPeli(new Peli());
        peliKayttis.run();
//        peli.pelaa();

//        Aanestys aanestys = new Aanestys(peli.getPelaajat());
//        aanestys.suorita(peli.getPelaajat());
    }
}
