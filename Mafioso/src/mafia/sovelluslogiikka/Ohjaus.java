/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.sovelluslogiikka;

import mafia.sovelluslogiikka.sekalaista.Pelaaja;
import mafia.sovelluslogiikka.sekalaista.Aanestys;
import mafia.sovelluslogiikka.peli.Paiva;
import mafia.sovelluslogiikka.peli.Yo;
import mafia.sovelluslogiikka.peli.Vaihe;
import java.util.ArrayList;
import mafia.sovelluslogiikka.peli.Peli;
import mafia.sovelluslogiikka.peli.Saannot;
import mafia.sovelluslogiikka.roolit.Rooli;

/**
 * Ohjaus-oliota käytetään linkkinä käyttöliittymän ja sovelluslogiikan välillä.
 * Oliomuuttujista Peli kuvaa käynnissä olevaa peliä, yo ja paiva joko kaynnissä olevaa tai sitä edeltävää vaihetta, toimija vuorossa olevaa pelaajaa, kohde toiminnan kohteena olevaa pelaajaa ja aanestys viimeistä tai kaynnissä olevaa äänestystä.
 * @author Arto
 */
public class Ohjaus {
    private Peli peli;
    private Yo yo;
    private Paiva paiva;
    private Pelaaja vuorossa;
    private Pelaaja kohde;
    private Aanestys aanestys;
      
    

    /**
     * Ohjaus-olio saa parametrinaan pelin, jota ohjaus-olion avulla ohjataan. 
     * @param peli
     */
    public Ohjaus(Peli peli) {
        this.peli=peli;
//        this.paiva = new Paiva(peli.getPelaajat());
//        this.yo=new Yo(peli.getPelaajat()); 
    }
 
    /**
     * Metodi palauttaa listan pelaajista, jotka eivät ole pelanneet vuoroaan kuluneena yönä.
     * @return 
     */
    public ArrayList<Pelaaja> haePelaamatta(){
        return yo.getVuoroPelaamatta();
    }
    
    /**
     * Metodi pistaa vuorossa olevan pelaajan yöllä pelaamattomien pelaajien listasta.
     */
    public void poistaPelaajaYonVuorolistalta(){
        yo.poistaPelaamattomista(vuorossa);
    }
    
    /**
     * Metodi kutsuu vuorossa olevan pelaajan roolin toimi-metodia, joka toteuttaa roolin erikoisominaisuuden. Parametrina annetaan toiminnon kohde. Metodi palauttaa String-oliona kuvauksen toiminnosta.
     * @param kohde
     * @return
     */
    public String toimi(Pelaaja kohde){
        return vuorossa.getRooli().toimi(yo, kohde);
    }
    
    /**
     * Metodi lisää äänen vuorossa olevalta pelaajalta parametrina annetulle pelaajalle.
     * @param aanestetty
     */
    public void lisaaAani(Pelaaja aanestetty){
        aanestys.lisaaAani(vuorossa, aanestetty);
    }
    
    /**
     * Metodi palauttaa ehdokkaat, joita parametrina annettu pelaaja voi äänestää.
     * @param pelaaja
     * @return
     */
    public ArrayList<Pelaaja> haeEhdokkaat(Pelaaja pelaaja){
        return aanestys.getAanestettavat(pelaaja);
    }
    
    /**
     * Metodi palauttaa viimeisessä äänestyksessä eniten ääniä saaneet pelaajat.
     * @return
     */
    public ArrayList<Pelaaja> getAanestyksenTulokset(){
        return aanestys.haeTulokset();
    }
    
    /**
     * Metodi asettaa lynkatut pelaajat kuluvan päivän lynattavat-listaan (käytännössä yhden, mutta laajennusmahdollisuuksien takia tarvittaessa useamman).
     * @param pelaajat
     */
    public void asetaLynkatut(ArrayList<Pelaaja> pelaajat){
       paiva.setLynkattu(pelaajat);
   }
   
    /**
     * Metodi luo uuden äänestyksen ja lisää sen kuluvalle päivälle. Ehdokkaana ovat parametrina annetut pelaajat. 
     * @param ehdokkaat
     */
    public void uusiAanestys(ArrayList<Pelaaja> ehdokkaat){
       Aanestys aanestys = new Aanestys(paiva.getPelaajat(),ehdokkaat);
       paiva.lisaaAanestys(aanestys);
       this.aanestys = aanestys;
   }
    
    /**
     *Metodi palauttaa kuluvan päivän hengissä olevat pelaajat.
     * @return
     */
    public ArrayList<Pelaaja> getPaivanPelaajat(){
        return paiva.getPelaajat();
    }
    
