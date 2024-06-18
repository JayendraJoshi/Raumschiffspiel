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
        raumschiff.setIntegritaetsgrad(100);
        System.out.println("Das Raumschiff wurde repariert, der Integritaetsgrad beträgt wieder 100");
    }

    public void aufruesten(Raumschiff raumschiff) {
        raumschiff.setWaffenstaerke(raumschiff.getWaffenstaerke() + 10);
    }

    public int getPosX() {
        return posX;
    }
    public int getPosY(){
        return posY;
    }
    public String getName(){
        return name;
    }

}