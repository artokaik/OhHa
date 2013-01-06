
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
public class EtsivaTest {
    Etsiva etsiva;
    
    /**
     *
     */
    public EtsivaTest() {
    }
    
 
    
    /**
     *
     */
    @Before
    public void setUp() {
        etsiva = new Etsiva();
    }
    
    /**
     *
     */
    @Test
    public void etsivaNimi() {
        assertEquals("Etsivä", etsiva.getRoolinimi());
    }

    /**
     *
     */
    @Test
    public void etsivaOnHyvis() {
        assertEquals(false, etsiva.onkoPahis());
    }
}
