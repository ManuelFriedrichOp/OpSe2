package gui;

import java.io.IOException;
import business.*;
import javafx.stage.Stage;

public class BuergeraemterControl{
	
	private BuergeraemterModel buergeraemterModel;
	private BuergeraemterView buergeraemterView;
	
	public  BuergeraemterControl(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		this.buergeraemterModel = new BuergeraemterModel();
		this.buergeraemterView = new BuergeraemterView(primaryStage, this, buergeraemterModel);
	}

	
	public void schreibeBuergeraemterInDatei(String typ) {
		try {
			if("csv".equals(typ)) {
				this.buergeraemterModel.schreibeBuergeraemterInCsvDatei();
				this.buergeraemterView.zeigeInformationsfensterAn("Die Buegeraemte wurden gespeichert");
			} else {
				this.buergeraemterView.zeigeInformationsfensterAn("Noch nicht implementiert");
			}
		} 
		catch (IOException ioe) {
			buergeraemterView.zeigeFehlermeldungsfensterAn("IOException");
			ioe.printStackTrace();
		} catch(Exception exc) {
			buergeraemterView.zeigeFehlermeldungsfensterAn("Unbekannter Fehler beim Speichern!");
			exc.printStackTrace();
		} 
	}
	
}

