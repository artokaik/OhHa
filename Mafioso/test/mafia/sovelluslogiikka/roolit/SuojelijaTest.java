
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
public class SuojelijaTest {
    private Suojelija suojelija;
    
    /**
     *
     */
    public SuojelijaTest() {
    }
    

    
      /**
     *
     */
    @Before
    public void setUp() {
        suojelija = new Suojelija();
    }
    
    /**
     *
     */
    @Test
    public void suojelijaNimi() {
        assertEquals("Suojelija", suojelija.getRoolinimi());
    }

    /**
     *
     */
    @Test
    public void suojelijaOnHyvis() {
        assertEquals(false, suojelija.onkoPahis());
    }
    

}
