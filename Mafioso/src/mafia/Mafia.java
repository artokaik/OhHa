
package mafia;

import mafia.tekstikayttoliittyma.*;
import mafia.sovelluslogiikka.*;

public class Mafia {

    public static void main(String[] args) {
        PelinLuoja luoja = new PelinLuoja();
        Peli peli = luoja.luoPeli();
        System.out.println(peli);
        
        Aanestys aanestys = new Aanestys(peli.getPelaajat());
        aanestys.suorita(peli.getPelaajat());
    }
}
