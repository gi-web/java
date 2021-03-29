package ch06;

public class TakeTrans {
	public static void main(String[] args) {
		//학생 2명을 생성하고 각각 한명은 버스 탑승, 한명은 지하철 탑승
		Student student1001 = new Student("홍길동", 100000);
		Student student1002 = new Student("강호동", 7000);
		
		//홍길동은 지하철 탑승
		Subway subWay02 = new Subway("2호선");
		student1001.takeSubway(subWay02);
		student1001.showInfo();
		subWay02.showInfo();
		
		//강호동은 버스 탑승
		Bus bus80 = new Bus(80);
		student1002.takeBus(bus80);
		student1002.showInfo();
		bus80.showInfo();
	}
}




