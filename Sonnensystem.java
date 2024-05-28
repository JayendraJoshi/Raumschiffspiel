import java.util.Scanner;

public class Sonnensystem {
    public static void main(String[] args) {
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