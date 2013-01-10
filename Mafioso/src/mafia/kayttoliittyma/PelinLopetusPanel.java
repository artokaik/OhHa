/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.kayttoliittyma;

import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import mafia.sovelluslogiikka.Vaihe;
import mafia.sovelluslogiikka.peli.Peli;

/**
 *
 * @author Arto
 */
public class PelinLopetusPanel extends JPanel{
    private Vaihe vaihe;
    private Kayttis kayttis;
    
    public PelinLopetusPanel(Vaihe vaihe, Kayttis kayttis){
        this.vaihe=vaihe;
        this.kayttis=kayttis;
        this.setPreferredSize(new Dimension(kayttis.getKeskustaMitat()));
        
        JLabel lopputulos = new JLabel(Peli.kerroLopputulos(vaihe.getPelaajat()));
        this.add(lopputulos);
        
        JButton menuun = new JButton("Takaisin alkuun");
        ToimintoAvaaMainMenu toiminto = new ToimintoAvaaMainMenu(kayttis);
        menuun.addActionListener(toiminto);
        this.add(menuun);
    }
}
