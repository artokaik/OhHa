/*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//package mafia.kayttoliittyma;
//
//import java.awt.Container;
//import java.awt.Dimension;
//import java.awt.GridLayout;
//import java.util.ArrayList;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import javax.swing.WindowConstants;
//import mafia.kayttoliittyma.Paiva.ToimintoSuljePelaajanValitsin;
//import mafia.kayttoliittyma.Paiva.ToimintoValitseAanestettava;
//import mafia.sovelluslogiikka.Aanestys;
//import mafia.sovelluslogiikka.Pelaaja;
//
///**
// *
// * @author Arto
// */
//public class PelaajanValitsijaPanelCopy extends JPanel{
//
//    private ArrayList<Pelaaja> valittavana;
//    private KayttisKuuntelija kuuntelija;
//    private JButton valitseNappi;
//
//    public PelaajanValitsijaPanelCopy(ArrayList<Pelaaja> pelaajat, JButton valitseNappi, KayttisKuuntelija kuuntelija) {
//        valittavana = pelaajat;
//        this.valitseNappi = valitseNappi;
//        this.kuuntelija = kuuntelija; 
//        luo();
//    }
//
//    public void luo() {
//        
//        this.setLayout(new GridLayout(valittavana.size() + 2, 1));
//        this.setPreferredSize(new Dimension(500,400));
//        JLabel valittu = new JLabel();
//        for (Pelaaja pelaaja : valittavana) {
//            JButton pelaajaNappi = new JButton(pelaaja.getNimi());
//            ToimintoValitsePelaaja toiminto = new ToimintoValitsePelaaja(pelaaja, valittu, kuuntelija, valitseNappi);
//            pelaajaNappi.addActionListener(toiminto);
//            this.add(pelaajaNappi);
//        }
//        JLabel teksti = new JLabel("Valittu:");
//        this.add(teksti);
//        this.add(valittu);
//    }
//
//    
//
//    public void setValittavana(ArrayList<Pelaaja> valittavana) {
//        this.valittavana = valittavana;
//    }
//
//    public void setKuuntelija(KayttisKuuntelija kuuntelija) {
//        this.kuuntelija = kuuntelija;
//    }
//
//    public void setValitseNappi(JButton valitseNappi) {
//        this.valitseNappi = valitseNappi;
//    }
//    
//    
//}
