package business;

public class Autovermietung {
	
	// Name der Autovermietung
    private String name;
    // Oeffnungszeiten
    private float geoeffnetVon;
    private float geoeffnetBis;
    // Strasse und Hausnummer der Autovermietung
    private String strasseHNr;
    // Dienstleistungen der Autovermietung
    private String[] dienstleistungen;

    public Autovermietung(String name, float geoeffnetVon, float geoeffnetBis,
    	String strasseHNr, String[] dienstleistungen){
   		this.name = name;
  	    this.geoeffnetVon = geoeffnetVon;
   	    this.geoeffnetBis = geoeffnetBis;
   	    this.strasseHNr = strasseHNr;
   	    this.dienstleistungen = dienstleistungen;
    }
    
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getGeoeffnetVon() {
		return geoeffnetVon;
	}

	public void setGeoeffnetVon(float geoeffnetVon) {
		this.geoeffnetVon = geoeffnetVon;
	}

	public float getGeoeffnetBis() {
		return geoeffnetBis;
	}

	public void setGeoeffnetBis(float geoeffnetBis) {
		this.geoeffnetBis = geoeffnetBis;
	}

	public String getStrasseHNr() {
		return strasseHNr;
	}

	public void setStrasseHNr(String strasseHNr) {
		this.strasseHNr = strasseHNr;
	}

	public String[] getDienstleistungen() {
		return dienstleistungen;
	}

	public void setDienstleistungen(String[] dienstleistungen) {
		this.dienstleistungen = dienstleistungen;
	}
	
	public String getDienstleistungenAlsString(char trenner) {
		String ergebnis = "";
		int i = 0;
		for(i = 0; i < this.getDienstleistungen().length - 1; i++) {
			ergebnis = ergebnis + this.getDienstleistungen()[i] + trenner; 
		}
		return ergebnis	+ this.getDienstleistungen()[i];
	}
	
	public String gibAutovermietungZurueck(char trenner){
  		return this.getName() + trenner 
  			+ this.getGeoeffnetVon() + trenner
  		    + this.getGeoeffnetBis() + trenner
  		    + this.getStrasseHNr() + trenner + "\n"
  		    + this.getDienstleistungenAlsString(trenner) + "\n";
  	}
}

