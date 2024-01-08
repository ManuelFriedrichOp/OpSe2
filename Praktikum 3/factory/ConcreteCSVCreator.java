package factory;

public class ConcreteCSVCreator extends Creator{

	@Override
	public Product factoryMethod() {
		// TODO Auto-generated method stub
		return new ConcreteCSVProduct();
	}

}
