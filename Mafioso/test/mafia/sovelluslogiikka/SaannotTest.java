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

import mafia.sovelluslogiikka.*;

/**
 *
 * @author Arto
 */
public class SaannotTest {

    Saannot saannot;

    public SaannotTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        saannot = new Saannot();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void oletusarvoisestiPeliAlkaaPaivalla() {
        assertEquals(true, saannot.getPaivaEnsin());
    }

    @Test
    public void saantojenMuutosPeliAlkaaYolla() {
        saannot.asetaYoEnsin();
        assertEquals(false, saannot.getPaivaEnsin());
    }

    @Test
    public void saantojenMuutosPeliAlkaaPaivalla() {
        saannot.asetaPaivaEnsin();
        assertEquals(true, saannot.getPaivaEnsin());
    }

    @Test
    public void saantojenMuutosPeliAlkaaYollaPaivalla() {
        saannot.asetaYoEnsin();
        saannot.asetaPaivaEnsin();
        assertEquals(true, saannot.getPaivaEnsin());
    }
}
