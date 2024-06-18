import java.util.Scanner;
import java.util.ArrayList;
public class Sonnensystem {
    public static void main(String[] args) {

        ArrayList<Planet> planeten = new ArrayList<>();
        planeten.add(new Planet("Auroria", true, 5, 5,new Ressource("Smaragd",5000,2,50)));
        planeten.add(new Planet("Solara", false, 10, 10, new Ressource("Uranium",100000,3,10)));
        planeten.add(new Planet("Ktaris", true, 15, 15,new Ressource("Titanium",500000,5,4)));

        ArrayList<Ladung> ladungen = new ArrayList<>();
        ladungen.add(new Ladung("Ladung1",10,3,3));
        ladungen.add(new Ladung("Ladung2", 20,5,6));
        ladungen.add(new Ladung("Ladung3", 30,9,5));
        ladungen.add(new Ladung("Ladung4", 40,9,9));



        ArrayList<Raumschiff> raumschiffe = new ArrayList<>();
        raumschiffe.add(new Jaeger("Eos Nova",10,0,new Kapitaen("Alexia Nova", 7, 10,5),100,100,100,100,100,1000));
        raumschiffe.add(new Transportschiff("Aurora Quest",0,0,new Kapitaen("Zenith Nightfall", 8, 9,10),100,100,100,100,100,2000));

        ArrayList<Asteroidenfeld> asteroidenfelder = new ArrayList<>();
        asteroidenfelder.add(new Asteroidenfeld(7, 20, 20));
        asteroidenfelder.add(new Asteroidenfeld(20,10,10));

        Raumstation raumstation = new Raumstation("Staion gamma",7,7);

        KosmischesNachrichtenarchiv nachrichtenarchiv = new KosmischesNachrichtenarchiv();
        boolean gameOver = false;
        Scanner scanner = new Scanner(System.in);

        while (!gameOver) {
            System.out.println("Raumschiff Koordinaten: (" + raumschiffe.get(0).getX() + ", " + raumschiffe.get(0).getY() + ")");
            System.out.println("Bewegung (a/w/s/d):");
            char richtung = scanner.next().charAt(0);
            raumschiffe.get(0).fliegen(richtung);
            System.out.println("Gesteuert von " + raumschiffe.get(0).getKapitaen().getName());
            raumschiffe.get(0).getKapitaen().setName("Alexia Starlight Nova");

            if (raumschiffe.get(0).pruefeKoordinaten(raumstation.getPosX(), raumstation.getPosY())) {
                System.out.println("Das Raumschiff ist an der Raumstation angekommen. Reparaturen und Upgrades werden durchgeführt.");
                raumstation.reparieren(raumschiffe.get(0));
                raumstation.aufruesten(raumschiffe.get(0));
                nachrichtenarchiv.nachrichtHinzufuegen(new Nachricht("Das Raumschiff wurde an der Raumstation repariert und aufgerüstet."));
            }

            for (Asteroidenfeld feld : asteroidenfelder) {
                if (raumschiffe.get(0).pruefeKoordinaten(feld.getPosX(), feld.getPosY())) {
                    System.out.println("Das Raumschiff ist in ein Asteroidenfeld geraten. Schäden wurden erlitten.");
                    raumschiffe.get(0).setIntegritaetsgrad(raumschiffe.get(0).getIntegritaetsgrad() - feld.getGefahrenpotential());
                    nachrichtenarchiv.nachrichtHinzufuegen(new Nachricht("Das Raumschiff hat Schaden durch ein Asteroidenfeld erlitten."));
                }
            }

            for (int i = 1; i < raumschiffe.size(); i++) {
                if (raumschiffe.get(0).pruefeKoordinaten(raumschiffe.get(i).getX(), raumschiffe.get(i).getY())) {
                    System.out.println("Das Raumschiff ist mit dem Raumschiff " + raumschiffe.get(i).getName() + " kollidiert.");
                    gameOver=true;
                    break;
                }

            }

            for (Planet planet : planeten) {
                if (raumschiffe.get(0).pruefeKoordinaten(planet.getPosX(), planet.getPosY())) {
                    System.out.println("Der Planet " + planet.getName() + " wurde erreicht." + " Atmosphäre: " + planet.getAtmosphare());
                    planet.showRessourcen();
                    boolean wahl = raumschiffe.get(0).wahlZumAbbauEinerRessource();
                    if(wahl==true){
                        System.out.println("Geben Sie den index der Ressource an.");
                        scanner.nextLine();
                        int index = Integer.parseInt(scanner.nextLine());
                        raumschiffe.get(0).ressourceAbbauen(planet.getRessource(index));
                        System.out.println("Neue Ressource aufgenommen, Liste aller aktuellen Ladungen:");
                        System.out.println(raumschiffe.get(0).getLadungen());
                    }
                }
            }
        }
        System.out.println("GAME OVER!!!");
        scanner.close();
    }
}