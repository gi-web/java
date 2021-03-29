package ch08;

public class Ex3 {
	public static void main(String[] args) {
		Customer ct = new Customer();
		VIPCustomer vct = new VIPCustomer();
		///////////////////////////////////
		//묵시적 형변환
		int i = 10;
		double d = i;
		//명시적 형변환
		short s = (short)i;
		//업캐스팅(Up Casting)
		Customer ct1 = 
				new VIPCustomer(1004,"김구라",2000);
		//VIPCustomer vct1 = new Customer();
		////////////////////////////////////
		/*오버라이딩 메소드는 상위클래스의 메소드가 아닌 하위클래스의
		 * 메소드가 호출된다. <-- 동적바인딩*/
		int price = ct1.calcPrice(100000);
		System.out.println("price : " + price);
		System.out.println(ct1.showCustomerInfo());
	}
}










