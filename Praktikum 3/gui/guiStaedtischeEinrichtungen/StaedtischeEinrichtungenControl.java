package gui.guiStaedtischeEinrichtungen;

import business.BuergeraemterModel;
import javafx.stage.Stage;
import ownUtil.Observer;

public class StaedtischeEinrichtungenControl implements Observer {
	private BuergeraemterModel buergeraemterModel;
	private StaedtischeEinrichtungenView staedtischeEinrichtungenView;
	
	public StaedtischeEinrichtungenControl(Stage primaryStage){
		// TODO Auto-generated method stub
		// Singleton
		this.buergeraemterModel = BuergeraemterModel.getInstance();
		this.staedtischeEinrichtungenView = new StaedtischeEinrichtungenView(primaryStage, this, buergeraemterModel);
		this.buergeraemterModel.addObserver(this);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		this.staedtischeEinrichtungenView.zeigeBuergeraemterAn();
	}
}
