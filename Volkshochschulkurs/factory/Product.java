package factory;

import java.io.IOException;

import business.Volkshochschulkurs;

public abstract class Product {

	public abstract void schreibeInDatei(Volkshochschulkurs vhk) throws IOException;
	
	public abstract void schliesseDatei() throws IOException;

	public abstract Volkshochschulkurs leseDatei() throws IOException;
}
