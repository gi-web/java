package ch08;

public class Customer {

	public int customerID;
	public String customerName;
	public String customerGrade;
	public int bonusPoint;
	public double bonusRatio;
	
	//생성자 : 객체가 생성될때 기본적인 값을 세팅을 목적으로 한다.
	//객체를 생성할때 한번만 호출을 하고 다른 메소드 처럼 반복적인 호출은 불가능
	public Customer() {
		customerGrade = "SILVER";
		bonusRatio = 0.01;//1%
	}
	public Customer(int customerID, String customerName) {
		this.customerID = customerID;
		this.customerName= customerName;
		customerGrade = "SILVER";
		bonusRatio = 0.01;//1%
	}
	
	public int calcPrice(int price) {
		bonusPoint+=price*bonusRatio;
		return price;
	}
	
	public String showCustomerInfo() {
		String str = customerName + "님의 등급은 " + customerGrade
				+"이며 보너스 포인트는 " + bonusPoint +"입니다.";
		return str;
	}
}













