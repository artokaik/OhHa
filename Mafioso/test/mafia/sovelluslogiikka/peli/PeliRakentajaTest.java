/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.sovelluslogiikka.peli;

import mafia.sovelluslogiikka.Pelaaja;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Arto
 */
public class PeliRakentajaTest {
    
    PeliRakentaja rakentaja;
    
    public PeliRakentajaTest() {
       
    }
    
    @Before
    public void setUp() {
        rakentaja = new PeliRakentaja();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void asetaPelaaja(){
        rakentaja.lisaaPelaaja(new Pelaaja("Arto"));
        assertEquals(1, rakentaja.getPelaajat().size());
    }
}
