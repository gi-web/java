package ch09;

import java.awt.Color;
import java.awt.Frame;

/*final(마지막) : 클래스, 필드(매개변수), 메소드
 * 1.클래스 : sub 클래스가 없는 클래스
 * 2.필드 : 상수선언
 * 3.메소드 : 오버라이딩 불가 메소드
 * */

final class A1{}
//class B1 extends A1{}
//class C1 extends String{}
class D1{
	int a;//필드는 초기화를 JVM 합니다.기본형 타입은 0(false), 클래스 타입은 null
	final int B = 22;//관례적으로 상수는 모든 철자가 대문자.
	
	public void prn(final int n) {
		//n = 23;//final 매개변수는 당연히 변경 불가
		System.out.println(5*5*Math.PI);//원의 넓이
		Frame f = new Frame();
		f.setBackground(new Color(255,255,0));
		f.setBackground(Color.yellow);
	}
}

class E1{
	void prn1() {}
	final void prn2() {}
}

class F1 extends E1{
	@Override
	void prn1() {}
	//@Override
	//void prn2() {}
}

public class Ex1 {

	public static void main(String[] args) {

	}

}




