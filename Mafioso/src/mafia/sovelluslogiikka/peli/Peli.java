package mafia.sovelluslogiikka.peli;

import java.util.ArrayList;
import mafia.sovelluslogiikka.sekalaista.Pelaaja;

/**
 * Peli-luokka kuvaa yhtä peliä. Se tuntee pelaajat, säännöt, sekä pelin
 * vaiheet.
 *
 * @author Arto
 */
public class Peli {

    private ArrayList<Pelaaja> pelaajat;
    private ArrayList<Vaihe> vaiheet;
    private Saannot saannot;

    /**
     *
     */
    public Peli() {
        this.pelaajat = new ArrayList<Pelaaja>();
        this.vaiheet = new ArrayList<Vaihe>();
        this.saannot = new Saannot();

    }

    /**
     *
     * @param pelaajat
     */
    public Peli(ArrayList<Pelaaja> pelaajat) {
        this.pelaajat = pelaajat;
        this.vaiheet = new ArrayList<Vaihe>();
        this.saannot = new Saannot();

    }

    /**
     * Pyytää nykyistä vaihetta luomaan pelin seuraavan vaiheen ja lisää sen vaihelistaan. Mikäli kyseessä on pelin ensimmäinen vaihe, tarkastaa säännöistä onko vaihe Paiva vai Yo. Lopuksi palauttaa kyseisen vaiheen.
     *
     * @return
     */
    public Vaihe seuraavaanVaiheseen() {
        Vaihe uusiVaihe = null;
        if (vaiheet.isEmpty()) {
            if (saannot.getPaivaEnsin()) {
                uusiVaihe = new Paiva(pelaajat);
            } else {
                uusiVaihe = new Yo(pelaajat);
            }
        } else {
            Vaihe nykyinenVaihe = vaiheet.get(vaiheet.size() - 1);
            uusiVaihe = nykyinenVaihe.luoSeuraavaVaihe();
        }
        vaiheet.add(uusiVaihe);
        return uusiVaihe;

    }
    
    /**
     * Palauttaa pelin käynnissä olevan tai viimeisen vaiheen.
     * @return
     */
    public Vaihe haeNykyinenVaihe(){
        if (vaiheet.isEmpty()){
            return null;
        } else {
            return vaiheet.get(vaiheet.size()-1);
        }
    }
    
    /**
     * Palauttaa elossa olevat pelaajat.
     * @return
     */
    public ArrayList<Pelaaja> elossa(){
        return this.haeNykyinenVaihe().getPelaajat();
    }
    

    /**
     * Lisää parametrina annetun pelaajan peliin, jos pelaaja ei jo ole pelissä.
     * Palauttaa true, jos lisääminen onnistuu ja false jos ei onnistu.
     *
     * @param pelaaja
     * @return
     */
    public boolean lisaaPelaaja(Pelaaja pelaaja) {
        if (!pelaajat.contains(pelaaja)) {
            return this.pelaajat.add(pelaaja);
        }
        return false;
    }

    /**
     * Poistaa parametrina annetun pelaajan pelistä. Jos poisto onnistuu,
     * palauttaa true, muuten false.
     *
     * @param pelaaja
     * @return
     */
    public boolean poistaPelaaja(Pelaaja pelaaja) {
        return pelaajat.remove(pelaaja);
    }

    /**
     * Palauttaa true, jos parametrina annetussa pelaajalistassa on vähintään
     * yksi pahis, mutta kuitenkin enemmän hyviksiä kuin pahiksia. Muuten
     * palauttaa false.
     *
     * @param hengissa
     * @return
     */
    public static boolean jatkuuko(ArrayList<Pelaaja> hengissa) {
        int pahikset = laskePahikset(hengissa);
        int hyvikset = laskeHyvikset(hengissa);
        if (pahikset == 0 || pahikset >= hyvikset) {
            return false;
        }
        return true;
    }

    /**
     * Palauttaa hyvisten määrän parametrina annetussa pelaajalistassa.
     *
     * @param hengissa
     * @return
     */
    public static int laskeHyvikset(ArrayList<Pelaaja> hengissa) {
        int hyvistenMaara = 0;
        for (Pelaaja pelaaja : hengissa) {
            if (!pelaaja.getRooli().onkoPahis()) {
                hyvistenMaara++;
            }
        }
        return hyvistenMaara;
    }

    /**
     * Palauttaa pahisten määrän parametrina annetussa pelaajalistassa.
     *
     * @param hengissa
     * @return
     */
    public static int laskePahikset(ArrayList<Pelaaja> hengissa) {
        int pahistenMaara = 0;
        for (Pelaaja pelaaja : hengissa) {
            if (pelaaja.getRooli().onkoPahis()) {
                pahistenMaara++;
            }
        }
        return pahistenMaara;
    }

    /**
     * Palauttaa true jos hyvisten voittoehto täyttyy parametrina annetulla
     * pelaajalistalla. Muuten palauttaa false
     *
     * @param hengissa
     * @return
     */
    public static boolean voittikoHyvikset(ArrayList<Pelaaja> hengissa) {
        for (Pelaaja pelaaja : hengissa) {
            if (pelaaja.getRooli().onkoPahis()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Palauttaa true jos pahisten voittoehto täyttyy parametrina annetulla
     * pelaajalistalla. Muuten palauttaa false
     *
     * @param hengissa
     * @return
     */
    public static boolean voittikoPahikset(ArrayList<Pelaaja> hengissa) {
        if (laskeHyvikset(hengissa) > laskePahikset(hengissa)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String tuloste = "";
        tuloste += "Pelaajia: " + pelaajat.size() + "\n";
        tuloste += "Pelaajat: " + pelaajat + "\n";
        tuloste += saannot;
        return tuloste;
    }

    /**
     * Palauttaa Stringinä pelin voittajan.
     * @param hengissa
     * @return
     */
    public static String kerroLopputulos(ArrayList<Pelaaja> hengissa) {
        String tulokset = "";
        if (voittikoHyvikset(hengissa)) {
            tulokset = "Hyvikset voittivat!\n";
        } else if (voittikoPahikset(hengissa)) {
            tulokset = "Pahikset voittivat!\n";
        } else {
            tulokset = "Tasapeli!\n";
        }
        return tulokset;
    }

    //Getterit ja setterit:
    /**
     *
     * @return
     */
    public ArrayList<Vaihe> getVaiheet() {
        return vaiheet;
    }

    /**
     *
     * @return
     */
    public ArrayList<Pelaaja> getPelaajat() {
        return this.pelaajat;
    }

    /**
     *
     * @return
     */
    public Saannot getSaannot() {
        return saannot;
    }

    /**
     *
     * @param pelaajat
     */
    public void setPelaajat(ArrayList<Pelaaja> pelaajat) {
        this.pelaajat = pelaajat;
    }

    /**
     *
     * @param vaiheet
     */
    public void setVaiheet(ArrayList<Vaihe> vaiheet) {
        this.vaiheet = vaiheet;
    }

    /**
     *
     * @param saannot
     */
    public void setSaannot(Saannot saannot) {
        this.saannot = saannot;
    }
}
