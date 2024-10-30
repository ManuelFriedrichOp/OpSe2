package gui;

import business.Autovermietung;
import business.AutovermietungModel;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import ownUtil.MeldungsfensterAnzeiger;

public class AutovermietungControl {
	
	AutovermietungView avv;
	public AutovermietungModel avm;
	
	public AutovermietungControl(Stage primaryStage) {
		this.avm = new AutovermietungModel(this);
		this.avv = new AutovermietungView(primaryStage, this);
	}
	
	
    public void nehmeAutovermietungAuf(String text, String von, String bis, String adresse, String dienstleistungen){
    	try{
    		Autovermietung av = new Autovermietung(
    			text,
   	            Float.parseFloat(von),
   	            Float.parseFloat(bis),
   	         adresse,
   	        dienstleistungen.split(";"));
    		avm.setAv(av);
    		zeigeInformationsfensterAn("Das Autovermietung wurde aufgenommen!");
       	}
       	catch(Exception exc){
       		System.out.println(exc.getMessage());
       		zeigeFehlermeldungsfensterAn(exc.getMessage());
     	}
    }
   
    public void zeigeAutovermietungenAn(){
    	if(avm.getAv() != null){
    		avv.txtAnzeige.setText(
    			avm.getAv().gibAutovermietungZurueck(' '));
    	}
    	else{
    		zeigeInformationsfensterAn("Bisher wurde kein Autovermietung aufgenommen!");
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
    
    public void leseAusDatei(String typ) {
    	avm.leseAusDatei(typ);
    }
    
    public void schreibeAutovermietungenInCsvDatei() {
    	avm.schreibeAutovermietungenInCsvDatei();
    }

}
