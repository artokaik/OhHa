/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.sovelluslogiikka;

import mafia.sovelluslogiikka.sekalaista.Pelaaja;
import mafia.sovelluslogiikka.sekalaista.Aani;
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
    Pelaaja antti;

    /**
     *
     */
    public AaniTest() {
    }

    /**
     *
     */
    @Before
    public void setUp() {
        arto = new Pelaaja("Arto");
        matti = new Pelaaja("Matti");
        antti = new Pelaaja("Antti");
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
    
    @Test
    public void aanenVaihtoToimii() {
        aani = new Aani(arto, matti);
        aani.setAanestetty(antti);
        assertEquals(antti, aani.getAanestetty());
    }
    
        @Test
    public void aanestajanVaihtoToimii() {
        aani = new Aani(arto, matti);
        aani.setAanestaja(antti);
        assertEquals(antti, aani.getAanestaja());
    }
}
