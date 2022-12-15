package backend;

import java.util.Scanner;

public class Kunde extends Person{

    public Kunde(int id, String vorname, String nachname, String username, String password, Rolle rolle) {
        super(id, vorname, nachname, username, password, rolle);
    }
}
