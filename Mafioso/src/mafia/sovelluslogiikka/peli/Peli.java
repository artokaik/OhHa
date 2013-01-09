package mafia.sovelluslogiikka.peli;

import java.util.ArrayList;
import mafia.kayttoliittyma.Ohjaus;
import mafia.sovelluslogiikka.Paiva;
import mafia.sovelluslogiikka.Pelaaja;
import mafia.sovelluslogiikka.Vaihe;
import mafia.sovelluslogiikka.Yo;

/**
 * Peli-luokka kuvaa yhtä peliä. Se tuntee pelaajat, säännöt, sekä pelin
 * vaiheet. 
 *
 * @author Arto
 */
public class Peli {

    private ArrayList<Pelaaja> pelaajat;
    private ArrayList<Vaihe> vaiheet;
    private Vaihe kaynnissaOlevaVaihe;
    private Saannot saannot;

    /**
     *
     */
    public Peli() {
        this.pelaajat = new ArrayList<Pelaaja>();
        this.vaiheet = new ArrayList<Vaihe>();
        this.saannot = new Saannot();
        this.kaynnissaOlevaVaihe = null;
    }
    
        public Peli(ArrayList<Pelaaja> pelaajat) {
        this.pelaajat = pelaajat;
        this.vaiheet = new ArrayList<Vaihe>();
        this.saannot = new Saannot();
        this.kaynnissaOlevaVaihe = null;
    }

        /**
     * Palauttaa pelin seuraavan vaiheen.
     *
     * @param pelaaja
     * @return
     */
        
        public Vaihe seuraavaVaihe(){
            if(vaiheet.isEmpty()){
                if(saannot.getPaivaEnsin()){
                    return new Paiva(pelaajat);
                } else {
                    return new Yo(pelaajat);
                }
            }
            Vaihe nykyinenVaihe = vaiheet.get(vaiheet.size()-1);
            return nykyinenVaihe.luoSeuraavaVaihe();
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
    public boolean jatkuuko(ArrayList<Pelaaja> hengissa) {
        int pahikset = laskePahikset(hengissa);
        int hyvikset = laskeHyvikset(hengissa);
        if ( pahikset == 0 || pahikset >= hyvikset) {
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
    public int laskeHyvikset(ArrayList<Pelaaja> hengissa) {
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
    public int laskePahikset(ArrayList<Pelaaja> hengissa) {
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
     */
    public boolean voittikoHyvikset(ArrayList<Pelaaja> hengissa) {
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
     */
    public boolean voittikoPahikset(ArrayList<Pelaaja> hengissa) {
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
     * @return
     */
    public Vaihe getKaynnissaOlevaVaihe() {
        return this.kaynnissaOlevaVaihe;
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
     * @param kaynnissaOlevaVaihe
     */
    public void setKaynnissaOlevaVaihe(Vaihe kaynnissaOlevaVaihe) {
        this.kaynnissaOlevaVaihe = kaynnissaOlevaVaihe;
    }

    /**
     *
     * @param saannot
     */
    public void setSaannot(Saannot saannot) {
        this.saannot = saannot;
    }
}
//    /**
//     *
//     */
//    public void pelaa() {
//        Vaihe seuraavaVaihe = new Yo((ArrayList<Pelaaja>) pelaajat.clone());
//        if (saannot.getPaivaEnsin()) {
//            seuraavaVaihe = new Paiva((ArrayList<Pelaaja>) pelaajat.clone());
//        }
//        while (jatkuuko(seuraavaVaihe.getPelaajat())) {
//            seuraavaVaihe = pelaaYksiVaihe(seuraavaVaihe);
//        }
//        this.julistaVoittaja(seuraavaVaihe.getPelaajat());
//    }
//    /**
//     * Suorittaa käynnissä olevan vaiheen pelaa(Saannot saannot) -metodin, lisää vaiheen pelin vaihelistaan, pyytää ohjausoliota tulostamaan vaiheen tapahtumat ja pyytää käynnissä olevaa vaihetta luomaan seuraavan vaiheen, joka on metodin paluuarvo.
//     * @param vaihe
//     * @return
//     */
//    public Vaihe pelaaYksiVaihe(Vaihe vaihe) {
//        kaynnissaOlevaVaihe = vaihe;
//        vaihe.pelaa(saannot);
//        vaiheet.add(vaihe);
//        Ohjaus ohjaus = new Ohjaus();
//        ohjaus.tulostaTapahtumat(vaihe);
//        return vaihe.luoSeuraavaVaihe();
//    }
//    /**
//     *
//     * @param hengissa
//     */
//    public void julistaVoittaja(ArrayList<Pelaaja> hengissa) {
//        Ohjaus ohjaus = new Ohjaus();
//        for (Pelaaja pelaaja : hengissa) {
//            if (pelaaja.getRooli().onkoPahis()) {
//                ohjaus.julistaVoittaja("Pahikset");
//                return;
//            }
//        }
//        ohjaus.julistaVoittaja("Hyvikset");
//    }