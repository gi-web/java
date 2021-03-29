package ch10;

interface A3 {
	void p();
}

interface B3 {
	void p1();
}
//인터페이스끼리는 다중상속 가능(문법)
interface C3 extends A3, B3 {
	void p2();
}

public class Ex3 {

	public static void main(String[] args) {

	}

}
