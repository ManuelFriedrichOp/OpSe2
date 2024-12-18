package business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import factory.ConcreteCsvCreator;
import factory.ConcreteCsvProduct;
import factory.ConcreteTxtCreator;
import factory.Creator;
import factory.Product;
import guiVolkshochschulkurs.VolkshochschulkursControl;
import ownUtil.Observable;
import ownUtil.Observer;


public class VolkshochschulkursModel implements Observable{
	
	//private Volkshochschulkurs vhk;
	static VolkshochschulkursModel model;
	public Vector<Observer> observers = new Vector<Observer>();
	private ArrayList<Volkshochschulkurs> kurs = new ArrayList<>(); //esto es nuevo
	
	private VolkshochschulkursModel() {
		
	}
	
	public static VolkshochschulkursModel getInstance() {
		if(model == null) {
			model = new VolkshochschulkursModel();
		} 
		return model;
	}
	
	public void schreibeVolkshochschulkursInCsvDatei() throws IOException {	
		
		if (this.kurs == null) throw new NullPointerException("Kein kurs zum Speichern."); //neu
		try {
			BufferedWriter aus = new BufferedWriter(new FileWriter("Volkshochschulkurs.csv", true));
			//aus.write(this.getVhk().gibVolkshochschulkursZurueck(';'));
			for(int i=0;i<kurs.size();i++) {                                                   //neu
				aus.write(kurs.get(i).gibVolkshochschulkursZurueck(';'));
			}
			aus.close();
		}
		catch(IOException exc){
			throw new IOException("Fehler beim Speichern der Datei!");
		}
		catch(Exception exc) {
			throw new IOException(exc);
		}
	}
	
	public void leseVolkshochschulkursAusCsvDatei()throws IOException{	
		Creator creator = new ConcreteCsvCreator();
		Product reader = creator.factoryMethod();
		String[] zeile = reader.leseAusDatei();
		this.kurs.add(new Volkshochschulkurs(zeile[0],             //neu
				zeile[1],
				zeile[2], zeile[3], zeile[4].split("_")));
		//this.vhk = new Volkshochschulkurs(zeile[0], 
		//	    zeile[1],
		//		zeile[2], zeile[3], zeile[4].split("_"));
		reader.schliesseDatei();
		notifyObservers();
	}
	
	public void leseVolkshochschulkursAusTxtDatei()throws IOException{
		Creator creator = new ConcreteTxtCreator();
		Product reader = creator.factoryMethod();
		String[] zeile = reader.leseAusDatei();
		this.kurs.add(new Volkshochschulkurs(zeile[0], 
				zeile[1],
				zeile[2], zeile[3], zeile[4].split("_")));
		//this.vhk = new Volkshochschulkurs(zeile[0], 
		//		zeile[1],
		//		zeile[2], zeile[3], zeile[4].split("_"));
		reader.schliesseDatei();
		notifyObservers();
	}
	
	//neu
	public ArrayList<Volkshochschulkurs> getVhk() {
		return kurs;
	}

	//public void setVhk(Volkshochschulkurs vhk) {
	//	this.vhk = vhk;
	//	notifyObservers();
	//}
	
	//neu
	public void setVhk(Volkshochschulkurs vhk) {
		kurs.add(vhk);
		notifyObservers();
	}

	@Override
	public void addObserver(Observer observer) {
		// TODO Auto-generated method stub
		observers.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		// TODO Auto-generated method stub
		observers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		for(int i=0;i<observers.size();i++) {
			this.observers.elementAt(i).update();
		}
	}
	
}