package ch08;

public class Ex3 {
	public static void main(String[] args) {
		Customer ct = new Customer();
		VIPCustomer vct = new VIPCustomer();
		///////////////////////////////////
		//������ ����ȯ
		int i = 10;
		double d = i;
		//����� ����ȯ
		short s = (short)i;
		//��ĳ����(Up Casting)
		Customer ct1 = 
				new VIPCustomer(1004,"�豸��",2000);
		//VIPCustomer vct1 = new Customer();
		////////////////////////////////////
		/*�������̵� �޼ҵ�� ����Ŭ������ �޼ҵ尡 �ƴ� ����Ŭ������
		 * �޼ҵ尡 ȣ��ȴ�. <-- �������ε�*/
		int price = ct1.calcPrice(100000);
		System.out.println("price : " + price);
		System.out.println(ct1.showCustomerInfo());
	}
}










