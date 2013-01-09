/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.sovelluslogiikka.peli;

import mafia.sovelluslogiikka.Pelaaja;
import mafia.sovelluslogiikka.roolit.Etsiva;
import mafia.sovelluslogiikka.roolit.Kansalainen;
import mafia.sovelluslogiikka.roolit.Mafioso;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Arto
 */
public class PeliRakentajaTest {

    PeliRakentaja rakentaja;

    public PeliRakentajaTest() {
    }

    @Before
    public void setUp() {
        rakentaja = new PeliRakentaja();
    }

    @Test
    public void lisaaPelaajaLisaaPelaajan() {
        rakentaja.lisaaPelaaja(new Pelaaja("Arto"));
        assertEquals(1, rakentaja.getPelaajat().size());
    }

    @Test
    public void lisaaPelaajaEiLIsaaPelaajaaJosSamanNiminenOnJoOlemassa() {
        rakentaja.lisaaPelaaja(new Pelaaja("Arto"));
        rakentaja.lisaaPelaaja(new Pelaaja("Arto"));
        assertEquals(1, rakentaja.getPelaajat().size());
        assertFalse(rakentaja.lisaaPelaaja(new Pelaaja("Arto")));
    }

    @Test
    public void lisaaPelaajaKahdestiLisaaKaksiPelaajaa() {
        assertTrue(rakentaja.lisaaPelaaja(new Pelaaja("Arto")));
        assertTrue(rakentaja.lisaaPelaaja(new Pelaaja("Matti")));
        assertEquals(2, rakentaja.getPelaajat().size());
    }

    @Test
    public void poistaPelaajatoimiiKunKaksiPelaajaa() {
        assertTrue(rakentaja.lisaaPelaaja(new Pelaaja("Arto")));
        assertTrue(rakentaja.lisaaPelaaja(new Pelaaja("Matti")));
        assertTrue(rakentaja.poistaPelaaja(new Pelaaja("Arto")));
        assertEquals(1, rakentaja.getPelaajat().size());
    }

    @Test
    public void poistaPelaajaEiTeeMitaanKunPelaajaaEiOle() {
        assertTrue(rakentaja.lisaaPelaaja(new Pelaaja("Arto")));
        assertTrue(rakentaja.lisaaPelaaja(new Pelaaja("Matti")));
        assertFalse(rakentaja.poistaPelaaja(new Pelaaja("Ossi")));
        assertEquals(2, rakentaja.getPelaajat().size());
    }

    @Test
    public void lisaaRooliLisaaRoolin() {
        assertTrue(rakentaja.lisaaRooli(new Mafioso()));
        assertEquals(1, rakentaja.getRoolit().size());
    }

    @Test
    public void lisaaSamaRooliKahdestiLisaaKaksiSamaaRoolia() {
        assertTrue(rakentaja.lisaaRooli(new Mafioso()));
        assertTrue(rakentaja.lisaaRooli(new Mafioso()));
        assertEquals(2, rakentaja.getRoolit().size());
    }

    @Test
    public void lisaaEriRooliKahdestiLisaaKaksiRoolia() {
        assertTrue(rakentaja.lisaaRooli(new Mafioso()));
        assertTrue(rakentaja.lisaaRooli(new Etsiva()));
        assertEquals(2, rakentaja.getRoolit().size());
    }

    @Test
    public void poistaRooliToimiiKunPelissaKaksiSamaaRoolia() {
        Mafioso mafioso = new Mafioso();
        Mafioso mafioso2 = new Mafioso();
        assertTrue(rakentaja.lisaaRooli(mafioso));
        assertTrue(rakentaja.lisaaRooli(mafioso2));
        assertTrue(rakentaja.poistaRooli(mafioso));
        assertEquals(1, rakentaja.getRoolit().size());
    }

    @Test
    public void poistaRooliToimiiKunPelissaKolmeEriRoolia() {
        Mafioso mafioso = new Mafioso();
        Etsiva etsiva = new Etsiva();
        Kansalainen kansalainen = new Kansalainen();
        assertTrue(rakentaja.lisaaRooli(mafioso));
        assertTrue(rakentaja.lisaaRooli(etsiva));
        assertTrue(rakentaja.lisaaRooli(kansalainen));
        assertTrue(rakentaja.poistaRooli(mafioso));
        assertEquals(2, rakentaja.getRoolit().size());
    }

