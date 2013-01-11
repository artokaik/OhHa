/* Seuraavia metodeja on testattu melko paljon:
 * 
 * boolean jatkuuko(ArrayList<Pelaaja>)
 * boolean poistaPelaaja(Pelaaja)
 * boolean lisaaPelaaja(Pelaaja)
 * 
 */
package mafia.sovelluslogiikka.peli;

import java.util.ArrayList;
import mafia.sovelluslogiikka.PeliRakentaja;
import mafia.sovelluslogiikka.roolit.Etsiva;
import mafia.sovelluslogiikka.roolit.Mafioso;
import mafia.sovelluslogiikka.roolit.Kansalainen;
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
public class PeliTest {

    Peli peli;

    /**
     *
     */
    public PeliTest() {
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
        peli = new Peli();

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
    public void alussaEiPelaajia() {
        assertEquals(0, peli.getPelaajat().size());
    }

    /**
     *
     */
    @Test
    public void lisaaYksiPelaaja() {
        Pelaaja pelaaja = new Pelaaja("Arto");
        peli.lisaaPelaaja(pelaaja);
        assertEquals(1, peli.getPelaajat().size());
    }

    /**
     *
     */
    @Test
    public void lisaaYksiPelaajaPalauttaaTrue() {
        Pelaaja pelaaja = new Pelaaja("Arto");
        assertEquals(true, peli.lisaaPelaaja(pelaaja));
    }

    /**
     *
     */
    @Test
    public void lisaaKaksiPelaajaa() {
        Pelaaja pelaaja = new Pelaaja("Arto");
        Pelaaja player = new Pelaaja("Matti");
        peli.lisaaPelaaja(pelaaja);
        peli.lisaaPelaaja(player);
        assertEquals(2, peli.getPelaajat().size());
    }

    /**
     *
     */
    @Test
    public void lisaasamaPelaajaKahdesti() {
        Pelaaja pelaaja = new Pelaaja("Arto");
        peli.lisaaPelaaja(pelaaja);
        peli.lisaaPelaaja(pelaaja);
        assertEquals(1, peli.getPelaajat().size());
    }

    /**
     *
     */
    @Test
    public void lisaaKaksiSamanNimistaPelaajaa() {
        Pelaaja pelaaja1 = new Pelaaja("Arto");
        Pelaaja pelaaja2 = new Pelaaja("Arto");
        peli.lisaaPelaaja(pelaaja1);
        peli.lisaaPelaaja(pelaaja2);
        assertEquals(1, peli.getPelaajat().size());
    }

    /**
     *
     */
    @Test
    public void lisaaKaksiSamanNimistaPelaajaaPalauttaaFalse() {
        Pelaaja pelaaja1 = new Pelaaja("Arto");
        Pelaaja pelaaja2 = new Pelaaja("Arto");
        peli.lisaaPelaaja(pelaaja1);
        assertEquals(false, peli.lisaaPelaaja(pelaaja2));
    }

    /**
     *
     */
    @Test
    public void lisaaKaksiPelaajaaJaPoistaYksi() {
        Pelaaja pelaaja = new Pelaaja("Arto");
        Pelaaja player = new Pelaaja("Matti");
        peli.lisaaPelaaja(pelaaja);
        peli.lisaaPelaaja(player);
        peli.poistaPelaaja(pelaaja);
        assertEquals(1, peli.getPelaajat().size());
    }

    /**
     *
     */
    @Test
    public void PoistaOlemassaolevaPelaajaPalauttaaTrue() {
        Pelaaja pelaaja = new Pelaaja("Arto");
        peli.lisaaPelaaja(pelaaja);
        assertEquals(true, peli.poistaPelaaja(new Pelaaja("Arto")));
    }

    /**
     *
     */
    @Test
    public void PoistaOlematonPelaajaPalauttaaFalse() {
        Pelaaja pelaaja = new Pelaaja("Arto");
        peli.lisaaPelaaja(pelaaja);
        assertEquals(false, peli.poistaPelaaja(new Pelaaja("Matti")));
    }

    /**
     *
     */
    @Test
    public void peliAlkaaPaivalla() {
        assertEquals(true, peli.getSaannot().getPaivaEnsin());
    }

    /**
     *
     */
    @Test
    public void tyhjaPelieiJatku() {
        assertEquals(false, peli.jatkuuko(peli.getPelaajat()));
    }

    /**
     *
     */
    @Test
    public void yhdenMafiosonJaKahdenHyviksenPeliJatkuueikaKumpikaanVoita() {
        Pelaaja pelaaja = new Pelaaja("Arto");
        pelaaja.setRooli(new Mafioso());
        Pelaaja pelaaja2 = new Pelaaja("Matti");
        pelaaja2.setRooli(new Etsiva());
        Pelaaja pelaaja3 = new Pelaaja("Erkki");
        pelaaja3.setRooli(new Kansalainen());
        peli.lisaaPelaaja(pelaaja);
        peli.lisaaPelaaja(pelaaja2);
        peli.lisaaPelaaja(pelaaja3);
        assertEquals(true, peli.jatkuuko(peli.getPelaajat()));
        assertFalse(peli.voittikoHyvikset(peli.getPelaajat()));
        assertFalse(peli.voittikoPahikset(peli.getPelaajat()));

    }

    /**
     *
     */
    @Test
    public void yhdenMafiosonJaYhdenHyviksenPeliEiJatkujaMafiosotVoitti() {
        Pelaaja pelaaja = new Pelaaja("Arto");
        pelaaja.setRooli(new Mafioso());
        Pelaaja pelaaja2 = new Pelaaja("Matti");
        pelaaja2.setRooli(new Etsiva());
        peli.lisaaPelaaja(pelaaja);
        peli.lisaaPelaaja(pelaaja2);
        assertEquals(false, peli.jatkuuko(peli.getPelaajat()));
        assertFalse(peli.voittikoHyvikset(peli.getPelaajat()));
        assertTrue(peli.voittikoPahikset(peli.getPelaajat()));
    }

    /**
     *
     */
    @Test
    public void KahdenHyviksenPeliEiJatkuu() {
        Pelaaja pelaaja2 = new Pelaaja("Matti");
        pelaaja2.setRooli(new Etsiva());
        Pelaaja pelaaja3 = new Pelaaja("Erkki");
        pelaaja3.setRooli(new Kansalainen());
        peli.lisaaPelaaja(pelaaja2);
        peli.lisaaPelaaja(pelaaja3);
        assertEquals(false, peli.jatkuuko(peli.getPelaajat()));
        assertTrue(peli.voittikoHyvikset(peli.getPelaajat()));
        assertFalse(peli.voittikoPahikset(peli.getPelaajat()));
    }

    @Test
    public void seuraavaVaiheToimiiJokaToinenPaiva() {
        Vaihe vaihe1;
        Vaihe vaihe2;
        if (peli.getSaannot().getPaivaEnsin()) {
            vaihe1 = new Paiva(new ArrayList<Pelaaja>());
            vaihe2 = new Yo(new ArrayList<Pelaaja>());
        } else {
            vaihe2 = new Paiva(new ArrayList<Pelaaja>());
            vaihe1 = new Yo(new ArrayList<Pelaaja>());
        }
        assertEquals(vaihe1.getClass(), peli.seuraavaanVaiheseen().getClass());
        assertEquals(vaihe2.getClass(), peli.seuraavaanVaiheseen().getClass());
        assertEquals(vaihe1.getClass(), peli.seuraavaanVaiheseen().getClass());
        assertEquals(vaihe2.getClass(), peli.seuraavaanVaiheseen().getClass());
        assertEquals(vaihe1.getClass(), peli.seuraavaanVaiheseen().getClass());
    }

    @Test
    public void seuraavaVaiheToimiiPelaajatSiirtyvät() {
        peli = teeIsoPeliPeliRakentajalla();
        assertEquals(9, peli.seuraavaanVaiheseen().getPelaajat().size());
        assertEquals(9, peli.seuraavaanVaiheseen().getPelaajat().size()); 
        assertEquals(9, peli.seuraavaanVaiheseen().getPelaajat().size());
    }
    
        public static Peli teeIsoPeliPeliRakentajalla() {
        PeliRakentaja rakentaja = new PeliRakentaja();
        rakentaja.lisaaPelaaja(new Pelaaja("a"));
        rakentaja.lisaaPelaaja(new Pelaaja("b"));
        rakentaja.lisaaPelaaja(new Pelaaja("c"));
        rakentaja.lisaaPelaaja(new Pelaaja("d"));
        rakentaja.lisaaPelaaja(new Pelaaja("e"));
        rakentaja.lisaaPelaaja(new Pelaaja("f"));
        rakentaja.lisaaPelaaja(new Pelaaja("g"));
        rakentaja.lisaaPelaaja(new Pelaaja("h"));
        rakentaja.lisaaPelaaja(new Pelaaja("i"));
        rakentaja.lisaaRooli(new Mafioso());
        rakentaja.lisaaRooli(new Mafioso());
        rakentaja.lisaaRooli(new Mafioso());
        rakentaja.lisaaRooli(new Kansalainen());
        rakentaja.lisaaRooli(new Kansalainen());
        rakentaja.lisaaRooli(new Kansalainen());
        rakentaja.lisaaRooli(new Kansalainen());
        rakentaja.lisaaRooli(new Kansalainen());
        rakentaja.lisaaRooli(new Kansalainen());
        return rakentaja.teePeli();
    }
    }
