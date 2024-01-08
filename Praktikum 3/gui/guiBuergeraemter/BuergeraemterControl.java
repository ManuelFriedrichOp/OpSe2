package gui.guiBuergeraemter;

import java.io.IOException;
import business.*;
import javafx.stage.Stage;
import ownUtil.Observer;

public class BuergeraemterControl implements Observer {
	
	private BuergeraemterModel buergeraemterModel;
	private BuergeraemterView buergeraemterView;
	
	public BuergeraemterControl(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		// Singleton
		this.buergeraemterModel = BuergeraemterModel.getInstance();
		this.buergeraemterView = new BuergeraemterView(primaryStage, this, buergeraemterModel);
		this.buergeraemterModel.addObserver(this);
	}
	
	public void schreibeBuergeraemterInDatei(String typ) {
		try {
			if("csv".equals(typ)) {
				this.buergeraemterModel.schreibeBuergeraemterInCsvDatei();
				this.buergeraemterView.zeigeInformationsfensterAn("Die Buegeraemte wurden gespeichert");
			} else if("txt".equals(typ)) {
				this.buergeraemterModel.schreibeBuergeraemterInTxtDatei();
				this.buergeraemterView.zeigeInformationsfensterAn("Die Buegeraemte wurden gespeichert");
			} else{
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

	@Override
	public void update() {
		// TODO Auto-generated method stub
		this.buergeraemterView.zeigeBuergeraemterAn();
	}
	
}

