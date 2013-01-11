/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.sovelluslogiikka;

import mafia.sovelluslogiikka.roolit.Mafioso;
import mafia.sovelluslogiikka.sekalaista.Pelaaja;
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

    /**
     *
     */
    public PelaajaTest() {
    }

 
    /**
     *
     */
    @Before
    public void setUp() {
        pelaaja = new Pelaaja("Arto");
    }

    /**
     *
     */
    @Test
    public void luoPelaajaNimiOikein() {
        assertEquals("Arto", pelaaja.getNimi());
    }

    /**
     *
     */
    @Test
    public void alussaEiRoolia() {
        assertEquals(null, pelaaja.getRooli());
    }

    /**
     *
     */
    @Test
    public void setRooliToimiiOikeinMafiosolla() {
        Mafioso mafioso = new Mafioso();
        pelaaja.setRooli(mafioso);
        assertEquals(mafioso, pelaaja.getRooli());
    }

    /**
     *
     */
    @Test
    public void alussaElossa() {
        assertEquals(true, pelaaja.getElossa());
    }

    /**
     *
     */
    @Test
    public void kuoleToimii() {
        pelaaja.kuole();
        assertEquals(false, pelaaja.getElossa());
    }
}
