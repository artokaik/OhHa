package mafia.sovelluslogiikka;

import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AanestysTest {

    Aanestys aanestys;
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

    public AanestysTest() {
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

    @Before
    public void setUp() {


        aanestys = new Aanestys(pelaajat);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void ehdokkaatOikein() {
        assertEquals(9, aanestys.getEhdokkaat().size());
    }

    @Test
    public void alussaEiAania() {
        assertEquals(0, aanestys.getAanet().size());
    }

    @Test
    public void aanienMaaraOikein() {
        kaikkiAanestavatA4B3C2();
        assertEquals(9, aanestys.getAanet().size());
    }

    @Test
    public void enitenAaniaSaanutOikein() {
        kaikkiAanestavatA4B3C2();
        assertTrue(aanestys.haeTulokset(1).contains(a));
        assertFalse(aanestys.haeTulokset(1).contains(b));
        assertEquals(1, aanestys.haeTulokset(1).size());
    }

    @Test
    public void enitenAaniaSaanutOikeinTasapeli() {
        kaikkiAanestavatA4B4C1();
        assertTrue(aanestys.haeTulokset(1).contains(a));
        assertTrue(aanestys.haeTulokset(1).contains(b));
        assertFalse(aanestys.haeTulokset(1).contains(c));
        assertEquals(2, aanestys.haeTulokset(1).size());
    }

    @Test
    public void kaksiEnitenAaniaSaanuttaOikein() {
        kaikkiAanestavatA4B3C2();
        assertTrue(aanestys.haeTulokset(2).contains(a));
        assertTrue(aanestys.haeTulokset(2).contains(b));
        assertFalse(aanestys.haeTulokset(2).contains(c));
        assertEquals(2, aanestys.haeTulokset(2).size());
    }

    @Test
    public void kaksiEnitenAaniaSaanuttaOikeinKunKahdenTasapeli() {
        kaikkiAanestavatA4B4C1();
        assertTrue(aanestys.haeTulokset(2).contains(a));
        assertTrue(aanestys.haeTulokset(2).contains(b));
        assertFalse(aanestys.haeTulokset(2).contains(c));
        assertEquals(2, aanestys.haeTulokset(2).size());
    }

    @Test
    public void kaksiEnitenAaniaSaanuttaOikeinKunKolmenTasapeli() {
        kaikkiAanestavatA2B2C2D1E1F1();
        assertTrue(aanestys.haeTulokset(2).contains(a));
        assertTrue(aanestys.haeTulokset(2).contains(b));
        assertTrue(aanestys.haeTulokset(2).contains(c));
        assertFalse(aanestys.haeTulokset(2).contains(d));
        assertEquals(3, aanestys.haeTulokset(3).size());
    }

    @Test
    public void laskeAanetOikeinYksiAani() {
        kaikkiAanestavatA4B4C1();
        assertEquals(1, aanestys.laskeAanimaara(c));
    }

    @Test
    public void laskeAanetOikeinMontaAanta() {
        kaikkiAanestavatA4B4C1();
        assertEquals(4, aanestys.laskeAanimaara(a));
    }

    @Test
    public void laskeAanetOikeinNollaAanta() {
        kaikkiAanestavatA4B4C1();
        assertEquals(0, aanestys.laskeAanimaara(d));
    }

    @Test
    public void jokuAanestaaKahdesti() {
        aanestys.lisaaAani(a, b);
        aanestys.lisaaAani(a, c);
        assertFalse(aanestys.lisaaAani(a, d));
        assertEquals(1, aanestys.laskeAanimaara(b));
        assertEquals(0, aanestys.laskeAanimaara(c));
    }

    @Test
    public void aanenVaihtoToimii() {
        kaikkiAanestavatA4B3C2();
        aanestys.vaihdaAani(c, b);
        assertEquals(3, aanestys.laskeAanimaara(a));
        assertEquals(9, aanestys.getAanet().size());
        assertEquals(4, aanestys.laskeAanimaara(b));
        assertTrue(aanestys.vaihdaAani(b, d));
    }

    @Test
    public void aanenVaihtoEiToimiJosAantaEiOleAnnettu() {
        aanestys.lisaaAani(a, b);
        aanestys.vaihdaAani(b, c);
        assertFalse(aanestys.vaihdaAani(c, d));
        assertEquals(0, aanestys.laskeAanimaara(c));
        assertEquals(1, aanestys.laskeAanimaara(b));
    }


    public void kaikkiAanestavatA4B3C2() {
        aanestys.lisaaAani(a, b);
        aanestys.lisaaAani(b, c);
        aanestys.lisaaAani(c, a);
        aanestys.lisaaAani(d, b);
        aanestys.lisaaAani(e, a);
        aanestys.lisaaAani(f, a);
        aanestys.lisaaAani(g, b);
        aanestys.lisaaAani(h, c);
        aanestys.lisaaAani(i, a);
    }

    public void kaikkiAanestavatA4B4C1() {
        aanestys.lisaaAani(a, c);
        aanestys.lisaaAani(b, a);
        aanestys.lisaaAani(c, a);
        aanestys.lisaaAani(d, a);
        aanestys.lisaaAani(e, a);
        aanestys.lisaaAani(f, b);
        aanestys.lisaaAani(g, b);
        aanestys.lisaaAani(h, b);
        aanestys.lisaaAani(i, b);
    }

    public void kaikkiAanestavatA2B2C2D1E1F1() {
        aanestys.lisaaAani(a, f);
        aanestys.lisaaAani(b, a);
        aanestys.lisaaAani(c, a);
        aanestys.lisaaAani(d, b);
        aanestys.lisaaAani(e, b);
        aanestys.lisaaAani(f, c);
        aanestys.lisaaAani(g, c);
        aanestys.lisaaAani(h, d);
        aanestys.lisaaAani(i, e);
    }
}
