import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Raumschiff {

        private String name;
        private int posX;
        private int posY;
        private Kapitaen kapitaen;
        private Ladung ladung;
        private int integritaetsgrad;
        private int energieschild;
        private int energieVersorgung;
        private int manoevrierFaehigkeit;
        protected int waffenstaerke;
        private ArrayList<Ladung> ladungen;
        protected int ladungskapazitaet;
        protected String typ;
        private Scanner scanner;

        public Raumschiff(String name,int posX, int posY, Kapitaen kapitaen,int integritaetsgrad, int energieschild, int energieVersorgung, int manoevrierFaehigkeit, int waffenstaerke, int ladungskapazitaet) {
            this.name = name;
            this.posX = posX;
            this.posY = posY;
            this.kapitaen = kapitaen;
            this.integritaetsgrad = integritaetsgrad;
            this.energieschild = energieschild;
            this.energieVersorgung = energieVersorgung;
            this.manoevrierFaehigkeit = manoevrierFaehigkeit;
            this.waffenstaerke = waffenstaerke;
            this.ladungen = new ArrayList<>();
            this.ladungskapazitaet = ladungskapazitaet;
            this.scanner = new Scanner(System.in);
        }

        public Kapitaen getKapitaen() {
            return kapitaen;
        }

        public String getName() {
            return name;
        }

        public int getX() {
            return this.posX;

        }
        public int getY(){
            return this.posY;
        }

        public Ladung getLadung() {
            return ladung;
        }

        public void fliegen(char richtung) {
            switch (richtung) {
                case 'w':
                    posY++;
                    break;
                case 's':
                    posY--;
                    break;
                case 'a':
                    posX--;
                    break;
                case 'd':
                    posX++;
                    break;
            }
        }

        public boolean pruefeKoordinaten(int x, int y) {
            return this.posX == x && this.posY == y;
        }

        public void angreifen(Raumschiff gegner) {
            int zufall = (int)(Math.random() * 10) + 1;
            int schaden = this.waffenstaerke * zufall;
            gegner.verteidigen(schaden);
        }

        public void verteidigen(int schaden) {
            int verteidigung = this.energieschild + this.manoevrierFaehigkeit + this.getKapitaen().getErfahrung();
            int endSchaden = schaden - verteidigung;
            if (endSchaden > 0) {
                this.integritaetsgrad -= endSchaden;
                if (this.integritaetsgrad < 0) {
                    this.integritaetsgrad = 0;
                }
            }
        }
        public void addLadung(Ladung ladung) {
            if (getGesamtgewicht() + ladung.getGewicht() <= ladungskapazitaet) {
                ladungen.add(ladung);
            }
        }

        public void removeLadung(Ladung ladung) {
            ladungen.remove(ladung);
        }

        public int getGesamtgewicht() {
            int gesamtgewicht = 0;
            for (Ladung ladung : ladungen) {
                gesamtgewicht += ladung.getGewicht();
            }
            return gesamtgewicht;
        }

        public ArrayList<Ladung> getLadungen() {
            return ladungen;
        }

        public void kaufenLadung(Ladung ladung, Handelsstation station) {
            if (getKapitaen().getGeld() >= ladung.getWert()) {
                addLadung(ladung);
                getKapitaen().setGeld(getKapitaen().getGeld() - ladung.getWert());
                station.removeLadung(ladung);
            }
        }

        public void verkaufenLadung(Ladung ladung, Handelsstation station) {
            removeLadung(ladung);
            getKapitaen().setGeld(getKapitaen().getGeld() + ladung.getWert());
            station.addLadung(ladung);
        }
        public void ressourceAbbauen(Ressource ressource){
            this.ladungen.add(new Ladung(ressource.getName(),ressource.getEinheit(), ressource.getGewicht(), ressource.getWert()));
        }
        public boolean wahlZumAbbauEinerRessource(){
            while(true) {
                System.out.println("Möchten Sie eine Ressource abbauen?");
                System.out.println("JA = 1");
                System.out.println("NEIN = beliebiges zeichen");
                String input = scanner.nextLine();
                if(input.equals("1"))return true;
                else return false;
            }

        }
        public String getTyp(){
            return typ;
        }
        public void setWaffenstaerke(int waffenstaerke){
            this.waffenstaerke = waffenstaerke;
        }

        public int getWaffenstaerke() {
            return waffenstaerke;
        }

        public void setIntegritaetsgrad(int integritaetsgrad) {
            this.integritaetsgrad = integritaetsgrad;
        }
        public int getIntegritaetsgrad(){
            return this.integritaetsgrad;
        }
}

