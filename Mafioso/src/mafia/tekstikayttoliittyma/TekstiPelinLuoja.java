/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mafia.tekstikayttoliittyma;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import mafia.sovelluslogiikka.Pelaaja;
import mafia.sovelluslogiikka.peli.Peli;
import mafia.sovelluslogiikka.peli.Saannot;
import mafia.sovelluslogiikka.roolit.Etsiva;
import mafia.sovelluslogiikka.roolit.Kansalainen;
import mafia.sovelluslogiikka.roolit.Mafioso;
import mafia.sovelluslogiikka.roolit.Rooli;
import mafia.sovelluslogiikka.roolit.Suojelija;



public class TekstiPelinLuoja {

    private Scanner lukija;
    private ArrayList<Rooli> roolit;
    private Random arpoja;

    public TekstiPelinLuoja() {
        lukija = new Scanner(System.in);
        arpoja = new Random();
        roolit = new ArrayList<Rooli>();
        
        roolit.add(new Mafioso());
        roolit.add(new Etsiva());
        roolit.add(new Suojelija());
        roolit.add(new Kansalainen());
    }

    public Peli luoPeli() {
        Peli peli = new Peli();
        System.out.println("Pelaajien lukumäärä:");
        int maara = lukija.nextInt();
        ArrayList<Rooli> pelinRoolit = lisaaRooli(maara);
        lisaaPelaajat(peli, maara, pelinRoolit);
        maaritaSaannot(peli);
        System.out.println(peli);
        return peli;
    }

    private void maaritaSaannot(Peli peli) {
        alkaakoPaivalla(peli.getSaannot());
    }

    private void alkaakoPaivalla(Saannot saannot) {
        System.out.println("Alkaako peli päivällä (0) vai yöllä (1): ");
        String valinta = lukija.nextLine();
        while (!valinta.equals("1") && !valinta.equals("0")) {
            System.out.println("Valitsit '" + valinta + "', vaikka piti valita '0' tai '1'. Yritä uudestaan.");
            System.out.println("Alkaako peli päivällä (0) vai yöllä (1): ");
            valinta = lukija.nextLine();
        }
        if (valinta.equals("1")) {
            saannot.asetaYoEnsin();
        } else {
            saannot.asetaPaivaEnsin();
        }
    }

    private ArrayList<Rooli> lisaaRooli(int maara) {
        ArrayList<Rooli> pelinRoolit = new ArrayList<Rooli>();
        for (int i = 0; i < maara; i++) {
                tulostaRoolit();
                System.out.print("Valitse lisättävä: ");
                int valittu = lukija.nextInt();
            while (!(valittu >= 0 && valittu < roolit.size())) {
                System.out.println("Ei ollut listalla, yritä uudestaan");
                tulostaRoolit();
                System.out.print("Valitse lisättävä: ");
                valittu = lukija.nextInt();
            }
            pelinRoolit.add(roolit.get(valittu));
        }
        return pelinRoolit;
    }

    private void tulostaRoolit() {
        for (Rooli rooli : roolit) {
            System.out.print(roolit.indexOf(rooli));
            System.out.println(": " + rooli.getRoolinimi());
        }
    }

    private void lisaaPelaajat(Peli peli, int maara, ArrayList<Rooli> pelinRoolit) {
        for (int i = 0; i < maara; i++) {
            Pelaaja pelaaja;
            while (true) {
                System.out.println("Anna nimesi:");
                String nimi = "";
                nimi = lukija.nextLine();
                nimi = lukija.nextLine();
                pelaaja = new Pelaaja(nimi);
                if (peli.lisaaPelaaja(pelaaja)) {
                    break;
                }
                System.out.println("Ei kelpaa, pelaaja on jo olemassa.");
                System.out.println("Pelaajat: " + peli.getPelaajat());
            }
            pelaaja.setRooli(arvoRooli(pelinRoolit));
            System.out.println("Roolisi on " + pelaaja.getRooli().getRoolinimi());
        }
    }

    private Rooli arvoRooli(ArrayList<Rooli> pelinRoolit) {
        int n = pelinRoolit.size();
        int x = arpoja.nextInt(n);
        Rooli rooli = pelinRoolit.get(x);
        pelinRoolit.remove(x);
        return rooli;
    }
}
