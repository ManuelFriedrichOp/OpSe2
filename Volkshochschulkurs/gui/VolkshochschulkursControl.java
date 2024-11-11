package gui;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import business.*;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import ownUtil.MeldungsfensterAnzeiger;
import business.Volkshochschulkurs;
import business.VolkshochschulkursModel;

public class VolkshochschulkursControl {
	
	private VolkshochschulkursView view;
	private VolkshochschulkursModel model;
	
	public VolkshochschulkursControl(Stage primaryStage) throws Exception {
		this.model = new VolkshochschulkursModel();
		this.view = new VolkshochschulkursView(primaryStage, this, model);
	}
	
	public void schreibeVolkshochschulkursInDatei(String typ) {
		try {
			if("csv".equals(typ)) {
				this.model.schreibeVolkshochschulkursInCsvDatei();
				this.view.zeigeInformationsfensterAn("Die Volkshochschulkurse wurden gespeichert");
			} 
		else if("txt".equals(typ)){
			this.model.schreibeVolkshochschulkursInTxtDatei();
			this.view.zeigeInformationsfensterAn("Die Haushaltsroboter wurden gespeichert");
		}else {
				this.view.zeigeInformationsfensterAn("Noch nicht implementiert");
			}
		} 
		catch (IOException ioe) {
			view.zeigeFehlermeldungsfensterAn("IOException");
			ioe.printStackTrace();
		} catch(Exception exc) {
			view.zeigeFehlermeldungsfensterAn("Unbekannter Fehler beim Speichern!");
			exc.printStackTrace();
		} 
	}
	public void leseAusDatei(String typ){
    	try {
      		if("csv".equals(typ)){
      			BufferedReader ein = new BufferedReader(new FileReader("Volkshochschulkurs.csv"));
      			String[] zeile = ein.readLine().split(";");
      			this.model.setVhk(new Volkshochschulkurs(zeile[0], 
          				(zeile[1]), 
          				(zeile[2]), 
          				zeile[3], zeile[4].split("_")));
      				ein.close();
      				view.zeigeInformationsfensterAn("Die Volkshochschulkurs wurden gelesen!");      
      		}
       		else{
       			view.zeigeInformationsfensterAn("Noch nicht implementiert!");
	   		}
		}
		catch(IOException exc){
			view.zeigeFehlermeldungsfensterAn(
				"IOException beim Lesen!");
		}
		catch(Exception exc){
			view.zeigeFehlermeldungsfensterAn(
				"Unbekannter Fehler beim Lesen!");
		}
	}
}