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
public class AaniTest {

    Aani aani;
    Pelaaja arto;
    Pelaaja matti;

    /**
     *
     */
    public AaniTest() {
    }

    /**
     *
     */
    @BeforeClass
    public static void setUpClass() {
    }

    /**
     *
     */
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     *
     */
    @Before
    public void setUp() {
        arto = new Pelaaja("Arto");
        matti = new Pelaaja("Matti");
    }

    /**
     *
     */
    @After
    public void tearDown() {
    }

    /**
     *
     */
    @Test
    public void AanestajaOikein() {
        aani = new Aani(arto, matti);
        assertEquals(arto, aani.getAanestaja());
    }

    /**
     *
     */
    @Test
    public void AanestettyOikein() {
        aani = new Aani(arto, matti);
        assertEquals(matti, aani.getAanestetty());
    }
}
