package main;

import gui.AutovermietungControl;
import gui.AutovermietungView;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		new AutovermietungControl(primaryStage);
	}	
	
	public static void main(String[] args){
		launch(args);
	}
}
