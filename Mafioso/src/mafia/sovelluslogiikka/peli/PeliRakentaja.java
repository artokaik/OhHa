
package mafia.sovelluslogiikka.peli;

import java.util.ArrayList;
import java.util.Collections;
import mafia.sovelluslogiikka.Pelaaja;
import mafia.sovelluslogiikka.roolit.Rooli;


public class PeliRakentaja {
    private Saannot saannot;
    private ArrayList<Pelaaja> pelaajat;
    private ArrayList<Rooli> roolit;
    private int pelaajienMaara;
    
    public PeliRakentaja(int pelaajia){
        saannot = new Saannot();
        pelaajat = new ArrayList<Pelaaja>();
        roolit = new ArrayList<Rooli>();
        pelaajienMaara = pelaajia;
    }
    
    public PeliRakentaja(){
        this(0);
    }
    
    public void lisaaPelaajienMaaraaYhdella(){
        pelaajienMaara++;
    }

    public boolean lisaaRooli(Rooli rooli){
        roolit.add(rooli);
        return true;
    }
    
    public boolean lisaaPelaaja(Pelaaja pelaaja){
        if(this.pelaajat.contains(pelaaja)){
            return false;
        }
        this.pelaajat.add(pelaaja);
        return true;
    }
    
    public Peli teePeli(){
        Peli peli = new Peli();
        peli.setPelaajat(arvoRoolit());
        peli.setSaannot(saannot);
        if(peli.getPelaajat()==null){
            return null;
        }
        return peli;
    }
    
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
    
    public void setSaannot(Saannot saannot) {
        this.saannot = saannot;
    }

    public void setPelaajat(ArrayList<Pelaaja> pelaajat) {
        this.pelaajat = pelaajat;
    }

    public void setRoolit(ArrayList<Rooli> roolit) {
        this.roolit = roolit;
    }

    public void setPelaajienMaara(int pelaajienMaara) {
        this.pelaajienMaara = pelaajienMaara;
    }

    public Saannot getSaannot() {
        return saannot;
    }

    public ArrayList<Pelaaja> getPelaajat() {
        return pelaajat;
    }

    public ArrayList<Rooli> getRoolit() {
        return roolit;
    }

    public int getPelaajienMaara() {
        return pelaajienMaara;
    }
    
    
}
