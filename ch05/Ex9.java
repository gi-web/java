package ch05;

import ch05_1.Ex10;

class A9{
	protected int a;
}

public class Ex9 {
	public static void main(String[] args) {
		/*protected : 동일한 패키지와  상속은 public 개념(다음에)
		 * SUN에서 제공되는 대부분의 필드와 메소드는 public
		 * 만약에 protected로 선언된 필드와 메소드를 사용하려면 상속밖에 
		 * 방법이 없다. 이유는 본인이 만드는 클래스와 SUN에 클래스와 동일한
		 * 패키지 선언 불가능 하기 때문에...
		 * */
		A9 a1 = new A9();
		a1.a = 22;//동일한 패키지이기 때문에 접근 가능
		Ex10 e1 = new Ex10();
		e1.a = 22;//public 가능
		//e1.b = 23;//protected 불가능
	}
}






