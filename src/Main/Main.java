package Main;

import guiVolkshochschulkurs.VolkshochschulkursControl;
import guiVolkshochschulkurs.VolkshochschulkursView;
import guiWissenschaffUndBildung.WissenschaftUndBildungControl;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		new VolkshochschulkursControl(primaryStage);
		Stage fensterKurseuebersicht = new Stage();
		new WissenschaftUndBildungControl(fensterKurseuebersicht);
	}	
	
	public static void main(String[] args){
		launch();
	}
}