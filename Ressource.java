public class Ressource {
    private String name;
    private int einheit;
    private int gewicht;
    private int wert;

    public Ressource(String name, int einheit, int gewicht, int wert){
        this.name = name;
        this.einheit = einheit;
        this.gewicht = gewicht;
        this.wert = wert;
    }

    public int getEinheit() {
        return einheit;
    }

    public void setEinheit(int einheit) {
         this.einheit = einheit;
    }

    public int getWert() {
        return wert;
    }

    public int getGewicht() {
        return gewicht;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString(){
        return "Name: "+this.name+", Einheit: "+this.einheit+", gewicht: "+this.gewicht+", Wert"+this.wert;
    }
}
