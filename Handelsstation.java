import java.util.ArrayList;

public class Handelsstation {
    private String name;
    private ArrayList<Ladung> ladungen;
    private int posX;
    private int posY;

    public Handelsstation(String name, Ladung ladung, int posX,int posY) {
        this.name = name;
        this.ladungen = new ArrayList<>();
        this.ladungen.add(ladung);
        this.posY = posY;
        this.posX = posX;
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

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public String getName(){
        return this.name;
    }
    public void printLadungen(){
        int i =0;
        for(Ladung l: ladungen){
            System.out.println(i+": "+l);
            i++;
        }
    }
    public Ladung getLadung(int nummer){
        if(this.ladungen.size()-1>=nummer){
            if(this.ladungen.get(nummer).getEinheiten()>=1){
                this.ladungen.get(nummer).setEinheiten(this.ladungen.get(nummer).getEinheiten()-1);
                return new Ladung(ladungen.get(nummer).getName(),1,ladungen.get(nummer).getGewicht(),ladungen.get(nummer).getWert());
            }
        }
        return null;
    }
}