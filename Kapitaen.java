public class Kapitaen {
    private String name;
    private int charisma;
    private int erfahrung;

    public Kapitaen(String name, int charisma, int erfahrung) {
        this.name = name;
        this.charisma = charisma;
        this.erfahrung = erfahrung;
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

    public void diplomatischeVerhandlung() {
        int zufall = (int)(Math.random() * 10) + 1;
        if (zufall <= 5) {
            System.out.println("Die Verhandlung war erfolgreich!");
        } else {
            System.out.println("Die Verhandlung war nicht erfolgreich.");
        }
    }
}