package mafia.sovelluslogiikka;

import java.util.*;

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
    
    public Vaihe pelaaSeuraavaVaihe(ArrayList<Pelaaja> pelaajat){
        Vaihe vaihe = this.seuraavaVaihe(pelaajat);
        kaynnissaOlevaVaihe = vaihe;
        vaiheet.add(vaihe);
        return vaihe;
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


    public Vaihe seuraavaVaihe(ArrayList<Pelaaja> hengissa) {
        if(this.jatkuuko(hengissa)){
            return null;
        }
        Vaihe vaihe = new Yo(hengissa);
        if (vaiheet.isEmpty()) {
            if (saannot.getPaivaEnsin()) {
                vaihe = new Paiva(hengissa);
            }
        } else if (vaiheet.get(vaiheet.size() - 1).getClass().equals(vaihe)) {
            vaihe = new Paiva(hengissa);
        }
        return vaihe;
    }

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
        }
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

//    private ArrayList kopioi(ArrayList kopioitava) {
//        ArrayList kopio = new ArrayList();
//        for (Object object : kopioitava) {
//            kopio.add(object);
//        }
//        return kopio;
//    }
    @Override
    public String toString() {
        String tuloste = "";
        tuloste += "Pelaajia: " + pelaajat.size() + "\n";
        tuloste += "Pelaajat: " + pelaajat + "\n";
        tuloste += saannot;
        return tuloste;
    }
}
