package mafia.sovelluslogiikka;

import mafia.sovelluslogiikka.sekalaista.Pelaaja;
import mafia.sovelluslogiikka.peli.Yo;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Arto
 */
public class YoTest {

    Yo yo;
    ArrayList<Pelaaja> pelaajat;
    Pelaaja a;
    Pelaaja b;
    Pelaaja c;
    Pelaaja d;
    Pelaaja e;
    Pelaaja f;
    Pelaaja g;
    Pelaaja h;
    Pelaaja i;

    /**
     *
     */
    public YoTest() {
        pelaajat = new ArrayList<Pelaaja>();
        a = new Pelaaja("a");
        b = new Pelaaja("b");
        c = new Pelaaja("c");
        d = new Pelaaja("d");
        e = new Pelaaja("e");
        f = new Pelaaja("f");
        g = new Pelaaja("g");
        h = new Pelaaja("h");
        i = new Pelaaja("i");
        pelaajat.add(a);
        pelaajat.add(b);
        pelaajat.add(c);
        pelaajat.add(d);
        pelaajat.add(e);
        pelaajat.add(f);
        pelaajat.add(g);
        pelaajat.add(h);
        pelaajat.add(i);
    }

    /**
     *
     */
    @Before
    public void setUp() {
        yo = new Yo(pelaajat);
    }

    /**
     *
     */
    @Test
    public void ammuttuAluksiNull() {
        assertEquals(null, yo.getAmmuttu());
    }

    /**
     *
     */
    @Test
    public void suojeltuAluksiNull() {
        assertEquals(null, yo.getSuojeltu());
    }

    /**
     *
     */
    @Test
    public void getPelaajatToimii() {
        assertEquals(9, yo.getPelaajat().size());
    }

    /**
     *
     */
    @Test
    public void asetaSuojeltuToimiiJosPelaajaOnOlemassa() {
        yo.asetaSuojeltu(a);
        assertEquals(a, yo.getSuojeltu());
    }

    /**
     *
     */
    @Test
    public void asetaSuojeltuEiToimiiJosPelaajaEiOleOlemassa() {
        Pelaaja x = new Pelaaja("x");
        Pelaaja y = new Pelaaja("y");
        yo.asetaSuojeltu(x);
        assertEquals(null, yo.getSuojeltu());
        assertFalse(yo.asetaSuojeltu(y));
    }

    /**
     *
     */
    @Test
    public void asetaTapettavaToimiiJosPelaajaOnOlemassa() {
        yo.asetaAmmuttu(a);
        assertEquals(a, yo.getAmmuttu()); 
    }

    /**
     *
     */
    @Test
    public void asetaTapettavaEiToimiJosPelaajaEiOleOlemassa() {
        Pelaaja x = new Pelaaja("x");
        Pelaaja y = new Pelaaja("y");
        yo.asetaAmmuttu(x);
        assertEquals(null, yo.getAmmuttu());
        assertFalse(yo.asetaAmmuttu(y));
    }

    /**
     *
     */
    @Test
    public void josSuojeltuJaAmmuttuSamatKukaanEiKuole() {
        yo.asetaSuojeltu(a);
        yo.asetaAmmuttu(a);
        yo.tapaAmmutut();
        assertEquals(9, yo.getPelaajat().size());
    }

    /**
     *
     */
    @Test
    public void josSuojeltuJaAmmuttuEriAmmuttuPoistetaan() {
        yo.asetaSuojeltu(a);
        yo.asetaAmmuttu(b);
        yo.tapaAmmutut();
        assertEquals(8, yo.getPelaajat().size());
        assertFalse(yo.getPelaajat().contains(b));
    }

    /**
     *
     */
    @Test
    public void josketäänEiSuojellaAmmuttuPoistetaan() {
        yo.asetaAmmuttu(b);
        yo.tapaAmmutut();
        assertEquals(8, yo.getPelaajat().size());
        assertFalse(yo.getPelaajat().contains(b));
    }
}
