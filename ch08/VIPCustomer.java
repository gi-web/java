package ch08;

//부모 클래스의 생성자 메소드는 상속은 되지 않는다.
public class VIPCustomer extends Customer{
	
	//VIPCustomer : 전담판매원, 포인트비율 5%, 세일 10%
	public int agentID;
	public double saleRatio;
	
	public VIPCustomer() {
		super();
		customerGrade = "VIP";
		bonusRatio = 0.05;
		saleRatio = 0.1;
	}
	public VIPCustomer(int customerID, String customerName, 
			int agentID) {
		//this.customerID = customerID;
		//this.customerName = customerName;
		super(customerID, customerName);
		customerGrade = "VIP";
		bonusRatio = 0.05;
		saleRatio = 0.1;
		this.agentID = agentID;
	}
	
	/*메소드 오버라이드(Override) : 
	부모가 선언한 메소드를 자식클래스에서 본인에 맞게끔 재정의 하는것*/
	//@ : 어노테이션(Annotation) -> 주석, 알림.
	@Override
	public int calcPrice(int price) {
		bonusPoint+=price*bonusRatio;
		return price - (int)(price*saleRatio);
	}
	
}




