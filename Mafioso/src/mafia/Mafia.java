
package mafia;

import mafia.sovelluslogiikka.peli.Peli;
import mafia.tekstikayttoliittyma.*;
import mafia.sovelluslogiikka.*;

/**
 *
 * @author Arto
 */
public class Mafia {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        TekstiPelinLuoja luoja = new TekstiPelinLuoja();
        Peli peli = luoja.luoPeli();
        peli.pelaa();
        
//        Aanestys aanestys = new Aanestys(peli.getPelaajat());
//        aanestys.suorita(peli.getPelaajat());
    }
}
