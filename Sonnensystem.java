import java.util.Scanner;
import java.util.ArrayList;
public class Sonnensystem {
    public static void main(String[] args) {


        ArrayList<Planet> planeten = new ArrayList<>();
        planeten.add(new Planet("Auroria", true, 5, 5));
        planeten.add(new Planet("Solara", false, 10, 10));
        planeten.add(new Planet("Ktaris", true, 15, 15));

        ArrayList<Ladung> ladungen = new ArrayList<>();
        ladungen.add(new Ladung("Ladung1", 10));
        ladungen.add(new Ladung("Ladung2", 20));
        ladungen.add(new Ladung("Ladung3", 30));
        ladungen.add(new Ladung("Ladung4", 40));

        planeten.get(0).addLadung(ladungen.get(0));
        planeten.get(1).addLadung(ladungen.get(1));
        planeten.get(2).addLadung(ladungen.get(2));

        ArrayList<Raumschiff> raumschiffe = new ArrayList<>();
        raumschiffe.add(new Raumschiff("Eos Nova",0,0,new Kapitaen("Alexia Nova", 7, 10),100,100,100,100,100));
        raumschiffe.add(new Raumschiff("Aurora Quest",0,0,new Kapitaen("Zenith Nightfall", 8, 9),100,100,100,100,100));

        ArrayList<Asteroidenfeld> asteroidenfelder = new ArrayList<>();
        asteroidenfelder.add(new Asteroidenfeld(7, 20, 20));

        boolean gameOver = false;
        Scanner scanner = new Scanner(System.in);

        while (!gameOver) {
            System.out.println("Raumschiff Koordinaten: (" + raumschiffe.get(0).getX() + ", " + raumschiffe.get(0).getY() + ")");
            System.out.println("Bewegung (a/w/s/d):");
            char richtung = scanner.next().charAt(0);
            raumschiffe.get(0).fliegen(richtung);
            System.out.println("Gesteuert von " + raumschiffe.get(0).getKapitaen().getName());
            raumschiffe.get(0).getKapitaen().setName("Alexia Starlight Nova");

            if (raumschiffe.get(0).pruefeKoordinaten(raumschiffe.get(1).getX(), raumschiffe.get(1).getY())) {
                System.out.println("Hier ist das Raumschiff " + raumschiffe.get(1).getName());
                gameOver = true;
            }
        }

        scanner.close();
    }
}