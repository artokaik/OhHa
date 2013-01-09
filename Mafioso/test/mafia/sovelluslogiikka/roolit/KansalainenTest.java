/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.sovelluslogiikka.roolit;

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
public class KansalainenTest {
        Kansalainen kansalainen;
    
    /**
     *
     */
    public KansalainenTest() {
    }
    
 
    
    /**
     *
     */
    @Before
    public void setUp() {
        kansalainen = new Kansalainen();
    }
    
    /**
     *
     */
    @Test
    public void etsivaNimi() {
        assertEquals("Kansalainen", kansalainen.getRoolinimi());
    }

    /**
     *
     */
    @Test
    public void etsivaOnHyvis() {
        assertEquals(false, kansalainen.onkoPahis());
    }
}