    /**
     * Metodi palauttaa kaikki pelin pelaajat.
     * @return
     */
    public ArrayList<Pelaaja> getKaikkiPelaajat(){
        return peli.getPelaajat();
    }
    
    /**
     * Metodi palauttaa pelin säännöt oliomuuttujana.
     * @return
     */
    public Saannot getSaannot(){
        return peli.getSaannot();
    }
    
    /**
     * Metodi kutsuu käynnissä olevan pelin seuraavaanVaiheeseen-metodia, joka tekee pelin seuraavan vaiheen ja lisää sen pelin vaihelistaan.
     * @return
     */
    public Vaihe siirrySeuraavaanVaiheeseen(){
        return peli.seuraavaanVaiheseen();
    }
    /**
     * Metodi hakee pelin nykyisen vaiheen ja palauttaa sen tapahtumat (lynkatut/ammutut pelaajat) String-muuttujana.
     * @return
     */
    public String kerroTuoreetTapahtumat(){
        return peli.haeNykyinenVaihe().kerroTapahtumat();
    }
    
    /**
     * Metodi poistaa lynkattavaksi merkityt pelaajat käynnissä olevan päivän pelaajaluettelosta.
     */
    public void tapaLynkatut(){
        paiva.tapaLynkattavat();
    }
    
    /**
     * Metodi poistaa ammuttavan pelaajan käynnissä olevan yön pelaajaluettelosta.
     */
    public void tapaAmmutut(){
        yo.tapaAmmutut();
    }
    
    /**
     * Metodi kertoo jatkuuko peli vai onko toinen osapuoli voittanut.
     * @return
     */
    public boolean jatkuuko(){
        return Peli.jatkuuko(peli.haeNykyinenVaihe().getPelaajat());
    }
    
    /**
     * Metodi palauttaa elossa olevat pelaajat.
     * @return
     */
    public ArrayList<Pelaaja> elossaOlevat(){
        return peli.elossa();
    }

    /**
     * Metodi luo ja asettaa käynnissäolevaksi uuden äänestyksen, jossa mukana ovat hengissä olevat pelaajat.
     */
    public void luoEnsimmainenAanestys() {
        Aanestys aanestys = new Aanestys(paiva.getPelaajat(), paiva.getPelaajat());
        this.aanestys = aanestys;
    }

    /**
     * Palauttaa listan pelaajista, jotka eivät ole äänestäneet käynnissä olevalla äänestyskierroksella.
     * @return
     */
    public ArrayList<Pelaaja> haeAanestamatta() {
        return aanestys.getAanestamatta();
    }

    /**
     * Palauttaa listan pelaajista, jotka parametrina annettu pelaaja voi valita roolinsa mukaisen toimintonsa kohteeksi yöllä.
     * @param pelaaja
     * @return
     */
    public ArrayList<Pelaaja> getValittavanaYolla(Pelaaja pelaaja) {
        return pelaaja.getRooli().getVaihtoehdot(yo.getPelaajat(), pelaaja);
    }
    
    /**
     * Palauttaa String-oliona selityksen paramterina annetun pelaajan öisestä toiminnasta.
     * @param pelaaja
     * @return
     */
    public String getRooliSelitys(Pelaaja pelaaja){
        return pelaaja.getRooli().getRooliSelitys(yo);
    }
    
    /**
     * Palauttaa parametrina annetun pelaajan roolin.
     * @param pelaaja
     * @return
     */
    public Rooli kerroRooli(Pelaaja pelaaja){
        return pelaaja.getRooli();
    }
    

    /**
     * 
     * @return
     */
    public Aanestys getAanestys() {
        return aanestys;
    }

    /**
     *
     * @param peli
     */
    public void setPeli(Peli peli) {
        this.peli = peli;
    }

    /**
     *
     * @param yo
     */
    public void setYo(Yo yo) {
        this.yo = yo;
    }

    /**
     *
     * @param paiva
     */
    public void setPaiva(Paiva paiva) {
        this.paiva = paiva;
    }

    /**
     *
     * @param toimija
     */
    public void setToimija(Pelaaja toimija) {
        this.vuorossa = toimija;
    }

    /**
     *
     * @param kohde
     */
    public void setKohde(Pelaaja kohde) {
        this.kohde = kohde;
    }

    /**
     *
     * @return
     */
    public Peli getPeli() {
        return peli;
    }

    /**
     *
     * @return
     */
    public Yo getYo() {
        return yo;
    }

    /**
     *
     * @return
     */
    public Paiva getPaiva() {
        return paiva;
    }

    /**
     *
     * @return
     */
    public Pelaaja getToimija() {
        return vuorossa;
    }

    /**
     *
     * @return
     */
    public Pelaaja getKohde() {
        return kohde;
    }
}
