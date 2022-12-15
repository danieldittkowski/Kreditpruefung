package frontend.login;

import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;

import database.DatabaseController;
import backend.Person;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginController implements Initializable {

	@FXML
	private PasswordField pwfield;
	@FXML
	private TextField benutzerNTxtfield;
	@FXML
	private Button BestaetigenBtn;
	

	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

	public void BestaetigenBtn_OnAction() {
		
		DatabaseController db = new DatabaseController();
        String dbName = "Kreditpruefung";
        Connection connection = db.connectToDatabase(dbName, "postgres", "ihbuha27.4G");
		
		
		Person p = db.getPersonByUsername(connection, benutzerNTxtfield.getText());
		
		if (p.getUsername() != null && pwfield.getText().equals(p.getPasswort())) {
			try {
				Stage pruefstage = new Stage();
				
				AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/window_pruefbereich/Pruefbereich.fxml"));
				
				Scene scene = new Scene(root,400,400);
				scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
				
				
				
				pruefstage.setScene(scene);
				pruefstage.setTitle("Pruefbereich");
				pruefstage.centerOnScreen();
				pruefstage.show();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		else
		
		if (benutzerNTxtfield.getText().equals("ge") && pwfield.getText().equals("pw")) {
			try {
				Stage pruefstage = new Stage();
				
				AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/window_gs/Geschfaeftsfuehrung.fxml"));
				
				Scene scene = new Scene(root,400,400);
				scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
				
				
				
				pruefstage.setScene(scene);
				pruefstage.setTitle("Geschäftsführung");
				pruefstage.centerOnScreen();
				pruefstage.show();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	public  String getsfromTxt() {
		// TODO Auto-generated method stub
		return benutzerNTxtfield.getText();
	}

}
