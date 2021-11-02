package practiceJava;

import java.util.HashSet;
import java.util.Set;

public class DataStructure {

	public static void main(String[] args) {
		Set<String> names = new HashSet<>();
		names.add("Nasir");
		names.add("Hafiz");
		names.add("Rayhan");
		names.add("Fatema");
		names.add("Bobby");
		names.add("Noyon");
		names.add("Bobby");
		
		for (String name : names) {
			System.out.println(name);
		}
		
		System.out.println(names.size());
	}
}
