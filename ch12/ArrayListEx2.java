package ch12;

import java.util.ArrayList;
import java.util.Vector;

public class ArrayListEx2 {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add("Java");
		//10�� int���̹Ƿ� Object�ƴ����� Auto-Boxing -> Integer ��ȯ ����
		list.add(10);
		list.add(true);
		list.add(new Object());
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		ArrayList list2 = new ArrayList();
		list2.add("Java");
		list2.add("JSP");
		list2.add("Oracle");
		
		for (int i = 0; i < list2.size(); i++) {
			//�����Ҷ� Ÿ������ ĳ���� ���� �����´�.
			String s = (String)list2.get(i);
			System.out.println(s.length());
		}
		
		//���׸�(Generic) : Collection ��ü�� ���� �Ҷ� Ÿ���� �̸� ����
		ArrayList<String> list3 = new ArrayList<String>();
		list3.add("Java");
		list3.add("JSP");
		list3.add("Oracle");
		//list3.add(10);
		String s = list3.get(0);
		
	}
}








