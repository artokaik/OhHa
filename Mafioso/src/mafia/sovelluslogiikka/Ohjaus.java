/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.sovelluslogiikka;

import java.util.ArrayList;
import mafia.sovelluslogiikka.peli.Peli;
import mafia.sovelluslogiikka.peli.Saannot;

/**
 *
 * @author Arto
 */
public class Ohjaus {
    private Peli peli;
    private Yo yo;
    private Paiva paiva;
    private Pelaaja toimija;
    private Pelaaja kohde;
    private Aanestys aanestys;
      
    

    public Ohjaus(Peli peli) {
        this.peli=peli;
        this.paiva = new Paiva(peli.getPelaajat());
        this.yo=new Yo(peli.getPelaajat());
        
    }
    
    public void lisaaAani(Pelaaja pelaaja){
        aanestys.lisaaAani(toimija, pelaaja);
    }
    
    public ArrayList<Pelaaja> haeEhdokkaat(Pelaaja pelaaja){
        return aanestys.getAanestettavat(pelaaja);
    }
    
    public ArrayList<Pelaaja> getAanestyksenTulokset(){
        return aanestys.haeTulokset();
    }
    
   public void asetaLynkatut(ArrayList<Pelaaja> pelaajat){
       paiva.setLynkattu(pelaajat);
   }
   
   public void uusiAanestys(ArrayList<Pelaaja> ehdokkaat){
       Aanestys aanestys = new Aanestys(paiva.getPelaajat(),ehdokkaat);
       paiva.lisaaAanestys(aanestys);
       this.aanestys = aanestys;
   }
    
    public ArrayList<Pelaaja> getPaivanPelaajat(){
        return paiva.getPelaajat();
    }
    
    public ArrayList<Pelaaja> getKaikkiPelaajat(){
        return peli.getPelaajat();
    }
    
    public Saannot getSaannot(){
        return peli.getSaannot();
    }
    
    public Vaihe siirrySeuraavaanVaiheeseen(){
        return peli.seuraavaanVaiheseen();
    }
    public String kerroTuoreetTapahtumat(){
        return peli.haeNykyinenVaihe().kerroTapahtumat();
    }
    
    public void tapaLynkatut(){
        paiva.tapaLynkattavat();
    }
    
    public boolean jatkuuko(){
        return Peli.jatkuuko(peli.haeNykyinenVaihe().getPelaajat());
    }
    
    public ArrayList<Pelaaja> elossaOlevat(){
        return peli.elossa();
    }
   
//    public static void tapaLynkatut(Paiva paiva) {
//        paiva.tapaLynkattavat();
//    }
//
//    public static void tapaAmmutut(Yo yo) {
//        yo.tapaAmmutut();
//    }
//
//    public static boolean jatkuuko(Vaihe vaihe) {
//        return Peli.jatkuuko(vaihe.getPelaajat());
//    }
//
//    public static ArrayList<Pelaaja> haePelaajat(Vaihe vaihe) {
//        return vaihe.getPelaajat();
//    }
//
//    public static Vaihe luoSeuraavaVaihe(Vaihe vaihe) {
//        return vaihe.luoSeuraavaVaihe();
//    }
//
    public void luoEnsimmainenAanestys() {
        Aanestys aanestys = new Aanestys(paiva.getPelaajat(), paiva.getPelaajat());
        this.aanestys = aanestys;
    }
//
//    public static String toimi(Pelaaja toimija, Pelaaja valittu, Yo tapahtumaAika) {
//        return toimija.getRooli().toimi(tapahtumaAika, valittu);
//    }
//
//    public static ArrayList<Pelaaja> haeEhdokkaat(Aanestys aanestys, Pelaaja pelaaja) {
//        return aanestys.getAanestettavat(pelaaja);
//    }
//
    public ArrayList<Pelaaja> haeAanestamatta() {
        return aanestys.getAanestamatta();
    }
//
//    public static void lisaaAani(Aanestys aanestys, Pelaaja aanestaja, Pelaaja aanestettava) {
//        aanestys.lisaaAani(aanestaja, aanestettava);
//    }
//
//    public static ArrayList<Pelaaja> getValittavanaYolla(Pelaaja pelaaja, Yo yo) {
//        return pelaaja.getRooli().getVaihtoehdot(yo.getPelaajat(), pelaaja);
//    }
//    
//    public static String getRooliSelitys(Pelaaja pelaaja, Yo yo){
//        return pelaaja.getRooli().getRooliSelitys(yo);
//    }
//    
//    public static boolean poistaPelaajaVuorolistalta(Yo yo, Pelaaja vuorossa){
//        return yo.poistaPelaamattomista(vuorossa);
//    }
//    
//    public static ArrayList<Pelaaja> haePelaamatta(Yo yo){
//        return yo.getVuoroPelaamatta();
//    }
//    
//    

    public Aanestys getAanestys() {
        return aanestys;
    }

    public void setPeli(Peli peli) {
        this.peli = peli;
    }

    public void setYo(Yo yo) {
        this.yo = yo;
    }

    public void setPaiva(Paiva paiva) {
        this.paiva = paiva;
    }

    public void setToimija(Pelaaja toimija) {
        this.toimija = toimija;
    }

    public void setKohde(Pelaaja kohde) {
        this.kohde = kohde;
    }

    public Peli getPeli() {
        return peli;
    }

    public Yo getYo() {
        return yo;
    }

    public Paiva getPaiva() {
        return paiva;
    }

    public Pelaaja getToimija() {
        return toimija;
    }

    public Pelaaja getKohde() {
        return kohde;
    }
}
