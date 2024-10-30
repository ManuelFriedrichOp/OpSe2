package gui;
   
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import business.Autovermietung;
import business.AutovermietungModel;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.*;

public class AutovermietungView {
	  
    //---Anfang Attribute der grafischen Oberflaeche---
    public Pane pane     					= new  Pane();
    public Label lblEingabe    	 		= new Label("Eingabe");
    public Label lblAnzeige   	 	    	= new Label("Anzeige");
    public Label lblName 					= new Label("Name:");
    public Label lblGeoeffnetVon   		= new Label("Geöffnet von:");
    public Label lblGeoeffnetBis  	 		= new Label("Geöffnet bis:");
    public Label lblStrasseHNr   			= new Label("Straße und Hausnummer:");
    public Label lblDienstleistungen  		= new Label("Dienstleistungen:");
    public TextField txtName 	 			= new TextField();
    public TextField txtGeoeffnetVon		= new TextField();
    public TextField txtGeoeffnetBis		= new TextField();
    public TextField txtStrasseHNr			= new TextField();
    public TextField txtDienstleistungen	= new TextField();
    public TextArea txtAnzeige  			= new TextArea();
    public Button btnEingabe 		 		= new Button("Eingabe");
    public Button btnAnzeige 		 		= new Button("Anzeige");
    public MenuBar mnbrMenuLeiste  		= new MenuBar();
    public Menu mnDatei             		= new Menu("Datei");
    public MenuItem mnItmCsvImport 		= new MenuItem("csv-Import");
    public MenuItem mnItmTxtImport 		= new MenuItem("txt-Import");
    public MenuItem mnItmCsvExport 		= new MenuItem("csv-Export");    
    //-------Ende Attribute der grafischen Oberflaeche-------
    
    // speichert temporaer ein Objekt vom Typ Autovermietung
    private Autovermietung Autovermietung;
    
    public AutovermietungView(Stage primaryStage, AutovermietungControl avc) {
    	Scene scene = new Scene(this.pane, 700, 340);
    	primaryStage.setScene(scene);
    	primaryStage.setTitle("Verwaltung von Autovermietungenn");
    	primaryStage.show();
    	this.initKomponenten();
		this.initListener(avc);
    }
    
    private void initKomponenten(){
       	// Labels
    	lblEingabe.setLayoutX(20);
    	lblEingabe.setLayoutY(40);
    	Font font = new Font("Arial", 24); 
    	lblEingabe.setFont(font);
    	lblEingabe.setStyle("-fx-font-weight: bold;"); 
    	lblAnzeige.setLayoutX(400);
    	lblAnzeige.setLayoutY(40);
      	lblAnzeige.setFont(font);
       	lblAnzeige.setStyle("-fx-font-weight: bold;"); 
       	lblName.setLayoutX(20);
    	lblName.setLayoutY(90);
    	lblGeoeffnetVon.setLayoutX(20);
    	lblGeoeffnetVon.setLayoutY(130);
    	lblGeoeffnetBis.setLayoutX(20);
    	lblGeoeffnetBis.setLayoutY(170);
    	lblStrasseHNr.setLayoutX(20);
    	lblStrasseHNr.setLayoutY(210);
    	lblDienstleistungen.setLayoutX(20);
    	lblDienstleistungen.setLayoutY(250);    	
       	pane.getChildren().addAll(lblEingabe, lblAnzeige, 
       		lblName, lblGeoeffnetVon, lblGeoeffnetBis,
       		lblStrasseHNr, lblDienstleistungen);
    
    	// Textfelder
     	txtName.setLayoutX(170);
    	txtName.setLayoutY(90);
    	txtName.setPrefWidth(200);
    	txtGeoeffnetVon.setLayoutX(170);
    	txtGeoeffnetVon.setLayoutY(130);
    	txtGeoeffnetVon.setPrefWidth(200);
    	txtGeoeffnetBis.setLayoutX(170);
    	txtGeoeffnetBis.setLayoutY(170);
    	txtGeoeffnetBis.setPrefWidth(200);
      	txtStrasseHNr.setLayoutX(170);
    	txtStrasseHNr.setLayoutY(210);
    	txtStrasseHNr.setPrefWidth(200);
    	txtDienstleistungen.setLayoutX(170);
    	txtDienstleistungen.setLayoutY(250);
    	txtDienstleistungen.setPrefWidth(200);
      	pane.getChildren().addAll( 
     		txtName, txtGeoeffnetVon, txtGeoeffnetBis,
     		txtStrasseHNr, txtDienstleistungen);
     	
        // Textbereich	
        txtAnzeige.setEditable(false);
     	txtAnzeige.setLayoutX(400);
    	txtAnzeige.setLayoutY(90);
     	txtAnzeige.setPrefWidth(270);
    	txtAnzeige.setPrefHeight(185);
       	pane.getChildren().add(txtAnzeige); 
       	
        // Buttons
        btnEingabe.setLayoutX(20);
        btnEingabe.setLayoutY(290);
        btnAnzeige.setLayoutX(400);
        btnAnzeige.setLayoutY(290);
        pane.getChildren().addAll(btnEingabe, btnAnzeige); 
        
 		// Menue
  	    this.mnbrMenuLeiste.getMenus().add(mnDatei);
  	    this.mnDatei.getItems().add(mnItmCsvImport);
  	    this.mnDatei.getItems().add(mnItmTxtImport);
  	    this.mnDatei.getItems().add(new SeparatorMenuItem());
  	    this.mnDatei.getItems().add(mnItmCsvExport);
 	    pane.getChildren().add(mnbrMenuLeiste);
   }
   
   private void initListener(AutovermietungControl avc) {
	    btnEingabe.setOnAction(new EventHandler<ActionEvent>() {      

			@Override
            public void handle(ActionEvent e) {
            	avc.nehmeAutovermietungAuf(txtName.getText(), txtGeoeffnetVon.getText(), txtGeoeffnetBis.getText(), txtStrasseHNr.getText(), txtDienstleistungen.getText());
            }
	    });
	    btnAnzeige.setOnAction(new EventHandler<ActionEvent>() {
	    	@Override
	        public void handle(ActionEvent e) {
	            avc.zeigeAutovermietungenAn();
	        } 
   	    });
	    mnItmCsvImport.setOnAction(new EventHandler<ActionEvent>() {
	    	@Override
	        public void handle(ActionEvent e) {
	       	 	avc.leseAusDatei("csv");
	    	}
	    });
	    mnItmTxtImport.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent e) {
		     	avc.leseAusDatei("txt");
		    }
    	});
	    mnItmCsvExport.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				avc.schreibeAutovermietungenInCsvDatei();
			}	
	    });
    }
    

}
