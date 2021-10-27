package practiceJava;

public class AClass{
	
	public void test(Object obj) {
		System.out.println("This is a test : " + obj);
	}
	
	public static void main(String[] args) {

		String string = new String("0");
		String string2 = new String("0");
		StringBuilder builder = new StringBuilder("0");
		StringBuilder builder2 = new StringBuilder("0");
		
		System.out.println(string.equals(string2)); //0 - Shakir, Bonny (null), Kamran, Bobby , Fatema
		System.out.println(builder.equals(builder2));//0 - Noyon, Shakir
		System.out.println(string.hashCode() + " : "+ string2.hashCode());
		System.out.println(builder.hashCode() + " : "+ builder2.hashCode());
		
	}

}
