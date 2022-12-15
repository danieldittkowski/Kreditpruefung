package backend;

public enum Rolle {
    KUNDE("kunde"),
    MITARBEITER("mitarbeiter");

    final String value;

    Rolle(String value) {this.value = value;};
}
