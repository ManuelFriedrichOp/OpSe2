package business;

import java.util.ArrayList;

public class Volkshochschulkurs {
	

    private String name;
    private String wochentag;
    private String startuhrzeit;
    private String kursbeitrag;
    private ArrayList<String> vorkenntnisse; // neu

    public Volkshochschulkurs(String name, String wochentag, String startuhrzeit,
    	String kursbeitrag, String[] vorkenntnisse){
    	
    	if(vorkenntnisse == null) {
    		throw new IllegalArgumentException("Fehler");
    	}// neu
    	
   		this.name = name;
  	    this.wochentag = wochentag;
   	    this.startuhrzeit = startuhrzeit;
   	    this.kursbeitrag = kursbeitrag;
   	    
   	    ArrayList<String> arr = new ArrayList<String>(); // neu
	    for(int i=0;i<vorkenntnisse.length;i++) {
	    	arr.add(vorkenntnisse[i]);
	    }
	    
	    this.vorkenntnisse = arr;
    }
    
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWochentag() {
		return wochentag;
	}

	public void setWochentag(String wochentag) {
		this.wochentag = wochentag;
	}

	public String getStartuhrzeit() {
		return startuhrzeit;
	}

	public void setStartuhrzeit(String startuhrzeit) {
		this.startuhrzeit = startuhrzeit;
	}

	public String getKursbeitrag() {
		return kursbeitrag;
	}

	public void setKursbeitrag(String kursbeitrag) {
		this.kursbeitrag = kursbeitrag;
	}
	// neu
	public ArrayList<String> getVorkenntnisse() {
		return vorkenntnisse;
	}
	// neu
	public void setVorkenntnisse(ArrayList<String> vorkenntnisse) {
		this.vorkenntnisse = vorkenntnisse;
	}
	
	public String getVorkenntnisseAlsString(char trenner) {
		String ergebnis = "";
		int i = 0;
		for(i = 0; i < this.getVorkenntnisse().size() - 1; i++) {           // neu
			ergebnis = ergebnis + this.getVorkenntnisse().get(i) + trenner; // neu
		}
		return ergebnis	+ this.getVorkenntnisse().get(i);                   // neu
	}
	
	public String gibVolkshochschulkursZurueck(char trenner){
  		return this.getName() + trenner 
  			+ this.getWochentag() + trenner
  		    + this.getStartuhrzeit() + trenner
  		    + this.getKursbeitrag() + trenner  
  		    + this.getVorkenntnisseAlsString(trenner) + "\n";
  	}
}
