public class Raumschiff {
        private String name;
        private int posX;
        private int posY;
        private Kapitaen kapitaen;

        public Raumschiff(String name,int posX, int posY, Kapitaen kapitaen) {
            this.name = name;
            this.posX = posX;
            this.posY = posY;
            this.kapitaen = kapitaen;
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
}

