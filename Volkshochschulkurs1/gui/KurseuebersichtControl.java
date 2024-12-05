package gui;

import business.VolkshochschulkursModel;
import javafx.stage.Stage;
import ownUtil.Observer;

public class KurseuebersichtControl implements Observer {
	

		private KurseuebersichtView kursview;
		private VolkshochschulkursModel kursmodel;
		
		public KurseuebersichtControl(Stage primaryStage){
			
	 		this.kursmodel = VolkshochschulkursModel.getInstance(null);	
	 		kursmodel.observers.add(this);
			this.KurseuebersichtView 
			 	= new KurseuebersichtView(this, primaryStage,
				kursmodel);
		}

	
	@Override
	public void update() {
		KurseuebersichtView.zeigeKurseAn();
	}

}