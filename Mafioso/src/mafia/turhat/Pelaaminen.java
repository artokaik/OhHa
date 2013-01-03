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
//import mafia.turhat.PaivanPelaaminen;
//import mafia.sovelluslogiikka.*;
//import java.util.*;
//
//public class Pelaaminen {
//
//    Peli peli;
//
//    public Pelaaminen(Peli peli) {
//        this.peli = peli;
//    }
//
//    public void pelaa() {
//        ArrayList<Pelaaja> pelaajat = peli.getPelaajat();
//        while (true) {
//            Vaihe vaihe = peli.pelaaSeuraavaVaihe(pelaajat);
//            VaiheenPelaaminen pelaaminen = this.seuraavanVaiheenPelaaminen(vaihe);
//            pelaaminen.pelaa();
//            pelaajat = vaihe.getPelaajat();
//        }
//    }
//    
//    public VaiheenPelaaminen seuraavanVaiheenPelaaminen(Vaihe vaihe){
//        Paiva testi = new Paiva(peli.getPelaajat());
//        if (vaihe.getClass().equals(testi.getClass())){
//            Paiva paiva = (Paiva) vaihe;
//            PaivanPelaaminen paivanPelaaminen = new PaivanPelaaminen(paiva);
//            return paivanPelaaminen;
//        } else {
//            Yo yo = (Yo) vaihe;
//            YonPelaaminen yonPelaaminen = new YonPelaaminen(yo);
//            return yonPelaaminen;
//        }
//        
//    }
//}

