package ch05;


//CarEx2.java -> CarEx2.class, Car2.class
/*Ŭ���� �� �ʵ� , �޼ҵ� ���̹� ��Ģ
 * 1.Ŭ�������� �ݵ�� ùö�ڴ� �빮���̰� ������ �ܾ �ι�° ö�ڵ� �빮��
 * ex)MyUtil.java , BoardMgr.java
 * 2.�ʵ� , �޼ҵ�� �ݵ�� ù��° �ܾ�� ��� �ҹ��� �ι�° �ܾ��� ù��° ö�ڴ� �빮��
 * ex)speedUp(), carName, 
 * */ 

class Car2{
	
	String carName;
	int velocity;
	String carColor;
	
	void speedUp() {
		velocity++;
	}
	void speedDown() {
		velocity--;
		if(velocity<0)
			velocity = 0;
	}
	void stop() {
		velocity = 0;
	}
}

public class CarEx2 {
	public static void main(String[] args) {
		// call by value, call by reference
		//�ڹ� Data Type : �⺻��(8��)�� ������(Ŭ���� Ÿ��)
		int a = 10;
		int b = a;
		a = 20;
		System.out.println(a+b);
		Car2 c1 = new Car2();
		Car2 c2 = new Car2();
		c1.carName = "�ҳ�Ÿ";
		c2.carName = "�׷���";
		c1.velocity = 10;
		c2.velocity = 20;
		System.out.println(c1.velocity);
		System.out.println(c2.velocity);
		c1 = c2;
		System.out.println(c1.velocity);
		System.out.println(c2.velocity);
		System.out.println("10*10");
	}
}






