package ch12;

import java.util.ArrayList;

public class ArrayListEx1 {
	public static void main(String[] args) {
		//��ü�� �����ϴ� Ŭ���� : �迭�� ������ ���ϳ��� Ŭ����
		//�迭 : ������ Data Type�̰� ũ�� ����.
		//ArrayList or Vector�� Ÿ�� �� ũ�� ����.
		ArrayList list = new ArrayList();
		list.add("Java");
		list.add("JSP");
		list.add("Database");
		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		list.remove(0);
		System.out.println("--------");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}






