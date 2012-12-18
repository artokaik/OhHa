package mafia.sovelluslogiikka;

import java.util.*;

public class Peli {
    private ArrayList<Pelaaja> pelaajat;
    private Vaihe ekaVaihe;
    private Saannot saannot;

    public Peli() {
        this.pelaajat = new ArrayList<Pelaaja>();
        this.saannot = new Saannot();
    }

    public ArrayList<Pelaaja> getPelaajat() {
        return this.pelaajat;
    }
    
    public Saannot getSaannot(){
        return saannot;
    }

    public void lisaaPelaaja(Pelaaja pelaaja) {
        if (!pelaajat.contains(pelaaja)) {
            this.pelaajat.add(pelaaja);
        }
    }
    
    public void poistaPelaaja(Pelaaja pelaaja){
        pelaajat.remove(pelaaja);
    }
    
    public void pelaa(){
        if(saannot.getPaivaEnsin()){
            Paiva paiva = new Paiva(pelaajat);
            ekaVaihe = paiva;
            paiva.pelaa();
        } else {
            Yo yo = new Yo(pelaajat);
            ekaVaihe = yo;
            yo.pelaa();
        }
    }
}
