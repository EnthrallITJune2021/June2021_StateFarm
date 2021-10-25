package practiceJava;

public class TestSingleton {

	public static void main(String[] args) {
		SingletonClass singletonClass1 = SingletonClass.getInstance();
		System.out.println(singletonClass1.hashCode());
		SingletonClass singletonClass2 = SingletonClass.getInstance();
		System.out.println(singletonClass2.hashCode());
		System.out.println(singletonClass1.equals(singletonClass2));
		SingletonClass singletonClass3 = SingletonClass.getInstance();
		System.out.println(singletonClass3.hashCode());
		SingletonClass singletonClass4 = SingletonClass.getInstance();
		System.out.println(singletonClass4.hashCode());
		SingletonClass singletonClass5 = SingletonClass.getInstance();
		System.out.println(singletonClass5.hashCode());
	}
}
