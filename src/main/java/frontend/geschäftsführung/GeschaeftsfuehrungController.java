package frontend.geschäftsführung;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import frontend.pruefbereich.PruefbereichController;

public class GeschaeftsfuehrungController implements Initializable {
	
	
	
	@FXML
	public Label cLabel;
	
	public static Label stcLabel;
	
	public int gsumme;
	public static int stgsumme;



	

	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		stcLabel=cLabel;
		stgsumme=gsumme;
	}

	public void annehmengs(ActionEvent event) {
		
		
			System.out.println(stgsumme);
			System.out.println(gsumme);
			PruefbereichController.stceLabel.setText("Kredit von: " + stgsumme + "€ wurde genehmigt");
			PruefbereichController.stceLabel.setTextFill(Color.GREEN);
			cLabel.setText("");
		
		
	}

	public void ablehnengs(ActionEvent event) {
		
		
		PruefbereichController.stceLabel.setText("Kredit von: " + stgsumme + "€ wurde abgelehnt");
		PruefbereichController.stceLabel.setTextFill(Color.DARKRED);
		cLabel.setText("");
	}
	
	
	
	
}


