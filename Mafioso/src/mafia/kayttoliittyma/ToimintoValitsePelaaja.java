/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import mafia.sovelluslogiikka.Pelaaja;

/**
 *
 * @author Arto
 */
public class ToimintoValitsePelaaja implements ActionListener{
    private Pelaaja pelaaja;
    private JLabel valittu;
    private KayttisKuuntelija kuuntelija;
    private JButton okNappi;
    
    public ToimintoValitsePelaaja(Pelaaja pelaaja, JLabel valittu, KayttisKuuntelija kuuntelija, JButton ok){
        this.pelaaja = pelaaja;
        this.valittu=valittu;
        this.kuuntelija = kuuntelija;
        this.okNappi = ok;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        this.okNappi.setEnabled(true);
        valittu.setText(pelaaja.getNimi());
        kuuntelija.setPelaaja(pelaaja);
        
    }
}