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

//    public Vaihe pelaaSeuraavaVaihe(ArrayList<Pelaaja> pelaajat) {
//        Vaihe vaihe = this.seuraavaVaihe(pelaajat);
//        kaynnissaOlevaVaihe = vaihe;
//        vaiheet.add(vaihe);
//        return vaihe;
//    }
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

//    public Vaihe seuraavaVaihe(ArrayList<Pelaaja> hengissa) {
//        if (this.jatkuuko(hengissa)) {
//            return null;
//        }
//        Vaihe vaihe = new Yo(hengissa);
//        if (vaiheet.isEmpty()) {
//            if (saannot.getPaivaEnsin()) {
//                vaihe = new Paiva(hengissa);
//            }
//        } else if (vaiheet.get(vaiheet.size() - 1).getClass().equals(vaihe)) {
//            vaihe = new Paiva(hengissa);
//        }
//        return vaihe;
//    }
    public void pelaa() {
        boolean seuraavaksiPaiva = saannot.getPaivaEnsin();
        boolean jatkuu = true;
        ArrayList<Pelaaja> hengissa = (ArrayList<Pelaaja>) pelaajat.clone();
        while (jatkuu) {
            Vaihe vaihe = new Yo(hengissa);
            if (seuraavaksiPaiva) {
                vaihe = new Paiva(hengissa);
                seuraavaksiPaiva = false;
            } else {
                seuraavaksiPaiva = true;
            }
            kaynnissaOlevaVaihe = vaihe;
            hengissa = (ArrayList<Pelaaja>) vaihe.pelaa(saannot).clone();
            jatkuu = jatkuuko(hengissa);
            vaiheet.add(vaihe);
            Ohjaus ohjaus = new Ohjaus();
            ohjaus.tulostaTapahtumat(vaihe);
        }
        this.julistaVoittaja(hengissa);

    }

    public boolean jatkuuko(ArrayList<Pelaaja> hengissa) {
        int hyvikset = 0;
        int pahikset = 0;
        for (Pelaaja pelaaja : hengissa) {
            if (pelaaja.getRooli().onkoPahis()) {
                pahikset++;
            } else {
                hyvikset++;
            }
        }
        if (hyvikset > pahikset) {
            if (pahikset > 0) {
                return true;
            }
        }
        return false;
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
