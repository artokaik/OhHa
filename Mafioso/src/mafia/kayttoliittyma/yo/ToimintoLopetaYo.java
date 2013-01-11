///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//package mafia.kayttoliittyma.yo;
//
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import mafia.kayttoliittyma.Kayttis;
//import mafia.sovelluslogiikka.Ohjaus;
//import mafia.sovelluslogiikka.Paiva;
//import mafia.sovelluslogiikka.Yo;
//
///**
// *
// * @author Arto
// */
//public class ToimintoLopetaYo implements ActionListener{
//    private Ohjaus ohjaus;
//    private Kayttis kayttis;
//    
//    public ToimintoLopetaYo(Ohjaus ohjaus,  Kayttis kayttis){
//        this.kayttis = kayttis;
//        this.ohjaus = ohjaus;
//    }
//    
//    @Override
//    public void actionPerformed(ActionEvent ae) {
//        ohjaus.tapaAmmutut();
//        YonTapahtumatPanel tapahtumat = new YonTapahtumatPanel(ohjaus, kayttis);
//        kayttis.korvaaKeskusta(tapahtumat);
//        
//    }
//    
//}
