package ch06;

public class TakeTrans {
	public static void main(String[] args) {
		//�л� 2���� �����ϰ� ���� �Ѹ��� ���� ž��, �Ѹ��� ����ö ž��
		Student student1001 = new Student("ȫ�浿", 100000);
		Student student1002 = new Student("��ȣ��", 7000);
		
		//ȫ�浿�� ����ö ž��
		Subway subWay02 = new Subway("2ȣ��");
		student1001.takeSubway(subWay02);
		student1001.showInfo();
		subWay02.showInfo();
		
		//��ȣ���� ���� ž��
		Bus bus80 = new Bus(80);
		student1002.takeBus(bus80);
		student1002.showInfo();
		bus80.showInfo();
	}
}




