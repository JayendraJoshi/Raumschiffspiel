import java.util.Scanner;

public class Sonnensystem {
    public static void main(String[] args) {
        Raumschiff eosNova = new Raumschiff("Eos Nova",0,0);
        Raumschiff auroraQuest = new Raumschiff("Aurora Quest",0,0);

        boolean gameOver = false;
        Scanner scanner = new Scanner(System.in);

        while (!gameOver) {
            System.out.println("Raumschiff Koordinaten: (" + eosNova.getX() + ", " + eosNova.getY() + ")");
            System.out.println("Bewegung (a/w/s/d):");
            char richtung = scanner.next().charAt(0);
            eosNova.fliegen(richtung);

            if (eosNova.pruefeKoordinaten(auroraQuest.getX(), auroraQuest.getY())) {
                System.out.println("Hier ist das Raumschiff " + auroraQuest.getName());
                gameOver = true;
            }
        }

        scanner.close();
    }
}