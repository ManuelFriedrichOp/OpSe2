package guiVolkshochschulkurs;
   
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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
import ownUtil.MeldungsfensterAnzeiger;


public class VolkshochschulkursView {
	  
    //---Anfang Attribute der grafischen Oberflaeche---
    public Pane pane     					= new  Pane();
    public Label lblEingabe    	 		= new Label("Eingabe");
    public Label lblAnzeige   	 	    	= new Label("Anzeige");
    public Label lblName 					= new Label("Name:");
    public Label lblWochentag   		= new Label("Wochentag :");
    public Label lblStartuhrzeit	 		= new Label("Startuhrzeit:");
    public Label lblKursbeitrag  			= new Label("Kursbeitrag:");
    public Label lblVorkenntnisse  		= new Label("Vorkenntnisse:");
    public TextField txtName 	 			= new TextField();
    public TextField txtWochentag		= new TextField();
    public TextField txtStartuhrzeit		= new TextField();
    public TextField txtKursbeitrag		= new TextField();
    public TextField txtVorkenntnisse	= new TextField();
    public TextArea txtAnzeige  			= new TextArea();
    public Button btnEingabe 		 		= new Button("Eingabe");
    public Button btnAnzeige 		 		= new Button("Anzeige");
    public MenuBar mnbrMenuLeiste  		= new MenuBar();
    public Menu mnDatei             		= new Menu("Datei");
    public MenuItem mnItmCsvImport 		= new MenuItem("csv-Import");
    public MenuItem mnItmTxtImport 		= new MenuItem("txt-Import");
    public MenuItem mnItmCsvExport 		= new MenuItem("csv-Export");   
    public MenuItem mnItmTxtExport 		= new MenuItem("txt-Export");
    //-------Ende Attribute der grafischen Oberflaeche-------
    
    // speichert temporaer ein Objekt vom Typ Volkshochschulkurs
    private VolkshochschulkursControl control;
    private VolkshochschulkursModel model;
    
    public VolkshochschulkursView(Stage primaryStage, VolkshochschulkursControl control,VolkshochschulkursModel model){
     	this.control = control;
 		this.model = model;
 		Scene scene = new Scene(this.pane, 700, 340);
     	primaryStage.setScene(scene);
     	primaryStage.setTitle("Verwaltung von Volkshochschulkurs");
     	primaryStage.show();
     	this.initKomponenten();
 		this.initListener();
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
    	lblWochentag.setLayoutX(20);
    	lblWochentag.setLayoutY(130);
    	lblStartuhrzeit.setLayoutX(20);
    	lblStartuhrzeit.setLayoutY(170);
    	lblKursbeitrag.setLayoutX(20);
    	lblKursbeitrag.setLayoutY(210);
    	lblVorkenntnisse.setLayoutX(20);
    	lblVorkenntnisse.setLayoutY(250);    	
       	pane.getChildren().addAll(lblEingabe, lblAnzeige, 
       		lblName, lblWochentag, lblStartuhrzeit,
       		lblKursbeitrag, lblVorkenntnisse);
    
    	// Textfelder
     	txtName.setLayoutX(170);
    	txtName.setLayoutY(90);
    	txtName.setPrefWidth(200);
    	txtWochentag.setLayoutX(170);
    	txtWochentag.setLayoutY(130);
    	txtWochentag.setPrefWidth(200);
    	txtStartuhrzeit.setLayoutX(170);
    	txtStartuhrzeit.setLayoutY(170);
    	txtStartuhrzeit.setPrefWidth(200);
      	txtKursbeitrag.setLayoutX(170);
    	txtKursbeitrag.setLayoutY(210);
    	txtKursbeitrag.setPrefWidth(200);
    	txtVorkenntnisse.setLayoutX(170);
    	txtVorkenntnisse.setLayoutY(250);
    	txtVorkenntnisse.setPrefWidth(200);
      	pane.getChildren().addAll( 
     		txtName, txtWochentag, txtStartuhrzeit,
     		txtKursbeitrag, txtVorkenntnisse);
     	
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
  	    this.mnDatei.getItems().add(mnItmCsvExport);
  	    this.mnDatei.getItems().add(mnItmCsvImport);
  	    this.mnDatei.getItems().add(mnItmTxtImport);
 	    pane.getChildren().add(mnbrMenuLeiste);
   }
   
