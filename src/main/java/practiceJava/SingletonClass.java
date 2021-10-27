package practiceJava;

public class SingletonClass extends Object{
	
	private static SingletonClass singletonClass;
	
	private SingletonClass() {}

	public static SingletonClass getInstance() {
		if(singletonClass == null) {
			singletonClass = new SingletonClass();
		}
		return singletonClass;
	}
}
