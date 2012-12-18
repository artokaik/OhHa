/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sovelluslogiikkaTests;

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
        assertEquals(peli.getPelaajat().size(), 0);
    }

    @Test
    public void lisaaYksiPelaaja() {
        Pelaaja pelaaja = new Pelaaja("Arto");
        peli.lisaaPelaaja(pelaaja);
        assertEquals(peli.getPelaajat().size(), 1);
    }

    @Test
    public void lisaaKaksiPelaajaa() {
        Pelaaja pelaaja = new Pelaaja("Arto");
        Pelaaja player = new Pelaaja("Matti");
        peli.lisaaPelaaja(pelaaja);
        peli.lisaaPelaaja(player);
        assertEquals(peli.getPelaajat().size(), 2);
    }

    @Test
    public void lisaasamaPelaajaKahdesti() {
        Pelaaja pelaaja = new Pelaaja("Arto");
        peli.lisaaPelaaja(pelaaja);
        peli.lisaaPelaaja(pelaaja);
        assertEquals(peli.getPelaajat().size(), 1);
    }
}
