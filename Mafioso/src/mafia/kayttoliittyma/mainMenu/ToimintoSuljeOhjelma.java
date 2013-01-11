/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.kayttoliittyma.mainMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import mafia.kayttoliittyma.Kayttis;
import mafia.sovelluslogiikka.sekalaista.Pelaaja;

/**
 *
 * @author Arto
 */
public class ToimintoSuljeOhjelma implements ActionListener{
    private Kayttis kayttis;
    
    /**
     *
     * @param kayttis
     */
    public ToimintoSuljeOhjelma(Kayttis kayttis){
        this.kayttis=kayttis;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        kayttis.getFrame().dispose();
        System.exit(0);
        
    }
}