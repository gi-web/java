package ch06;

public class Bus {

	public int busNumber;//버스번호
	public int passengerCount;//승객수
	public int money;//버스의 수입

	//생성자
	public Bus(int busNumber) {
		this.busNumber = busNumber;
	}
	//메소드
	public void take(int money) {
		this.money += money;
		passengerCount++;
	}
	public void showInfo() {
		System.out.println("버스 : " + busNumber);
		System.out.println("승객 : " + passengerCount);
		System.out.println("수입 : " + money);
		System.out.println("-----------------------");
	}
	
	
}




