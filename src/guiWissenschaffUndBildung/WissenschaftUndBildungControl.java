package guiWissenschaffUndBildung;
import business.VolkshochschulkursModel;


import javafx.stage.Stage;
import ownUtil.Observer;
public class WissenschaftUndBildungControl implements Observer{	
	
	private WissenschaftUndBildungView wissenschaftUndBildungView;
	private VolkshochschulkursModel volkshochschulkurseModel;
	
	public WissenschaftUndBildungControl(Stage primaryStage){
 		this.volkshochschulkurseModel = VolkshochschulkursModel.getInstance(); 		
		this.wissenschaftUndBildungView = new WissenschaftUndBildungView(this, primaryStage,volkshochschulkurseModel);
		volkshochschulkurseModel.observers.add(this);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		wissenschaftUndBildungView.zeigeVolkshochschulkurseAn();
	}
	
}
