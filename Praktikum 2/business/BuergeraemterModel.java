package business;

import java.io.IOException;

import factory.ConcreteCSVCreator;
import factory.ConcreteTxtCreator;
import factory.Creator;
import factory.Product;

public class BuergeraemterModel {
	
	public Buergeramt buergeramt;
	
		public void schreibeBuergeraemterInCsvDatei() throws IOException {
			Creator writerCreator = new ConcreteCSVCreator();
			Product writer = writerCreator.factoryMethod();
			writer.fuegeInDateiHinzu(this.buergeramt);
			writer.schliesseDatei();
		}
		
		public void schreibeBuergeraemterInTxtDatei() throws IOException {
			Creator writerCreator = new ConcreteTxtCreator();
			Product writer = writerCreator.factoryMethod();
			writer.fuegeInDateiHinzu(this.buergeramt);
			writer.schliesseDatei();
		}
		
		public Buergeramt getBuergeramt() {
			return this.buergeramt;
		}

		public void setBuergeramt(Buergeramt buergeramt) {
			this.buergeramt = buergeramt;
		}

	}