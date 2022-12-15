module frontend {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens frontend.kreditpruefung to javafx.fxml;
}