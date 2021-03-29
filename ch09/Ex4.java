package ch09;

import java.awt.Component;

abstract class A4{
	abstract void prn1();
}
//추상클래스들 간의 상속은 오버라이딩 할 필요가 없다.
abstract class B4 extends A4{
	abstract void prn2();
}
class C4 extends B4{
	@Override
	void prn2() {}
	@Override
	void prn1() {}
}
//추상클래스는 반드시 추상메소드를 가지고 있지는 않다. 추상적인 개념 때문에 추상클래스임.
class D4 extends Component{}

public class Ex4 {
	public static void main(String[] args) {
		
	}
}




