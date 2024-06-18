public class Raumstation {
    private String name;
    private int posX;
    private int posY;

    public Raumstation(String name, int posX, int posY) {
        this.name = name;
        this.posX = posX;
        this.posY = posY;
    }

    public void reparieren(Raumschiff raumschiff) {
        // Reparatur erhöht den Integritätsgrad des Raumschiffs
        raumschiff.setIntegritaetsgrad(100);
    }

    public void aufruesten(Raumschiff raumschiff) {
        // Aufrüstung erhöht die Waffenstärke des Raumschiffs
        raumschiff.setWaffenstaerke(raumschiff.getWaffenstaerke() + 10);
    }

    public int getPosX() {
        return posX;
    }
    public int getPosY(){
        return posY;
    }
}