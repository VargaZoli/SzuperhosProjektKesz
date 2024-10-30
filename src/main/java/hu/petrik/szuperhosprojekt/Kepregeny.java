package hu.petrik.szuperhosprojekt;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Kepregeny {
    public static List<Szuperhos> szuperhosLista = new ArrayList<>();

    public static void szereplok(String filePath) throws IOException {
        List<String> sorok = Files.readAllLines(Paths.get(filePath));
        for (String sor : sorok) {
            String[] adatok = sor.split(" ");
            String nev = adatok[0];
            int kutyuSzam = Integer.parseInt(adatok[1]);

            Szuperhos szuperhos;
            if (nev.equals("Vasember")) {
                szuperhos = new Vasember();
            } else {
                szuperhos = new Batman();
            }

            for (int i = 0; i < kutyuSzam; i++) {
                if (szuperhos instanceof Milliardos) {
                    ((Milliardos) szuperhos).kutyutKeszit();
                }
            }

            szuperhosLista.add(szuperhos);
        }
    }

    public static void szuperhosok() {
        for (Szuperhos szuperhos : szuperhosLista) {
            System.out.println(szuperhos);
        }
    }

    public static void main(String[] args) {
        try {
            szereplok("src/szuperhosok.txt");
            szuperhosok();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
