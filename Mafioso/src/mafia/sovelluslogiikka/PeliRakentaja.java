package mafia.sovelluslogiikka;

import java.util.ArrayList;
import java.util.Collections;
import mafia.sovelluslogiikka.sekalaista.Pelaaja;
import mafia.sovelluslogiikka.peli.Peli;
import mafia.sovelluslogiikka.peli.Saannot;
import mafia.sovelluslogiikka.roolit.Rooli;

/**
 * PeliRakentaja on luokka, jota käytetään pelin luomiseen.
 * PeliRakentaja-luokkia voidaan periaatteessa tallentaa ja käyttää uudestaan,
 * jolloin uuden pelin luominen samoilla pelaajilla, rooleilla ja säännöillä on
 * nopeaa. Roolit kuitenkin arvotaan pelaajille aina uudestaan.
 *
 * @author Arto
 */
public class PeliRakentaja {

    private Saannot saannot;
    private ArrayList<Pelaaja> pelaajat;
    private ArrayList<Rooli> roolit;

    /**
     *
     * @param pelaajia
     */
    public PeliRakentaja() {
        saannot = new Saannot();
        pelaajat = new ArrayList<Pelaaja>();
        roolit = new ArrayList<Rooli>();

    }

    /**
     * Palauttaa true jos pelaajien ja roolien määrä on sama tai pelaajien määrä
     * on 2 tai alle.
     *
     * @return
     */
    public boolean onkoValmis() {
        if (pelaajat.size() <= 2) {
            return false;
        }
        if (pelaajat.size() == roolit.size()) {
            return true;
        }
        return false;
    }

    /**
     * Lisää parametrina annetun roolin roolilistaan. Palauttaa true jos onnistuu, muuten false.
     *
     * @param rooli
     * @return
     */
    public boolean lisaaRooli(Rooli rooli) {
        return roolit.add(rooli);
    }

    /**
     * Poistaa parametrina annetun roolin roolilistalta. Palauttaa true jos onnistuu, muuten false.
     * @param rooli
     * @return
     */
    public boolean poistaRooli(Rooli rooli) {
        return roolit.remove(rooli);
    }

    /**
     * Lisää parametrina annetun pelaajan pelaajalistaan. Palauttaa false jos pelaaja on jo listalla tai lisäys ei muuten onnistu, true jos lisäys onnistuu.
     * @param pelaaja
     * @return
     */
    public boolean lisaaPelaaja(Pelaaja pelaaja) {
        if (this.pelaajat.contains(pelaaja)) {
            return false;
        }
        return this.pelaajat.add(pelaaja);
    }

    /**
     * Poistaa pelaajan pelaajalistalta. Palauttaa true jos onnistuu, false jos epäonnistuu.
     * @param pelaaja
     * @return
     */
    public boolean poistaPelaaja(Pelaaja pelaaja) {
        return this.pelaajat.remove(pelaaja);
    }

    /**
     * Luo uuden pelin, arpoo roolilistassa olevat roolit pelaajalistassa oleville pelaajille ja lisää nämä peliin. Palauttaa luodun pelin tai null jos peli ei ole valmis luotavaksi.
     * @return
     */
    public Peli teePeli() {
        if (!onkoValmis()) {
            return null;
        }
        Peli peli = new Peli();
        peli.setPelaajat(arvoRoolit());
        peli.setSaannot(saannot);
        if (peli.getPelaajat() == null) {
            return null;
        }
        return peli;
    }

    /**
     * Arpoo roolilistassa olevat roolit pelaajalistassa oleville pelaajille ja palauttaa listan pelaajista aakkosjärjestyksessä.
     * @return
     */
    public ArrayList<Pelaaja> arvoRoolit() {
        if (pelaajat.size() != roolit.size()) {
            return null;
        }
        ArrayList<Pelaaja> pelinPelaajat = (ArrayList<Pelaaja>) pelaajat.clone();
        Collections.shuffle(roolit);
        for (int i = 0; i < pelinPelaajat.size(); i++) {
            pelinPelaajat.get(i).setRooli(roolit.get(i));
        }
        Collections.sort(pelinPelaajat);
        return pelinPelaajat;
    }

    //Settereitä ja gettereitä:
    /**
     * 
     * @param saannot
     */
    public void setSaannot(Saannot saannot) {
        this.saannot = saannot;
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
     * @param roolit
     */
    public void setRoolit(ArrayList<Rooli> roolit) {
        this.roolit = roolit;
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
    public ArrayList<Pelaaja> getPelaajat() {
        return pelaajat;
    }

    /**
     *
     * @return
     */
    public ArrayList<Rooli> getRoolit() {
        return roolit;
    }

}
