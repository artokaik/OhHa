package mafia.sovelluslogiikka;

import java.util.*;

public class Peli {

    private ArrayList<Pelaaja> pelaajat;
    private ArrayList<Vaihe> vaiheet;
    private Saannot saannot;

    public Peli() {
        this.pelaajat = new ArrayList<Pelaaja>();
        this.vaiheet = new ArrayList<Vaihe>();
        this.saannot = new Saannot();
    }

    public ArrayList<Pelaaja> getPelaajat() {
        return this.pelaajat;
    }

    public Saannot getSaannot() {
        return saannot;
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
        boolean seuraavaksiPaiva = saannot.getPaivaEnsin();
        boolean jatkuu = true;
        ArrayList<Pelaaja> hengissa = kopioi(pelaajat);

        while (jatkuu) {
            Vaihe vaihe = new Yo(hengissa);
            if (seuraavaksiPaiva) {
                vaihe = new Paiva(hengissa);
            } 
            hengissa = kopioi(vaihe.pelaa());
            jatkuu = jatkuuko(hengissa);
            vaiheet.add(vaihe);
        }
    }

private boolean jatkuuko(ArrayList<Pelaaja> hengissa) {
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
            return true;
        }
        return false;
    }
    

    private ArrayList kopioi(ArrayList kopioitava) {
        ArrayList kopio = new ArrayList();
        for (Object object : kopioitava) {
            kopio.add(object);
        }
        return kopio;
    }
    
    @Override
    public String toString(){
        String tuloste = "";
        tuloste += "Pelaajia: " + pelaajat.size() + "\n";
        tuloste += "Pelaajat: " + pelaajat + "\n";
        tuloste += saannot;
        return tuloste;
    }
}
