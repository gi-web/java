package ch16;

import java.awt.List;

public class ListEx1 extends MFrame{
	
	List list1, list2;
	String team1[] ={"�Ե�","�Ｚ","��ȭ","KIA","SK"};
	String team2[] ={"LG","�λ�","Ű��","NC","KT"};
	
	public ListEx1() {
		setTitle("List Example");
		list1 = new List(3, false);//���ϼ���
		for (int i = 0; i < team1.length; i++) {
			list1.add(team1[i]);
		}
		list2 = new List(5, true);//����(����)����
		for (int i = 0; i < team2.length; i++) {
			list2.add(team2[i]);
		}
		add(list1);
		add(list2);
	}

	public static void main(String[] args) {
		new ListEx1();
	}
}


