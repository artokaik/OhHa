
package mafia.sovelluslogiikka;

import mafia.sovelluslogiikka.peli.Saannot;
import java.util.ArrayList;
import mafia.kayttoliittyma.Ohjaus;

public class Yo implements Vaihe {

    private ArrayList<Pelaaja> pelaajat;
    private ArrayList<Pelaaja> vuoroPelaamatta;
    private Pelaaja ammuttu;
    private Pelaaja suojeltu;

    public Yo(ArrayList<Pelaaja> pelaajat) {
        this.pelaajat = pelaajat;
        this.vuoroPelaamatta = (ArrayList<Pelaaja>) pelaajat.clone();
    }


    public boolean asetaTapettava(Pelaaja pelaaja) {
        if (pelaajat.contains(pelaaja)) {
            ammuttu = pelaaja;
            return true;
        }
        return false;
    }

    public boolean asetaSuojeltu(Pelaaja pelaaja) {
        if (pelaajat.contains(pelaaja)) {
            suojeltu = pelaaja;
            return true;
        }
        return false;
    }

    public ArrayList<Pelaaja> pelaa(Saannot saannot) {
        Ohjaus ohjaus = new Ohjaus();
        while(!vuoroPelaamatta.isEmpty()){
            Pelaaja pelaaja = ohjaus.valitsePelaaja(vuoroPelaamatta);
            pelaaja.toimiRoolinMukaan(this);
            vuoroPelaamatta.remove(pelaaja);
        }
        this.tapaAmmutut();
        ArrayList<Pelaaja> hengissa = (ArrayList<Pelaaja>) pelaajat.clone();
        return pelaajat;
    }

    public void tapaAmmutut() {
        if (suojeltu == null || !suojeltu.equals(ammuttu)) {
            pelaajat.remove(ammuttu);
        }
    }
    
    public Paiva luoSeuraavaVaihe(){
        Paiva paiva = new Paiva(pelaajat);
        return paiva;
    }
    
    public String kerroTapahtumat(){
        String tuloste = "";
        if (this.ammuttu.equals(this.suojeltu)){
            tuloste = "Kukaan ei kuollut!";
        } else {
            tuloste = ammuttu + " kuoli!";
        }
        tuloste += "\n Seuraavaksi vuorossa päivä ja äänestys:";
        return tuloste;
        
    }
    
    //getterit ja setterit;

    public void setPelaajat(ArrayList<Pelaaja> pelaajat) {
        this.pelaajat = pelaajat;
    }

    public void setVuoroPelaamatta(ArrayList<Pelaaja> vuoroPelaamatta) {
        this.vuoroPelaamatta = vuoroPelaamatta;
    }
    
       public ArrayList<Pelaaja> getVuoroPelaamatta() {
        return vuoroPelaamatta;
    }

    public Pelaaja getSuojeltu() {
        return suojeltu;
    }

    public ArrayList<Pelaaja> getPelaajat() {
        return pelaajat;
    }
    
    public Pelaaja getAmmuttu(){
        return ammuttu;
    }

     
//    public Pelaaja haePelaaja(String nimi) {
//        for (Pelaaja pelaaja : pelaajat) {
//            if (pelaaja.getNimi().equals(nimi)) {
//                return pelaaja;
//            }
//        }
//        return null;
//    }

    
}
