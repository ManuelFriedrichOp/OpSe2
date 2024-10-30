package business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import gui.AutovermietungControl;

public class AutovermietungModel {
	
	AutovermietungControl avc;
	Autovermietung av;
	

	public AutovermietungModel(AutovermietungControl autovermietungControl) {
		this.avc = autovermietungControl;
		this.av = null;
	}



	public Autovermietung getAv() {
		return av;
	}




	public void setAv(Autovermietung av) {
		this.av = av;
	}




	public void leseAusDatei(String typ){
    	try {
      		if("csv".equals(typ)){
      			BufferedReader ein = new BufferedReader(new FileReader("Autovermietungen.csv"));
      			String[] zeile = ein.readLine().split(";");
      			Autovermietung av = new Autovermietung(zeile[0], 
      				Float.parseFloat(zeile[1]), 
      				Float.parseFloat(zeile[2]), 
      				zeile[3], zeile[4].split("_"));
      				ein.close();
      				setAv(av);
      				avc.zeigeInformationsfensterAn("Die Autovermietungen wurden gelesen!");      
      		}
       		else{
	   			avc.zeigeInformationsfensterAn("Noch nicht implementiert!");
	   		}
		}
		catch(IOException exc){
			avc.zeigeFehlermeldungsfensterAn(
				"IOException beim Lesen!");
		}
		catch(Exception exc){
			avc.zeigeFehlermeldungsfensterAn(
				"Unbekannter Fehler beim Lesen!");
		}
	}
		
	public void schreibeAutovermietungenInCsvDatei() {
		if(getAv() != null) {
			try {
				System.out.println(getAv().gibAutovermietungZurueck(';'));
				BufferedWriter aus 
					= new BufferedWriter(new FileWriter("AutovermietungenAusgabe.csv", true));
				aus.write(av.gibAutovermietungZurueck(';'));
				aus.close();
				System.out.println(av.gibAutovermietungZurueck(';'));
	   			avc.zeigeInformationsfensterAn(
		   			"Die Autovermietungen wurden gespeichert!");
			}	
			catch(IOException exc){
				avc.zeigeFehlermeldungsfensterAn(
					"IOException beim Speichern!");
			}
			catch(Exception exc){
				System.out.println(exc.getMessage());
				avc.zeigeFehlermeldungsfensterAn(
					"Unbekannter Fehler beim Speichern!");
			} 
			
		} else {
		avc.zeigeFehlermeldungsfensterAn(
				"Die Autovermietung wurde nicht gesetzt");
		}
	}
	

}
