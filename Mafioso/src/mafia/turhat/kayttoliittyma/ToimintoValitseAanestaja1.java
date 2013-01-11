///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//package mafia.kayttoliittyma.Paiva;
//
//import mafia.kayttoliittyma.KayttisKuuntelija;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import javax.swing.JButton;
//import mafia.sovelluslogiikka.Aanestys;
//import mafia.sovelluslogiikka.Pelaaja;
//
///**
// *
// * @author Arto
// */
//public class ToimintoValitseAanestaja1 implements ActionListener{
//    private Pelaaja pelaaja;
//    private Aanestys aanestys;
//    private JButton nappi; 
//    
//    public ToimintoValitseAanestaja1(Aanestys aanestys, Pelaaja pelaaja, JButton nappi){
//        this.aanestys = aanestys;
//        this.pelaaja = pelaaja;
//        this.nappi = nappi;
//    }
//    
//    @Override
//    public void actionPerformed(ActionEvent ae) {
//        KayttisKuuntelija kuuntelija = new KayttisKuuntelija();
//        KayttisAanestaja aanestaminen = new KayttisAanestaja(aanestys,pelaaja,kuuntelija);
//        aanestaminen.run();
//        nappi.setEnabled(false);        
//        
//    }
//        
//        
//    }