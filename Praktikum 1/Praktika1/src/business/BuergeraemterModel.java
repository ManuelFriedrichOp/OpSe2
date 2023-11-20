package business;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BuergeraemterModel {
	
	public Buergeramt buergeramt;
	
		public void schreibeBuergeraemterInCsvDatei() throws IOException {
			BufferedWriter aus = new BufferedWriter(new FileWriter("Buergeraemter.csv", true));
			aus.write(this.getBuergeramt().gibBuergeramtZurueck(';'));
			aus.close();
		}
		
		public Buergeramt getBuergeramt() {
			return this.buergeramt;
		}

		public void setBuergeramt(Buergeramt buergeramt) {
			this.buergeramt = buergeramt;
		}

	}