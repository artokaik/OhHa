
package mafia.sovelluslogiikka;

import mafia.sovelluslogiikka.roolit.Rooli;


/**
 *Pelaajalla on muuttujina nimi (String) ja rooli. Yhdessä pelissä ei voi olla kahta samannimistä pelaajaa, sillä pelaajat erotetaan toisistaan nimen avulla. Siksi equals-metodi on toteutettu siten, että kaksi pelaajaa tunnistetaan samoiksi mikäli näiden nimet ovat samoja. 
 * @author Arto
 */
public class Pelaaja {
    private String nimi;
    private Rooli rooli;
    private boolean elossa;
    
    /**
     *
     * @param nimi
     */
    public Pelaaja(String nimi){
        this.nimi = nimi;
        this.elossa = true;
    }
    
    /**
     *
     * @return
     */
    public String getNimi(){
        return this.nimi;
    }
    
    /**
     *
     */
    public void kuole(){
        this.elossa = false;
    }
    
    /**
     *
     * @return
     */
    public boolean getElossa(){
        return elossa;
    }
    
    /**
     *
     * @return
     */
    public Rooli getRooli(){
        return this.rooli;
    }
    
    /**
     *
     * @param rooli
     */
    public void setRooli(Rooli rooli){
        this.rooli=rooli;
    }
    
    /**
     *
     * @param yo
     */
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
