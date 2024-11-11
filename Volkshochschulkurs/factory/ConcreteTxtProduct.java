package factory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import business.Volkshochschulkurs;

public class ConcreteTxtProduct extends Product {

	private BufferedWriter aus;
	@Override
	public void schreibeInDatei(Volkshochschulkurs vhk) throws IOException {
		
		aus = new BufferedWriter(new FileWriter("Cafe.txt", true));
		aus.write("Name des Volkshochschulkurs: " + vhk.getName() +"\n");
		aus.write("Wochentag: " + vhk.getWochentag() + "\n");
		aus.write("Startuhrzeit: " + vhk.getStartuhrzeit() +"\n");
		aus.write("Kursbeitrag: " + vhk.getKursbeitrag() + "\n");
		aus.write("Vorkenntnisse: " + vhk.getVorkenntnisseAlsString(';'));
		aus.newLine();
		
	}
	
	@Override
	public Volkshochschulkurs leseDatei() throws IOException {
		try (BufferedReader ein = new BufferedReader(new FileReader("Volkshochschulkurs.txt"))) {
            String[] zeile = ein.readLine().split(";");
            return new Volkshochschulkurs(
                (zeile[0]), 
                (zeile[1]), 
                zeile[2], 
                zeile[3], 
                zeile[4].split("_")
            );
        } catch (IOException e) {
            System.err.println("IOException beim Lesen!");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Unbekannter Fehler beim Lesen!");
            e.printStackTrace();
        }
        return null;
	}
	
	public void schliesseDatei() throws IOException {
		aus.close();
	}

}
