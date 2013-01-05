
package mafia.sovelluslogiikka;


public class Aani {
    private Pelaaja aanestaja;
    private Pelaaja aanestetty;
    
    public Aani(Pelaaja aanestaja, Pelaaja aanestetty){
        this.aanestaja = aanestaja;
        this.aanestetty = aanestetty;
    }

    public void setAanestaja(Pelaaja aanestaja) {
        this.aanestaja = aanestaja;
    }

    public void setAanestetty(Pelaaja aanestetty) {
        this.aanestetty = aanestetty;
    }
    
    public Pelaaja getAanestaja(){
        return this.aanestaja;
    }
    
    public Pelaaja getAanestetty(){
        return this.aanestetty;
    }
    
    @Override
    public String toString(){
        return aanestaja + ": " + aanestetty;
    }
}
