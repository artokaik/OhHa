package mafia.sovelluslogiikka.peli;

import java.util.ArrayList;
import mafia.kayttoliittyma.Ohjaus;
import mafia.sovelluslogiikka.Paiva;
import mafia.sovelluslogiikka.Pelaaja;
import mafia.sovelluslogiikka.Vaihe;
import mafia.sovelluslogiikka.Yo;

public class Peli {

    private ArrayList<Pelaaja> pelaajat;
    private ArrayList<Vaihe> vaiheet;
    private Vaihe kaynnissaOlevaVaihe;
    private Saannot saannot;

    public Peli() {
        this.pelaajat = new ArrayList<Pelaaja>();
        this.vaiheet = new ArrayList<Vaihe>();
        this.saannot = new Saannot();
        this.kaynnissaOlevaVaihe = null;
    }


    public boolean lisaaPelaaja(Pelaaja pelaaja) {
        if (!pelaajat.contains(pelaaja)) {
            this.pelaajat.add(pelaaja);
            return true;
        }
        return false;
    }

    public boolean poistaPelaaja(Pelaaja pelaaja) {
        return pelaajat.remove(pelaaja);
    }

    public void pelaa() {
        Vaihe seuraavaVaihe = new Yo((ArrayList<Pelaaja>) pelaajat.clone());
        if (saannot.getPaivaEnsin()) {
            seuraavaVaihe = new Paiva((ArrayList<Pelaaja>) pelaajat.clone());
        }
        while (jatkuuko(seuraavaVaihe.getPelaajat())) {
            seuraavaVaihe = pelaaYksiVaihe(seuraavaVaihe);
        }
        this.julistaVoittaja(seuraavaVaihe.getPelaajat());
    }

    public Vaihe pelaaYksiVaihe(Vaihe vaihe) {
        kaynnissaOlevaVaihe = vaihe;
        vaihe.pelaa(saannot);
        vaiheet.add(vaihe);
        Ohjaus ohjaus = new Ohjaus();
        ohjaus.tulostaTapahtumat(vaihe);
        return vaihe.luoSeuraavaVaihe();
    }

    public boolean jatkuuko(ArrayList<Pelaaja> hengissa) {
        if(laskePahikset(hengissa)==0){
            return false;
        } else if (laskePahikset(hengissa)>=laskeHyvikset(hengissa)){
            return false;
        }
        return true;
    }
    
    public int laskeHyvikset(ArrayList<Pelaaja> hengissa){
        int hyvistenMaara = 0;
        for (Pelaaja pelaaja : hengissa) {
            if (!pelaaja.getRooli().onkoPahis()) {
                hyvistenMaara++;
            }
        }
        return hyvistenMaara;
    }
        public int laskePahikset(ArrayList<Pelaaja> hengissa){
        int pahistenMaara = 0;
        for (Pelaaja pelaaja : hengissa) {
            if (pelaaja.getRooli().onkoPahis()) {
                pahistenMaara++;
            }
        }
        return pahistenMaara;
    }
    

    public void julistaVoittaja(ArrayList<Pelaaja> hengissa) {
        Ohjaus ohjaus = new Ohjaus();
        for (Pelaaja pelaaja : hengissa) {
            if (pelaaja.getRooli().onkoPahis()) {
                ohjaus.julistaVoittaja("Pahikset");
                return;
            }
        }
        ohjaus.julistaVoittaja("Hyvikset");
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
    public ArrayList<Vaihe> getVaiheet() {
        return vaiheet;
    }

    public ArrayList<Pelaaja> getPelaajat() {
        return this.pelaajat;
    }

    public Saannot getSaannot() {
        return saannot;
    }

    public Vaihe getKaynnissaOlevaVaihe() {
        return this.kaynnissaOlevaVaihe;
    }

    public void setPelaajat(ArrayList<Pelaaja> pelaajat) {
        this.pelaajat = pelaajat;
    }

    public void setVaiheet(ArrayList<Vaihe> vaiheet) {
        this.vaiheet = vaiheet;
    }

    public void setKaynnissaOlevaVaihe(Vaihe kaynnissaOlevaVaihe) {
        this.kaynnissaOlevaVaihe = kaynnissaOlevaVaihe;
    }

    public void setSaannot(Saannot saannot) {
        this.saannot = saannot;
    }
}
