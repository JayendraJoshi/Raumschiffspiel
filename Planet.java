import java.util.ArrayList;

public class Planet {
    private String name;
    private boolean atmosphare;
    private int posX;
    private int posY;
    private ArrayList<Ressource> ressourcen;

    public Planet(String name, boolean atmosphare, int posX, int posY,Ressource ressource) {
        this.name = name;
        this.atmosphare = atmosphare;
        this.posX = posX;
        this.posY = posY;
        ressourcen = new ArrayList<>();
        this.ressourcen.add(ressource);
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
    public Ressource getRessource(int nummer){
        if(this.ressourcen.size()-1>=nummer){
            if(this.ressourcen.get(nummer).getEinheit()>=1){
                this.ressourcen.get(nummer).setEinheit(this.ressourcen.get(nummer).getEinheit()-1);
                return new Ressource(ressourcen.get(nummer).getName(),1,ressourcen.get(nummer).getGewicht(),ressourcen.get(nummer).getWert());
            }
        }
        return null;
    }

    public void showRessourcen(){
        System.out.println("Ressourcen: ");
        int i =0;
        for(Ressource r: ressourcen){
            System.out.println(i+": "+r);
            i++;
        }
    }


}