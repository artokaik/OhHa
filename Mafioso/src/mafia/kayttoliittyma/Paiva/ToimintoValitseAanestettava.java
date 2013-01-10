/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.kayttoliittyma.Paiva;

import mafia.kayttoliittyma.KayttisKuuntelija;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import mafia.sovelluslogiikka.Pelaaja;

/**
 *
 * @author Arto
 */
public class ToimintoValitseAanestettava implements ActionListener{
    private Pelaaja aanestaja;
    private Pelaaja aanestetty;
    private JLabel valittu;
    private KayttisKuuntelija kuuntelija;
    private JButton okNappi;
    
    public ToimintoValitseAanestettava(Pelaaja aanestaja, Pelaaja aanestetty, JLabel valittu, KayttisKuuntelija kuuntelija, JButton ok){
        this.aanestaja = aanestaja;
        this.aanestetty=aanestetty;
        this.valittu=valittu;
        this.kuuntelija = kuuntelija;
        this.okNappi = ok;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        this.okNappi.setEnabled(true);
        valittu.setText(aanestetty.getNimi());
        kuuntelija.setPelaaja(aanestetty);
        
    }
    
}
