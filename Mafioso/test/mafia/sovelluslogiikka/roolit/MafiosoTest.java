/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.sovelluslogiikka.roolit;

import mafia.sovelluslogiikka.roolit.Mafioso;
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
public class MafiosoTest {

    Mafioso mafioso;


    public MafiosoTest() {
    }



    @Before
    public void setUp() {
        mafioso = new Mafioso();
    }

    @Test
    public void mafiosoLuotu() {
        assertEquals("Mafioso", mafioso.getRoolinimi());
    }


    @Test
    public void mafiosoonPahis() {
        assertEquals(true, mafioso.onkoPahis());
    }
}
