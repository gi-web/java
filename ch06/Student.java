package ch06;

public class Student {
	//필드(멤버변수) : 객체의 속성을 지니고 있다.
	public String studentName;//학생이름
	public int grade;//학년
	public int money;//가지고 있는 돈
	
	//생성자
	public Student(String studentName, int money) {
		this.studentName = studentName;
		this.money = money;
	}
	
	//메소드 : 3개 선언
	public void takeBus(Bus bus) {
		bus.take(1000);
		this.money -= 1000;
	}
	
	public void takeSubway(Subway subway) {
		subway.take(1500);
		this.money -= 1500;
	}
	
	public void showInfo() {
		System.out.println(studentName+"의 남은 돈은 " 
				+ money +"입니다." );
	}
}










