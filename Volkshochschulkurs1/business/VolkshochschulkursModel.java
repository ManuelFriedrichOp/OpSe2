package business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Vector;

import factory.ConcreteCsvCreator;
import factory.ConcreteCsvProduct;
import factory.ConcreteTxtCreator;
import factory.Creator;
import factory.Product;
import gui.VolkshochschulkursControl;
import ownUtil.Observable;
import ownUtil.Observer;


public class VolkshochschulkursModel implements Observable{
	
	public Volkshochschulkurs vhk;
	static VolkshochschulkursModel model;
	static VolkshochschulkursControl control;
	public Vector<Observer> observers = new Vector<Observer>();
	
	private VolkshochschulkursModel(VolkshochschulkursControl volkshochschulkursControl) {
		this.control = volkshochschulkursControl;
		this.vhk = null;
	}
	
	public static VolkshochschulkursModel getInstance(VolkshochschulkursControl volkshochschulkursControl) {
		if(model == null) {
			model = new VolkshochschulkursModel(control);
		} 
		return model;
	}
	
	public void schreibeVolkshochschulkursInCsvDatei() throws IOException {	
		BufferedWriter aus = new BufferedWriter(new FileWriter("Volkshochschulkurs.csv", true));
		aus.write(this.getVhk().gibVolkshochschulkursZurueck(';'));
		aus.close();
	}
	
	public void leseVolkshochschulkursAusCsvDatei()throws IOException{	
		Creator creator = new ConcreteCsvCreator();
		Product reader = creator.factoryMethod();
		String[] zeile = reader.leseAusDatei();
		this.vhk = new Volkshochschulkurs(zeile[0], 
				zeile[1],
				zeile[2], zeile[3], zeile[4].split("_"));
		reader.schliesseDatei();
		notifyObservers();
	}
	
	public void leseVolkshochschulkursAusTxtDatei()throws IOException{
		Creator creator = new ConcreteTxtCreator();
		Product reader = creator.factoryMethod();
		String[] zeile = reader.leseAusDatei();
		this.vhk = new Volkshochschulkurs(zeile[0], 
				zeile[1],
				zeile[2], zeile[3], zeile[4].split("_"));
		reader.schliesseDatei();
		notifyObservers();
	}
	
	public Volkshochschulkurs getVhk() {
		return vhk;
	}

	public void setVhk(Volkshochschulkurs vhk) {
		this.vhk = vhk;
		notifyObservers();
	}
	
	@Override
	public void addObserver(Observer observer) {
		observers.add(observer);
		
	}

	@Override
	public void removeObserver(Observer observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		for(Observer observer : observers) {
			observer.update();
		}
	}
	
}