///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//package mafia.kayttoliittyma.yo;
//
//import java.awt.Dimension;
//import java.util.ArrayList;
//import javax.swing.BoxLayout;
//import javax.swing.JButton;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import mafia.kayttoliittyma.Kayttis;
//import mafia.kayttoliittyma.KayttisKuuntelija;
//import mafia.kayttoliittyma.PelaajanValitsijaPanel;
//import mafia.sovelluslogiikka.Pelaaja;
//import mafia.sovelluslogiikka.Yo;
//
///**
// *
// * @author Arto
// */
//public class YoVuoroPanel extends JPanel{
//    private Kayttis kayttis;
//    private Yo yo;
//    private Pelaaja vuorossa;
//    
//    public YoVuoroPanel(Kayttis kayttis, Yo yo, Pelaaja vuorossa){
//        this.kayttis = kayttis;
//        this.yo = yo;
//        this.vuorossa = vuorossa;
//        this.setPreferredSize(new Dimension(kayttis.getKeskustaMitat()));
//        
//        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
//        JLabel label = new JLabel(vuorossa.getRooli().getRooliSelitys(yo));
//        
//        ArrayList<Pelaaja> vaihtoehdot = vuorossa.getRooli().getVaihtoehdot(yo.getPelaajat(), vuorossa);
//        
//        JButton okNappi = new JButton("OK");
//        if(!vaihtoehdot.isEmpty()){
//            okNappi.setEnabled(false);
//        }
//        KayttisKuuntelija kuuntelija = new KayttisKuuntelija();
//        
//        PelaajanValitsijaPanel valitsijaPanel = new PelaajanValitsijaPanel(vaihtoehdot, okNappi, kuuntelija);
//        
//        ToimintoVahvistaValinta vahvitusToiminto = new ToimintoVahvistaValinta(vuorossa, yo, kuuntelija, kayttis);
//        okNappi.addActionListener(vahvitusToiminto);
//        
//        this.add(label);
//        this.add(valitsijaPanel);
//        this.add(okNappi);
//    }
//    
//
//    
//}
