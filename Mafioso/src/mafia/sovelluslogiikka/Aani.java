
package mafia.sovelluslogiikka;


/**
 *Aani-olioon tallennetaan äänen antaja ja äänestetty. Luokalla ei ole settereiden ja gettereiden lisäksi muita metodeja.
 * @author Arto
 */
public class Aani {
    private Pelaaja aanestaja;
    private Pelaaja aanestetty;
    
    /**
     *
     * @param aanestaja
     * @param aanestetty
     */
    public Aani(Pelaaja aanestaja, Pelaaja aanestetty){
        this.aanestaja = aanestaja;
        this.aanestetty = aanestetty;
    }

    /**
     *
     * @param aanestaja
     */
    public void setAanestaja(Pelaaja aanestaja) {
        this.aanestaja = aanestaja;
    }

    /**
     *
     * @param aanestetty
     */
    public void setAanestetty(Pelaaja aanestetty) {
        this.aanestetty = aanestetty;
    }
    
    /**
     *
     * @return
     */
    public Pelaaja getAanestaja(){
        return this.aanestaja;
    }
    
    /**
     *
     * @return
     */
    public Pelaaja getAanestetty(){
        return this.aanestetty;
    }
    
    @Override
    public String toString(){
        return aanestaja + ": " + aanestetty;
    }
}
