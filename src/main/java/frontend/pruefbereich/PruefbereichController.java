package frontend.pruefbereich;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PruefbereichController extends frontend.geschäftsführung.GeschaeftsfuehrungController implements Initializable {

	@FXML
	public TextField summeTxtField;
	
	
	
	@FXML
	private TextField zeitTxtField;
	
	@FXML
    public Label eLabel;
	
	public static Label stceLabel;
	
	public int summe;
	public static int stsumme;
	int zeit; 

	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		stceLabel = eLabel;
		stsumme = summe;
		
	}
	


	public void BeantragenBtn_OnAction(ActionEvent event) {

		//try {
	
	int bonitaet = 300000;
	String name = "Daniel";
	
		
		
			setSumme(Integer.parseInt(summeTxtField.getText()));
			zeit = Integer.parseInt(zeitTxtField.getText());
			
			if ((summe < 5000000) && (summe < bonitaet) ) {
				eLabel.setText("Kredit von: " + summe + "€ wurde genehmigt");
			
			} 
			
			else if ( summe > 499999) {
			
				eLabel.setText("Ihr Kreditantrag wird bearbeitet");
				frontend.geschäftsführung.GeschaeftsfuehrungController.stcLabel.setText("Kredit von " + name + " in Höhe von: " + summe + "€");
				frontend.geschäftsführung.GeschaeftsfuehrungController.stgsumme = summe;
				
			
				
				
			}
			//eLabel.isVisible();
			
//			Stage pruefstage = new Stage();
//
//			AnchorPane root = (AnchorPane) FXMLLoader
//					.load(getClass().getResource("/window_AntragErfolgreich/AntragErfolgreich.fxml"));
//
//			Scene scene = new Scene(root, 400, 400);
//			scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
//			
//			
//			pruefstage.setScene(scene);
//			pruefstage.setTitle("Pruefbereich");
//			pruefstage.centerOnScreen();
//			pruefstage.show();

//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	public  int getSumme() {
		return summe;
	}

	public void setSumme(int summe) {
		this.summe = summe;
	}
}


