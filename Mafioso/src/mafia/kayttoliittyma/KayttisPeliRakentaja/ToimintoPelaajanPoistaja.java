/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.kayttoliittyma.KayttisPeliRakentaja;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JList;
import mafia.sovelluslogiikka.Pelaaja;
import mafia.sovelluslogiikka.peli.PeliRakentaja;
import mafia.sovelluslogiikka.roolit.Rooli;

/**
 *
 * @author Arto
 */
public class ToimintoPelaajanPoistaja implements ActionListener{
    private JList valitut;
    private PeliRakentaja rakentaja;
    private JLabel pelaajienMaara;
    
    
 ToimintoPelaajanPoistaja(JList valitut, PeliRakentaja rakentaja, JLabel pelaajienMaara){
     this.valitut = valitut;
     this.rakentaja=rakentaja;
     this.pelaajienMaara = pelaajienMaara;
 }
 
 @Override
 public void actionPerformed(ActionEvent ae){
     Pelaaja pelaaja = (Pelaaja) valitut.getSelectedValue();
     rakentaja.poistaPelaaja(pelaaja);
     Pelaaja[] valitutPelaajat = new Pelaaja[rakentaja.getPelaajat().size()];
     for (int i = 0; i < rakentaja.getPelaajat().size(); i++) {
         valitutPelaajat[i]=rakentaja.getPelaajat().get(i);        
     }
     valitut.setListData(valitutPelaajat);
     pelaajienMaara.setText(rakentaja.getPelaajat().size()+"");
 }
}
