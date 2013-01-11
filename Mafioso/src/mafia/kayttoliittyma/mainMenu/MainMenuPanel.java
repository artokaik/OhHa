/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.kayttoliittyma.mainMenu;

import java.awt.Dimension;
import mafia.kayttoliittyma.mainMenu.ToimintoSuljeOhjelma;
import mafia.kayttoliittyma.mainMenu.ToimintoUusiPeliRakentaja;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import mafia.kayttoliittyma.Kayttis;

/**
 *
 * @author Arto
 */
public class MainMenuPanel extends JPanel {

    private Kayttis kayttis;

    /**
     *
     * @param kayttis
     */
    public MainMenuPanel(Kayttis kayttis) {
        this.kayttis = kayttis;
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.add(teeUusiPeliNappi());
        this.add(teeLopetusNappi());
        this.setPreferredSize(new Dimension(kayttis.getKeskustaMitat()));


    }

    /**
     *
     * @return
     */
    public JButton teeUusiPeliNappi() {
        JButton nappi = new JButton("Uusi peli");
        ToimintoUusiPeliRakentaja toiminto = new ToimintoUusiPeliRakentaja(kayttis);
        nappi.addActionListener(toiminto);
        return nappi;
    }

    /**
     *
     * @return
     */
    public JButton teeLopetusNappi() {
        JButton nappi = new JButton("Lopeta");
        ToimintoSuljeOhjelma sulje = new ToimintoSuljeOhjelma(kayttis);
        nappi.addActionListener(sulje);
        return nappi;
    }
}
