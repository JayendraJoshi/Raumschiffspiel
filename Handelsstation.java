import java.util.ArrayList;

public class Handelsstation {
    private String name;
    private ArrayList<Ladung> ladungen;

    public Handelsstation(String name) {
        this.name = name;
        this.ladungen = new ArrayList<>();
    }

    public void addLadung(Ladung ladung) {
        ladungen.add(ladung);
    }

    public void removeLadung(Ladung ladung) {
        ladungen.remove(ladung);
    }

    public ArrayList<Ladung> getLadungen() {
        return ladungen;
    }
}