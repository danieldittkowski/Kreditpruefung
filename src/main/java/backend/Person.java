package backend;

public abstract class Person {
    private int id;
    private String vorname;
    private String nachname;
    private String username;
    private String passwort;
    private Rolle rolle;

    /*
    Konstruktoren
     */
    public Person() {}

    public Person(int id, String vorname, String nachname, String username, String passwort, Rolle rolle) {
        this.id = id;
        this.vorname = vorname;
        this.nachname = nachname;
        this.username = username;
        this.passwort = passwort;
        this.rolle = rolle;
    }

    /*
    Setter und Getter
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswort() {
        return passwort;
    }

    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }

    public Rolle getRolle() {
        return rolle;
    }

    public void setRolle(Rolle rolle) {
        this.rolle = rolle;
    }
}
