package mafia.sovelluslogiikka;

import java.util.*;

public class Peli {
    ArrayList<Pelaaja> pelaajat;

    public Peli() {
        this.pelaajat = new ArrayList<Pelaaja>();
    }

    public ArrayList<Pelaaja> getPelaajat() {
        return this.pelaajat;
    }

    public void lisaaPelaaja(Pelaaja pelaaja) {
        if (!pelaajat.contains(pelaaja)) {
            this.pelaajat.add(pelaaja);
        }
    }
}
