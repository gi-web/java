package ch11;

import java.util.Vector;

public class WrapperEx3 {
	public static void main(String[] args) {
		//자바기본형 <---> Warapper 클래스 : 5.0에서 지원되는 문법
		int a = 10;
		Integer ie = a;//오토박싱
		int b = ie;//오토언박싱
		
		int c = ie.intValue();
		Integer ie2 = Integer.valueOf(10);
		
		Vector v = new Vector();
		v.add(10);//오토박싱이 내부적으로 발생
	}//--main
}//--class















