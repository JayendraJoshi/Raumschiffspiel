public class Asteroidenfeld {
    private int gefahrenpotential;
    private int posX;
    private int posY;

    public Asteroidenfeld(int gefahrenpotential, int posX, int posY) {
        this.gefahrenpotential = gefahrenpotential;
        this.posX = posX;
        this.posY = posY;
    }

    public int getGefahrenpotential() {
        return gefahrenpotential;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }
}