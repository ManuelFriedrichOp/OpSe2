package factory;

public class ConcreteTxtCreator extends Creator{

	@Override
	public Product factoryMethod() {
		return new ConcreteTxtProduct();
	}

}
