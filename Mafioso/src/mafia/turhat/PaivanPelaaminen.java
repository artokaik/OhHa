///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//package mafia.turhat;
//
///**
// *
// * @author Arto
// */
//import mafia.sovelluslogiikka.*;
//import java.util.*;
//
//public class PaivanPelaaminen implements VaiheenPelaaminen {
//
//    private Paiva paiva;
//    private Scanner lukija;
//
//    public PaivanPelaaminen(Paiva paiva) {
//        this.paiva = paiva;
//        lukija = new Scanner(System.in);
//    }
//
//    public YonPelaaminen pelaa() {
//        this.aanestys(paiva.getPelaajat());
//        
//        
//        ArrayList<Pelaaja> pelaajat = paiva.getPelaajat();
//        Yo yo = new Yo(pelaajat);
//        YonPelaaminen yonPelaaminen = new YonPelaaminen(yo);
//        return yonPelaaminen;
//
//    }
//
//    public void aanestys(ArrayList<Pelaaja> ehdokkaat) {
//        System.out.println("Äänestys alkaa:");
//        Aanestys aanestys = new Aanestys(ehdokkaat);
//        for (Pelaaja pelaaja : paiva.getPelaajat()) {
//            this.annaAani(pelaaja, aanestys);
//        }
//    }
//
//    public void annaAani(Pelaaja aanestaja, Aanestys aanestys) {
//        while (true) {
//            System.out.println("Äänestyksessä ehdokkaana ovat: " + aanestys.getEhdokkaat());
//            System.out.println(aanestaja.getNimi() + ", valitse pelaaja jota äänestät");
//            String nimi = lukija.nextLine();
//            Pelaaja aanestetty = aanestys.haeEhdokas(nimi);
//            if (aanestetty == null) {
//                System.out.println("Virheellinen nimi, yritä uudestaan");
//            } else {
//                aanestys.lisaaAani(aanestaja, aanestetty);
//                break;
//            }
//        }
//    }
//}
