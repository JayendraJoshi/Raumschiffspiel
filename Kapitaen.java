public class Kapitaen {
    private String name;
    private int charisma;
    private int erfahrung;
    private int geld;

    public Kapitaen(String name, int charisma, int erfahrung, int geld) {
        this.name = name;
        this.charisma = charisma;
        this.erfahrung = erfahrung;
        this.geld = geld;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    public int getErfahrung() {
        return erfahrung;
    }

    public void setErfahrung(int erfahrung) {
        this.erfahrung = erfahrung;
    }

    public int getGeld(){
        return geld;
    }
    public void setGeld(int geld){
        this.geld = geld;
    }

    public void diplomatischeVerhandlung() {
        int zufall = (int)(Math.random() * 10) + 1;
        if (zufall <= 5) {
            System.out.println("Die Verhandlung war erfolgreich!");
        } else {
            System.out.println("Die Verhandlung war nicht erfolgreich.");
        }
    }
}