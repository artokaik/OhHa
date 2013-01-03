
package mafia;

import mafia.tekstikayttoliittyma.*;
import mafia.sovelluslogiikka.*;

public class Mafia {

    public static void main(String[] args) {
        TekstiPelinLuoja luoja = new TekstiPelinLuoja();
        Peli peli = luoja.luoPeli();
        peli.pelaa();
        
//        Aanestys aanestys = new Aanestys(peli.getPelaajat());
//        aanestys.suorita(peli.getPelaajat());
    }
}
