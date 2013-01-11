/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.sovelluslogiikka;

import mafia.sovelluslogiikka.sekalaista.Pelaaja;
import mafia.sovelluslogiikka.peli.Paiva;
import mafia.sovelluslogiikka.peli.Yo;
import mafia.sovelluslogiikka.peli.Peli;
import mafia.sovelluslogiikka.roolit.Etsiva;
import mafia.sovelluslogiikka.roolit.Kansalainen;
import mafia.sovelluslogiikka.roolit.Mafioso;
import mafia.sovelluslogiikka.roolit.Suojelija;
import mafia.sovelluslogiikka.sekalaista.Aanestys;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Arto
 */
public class PaivaTest {

    Peli peli;
    Mafioso mafioso;
    Etsiva etsiva;
    Kansalainen kansalainen;
    Suojelija suojelija;
    Pelaaja arto;
    Pelaaja matti;
    Pelaaja antti;
    Pelaaja pekka;
    Pelaaja pasi;
    Pelaaja ossi;
    Paiva paiva;

    public PaivaTest() {
    }

    @Before
    public void setUp() {
        peli = new Peli();
        mafioso = new Mafioso();
        kansalainen = new Kansalainen();
        etsiva = new Etsiva();
        suojelija = new Suojelija();
        arto = new Pelaaja("Arto");
        matti = new Pelaaja("Matti");
        antti = new Pelaaja("Antti");
        pekka = new Pelaaja("Pekka");
        pasi = new Pelaaja("Pasi");
        ossi = new Pelaaja("Ossi");
        arto.setRooli(mafioso);
        matti.setRooli(mafioso);
        antti.setRooli(etsiva);
        pekka.setRooli(suojelija);
        pasi.setRooli(kansalainen);
        ossi.setRooli(kansalainen);
        peli.lisaaPelaaja(arto);
        peli.lisaaPelaaja(matti);
        peli.lisaaPelaaja(antti);
        peli.lisaaPelaaja(pekka);
        peli.lisaaPelaaja(pasi);
        peli.lisaaPelaaja(ossi);
        paiva = new Paiva(peli.getPelaajat());
    }

    @After
    public void tearDown() {
    }

    @Test
    public void paivaLuominenOnnistuu() {
        assertTrue(paiva.getAanestykset().isEmpty());
        assertTrue(paiva.getLynkattu().isEmpty());
        assertEquals(6, paiva.getPelaajat().size());
    }

    @Test
    public void luoSeuraavaVaiheToimii() {
        Yo yo = paiva.luoSeuraavaVaihe();
        assertEquals(null, yo.getAmmuttu());
        assertEquals(paiva.getPelaajat(), yo.getPelaajat());
        yo.asetaAmmuttu(pekka);
        yo.tapaAmmutut();
        assertFalse(paiva.getPelaajat().equals(yo.getPelaajat()));
    }
    
    @Test
    public void aanestyksenLisaaminenToimii(){
        paiva.lisaaAanestys(new Aanestys(paiva.getPelaajat(), paiva.getPelaajat()));
        assertEquals(1,paiva.getAanestykset().size());
    }
}
