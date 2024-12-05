package Main;

import gui.KurseuebersichtControl;
import gui.VolkshochschulkursControl;
import gui.VolkshochschulkursView;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		new VolkshochschulkursControl(primaryStage);
		Stage fensterKurseuebersicht = new Stage();
		new KurseuebersichtControl(fensterKurseuebersicht);
	}	
	
	public static void main(String[] args){
		launch();
	}
}