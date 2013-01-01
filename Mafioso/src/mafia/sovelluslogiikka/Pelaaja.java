
package mafia.sovelluslogiikka;


public class Pelaaja {
    private String nimi;
    private Rooli rooli;
    private boolean elossa;
    
    public Pelaaja(String nimi){
        this.nimi = nimi;
        this.elossa = true;
    }
    
    public String getNimi(){
        return this.nimi;
    }
    
    public void kuole(){
        this.elossa = false;
    }
    
    public boolean getElossa(){
        return elossa;
    }
    
    public Rooli getRooli(){
        return this.rooli;
    }
    
    public void setRooli(Rooli rooli){
        this.rooli=rooli;
    }
    
    public void toimiRoolinMukaan(Yo yo){
        this.rooli.toimi(yo);
    }
    
    @Override
    public String toString(){
        return this.nimi;
    }
    
    @Override
    public boolean equals(Object olio){
        if(olio==null){
            return false;
        }
        if(!this.getClass().equals(olio.getClass())){
            return false;
        }
        Pelaaja verrattava = (Pelaaja) olio;
        if(this.getNimi().equals(verrattava.getNimi())){
            return true;
        }
        return false;
    }
}
