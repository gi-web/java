package ch08;

import java.awt.Dialog;
import java.awt.Frame;
import java.util.Vector;

class Person{
	String name;
	public Person(String name) {
		this.name = name;
	}
}

class Student extends Person{
	String grade;
	public Student(String name) {
		super(name);
	}
}

/*Ex5.java : ������ �ڹ����Ͽ� �����ϴ� Ŭ������
.java ���Ϸ� ����� Ŭ������ public ����*/

public class Ex5 {
	public static void main(String[] args) {
		Frame f = new Frame();
		Dialog d = new Dialog(f);
		/////////////////////////////////
		Person p;
		Student s = new Student("ȫ�浿");
		p = s;//��ĳ����(UpCasting)
		////////////////////////////////
		Vector v = new Vector();//��ü�� �����ϴ� �ָӴ� ��Ȱ�� Ŭ����
		String str = new String("����");
		v.add(str);//add�� �Ű����� Ÿ���� Object�̴�.
		String str1 = (String)v.get(0);
		////////////////////////////////
		Student s1;
		Person p1 = new Person("��ȣ��");
		//������ �������� ������ ���� ������ ĳ���� ���ܰ� �߻� 
		s1 = (Student)p1;//�ٿ�ĳ����(DownCasting)
		s1.grade = "A";
		System.out.println(s1.grade);
		////////////////////////////////
	}
}



















