package business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import factory.ConcreteCsvCreator;
import factory.ConcreteCsvProduct;
import factory.ConcreteTxtCreator;
import factory.Creator;
import factory.Product;


public class VolkshochschulkursModel {
	
	public Volkshochschulkurs vhk;
	
	public void schreibeVolkshochschulkursInCsvDatei() throws IOException {
		Creator writerCreator = new ConcreteCsvCreator();
		Product writer = writerCreator.factoryMethod();
		writer.schreibeInDatei(this.vhk);
		writer.schliesseDatei();
	}
	
	public void schreibeVolkshochschulkursInTxtDatei() throws IOException {
		Creator writerCreator = new ConcreteTxtCreator();
		Product writer = writerCreator.factoryMethod();
		writer.schreibeInDatei(this.vhk);
		writer.schliesseDatei();
	}
	public void leseVolkshochschulkursCsv()throws IOException{
		Creator readerCreator = new ConcreteCsvCreator();
		Product reader = readerCreator.factoryMethod();
		this.vhk = reader.leseDatei();
	}
	
	public void leseVolkshochschulkursTxt()throws IOException{
		Creator readerCreator = new ConcreteTxtCreator();
		Product reader = readerCreator.factoryMethod();
		reader.leseDatei();
	}
	
	public Volkshochschulkurs getVhk() {
		return vhk;
	}

	public void setVhk(Volkshochschulkurs vhk) {
		this.vhk = vhk;
	}
	
}