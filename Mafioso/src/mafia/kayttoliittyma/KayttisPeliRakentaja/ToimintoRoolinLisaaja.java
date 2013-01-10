/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.kayttoliittyma.KayttisPeliRakentaja;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import mafia.sovelluslogiikka.peli.PeliRakentaja;
import mafia.sovelluslogiikka.roolit.Rooli;

/**
 *
 * @author Arto
 */
public class ToimintoRoolinLisaaja implements ActionListener{
    private JList valitut;
    private PeliRakentaja rakentaja;
    private JList roolilista;
    private JLabel roolienMaara;
    
    
 ToimintoRoolinLisaaja(JList valitut, PeliRakentaja rakentaja, JList lista, JLabel roolienMaara){
     this.valitut = valitut;
     this.rakentaja=rakentaja;
     this.roolilista=lista;
     this.roolienMaara = roolienMaara;
 }
 
 @Override
 public void actionPerformed(ActionEvent ae){
     Rooli rooli = (Rooli) roolilista.getSelectedValue();
     rakentaja.lisaaRooli(rooli.kopioi());
     Rooli[] valitutRoolit = new Rooli[rakentaja.getRoolit().size()];
     for (int i = 0; i < rakentaja.getRoolit().size(); i++) {
         valitutRoolit[i]=rakentaja.getRoolit().get(i);        
     }
     valitut.setListData(valitutRoolit);
     roolienMaara.setText(rakentaja.getRoolit().size()+"");
 }
    
}
