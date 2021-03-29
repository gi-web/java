package ch02;

public class Ex4 {
	
	static boolean b1;
	static int i1;

	public static void main(String[] args) {
		//자바 기본형 Data Type 8가지
		System.out.println(b1);
		System.out.println(i1);
		boolean b = true;//기본값 => false
		char c = '가';
		//char c1 = '가나';//오류
		//char c2 = 'ab';//오류
		//정수 : byte> short> int> long
		byte bt = 10;
		//byte bt1 = 128;//1byte 범위 : -128~127
		short s = 200;
		int i = 2000;
		long l = 12345678900L;
		//4가지 정수의 범위 출력
		System.out.println(Byte.MIN_VALUE+"~"+Byte.MAX_VALUE);
		System.out.println(Short.MIN_VALUE+"~"+Short.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE+"~"+Integer.MAX_VALUE);
		System.out.println(Long.MIN_VALUE+"~"+Long.MAX_VALUE);
		//실수형
		//실수형의 기본값은 double이므로 더 작은 타입으로 선언을 하려면 반드시 f or F
		float f = 3.14f;
		double d = 3.33;
	}

}






