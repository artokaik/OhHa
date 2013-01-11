/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.kayttoliittyma.KayttisPeliRakentaja;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JList;
import mafia.sovelluslogiikka.PeliRakentaja;
import mafia.sovelluslogiikka.roolit.Rooli;

/**
 *
 * @author Arto
 */
public class ToimintoRoolinPoistaja implements ActionListener{
    private JList valitut;
    private PeliRakentaja rakentaja;
    private JLabel roolienMaara;
    
    
 ToimintoRoolinPoistaja(JList valitut, PeliRakentaja rakentaja, JLabel roolienMaara){
     this.valitut = valitut;
     this.rakentaja=rakentaja;
     this.roolienMaara = roolienMaara;
 }
 
 @Override
 public void actionPerformed(ActionEvent ae){
     Rooli rooli = (Rooli) valitut.getSelectedValue();
     rakentaja.poistaRooli(rooli);
     Rooli[] valitutRoolit = new Rooli[rakentaja.getRoolit().size()];
     for (int i = 0; i < rakentaja.getRoolit().size(); i++) {
         valitutRoolit[i]=rakentaja.getRoolit().get(i);        
     }
     valitut.setListData(valitutRoolit);
     roolienMaara.setText(rakentaja.getRoolit().size()+"");
 }
}