/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.kayttoliittyma.KayttisPeliRakentaja;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import mafia.kayttoliittyma.Kayttis;
import mafia.kayttoliittyma.kerroRoolit.ToimintoKerroRoolit;
import mafia.sovelluslogiikka.peli.PeliRakentaja;
import mafia.sovelluslogiikka.roolit.Rooli;
import mafia.sovelluslogiikka.roolit.Roolilista;

/**
 *
 * @author Arto
 */
public class PeliRakentajaMainPanel extends JPanel{


    private ArrayList<Rooli> roolit;
    private PeliRakentaja rakentaja;
    private Kayttis kayttis;


    public PeliRakentajaMainPanel(Kayttis kayttis) {
        this.kayttis = kayttis;
        Roolilista roolilista = new Roolilista();
        roolit = roolilista.getRoolit();
        rakentaja = new PeliRakentaja();
        this.setPreferredSize(new Dimension(kayttis.getKeskustaMitat()));
        
        this.setLayout(new BorderLayout());
        JPanel vasen = luoVasen();
        this.add(vasen, BorderLayout.WEST);
        JPanel keskusta = luoKeskusta();
        this.add(keskusta, BorderLayout.CENTER);
        JPanel oikea = luoOikea();
        this.add(oikea, BorderLayout.EAST);
        JPanel ylin = luoYlin();
        this.add(ylin, BorderLayout.NORTH);
        JPanel alin = luoAlin();
        this.add(alin, BorderLayout.SOUTH);
    }

    public JPanel luoVasen() {
        JPanel panel = new JPanel();
        panel.add(luoRoolienValitsija());
        return panel;
    }

    public JPanel luoKeskusta() {
        JPanel panel = new JPanel();
        panel.add(luoPelaajienValitsija());
        return panel;
    }

    public JPanel luoOikea() {
        JPanel panel = new JPanel();
        return panel;
    }
    public JPanel luoYlin(){
        JPanel panel = new JPanel();
        return panel;
    }  
    public JPanel luoAlin(){
        JPanel panel = new JPanel();
        JButton aloita = new JButton("Aloita peli");
        ToimintoKerroRoolit valmis = new ToimintoKerroRoolit(rakentaja, kayttis);
        aloita.addActionListener(valmis);
        panel.add(aloita);
        
        
        return panel;
    }

    private JPanel luoRoolienValitsija() {
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(250,400));

        panel.setLayout(new GridLayout(3, 2));
        JList roolilista = luoRooliluettelo();
        JButton valitse = new JButton("Lisää");
        JLabel roolienMaara = new JLabel("Roolien määrä:");
        JLabel maara = new JLabel();
        JList valitutRoolit = new JList();
        JButton poista = new JButton("Poista");

        ToimintoRoolinLisaaja lisaaja = new ToimintoRoolinLisaaja(valitutRoolit, rakentaja, roolilista, maara);
        valitse.addActionListener(lisaaja);

        ToimintoRoolinPoistaja poistaja = new ToimintoRoolinPoistaja(valitutRoolit, rakentaja, maara);
        poista.addActionListener(poistaja);
        roolilista.setLayoutOrientation(JList.VERTICAL);
        roolilista.setSelectedIndex(0);
        roolilista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        valitutRoolit.setLayoutOrientation(JList.VERTICAL);
        valitutRoolit.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        JScrollPane roolitScroller = new JScrollPane(roolilista);
        JScrollPane valitutScroller = new JScrollPane(valitutRoolit);


        panel.add(roolitScroller);
        panel.add(valitse);
        panel.add(roolienMaara);
        panel.add(maara);
        panel.add(valitutScroller);
        panel.add(poista);

        return panel;
    }

    private JPanel luoPelaajienValitsija() {
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(250,400));

        panel.setLayout(new GridLayout(3, 2));

        JTextField nimi = new JTextField();
        JButton lisaa = new JButton("Lisää");
        JLabel pelaajienMaara = new JLabel("Pelaajien määrä:");
        JLabel maara = new JLabel();
        JList pelaajat = new JList();
        JButton poista = new JButton("Poista");

        ToimintoPelaajanLisaaja lisaaja = new ToimintoPelaajanLisaaja(pelaajat, rakentaja, nimi, maara);
        lisaa.addActionListener(lisaaja);

        ToimintoPelaajanPoistaja poistaja = new ToimintoPelaajanPoistaja(pelaajat, rakentaja, maara);
        poista.addActionListener(poistaja);

        pelaajat.setLayoutOrientation(JList.VERTICAL);
        pelaajat.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane valitutScroller = new JScrollPane(pelaajat);


        panel.add(nimi);
        panel.add(lisaa);
        panel.add(pelaajienMaara);
        panel.add(maara);
        panel.add(valitutScroller);
        panel.add(poista);

        return panel;
    }

    private JList luoRooliluettelo() {
        Rooli[] rooliluettelo = new Rooli[roolit.size()];
        for (int i = 0;
                i < rooliluettelo.length;
                i++) {
            rooliluettelo[i] = roolit.get(i);
        }
        JList list = new JList();
        list.setLayoutOrientation(JList.VERTICAL);
        list.setVisibleRowCount(-1);
        list.setListData(rooliluettelo);

        return list;
    }
}
