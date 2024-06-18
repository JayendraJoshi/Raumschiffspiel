public class Ladung {
    private String name;
    private int einheiten;
    private int gewicht;
    private int wert;

    public Ladung(String name, int einheiten, int gewicht, int wert) {
        this.name = name;
        this.einheiten = einheiten;
        this.gewicht = gewicht;
        this.wert =wert;
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
    public int getGewicht(){
        return gewicht;
    }
    public int getWert(){
        return wert;
    }

    public void setEinheiten(int einheiten) {
        this.einheiten = einheiten;
    }



    public String toString(){
        return "Name: "+ this.name+" ,Einheit: "+this.einheiten+" ,Gewicht: "+this.gewicht+" ,Wert: "+this.wert;
    }
}