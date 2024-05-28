public class Planet {
    private String name;
    private boolean atmosphare;
    private int posX;
    private int posY;
    private Ladung ladung;

    public Planet(String name, boolean atmosphare, int posX, int posY) {
        this.name = name;
        this.atmosphare = atmosphare;
        this.posX = posX;
        this.posY = posY;
    }

    public String getName() {
        return name;
    }

    public boolean getAtmosphare() {
        return atmosphare;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
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

}