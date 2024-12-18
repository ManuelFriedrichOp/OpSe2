package factory;

public class ConcreteCsvCreator extends Creator{

	@Override
	public Product factoryMethod() {
		return new ConcreteCsvProduct();
	}	
}
