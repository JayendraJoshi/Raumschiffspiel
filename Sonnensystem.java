import java.util.Scanner;

public class Sonnensystem {
    public static void main(String[] args) {

        Planet auroria = new Planet("Auroria", true, 5, 5);
        Planet solara = new Planet("Solara", false, 10, 10);
        Planet ktaris = new Planet("Ktaris", true, 15, 15);

        Ladung ladung1 = new Ladung("Ladung1", 10);
        Ladung ladung2 = new Ladung("Ladung2", 20);
        Ladung ladung3 = new Ladung("Ladung3", 30);
        Ladung ladung4 = new Ladung("Ladung4", 40);

        auroria.addLadung(ladung1);
        solara.addLadung(ladung2);
        ktaris.addLadung(ladung3);

        Kapitaen alexiaNova = new Kapitaen("Alexia Nova", 7, 10);
        Kapitaen zenithNightfall = new Kapitaen("Zenith Nightfall", 8, 9);

        Raumschiff eosNova = new Raumschiff("Eos Nova",0,0,alexiaNova);
        Raumschiff auroraQuest = new Raumschiff("Aurora Quest",0,0,zenithNightfall);

        boolean gameOver = false;
        Scanner scanner = new Scanner(System.in);

        while (!gameOver) {
            System.out.println("Raumschiff Koordinaten: (" + eosNova.getX() + ", " + eosNova.getY() + ")");
            System.out.println("Bewegung (a/w/s/d):");
            char richtung = scanner.next().charAt(0);
            eosNova.fliegen(richtung);
            System.out.println("Gesteuert von " + eosNova.getKapitaen().getName());
            eosNova.getKapitaen().setName("Alexia Starlight Nova");

            if (eosNova.pruefeKoordinaten(auroraQuest.getX(), auroraQuest.getY())) {
                System.out.println("Hier ist das Raumschiff " + auroraQuest.getName());
                gameOver = true;
            }
        }

        scanner.close();
    }
}