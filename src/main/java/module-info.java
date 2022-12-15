module frontend.kreditpruefung {
    requires javafx.controls;
    requires javafx.fxml;


    opens frontend.kreditpruefung to javafx.fxml;
    exports frontend.kreditpruefung;
}