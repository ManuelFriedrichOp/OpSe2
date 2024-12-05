package gui;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import business.*;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import ownUtil.MeldungsfensterAnzeiger;
import business.Volkshochschulkurs;
import business.VolkshochschulkursModel;

public class VolkshochschulkursControl implements Observer {
	
	VolkshochschulkursView view;
	public VolkshochschulkursModel model;
	
	public VolkshochschulkursControl(Stage primaryStage) throws Exception {
		this.model = VolkshochschulkursModel.getInstance(this);
		model.observers.add(this);
		this.view = new VolkshochschulkursView(primaryStage, this);
	}
	
	public void schreibeVolkshochschulkursInDatei(String typ) {
		try {
			if("csv".equals(typ)) {
				this.model.schreibeVolkshochschulkursInCsvDatei();
				this.view.zeigeInformationsfensterAn("Volkshochschulkurs wurde gespeichert");
			} else {
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
			if("csv".equals(typ)) {
				this.model.leseVolkshochschulkursAusCsvDatei();
				this.view.zeigeInformationsfensterAn("Volkshochschulkurs wurde importiert");
			} 
			else if("txt".equals(typ)) {
				this.model.leseVolkshochschulkursAusTxtDatei();
				this.view.zeigeInformationsfensterAn("Volkshochschulkurs wurde importiert");
			}
			else {
				this.view.zeigeInformationsfensterAn("Noch nicht implementiert");
			}
		} 
		catch (IOException ioe) {
			view.zeigeFehlermeldungsfensterAn("IOException");
			ioe.printStackTrace();
		} catch(Exception exc) {
			view.zeigeFehlermeldungsfensterAn("Unbekannter Fehler beim Importieren!");
			exc.printStackTrace();
		} 
	}
	
	  public void nehmeKurseAuf(String name, String wochentag, String uhrzeit, String kursbeitrag, String vorkenntnisse){
	    	try{
	    		Volkshochschulkurs vhk = new Volkshochschulkurs(
	    			name,
	   	            wochentag,
	   	            uhrzeit,
	   	            kursbeitrag,
	   	            vorkenntnisse.split(";"));
	    		model.setVhk(vhk);
	    		zeigeInformationsfensterAn("Der Kurs wurde aufgenommen!");
	       	}
	       	catch(Exception exc){
	       		System.out.println(exc.getMessage());
	       		zeigeFehlermeldungsfensterAn(exc.getMessage());
	     	}
	    }
	
	  public void zeigeInformationsfensterAn(String meldung){
	    	new MeldungsfensterAnzeiger(AlertType.INFORMATION,
	    		"Information", meldung).zeigeMeldungsfensterAn();
	    }	
	    
	   public void zeigeFehlermeldungsfensterAn(String meldung){
	       	new MeldungsfensterAnzeiger(AlertType.ERROR,
	        	"Fehler", meldung).zeigeMeldungsfensterAn();
	    }
	    
	   public void zeigeKurseAn(){
	    	if(model.getVhk() != null){
	    		view.txtAnzeige.setText(
	    			model.getVhk().gibVolkshochschulkursZurueck(' '));
	    	}
	    	else{
	    		zeigeInformationsfensterAn("Bisher wurde keine kurse aufgenommen!");
	    	}
	    }   

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		zeigeKurseAn();
	}
}