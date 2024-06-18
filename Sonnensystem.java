import java.util.Scanner;
import java.util.ArrayList;
public class Sonnensystem {
    public static void main(String[] args) {

        System.out.println("   _____                   __          __            \n" +
                    "  / ____|                  \\ \\        / /            \n" +
                    " | (___  _ __   __ _  ___ __\\ \\  /\\  / __ _ _ __ ___ \n" +
                    "  \\___ \\| '_ \\ / _` |/ __/ _ \\ \\/  \\/ / _` | '__/ __|\n" +
                    "  ____) | |_) | (_| | (_|  __/\\  /\\  | (_| | |  \\__ \\\n" +
                    " |_____/| .__/ \\__,_|\\___\\___| \\/  \\/ \\__,_|_|  |___/\n" +
                    "        | |                                          \n" +
                    "        |_|                                          ");



        ArrayList<Planet> planeten = new ArrayList<>();
        planeten.add(new Planet("Auroria", true, 5, 5,new Ressource("Smaragd",5000,2,50)));
        planeten.add(new Planet("Solara", false, 10, 12, new Ressource("Uranium",100000,3,10)));
        planeten.add(new Planet("Ktaris", true, 15, 15,new Ressource("Titanium",500000,5,4)));

        ArrayList<Ladung> ladungen = new ArrayList<>();
        ladungen.add(new Ladung("Ladung1",10,3,3));
        ladungen.add(new Ladung("Ladung2", 20,5,6));
        ladungen.add(new Ladung("Ladung3", 30,9,5));
        ladungen.add(new Ladung("Ladung4", 40,9,9));



        ArrayList<Raumschiff> raumschiffe = new ArrayList<>();
        raumschiffe.add(new Jaeger("Eos Nova",10,0,new Kapitaen("Alexia Nova", 7, 10,5),100,100,100,100,100));
        raumschiffe.add(new Transportschiff("Aurora Quest",0,0,new Kapitaen("Zenith Nightfall", 8, 9,30),200,200,50,50,1000));

        ArrayList<Asteroidenfeld> asteroidenfelder = new ArrayList<>();
        asteroidenfelder.add(new Asteroidenfeld(7, 20, 20));
        asteroidenfelder.add(new Asteroidenfeld(20,10,10));

        Raumstation raumstation = new Raumstation("Staion gamma",7,7);

        Handelsstation handelsstation = new Handelsstation("Galaktischer Handelsposten",new Ladung("Treibstoff",5,3,4),8,9);


        KosmischesNachrichtenarchiv nachrichtenarchiv = new KosmischesNachrichtenarchiv();
        boolean gameOver = false;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Raumschiff gesteuert von " + raumschiffe.get(0).getKapitaen().getName());
        while (!gameOver) {
            System.out.println("Koordinaten: (" + raumschiffe.get(0).getX() + ", " + raumschiffe.get(0).getY() + ")");
            System.out.println("Bewegung (a/w/s/d):");
            char richtung = scanner.next().charAt(0);
            raumschiffe.get(0).fliegen(richtung);
            raumschiffe.get(0).getKapitaen().setName("Alexia Starlight Nova");

            for (Asteroidenfeld feld : asteroidenfelder) {
                if (raumschiffe.get(0).pruefeKoordinaten(feld.getPosX(), feld.getPosY())) {
                    System.out.println("Das Raumschiff ist in ein Asteroidenfeld geraten. Ein Schaden von "+feld.getGefahrenpotential()+"  wurde erlitten.");
                    raumschiffe.get(0).setIntegritaetsgrad(raumschiffe.get(0).getIntegritaetsgrad() - feld.getGefahrenpotential());
                    nachrichtenarchiv.nachrichtHinzufuegen(new Nachricht("Das Raumschiff hat "+ feld.getGefahrenpotential()+" Schaden durch ein Asteroidenfeld erlitten."));
                    if(raumschiffe.get(0).getIntegritaetsgrad()<0){
                        System.out.println("Der Integritätsgrad liegt unter 0! Das Raumschiff wurde zerstört.");
                        gameOver=true;
                        break;
                    }
                }
            }

            if (raumschiffe.get(0).pruefeKoordinaten(raumstation.getPosX(), raumstation.getPosY())) {
                System.out.println("Das Raumschiff ist an der Raumstation "+raumstation.getName()+" angekommen. Reparaturen und Upgrades werden durchgeführt.");
                raumstation.reparieren(raumschiffe.get(0));
                raumstation.aufruesten(raumschiffe.get(0));
                nachrichtenarchiv.nachrichtHinzufuegen(new Nachricht("Das Raumschiff wurde an der Raumstation "+raumstation.getName()+ "repariert und aufgerüstet."));
            }

            for (int i = 1; i < raumschiffe.size(); i++) {
                if (raumschiffe.get(0).pruefeKoordinaten(raumschiffe.get(i).getX(), raumschiffe.get(i).getY())) {
                    System.out.println("Das Raumschiff ist mit dem Raumschiff " + raumschiffe.get(i).getName() + " kollidiert.");
                    System.out.println("Beide Raumschiffe haben 50 Schaden erlitten");
                    System.out.println("Informationen über das andere Raumschiff: ");
                    System.out.println(raumschiffe.get(i));
                    System.out.println("Möchten Sie diplomatische Verhandlungen einleiten?");
                    System.out.println("1: JA");
                    System.out.println("Beliebiges Zeichen: NEIN");
                    scanner.nextLine();
                    String wahl = scanner.nextLine();
                    if(wahl.equals("1")){
                        raumschiffe.get(0).getKapitaen().diplomatischeVerhandlung();

                    }
                    else{
                        System.out.println("Es wurden keine diplomatischen Verhandlungen eingeleitet.");
                        System.out.println("Wir werden beschossen, nichts wie weg hier!");
                    }
                }
            }

            if( raumschiffe.get(0).pruefeKoordinaten(handelsstation.getPosX(), handelsstation.getPosY())){
                System.out.println("Das Raumschiff ist an der Handelsstation "+handelsstation.getName()+" angekommen. Die Station hat folgende Ladungen auf Lager:");
                handelsstation.printLadungen();
                System.out.println("1:Ich möchte etwas kaufen.");
                System.out.println("2:Ich möchte etwas verkaufen.");
                System.out.println("Beliebiges Zeichen:Ich möchte nicht handeln.");
                scanner.nextLine();
                String input = scanner.nextLine();
                if(input.equals("1")){
                    System.out.println("Geben Sie die Nummer der Ladung ein, die Sie kaufen möchten.");
                    int index2 = Integer.valueOf(scanner.nextLine());
                    raumschiffe.get(0).kaufenLadung(handelsstation.getLadung(index2),handelsstation);

                }
                else if(input.equals("2")){
                    while(true) {
                        System.out.println("Sie haben folgende Ladungen zur Verfügung: ");
                        if (raumschiffe.get(0).getLadungen().size() < 1) {
                            System.out.println("Sie besitzen keine Ladung.");
                            break;
                        }
                        System.out.println(raumschiffe.get(0).getLadungen());
                        System.out.println("Geben sie die Nummer der Ladung ein, die Sie verkaufen möchten.");
                        System.out.println("(Die erste Ladung trägt die Nummer 0, die zweite 1 usw.");
                        int num = Integer.valueOf(scanner.nextLine());

                        raumschiffe.get(0).verkaufenLadung(raumschiffe.get(0).getLadung(num), handelsstation);
                        break;
                    }
                }

                else{
                    System.out.println("Verstanden, es wird nicht gehandelt.");
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