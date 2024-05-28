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
        private int waffenstaerke;

        public Raumschiff(String name,int posX, int posY, Kapitaen kapitaen,int integritaetsgrad, int energieschild, int energieVersorgung, int manoevrierFaehigkeit, int waffenstaerke) {
            this.name = name;
            this.posX = posX;
            this.posY = posY;
            this.kapitaen = kapitaen;
            this.integritaetsgrad = integritaetsgrad;
            this.energieschild = energieschild;
            this.energieVersorgung = energieVersorgung;
            this.manoevrierFaehigkeit = manoevrierFaehigkeit;
            this.waffenstaerke = waffenstaerke;
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
        public void addLadung(Ladung ladung) {
            this.ladung = ladung;
        }

        public void removeLadung() {
            this.ladung = null;
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
            gegner.vertiedigen(schaden);
        }

        public void vertiedigen(int schaden) {
            int verteidigung = this.energieschild + this.manoevrierFaehigkeit + this.getKapitaen().getErfahrung();
            int endSchaden = schaden - verteidigung;
            if (endSchaden > 0) {
                this.integritaetsgrad -= endSchaden;
                if (this.integritaetsgrad < 0) {
                    this.integritaetsgrad = 0;
                }
            }
        }
}

