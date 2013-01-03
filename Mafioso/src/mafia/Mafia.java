
package mafia;

import mafia.tekstikayttoliittyma.*;
import mafia.sovelluslogiikka.*;

public class Mafia {

    public static void main(String[] args) {
        TekstiPelinLuoja luoja = new TekstiPelinLuoja();
        Peli peli = luoja.luoPeli();
        System.out.println(peli);
        peli.pelaa();
        
//        Aanestys aanestys = new Aanestys(peli.getPelaajat());
//        aanestys.suorita(peli.getPelaajat());
    }
}
