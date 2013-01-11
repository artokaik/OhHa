///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//package mafia.kayttoliittyma.Paiva;
//
//import mafia.kayttoliittyma.KayttisKuuntelija;
//import java.awt.Container;
//import java.awt.Dimension;
//import javax.swing.BoxLayout;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.WindowConstants;
//import mafia.kayttoliittyma.PelaajanValitsijaPanel;
//import mafia.sovelluslogiikka.Aanestys;
//import mafia.sovelluslogiikka.Pelaaja;
//
///**
// *
// * @author Arto
// */
//public class KayttisAanestajaCopy implements Runnable {
//
//    private JFrame frame;
//    private Aanestys aanestys;
//    private Pelaaja aanestaja;
//    private KayttisKuuntelija kuuntelija;
//
//    public KayttisAanestajaCopy(Aanestys aanestys, Pelaaja aanestaja, KayttisKuuntelija kuuntelija) {
//        this.aanestys = aanestys;
//        this.aanestaja = aanestaja;
//        this.kuuntelija = kuuntelija;
//        
//    }
//
//    @Override
//    public void run() {
//        frame = new JFrame("Pelaajan valitsija");
//        frame.setPreferredSize(new Dimension(300, 600));
//
//        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//
//        luoKomponentit(frame.getContentPane());
//
//        frame.pack();
//        frame.setVisible(true);
//
//
//
//    }
//
//    public void luoKomponentit(Container container) {
//        BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
//        container.setLayout(layout);
//        
//        JButton suljeNappi = new JButton("Sulje");
//        ToimintoSuljePelaajanValitsin sulje = new ToimintoSuljePelaajanValitsin(aanestys, this.frame, aanestaja, kuuntelija);
//        suljeNappi.addActionListener(sulje);
//        suljeNappi.setEnabled(false);
//        
//        PelaajanValitsijaPanel valitsija = new PelaajanValitsijaPanel(aanestys.getAanestettavat(aanestaja), suljeNappi, kuuntelija);
//        
//        
//        container.add(valitsija);
////        container.add(suljeNappi);
//    }
////    public void luoKomponentit(Container container) {
////        ArrayList<Pelaaja> ehdokkaat = aanestys.getAanestettavat(aanestaja);
////        container.setLayout(new GridLayout(ehdokkaat.size() + 4, 1));
////        JLabel otsikko = new JLabel(aanestaja.getNimi() + ", ketä äänestät:");
////        container.add(otsikko);
////        JLabel valittu = new JLabel();
////
////        JButton suljeNappi = new JButton("OK");
////        ToimintoSuljePelaajanValitsin sulje = new ToimintoSuljePelaajanValitsin(aanestys, this.frame, aanestaja, kuuntelija);
////        suljeNappi.addActionListener(sulje);
////        suljeNappi.setEnabled(false);
////
////        for (Pelaaja ehdokas : ehdokkaat) {
////            JButton pelaajaNappi = new JButton(ehdokas.getNimi());
////            ToimintoValitseAanestettava toiminto = new ToimintoValitseAanestettava(aanestaja, ehdokas, valittu, kuuntelija, suljeNappi);
////            pelaajaNappi.addActionListener(toiminto);
////            container.add(pelaajaNappi);
////        }
////        JLabel teksti = new JLabel("Valittu:");
////
////
////        container.add(teksti);
////        container.add(valittu);
////        container.add(suljeNappi);
////
////    }
//}
