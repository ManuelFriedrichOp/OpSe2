package factory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


import business.Volkshochschulkurs;

public class ConcreteCsvProduct extends Product {

	private BufferedReader aus;

	@Override
	public void schliesseDatei() throws IOException {
		// TODO Auto-generated method stub
		aus.close();
		
	}
	@Override
	public String[] leseAusDatei() throws IOException {
		
		aus = new BufferedReader(new FileReader("Volkshochschulkurs.csv"));
		String zeile[] = aus.readLine().split(";");
		return zeile;
	}


}
