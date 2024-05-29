import java.util.ArrayList;

public class KosmischesNachrichtenarchiv {
    private static ArrayList<Nachricht> nachrichten = new ArrayList<>();

    public void nachrichtHinzufuegen(Nachricht nachricht) {
        nachrichten.add(nachricht);
    }

    public ArrayList<Nachricht> alleNachrichtenAbrufen() {
        return nachrichten;
    }
}