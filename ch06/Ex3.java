package ch06;

import java.awt.Color;

class A3{
	private A3() {}
	static int i;
	static void prn() {
		System.out.println(i);
	}
}

public class Ex3 {
	public static void main(String[] args) {
		/*static 변수 및 메소드는 객체를 생성하지 않고도 사용 가능*/
		A3.i = 22;
		A3.prn();
		//A3 a = new A3();
		int a = -22;
		/*Math 클래스의 모든 필드와 메소드는 static.
		 * 이유는 필요한 필드 및 메소드는 클래스명으로 접근하여 사용하고
		 * 객체 생성은 하지마. 그래서 Math 클래스의 생성자는 private 이다.*/
		int b = Math.abs(a);
		System.out.println(b);
		/*Frame에 입력한 값들은 모두 문자열(String 타입)입니다.
		 * 이러한 숫자 모양의 문자열을 계산하기 위해서는 정수로 변환*/
		String s1 = "22";
		String s2 = "23";
		Integer it = new Integer(0);
		int i = it.parseInt(s1);
		i = Integer.parseInt(s1);
		int j = Integer.parseInt(s2);
		System.out.println(i+j);
		//PI는 상수(static final)
		System.out.println(Math.PI);
		System.out.println(Color.RED);
		System.out.println(Color.red);
	}
}









