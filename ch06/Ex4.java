package ch06;

class A4{
	/*static 필드는 같은 클래스의 모든 객체가 공유의 목적으로 static 메모리에
	 * 오직 하나만 만들어 진다.*/
	static int k;
	int p;
}

public class Ex4 {
	public static void main(String[] args) {
		A4 a = new A4();
		A4 b = new A4();
		a.k = 100;
		a.p = 100;
		System.out.println(a.k + a.p);
		b.k = 200;
		b.p = 200;
		System.out.println(b.k + b.p);
		System.out.println(a.k + a.p);
	}
}



