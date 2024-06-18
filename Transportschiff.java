public class Transportschiff extends Raumschiff {
    public Transportschiff(String name, int posX, int posY, Kapitaen kapitaen, int energieschild, int energieVersorgung, int manoevrierFaehigkeit, int waffenstaerke, int ladungskapazitaet) {
        super(name, posX, posY, kapitaen, energieschild, energieVersorgung, manoevrierFaehigkeit, waffenstaerke, ladungskapazitaet);
        this.typ = "Transportschiff";
        this.ladungskapazitaet +=1000;
    }

    @Override
    public String toString() {
        return "Transportschiff: " + super.toString();
    }
}