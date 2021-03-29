package ch05;

import java.awt.Frame;
import java.lang.*; //생략

class A2{}
//주석 단축키 : ctrl+shift+?
/* class String{} */


public class Ex2 {
	public static void main(String[] args) {
		/*동일한 패키지 있는 클래스 따로 import 사용가능.
		 * 그러나 다른 패키지에 있는 클래스는 반드시 import 해야한다.
		 * 단.java.lang에 있는 클래스들은 예외.
		*/
		A2 a = new A2();
		Frame f = new Frame();
	}
}