    @Test
    public void arvoRoolitToimii() {
        rakentaja.lisaaPelaaja(new Pelaaja("Arto"));
        rakentaja.lisaaPelaaja(new Pelaaja("Matti"));
        rakentaja.lisaaPelaaja(new Pelaaja("Antti"));
        rakentaja.lisaaRooli(new Mafioso());
        rakentaja.lisaaRooli(new Etsiva());
        rakentaja.lisaaRooli(new Kansalainen());
        for (Pelaaja pelaaja : rakentaja.getPelaajat()) {
            assertTrue(pelaaja.getRooli() == null);
        }
        rakentaja.arvoRoolit();
        for (Pelaaja pelaaja : rakentaja.getPelaajat()) {
            assertFalse(pelaaja.getRooli() == null);
        }
    }

    @Test
    public void onkoValmisPalauttaaFalseJosNollaPelaajaaJaRoolia() {
        assertFalse(rakentaja.onkoValmis());
    }

    @Test
    public void onkoValmisPalauttaaFalseJosYksiPelaajaJaRooli() {
        rakentaja.lisaaPelaaja(new Pelaaja("Antti"));
        rakentaja.lisaaRooli(new Mafioso());
        assertFalse(rakentaja.onkoValmis());
    }

    @Test
    public void onkoValmisPalauttaaFalseJosKaksiPelaajaaJaRoolia() {
        rakentaja.lisaaPelaaja(new Pelaaja("Matti"));
        rakentaja.lisaaPelaaja(new Pelaaja("Antti"));
        rakentaja.lisaaRooli(new Mafioso());
        rakentaja.lisaaRooli(new Etsiva());
        assertFalse(rakentaja.onkoValmis());
    }

    @Test
    public void onkoValmisPalauttaaFalseJosKolmePelaajaaJaNeljäRoolia() {
        rakentaja.lisaaPelaaja(new Pelaaja("Arto"));
        rakentaja.lisaaPelaaja(new Pelaaja("Matti"));
        rakentaja.lisaaPelaaja(new Pelaaja("Antti"));
        rakentaja.lisaaRooli(new Mafioso());
        rakentaja.lisaaRooli(new Etsiva());
        rakentaja.lisaaRooli(new Kansalainen());
        rakentaja.lisaaRooli(new Kansalainen());
        assertFalse(rakentaja.onkoValmis());
    }

    @Test
    public void onkoValmisPalauttaaFalseJosNeljäPelaajaaJaKolmeRoolia() {
        rakentaja.lisaaPelaaja(new Pelaaja("Arto"));
        rakentaja.lisaaPelaaja(new Pelaaja("Matti"));
        rakentaja.lisaaPelaaja(new Pelaaja("Antti"));
        rakentaja.lisaaPelaaja(new Pelaaja("Ossi"));
        rakentaja.lisaaRooli(new Etsiva());
        rakentaja.lisaaRooli(new Kansalainen());
        rakentaja.lisaaRooli(new Kansalainen());
        assertFalse(rakentaja.onkoValmis());
    }

    @Test
    public void onkoValmisPalauttaaTrueJosKolmePelaajaaJaKolmeRoolia() {
        rakentaja.lisaaPelaaja(new Pelaaja("Arto"));
        rakentaja.lisaaPelaaja(new Pelaaja("Matti"));
        rakentaja.lisaaPelaaja(new Pelaaja("Antti"));
        rakentaja.lisaaRooli(new Mafioso());
        rakentaja.lisaaRooli(new Etsiva());
        rakentaja.lisaaRooli(new Kansalainen());
        assertTrue(rakentaja.onkoValmis());
    }

    @Test
    public void teePeliPalauttaaNullKunPelaajiaKolmeJaRoolejaNelja() {
        rakentaja.lisaaPelaaja(new Pelaaja("Arto"));
        rakentaja.lisaaPelaaja(new Pelaaja("Matti"));
        rakentaja.lisaaPelaaja(new Pelaaja("Antti"));
        rakentaja.lisaaRooli(new Mafioso());
        rakentaja.lisaaRooli(new Etsiva());
        rakentaja.lisaaRooli(new Kansalainen());
        rakentaja.lisaaRooli(new Kansalainen());
        Peli peli = rakentaja.teePeli();
        assertEquals(null, peli);
    }
    
        @Test
    public void teePeliPalauttaaPelinKunPelaajiaJaRoolejaKolme() {
        rakentaja.lisaaPelaaja(new Pelaaja("Arto"));
        rakentaja.lisaaPelaaja(new Pelaaja("Matti"));
        rakentaja.lisaaPelaaja(new Pelaaja("Antti"));
        rakentaja.lisaaRooli(new Mafioso());
        rakentaja.lisaaRooli(new Etsiva());
        rakentaja.lisaaRooli(new Kansalainen());
        Peli peli = rakentaja.teePeli();
        assertEquals(3, peli.getPelaajat().size());
    }
}
