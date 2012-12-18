/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.sovelluslogiikka;

import mafia.sovelluslogiikka.Mafioso;
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

public class PelaajaTest {

    Pelaaja pelaaja;

    public PelaajaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        pelaaja = new Pelaaja("Arto");
    }

    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    @Test
    public void luoPelaajaNimiOikein() {
        assertEquals("Arto", pelaaja.getNimi());
    }

    @Test
    public void alussaEiRoolia() {
        assertEquals(null, pelaaja.getRooli());
    }

    @Test
    public void setRooliToimiiOikeinMafiosolla() {
        Mafioso mafioso = new Mafioso();
        pelaaja.setRooli(mafioso);
        assertEquals(mafioso, pelaaja.getRooli());
    }

    @Test
    public void alussaElossa() {
        assertEquals(true, pelaaja.getElossa());
    }

    @Test
    public void kuoleToimii() {
        pelaaja.kuole();
        assertEquals(false, pelaaja.getElossa());
    }
}
