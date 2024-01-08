package factory;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import business.Buergeramt;

public class ConcreteCSVProduct extends Product {
	private BufferedWriter aus;
	@Override
	public void fuegeInDateiHinzu(Buergeramt buergeramt) throws IOException {
		// TODO Auto-generated method stub
		aus = new BufferedWriter(new FileWriter("Buergeraemter.csv", true));
		aus.write(buergeramt.gibBuergeramtZurueck(';'));
		aus.flush();
	}

	@Override
	public void schliesseDatei() throws IOException {
		// TODO Auto-generated method stub
		aus.close();
	}

}
