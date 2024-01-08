package factory;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import business.Buergeramt;

public class ConcreteTxtProduct extends Product{
	private PrintWriter aus;
	@Override
	public void fuegeInDateiHinzu(Buergeramt buergeramt) throws IOException {
		// TODO Auto-generated method stub
		aus = new PrintWriter(new FileWriter("Buergeraemter.txt", true));
		aus.println("Daten des Buergeramts");
		aus.println("Name des Buergeramts: " + buergeramt.getName());
		aus.println("Oeffnungszeit des Buergamts: " + buergeramt.getGeoeffnetVon() + "-" + buergeramt.getGeoeffnetBis());
		aus.println("Strasse und Hausnummer des Buergamts: " + buergeramt.getStrasseHNr());
		aus.println("Dienstleistungen des Buegeramts: " + buergeramt.getDienstleistungenAlsString(';'));
		aus.println();
	}

	@Override
	public void schliesseDatei() throws IOException {
		// TODO Auto-generated method stub
		aus.close();
	}

}
