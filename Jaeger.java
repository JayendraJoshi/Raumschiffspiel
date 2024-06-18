public class Jaeger extends Raumschiff {

    public Jaeger(String name, int posX, int posY, Kapitaen kapitaen, int energieschild, int energieVersorgung, int manoevrierFaehigkeit, int waffenstaerke, int ladungskapazitaet) {
        super(name, posX, posY, kapitaen, energieschild, energieVersorgung, manoevrierFaehigkeit, waffenstaerke, ladungskapazitaet);
        this.typ = "Jaeger";
        this.waffenstaerke += 20;
    }

    @Override
    public String toString() {
        return "Jaeger: " + super.toString();
    }
}