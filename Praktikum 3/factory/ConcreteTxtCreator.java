package factory;

public class ConcreteTxtCreator extends Creator {

	@Override
	public Product factoryMethod() {
		// TODO Auto-generated method stub
		return new ConcreteTxtProduct();
	}

}