    private void initListener() {
 	   
 	   mnItmCsvExport.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
         	   schreibeVolkshochschulkursInDatei("csv");
            }
 	   });
 	  mnItmCsvImport.setOnAction(new EventHandler<ActionEvent>() {
	    	@Override
	        public void handle(ActionEvent e) {
	       	 	control.leseAusDatei("csv");
	    	}
	    });
	    mnItmTxtImport.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent e) {
		     	control.leseAusDatei("txt");
		    }
  	});
 	   
 	   
 	   btnEingabe.setOnAction(new EventHandler<ActionEvent>() {
             @Override
             public void handle(ActionEvent e) {
         	    schreibeVolkshochschulkurs();
         	    
             }
 	    });
 	   btnAnzeige.setOnAction(new EventHandler<ActionEvent>() {
 	    	@Override
 	        public void handle(ActionEvent e) {
 	           zeigeVolkshochschulkursAn();
 	        } 
    	    });  
     }
    	
    public void zeigeInformationsfensterAn(String meldung){
    	new MeldungsfensterAnzeiger(AlertType.INFORMATION,
    		"Information", meldung).zeigeMeldungsfensterAn();
    }	
 	
 	public void zeigeFehlermeldungsfensterAn(String meldung){
       	new MeldungsfensterAnzeiger(AlertType.ERROR,
        	"Fehler", meldung).zeigeMeldungsfensterAn();
    }
 	
 	private void leseVolkshochschulkursAusDatei(String typ) {
		this.control.leseAusDatei(typ);
	} 
 	
 	private void schreibeVolkshochschulkursInDatei(String typ) {
 		this.control.schreibeVolkshochschulkursInDatei(typ);
 	} 
     
     private void schreibeVolkshochschulkurs(){
     	//try{
     	//	this.model.setVhk(new Volkshochschulkurs(
     	//		txtName.getText(), 
    	//      txtWochentag.getText(),
    	//      txtStartuhrzeit.getText(),
     	//	    txtKursbeitrag.getText(),
     	//	    txtVorkenntnisse.getText().split(";")));
     	//	zeigeInformationsfensterAn("Volkshochschulkurs wurde aufgenommen!");
        //	}
        //	catch(Exception exc){
        //		zeigeFehlermeldungsfensterAn(exc.getMessage());
      	//}
     	try{
     		this.model.getVhk().add(new Volkshochschulkurs(
     				txtName.getText(), 
        	        txtWochentag.getText(),
        	        txtStartuhrzeit.getText(),
         		    txtKursbeitrag.getText(),
         		    txtVorkenntnisse.getText().split(";")));
         		zeigeInformationsfensterAn("Volkshochschulkurs wurde aufgenommen!");
     	} catch(Exception exc){
		zeigeFehlermeldungsfensterAn("Fehler bei der Eingabe: " + exc.getMessage());
		}
     }
     	
   
     
     public void zeigeVolkshochschulkursAn(){
     //	if(model.getVhk() != null){
     //		txtAnzeige.setText(
     //				model.getVhk().gibVolkshochschulkursZurueck(' '));
     //	}else{
     //		zeigeInformationsfensterAn("Bisher wurde kein Volkshochschulkurs aufgenommen!");
     //	}
    	if(this.model.getVhk().size() > 0) {
     		StringBuffer text = new StringBuffer();
     		for(Volkshochschulkurs m : this.model.getVhk()) {
     			text.append(m.gibVolkshochschulkursZurueck(' '));
     		}
 			
     		txtAnzeige.setText(text.toString());
     	}
     	else{
     		zeigeInformationsfensterAn("Bisher wurde kein Volkshochschulkurs aufgenommen!");
     	}
     }	
 }
