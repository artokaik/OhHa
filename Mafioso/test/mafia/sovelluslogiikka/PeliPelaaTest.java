/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.sovelluslogiikka;

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
public class PeliPelaaTest {

    Peli peli;
    Mafioso mafioso;
    Etsiva etsiva;
    Kansalainen kansalainen;
    Suojelija suojelija;
    Pelaaja arto;
    Pelaaja matti;
    Pelaaja antti;
    Pelaaja pekka;
    Pelaaja pasi;
    Pelaaja ossi;

    public PeliPelaaTest() {
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
        mafioso = new Mafioso();
        kansalainen = new Kansalainen();
        etsiva = new Etsiva();
        suojelija = new Suojelija();
        arto = new Pelaaja("Arto");
        matti = new Pelaaja("Matti");
        antti = new Pelaaja("Antti");
        pekka = new Pelaaja("Pekka");
        pasi = new Pelaaja("Pasi");
        ossi = new Pelaaja("Ossi");
        arto.setRooli(mafioso);
        matti.setRooli(mafioso);
        antti.setRooli(etsiva);
        pekka.setRooli(suojelija);
        pasi.setRooli(kansalainen);
        ossi.setRooli(kansalainen);
        peli.lisaaPelaaja(arto);
        peli.lisaaPelaaja(matti);
        peli.lisaaPelaaja(antti);
        peli.lisaaPelaaja(pekka);
        peli.lisaaPelaaja(pasi);
        peli.lisaaPelaaja(ossi);
    }

    @After
    public void tearDown() {
    }


}
