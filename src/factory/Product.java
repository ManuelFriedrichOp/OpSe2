package factory;

import java.io.IOException;

import business.Volkshochschulkurs;

public abstract class Product {	
	
	public abstract String[] leseAusDatei() throws IOException;
	public abstract void schliesseDatei() throws IOException;
	
}
