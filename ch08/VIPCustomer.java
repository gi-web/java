package ch08;

//�θ� Ŭ������ ������ �޼ҵ�� ����� ���� �ʴ´�.
public class VIPCustomer extends Customer{
	
	//VIPCustomer : �����Ǹſ�, ����Ʈ���� 5%, ���� 10%
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
	
	/*�޼ҵ� �������̵�(Override) : 
	�θ� ������ �޼ҵ带 �ڽ�Ŭ�������� ���ο� �°Բ� ������ �ϴ°�*/
	//@ : ������̼�(Annotation) -> �ּ�, �˸�.
	@Override
	public int calcPrice(int price) {
		bonusPoint+=price*bonusRatio;
		return price - (int)(price*saleRatio);
	}
	
}




