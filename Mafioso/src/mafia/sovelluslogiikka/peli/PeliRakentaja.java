package mafia.sovelluslogiikka.peli;

import java.util.ArrayList;
import java.util.Collections;
import mafia.sovelluslogiikka.Pelaaja;
import mafia.sovelluslogiikka.roolit.Rooli;

/**
 * PeliRakentaja on luokka, jota käytetään pelin luomiseen.
 * PeliRakentaja-luokkia voidaan tallentaa ja käyttää uudestaan, jolloin uuden
 * pelin luominen samoilla pelaajilla, rooleilla ja säännöillä on nopeaa. Roolit
 * kuitenkin arvotaan pelaajille aina uudestaan.
 *
 * @author Arto
 */
public class PeliRakentaja {

    private Saannot saannot;
    private ArrayList<Pelaaja> pelaajat;
    private ArrayList<Rooli> roolit;
//    private int pelaajienMaara;

    /**
     *
     * @param pelaajia
     */
    public PeliRakentaja(int pelaajia) {
        saannot = new Saannot();
        pelaajat = new ArrayList<Pelaaja>();
        roolit = new ArrayList<Rooli>();
//        pelaajienMaara = pelaajia;
    }

    /**
     *
     */
    public PeliRakentaja() {
        this(0);
    }
    
    
    /**
     * Palauttaa true jos pelaajien ja roolien määrä on sama tai pelaajien määrä on 2 tai alle.
     */
    public boolean onkoValmis() {
        if (pelaajat.size()<=2){
            return false;
        }
        if (pelaajat.size() == roolit.size()) {
            return true;
        }
        return false;
    }

//
/**
 *
 * @param rooli
 * @return
 */
public boolean lisaaRooli(Rooli rooli){
        return roolit.add(rooli);
    }
    
        public boolean poistaRooli(Rooli rooli){    
        return roolit.remove(rooli);
    }
    
    /**
     *
     * @param pelaaja
     * @return
     */
    public boolean lisaaPelaaja(Pelaaja pelaaja){
        if(this.pelaajat.contains(pelaaja)){
            return false;
        }      
        return this.pelaajat.add(pelaaja);
    }
    
    public boolean poistaPelaaja(Pelaaja pelaaja){
        return this.pelaajat.remove(pelaaja);
    }
    
    /**
     *
     * @return
     */
    public Peli teePeli(){
        if(!onkoValmis()){
            return null;
        }
        Peli peli = new Peli();
        peli.setPelaajat(arvoRoolit());
        peli.setSaannot(saannot);
        if(peli.getPelaajat()==null){
            return null;
        }
        return peli;
    }
    
    /**
     *
     * @return
     */
    public ArrayList<Pelaaja> arvoRoolit(){
        if(pelaajat.size()!=roolit.size()){
            return null;
        }
        ArrayList<Pelaaja> pelinPelaajat = (ArrayList<Pelaaja>) pelaajat.clone();
        Collections.shuffle(roolit);
        for (int i = 0; i < pelinPelaajat.size(); i++) {
            pelinPelaajat.get(i).setRooli(roolit.get(i));
        }
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

//    /**
//     *
//     * @param pelaajienMaara
//     */
//    public void setPelaajienMaara(int pelaajienMaara) {
//        this.pelaajienMaara = pelaajienMaara;
//    }

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

//    /**
//     *
//     * @return
//     */
//    public int getPelaajienMaara() {
//        return pelaajienMaara;
//    }
        /**
//     *
//     */
//    public void lisaaPelaajienMaaraaYhdella(){
//        pelaajienMaara++;
//    }
    
}
