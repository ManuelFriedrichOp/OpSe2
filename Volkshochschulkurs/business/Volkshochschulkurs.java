package business;

public class Volkshochschulkurs {
	

    private String name;
    private String wochentag;
    private String startuhrzeit;
    private String kursbeitrag;
    private String[] vorkenntnisse;

    public Volkshochschulkurs(String name, String wochentag, String startuhrzeit,
    	String kursbeitrag, String[] vorkenntnisse){
   		this.name = name;
  	    this.wochentag = wochentag;
   	    this.startuhrzeit = startuhrzeit;
   	    this.kursbeitrag = kursbeitrag;
   	    this.vorkenntnisse = vorkenntnisse;
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

	public String[] getVorkenntnisse() {
		return vorkenntnisse;
	}

	public void setVorkenntnisse(String[] vorkenntnisse) {
		this.vorkenntnisse = vorkenntnisse;
	}
	
	public String getVorkenntnisseAlsString(char trenner) {
		String ergebnis = "";
		int i = 0;
		for(i = 0; i < this.getVorkenntnisse().length - 1; i++) {
			ergebnis = ergebnis + this.getVorkenntnisse()[i] + trenner; 
		}
		return ergebnis	+ this.getVorkenntnisse()[i];
	}
	
	public String gibVolkshochschulkursZurueck(char trenner){
  		return this.getName() + trenner 
  			+ this.getWochentag() + trenner
  		    + this.getStartuhrzeit() + trenner
  		    + this.getKursbeitrag() + trenner + "\n"
  		    + this.getVorkenntnisseAlsString(trenner) + "\n";
  	}
}
