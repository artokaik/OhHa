
package mafia.sovelluslogiikka.sekalaista;

import mafia.sovelluslogiikka.peli.Yo;
import mafia.sovelluslogiikka.roolit.Rooli;


/**
 *Pelaajalla on muuttujina nimi (String) ja rooli. Yhdessä pelissä ei voi olla kahta samannimistä pelaajaa, sillä pelaajat erotetaan toisistaan nimen avulla. Siksi equals-metodi on toteutettu siten, että kaksi pelaajaa tunnistetaan samoiksi mikäli näiden nimet ovat samoja. 
 * @author Arto
 */
public class Pelaaja implements Comparable{
    private String nimi;
    private Rooli rooli;

    
    /**
     *
     * @param nimi
     */
    public Pelaaja(String nimi){
        this.nimi = nimi;
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
    
    @Override
    public int compareTo(Object object){
        Pelaaja verrattava = (Pelaaja) object;
        return this.nimi.compareTo(verrattava.getNimi());
    }
}
