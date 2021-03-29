package ch09;

//추상클래스
abstract class A2{
	//추상메소드 : 선언부만 있고 구현부는 없다.
	abstract void prn();
}

//A2의 prn 메소드는 반드시 강제적으로 오버라이딩 해야 한다.
class B2 extends A2{
	@Override
	void prn() {
	}
}
class C2 extends A2{
	@Override
	void prn() {
	}
}

public class Ex2 {

	public static void main(String[] args) {

	}

}
