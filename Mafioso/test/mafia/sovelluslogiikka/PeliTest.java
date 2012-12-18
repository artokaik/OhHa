/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.sovelluslogiikka;

import mafia.sovelluslogiikka.Peli;
import mafia.sovelluslogiikka.Pelaaja;
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
public class PeliTest {

    Peli peli;

    public PeliTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        peli = new Peli();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void alussaEiPelaajia() {
        assertEquals(0, peli.getPelaajat().size());
    }

    @Test
    public void lisaaYksiPelaaja() {
        Pelaaja pelaaja = new Pelaaja("Arto");
        peli.lisaaPelaaja(pelaaja);
        assertEquals(1, peli.getPelaajat().size());
    }

    @Test
    public void lisaaKaksiPelaajaa() {
        Pelaaja pelaaja = new Pelaaja("Arto");
        Pelaaja player = new Pelaaja("Matti");
        peli.lisaaPelaaja(pelaaja);
        peli.lisaaPelaaja(player);
        assertEquals(2, peli.getPelaajat().size());
    }

    @Test
    public void lisaasamaPelaajaKahdesti() {
        Pelaaja pelaaja = new Pelaaja("Arto");
        peli.lisaaPelaaja(pelaaja);
        peli.lisaaPelaaja(pelaaja);
        assertEquals(1, peli.getPelaajat().size());
    }

    @Test
    public void lisaaKaksiPelaajaaJaPoistaYksi() {
        Pelaaja pelaaja = new Pelaaja("Arto");
        Pelaaja player = new Pelaaja("Matti");
        peli.lisaaPelaaja(pelaaja);
        peli.lisaaPelaaja(player);
        peli.poistaPelaaja(pelaaja);
        assertEquals(1, peli.getPelaajat().size());
    }
    
        @Test
    public void peliAlkaaPaivalla() {
                assertEquals(true, peli.getSaannot().getPaivaEnsin());
    }
}
