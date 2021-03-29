package ch10;

interface A2{
	//필드 : 자동으로 상수
	int A = 22;
	//메소드 : 추상메소드만 가능(8.0이하)
	void prn();
}

class B2 extends Object implements A2{
	@Override
	public void prn() {
	}
}

//클래스는 다중상속 불가능하지만 다중 구현은 가능
interface C2{
	void prn1();
}

//여러개 인터페이스 가능(다중구현은 가능)
class D2 implements A2, C2{
	@Override
	public void prn1() {}
	@Override
	public void prn() {}
}

public class Ex2 {

	public static void main(String[] args) {

	}

}
