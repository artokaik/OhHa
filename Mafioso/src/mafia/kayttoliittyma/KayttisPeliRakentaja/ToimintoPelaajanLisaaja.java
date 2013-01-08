/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.kayttoliittyma.KayttisPeliRakentaja;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import mafia.sovelluslogiikka.Pelaaja;
import mafia.sovelluslogiikka.peli.PeliRakentaja;
import mafia.sovelluslogiikka.roolit.Rooli;

/**
 *
 * @author Arto
 */
public class ToimintoPelaajanLisaaja implements ActionListener {

    private JList valitut;
    private PeliRakentaja rakentaja;
    private JTextField nimi;
    private JLabel pelaajienMaara;

    ToimintoPelaajanLisaaja(JList valitut, PeliRakentaja rakentaja, JTextField nimi, JLabel pelaajienMaara) {
        this.valitut = valitut;
        this.rakentaja = rakentaja;
        this.nimi = nimi;
        this.pelaajienMaara = pelaajienMaara;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (!nimi.getText().isEmpty()) {
            Pelaaja pelaaja = new Pelaaja(nimi.getText());
            rakentaja.lisaaPelaaja(pelaaja);
            Pelaaja[] valitutPelaajat = new Pelaaja[rakentaja.getPelaajat().size()];
            for (int i = 0; i < rakentaja.getPelaajat().size(); i++) {
                valitutPelaajat[i] = rakentaja.getPelaajat().get(i);
            }
            valitut.setListData(valitutPelaajat);
            pelaajienMaara.setText(rakentaja.getPelaajat().size() + "");
            nimi.setText(null);
        }
    }
}
