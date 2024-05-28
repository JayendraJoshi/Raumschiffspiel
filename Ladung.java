public class Ladung {
    private String name;
    private int einheiten;

    public Ladung(String name, int einheiten) {
        this.name = name;
        this.einheiten = einheiten;
    }

    public Ladung() {
        this.name = "Leerladung";
        this.einheiten = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEinheiten() {
        return einheiten;
    }

    public void setEinheiten(int einheiten) {
        this.einheiten = einheiten;
    }
}