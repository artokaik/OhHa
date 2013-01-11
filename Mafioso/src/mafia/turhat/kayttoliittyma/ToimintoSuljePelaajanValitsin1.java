///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//package mafia.turhat.kayttoliittyma;
//
//import mafia.kayttoliittyma.KayttisKuuntelija;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.WindowListener;
//import javax.swing.JFrame;
//import mafia.sovelluslogiikka.Aanestys;
//import mafia.sovelluslogiikka.Pelaaja;
//
///**
// *
// * @author Arto
// */
//public class ToimintoSuljePelaajanValitsin1 implements ActionListener {
//
//    private JFrame frame;
//    private KayttisKuuntelija kuuntelija;
//    private Pelaaja aanestaja;
//    private Aanestys aanestys;
//
//    public ToimintoSuljePelaajanValitsin1(Aanestys aanestys, JFrame frame, Pelaaja aanestaja, KayttisKuuntelija kuuntelija) {
//        this.aanestys = aanestys;
//        this.frame = frame;
//        this.kuuntelija = kuuntelija;
//        this.aanestaja = aanestaja;
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent ae) {
//        if (kuuntelija.getPelaaja() != null) {
//            aanestys.lisaaAani(aanestaja, kuuntelija.getPelaaja());
//            frame.dispose();
//        }
//
//
//    }
//}
