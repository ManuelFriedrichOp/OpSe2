package gui;

import business.VolkshochschulkursModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.MeldungsfensterAnzeiger;

public class KurseuebersichtView {
	
	private KurseuebersichtControl
	kurseuebersichtControl;
	private VolkshochschulkursModel kursmodel;	
	
	//---Anfang Attribute der grafischen Oberflaeche---
	private Pane pane = new  Pane();
	private Label lblAnzeigeKurse     
	= new Label("Anzeige Kurse");
	private TextArea txtAnzeigeKurse  = new TextArea();
	
	private Button btnAnzeigeKurse = new Button("Anzeige");
	//-------Ende Attribute der grafischen Oberflaeche-------

	public KurseuebersichtView(
			
		KurseuebersichtControl KurseuebersichtControl, 
		Stage primaryStage, 
		VolkshochschulkursModel kursmodel){
		Scene scene = new Scene(this.pane, 560, 340);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Anzeige von Fahrzeugen");
		primaryStage.show();
		this.kurseuebersichtControl = kurseuebersichtControl;
		this.kursmodel = kursmodel;
		this.initKomponenten();
		this.initListener();
		
	}

 	private void initKomponenten(){
    		// Label
 		Font font = new Font("Arial", 20);
       	lblAnzeigeKurse.setLayoutX(310);
    	lblAnzeigeKurse.setLayoutY(40);
    	lblAnzeigeKurse.setFont(font);
    	lblAnzeigeKurse.setStyle("-fx-font-weight: bold;"); 
       	pane.getChildren().add(lblAnzeigeKurse);           
// Textbereich	
        	txtAnzeigeKurse.setEditable(false);
     		txtAnzeigeKurse.setLayoutX(310);
    		txtAnzeigeKurse.setLayoutY(90);
     		txtAnzeigeKurse.setPrefWidth(220);
    		txtAnzeigeKurse.setPrefHeight(185);
       	pane.getChildren().add(txtAnzeigeKurse);        	
        	// Button
          	btnAnzeigeKurse.setLayoutX(310);
        	btnAnzeigeKurse.setLayoutY(290);
        	pane.getChildren().add(btnAnzeigeKurse); 
   }
   
   private void initListener() {
	    btnAnzeigeKurse.setOnAction(
 			new EventHandler<ActionEvent>() {
	    		@Override
	        	public void handle(ActionEvent e) {
	            	zeigeKurseAn();
	        	} 
   	    });
    }
   
    public void zeigeKurseAn(){
    		if(kursmodel.getVhk() != null){
    			txtAnzeigeKurse.setText(
    				kursmodel.getVhk()
 				.gibVolkshochschulkursZurueck(' '));
    		}
    		else{
    			zeigeInformationsfensterAn(
 				"Bisher wurde kein Kurs aufgenommen!");
    		}
    }	
   
    private void zeigeInformationsfensterAn(String meldung){
    	  	new MeldungsfensterAnzeiger(AlertType.INFORMATION,
               	"Information", meldung).zeigeMeldungsfensterAn();
    }	
    
}