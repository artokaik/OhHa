/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.kayttoliittyma.Aanestys;

import mafia.kayttoliittyma.Aanestys.KayttisKuuntelija;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import mafia.sovelluslogiikka.Pelaaja;

/**
 *
 * @author Arto
 */
public class KayttisAanestysToiminto implements ActionListener{
    private Pelaaja aanestaja;
    private Pelaaja aanestetty;
    private JLabel valittu;
    private KayttisKuuntelija kuuntelija;
    
    public KayttisAanestysToiminto(Pelaaja aanestaja, Pelaaja aanestetty, JLabel valittu, KayttisKuuntelija kuuntelija){
        this.aanestaja = aanestaja;
        this.aanestetty=aanestetty;
        this.valittu=valittu;
        this.kuuntelija = kuuntelija;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        valittu.setText(aanestetty.getNimi());
        kuuntelija.setPelaaja(aanestetty);
        
    }
    
}
