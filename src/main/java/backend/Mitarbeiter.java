package backend;

public class Mitarbeiter extends Person{
    private Integer vorgesetzter;

    public Mitarbeiter(int id, String vorname, String nachname, String username, String passwort, Rolle rolle, Integer vorgesetzter) {
        super(id, vorname, nachname, username, passwort, rolle);
        this.vorgesetzter = vorgesetzter;
    }
}
