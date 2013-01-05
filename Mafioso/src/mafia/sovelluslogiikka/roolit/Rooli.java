
package mafia.sovelluslogiikka.roolit;

import mafia.sovelluslogiikka.Yo;

public interface Rooli {
    
    public void toimi(Yo yo);
    public boolean onkoPahis();
    public String getRoolinimi();
}
