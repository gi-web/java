package ch12;

import java.util.Vector;

public class VectorEx1 {
	public static void main(String[] args) {
		Vector<String> vec = new Vector<String>();
		vec.add("Java");
		vec.add("JSP");
		vec.add("Andorid");
		vec.add("Oracle");
		vec.add("Kotlin");
		System.out.println(vec.size());
		System.out.println(vec.capacity());
		vec.remove(0);
		if(vec.contains("Andorid")) {
			int idx = vec.indexOf("Andorid");
			System.out.println(idx);
		}
		System.out.println(vec.isEmpty());
		vec.addElement("Spring");//add¶û ºñ½Á
		System.out.println(vec.get(0));
		System.out.println(vec.elementAt(1));
	}
}






