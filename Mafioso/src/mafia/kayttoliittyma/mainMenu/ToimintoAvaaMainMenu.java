/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.kayttoliittyma.mainMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import mafia.kayttoliittyma.Kayttis;
import mafia.kayttoliittyma.mainMenu.MainMenuPanel;

/**
 *
 * @author Arto
 */
public class ToimintoAvaaMainMenu implements ActionListener{
    private Kayttis kayttis;
    
    /**
     *
     * @param kayttis
     */
    public ToimintoAvaaMainMenu(Kayttis kayttis){
       this.kayttis=kayttis;
    }
    
    public void actionPerformed(ActionEvent ae){
        kayttis.korvaaKeskusta(new MainMenuPanel(kayttis));
    }
            
}
