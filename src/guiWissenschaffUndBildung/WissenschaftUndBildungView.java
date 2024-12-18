package guiWissenschaffUndBildung;
   
import business.Volkshochschulkurs;
import business.VolkshochschulkursModel;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.*;

public class WissenschaftUndBildungView {
	
	private WissenschaftUndBildungControl wissenschaftUndBildungControl;
	private VolkshochschulkursModel volkshochschulkurseModel;	

    	//---Anfang Attribute der grafischen Oberflaeche---
    	private Pane pane = new  Pane();
    	private Label lblAnzeigeVolkshochschulkurse     
 		= new Label("Anzeige Volkshochschulkurse");
    	private TextArea txtAnzeigeVolkshochschulkurse  = new TextArea();
    	private Button btnAnzeigeVolkshochschulkurse 
 		= new Button("Anzeige");
    	//-------Ende Attribute der grafischen Oberflaeche-------
    
    	public WissenschaftUndBildungView(
 		WissenschaftUndBildungControl wissenschaftUndBildungControl, 
   	 	Stage primaryStage, 
 		VolkshochschulkursModel volkshochschulkurseModel){
    		Scene scene = new Scene(this.pane, 560, 340);
    		primaryStage.setScene(scene);
    		primaryStage.setTitle("Anzeige von Bildungsangeboten" );
    		primaryStage.show();
    		this.wissenschaftUndBildungControl = wissenschaftUndBildungControl;
 		this.volkshochschulkurseModel = volkshochschulkurseModel;
 		this.initKomponenten();
		this.initListener();
    	}

 	private void initKomponenten(){
    		// Label
 		Font font = new Font("Arial", 20);
       	lblAnzeigeVolkshochschulkurse.setLayoutX(310);
    		lblAnzeigeVolkshochschulkurse.setLayoutY(40);
    		lblAnzeigeVolkshochschulkurse.setFont(font);
    		lblAnzeigeVolkshochschulkurse.setStyle("fx-font-weight: bold;"); 
       	pane.getChildren().add(lblAnzeigeVolkshochschulkurse);           
// Textbereich	
        	txtAnzeigeVolkshochschulkurse.setEditable(false);
     		txtAnzeigeVolkshochschulkurse.setLayoutX(310);
    		txtAnzeigeVolkshochschulkurse.setLayoutY(90);
     		txtAnzeigeVolkshochschulkurse.setPrefWidth(220);
    		txtAnzeigeVolkshochschulkurse.setPrefHeight(185);
       	pane.getChildren().add(txtAnzeigeVolkshochschulkurse);    	
        	// Button
          	btnAnzeigeVolkshochschulkurse.setLayoutX(310);
        	btnAnzeigeVolkshochschulkurse.setLayoutY(290);
        	pane.getChildren().add(btnAnzeigeVolkshochschulkurse); 
   }
   
   private void initListener() {
	    btnAnzeigeVolkshochschulkurse.setOnAction(
 			new EventHandler<ActionEvent>() {
	    		@Override
	        	public void handle(ActionEvent e) {
	            	zeigeVolkshochschulkurseAn();
	        	} 
   	    });
    }
   
    public void zeigeVolkshochschulkurseAn(){
    		//if(volkshochschulkurseModel.getVhk()!= null){
    		//	txtAnzeigeVolkshochschulkurse.setText(volkshochschulkurseModel.getVhk().gibVolkshochschulkursZurueck(' '));
    		//}
    		//else{
    		//	zeigeInformationsfensterAn("Bisher wurde kein Volkshochschulkurs " + "aufgenommen!");
    		//} 
    	if(this.volkshochschulkurseModel.getVhk().size() > 0) {
     		StringBuffer text = new StringBuffer();
     		for(Volkshochschulkurs m : this.volkshochschulkurseModel.getVhk()) {
     			text.append(m.gibVolkshochschulkursZurueck(' '));
     		}
     		txtAnzeigeVolkshochschulkurse.setText(text.toString());
     	}
     	else{
     		zeigeInformationsfensterAn("Bisher wurde kein Volkshochschulkurs aufgenommen!");
     	}
    }	
   
    private void zeigeInformationsfensterAn(String meldung){
    	  	new MeldungsfensterAnzeiger(AlertType.INFORMATION,
               	"Information", meldung).zeigeMeldungsfensterAn();
    }	
    
}
