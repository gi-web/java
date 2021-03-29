package ch06;

/*this : 자기자신(메모리 만들어진 객체)을 가르키는 예약어
 * 1.this() : 자신의 객체 생성을 의미
 * 2.this.필드 : 객체의 속성을 뜻하는 필드를 사용할때
 * 메소드 안에 지역변수와 동일한 변수명을때 필드를 사용하기 목적이다.
 * 3.자신의 객체를 반환할때 (지금은 절때 안함.)*/
class A1 extends Object{
	//생성자 : 객체를 만드는 메소드
	//생성자를 선언이유 : 객체가 생성될때 필요한 초기적인 값을 구현 목적.
	public A1() {
		super();//super는 누구? Object
	}
	public A1(int i) {
		this();
	}
}

class B1{
	
	int age;
	int num;
	String name;
	
	public void setAge(int age) {
		//변수명 선언
		int num = this.age *10;
		System.out.println(age);
	}
	
	public void prn() {
		/*일반적으로 필드와 동일한 지역변수는 많이 선언이 된다.
		* 그럴때에 필드를 사용하려면 this을 앞에 붙이면 된다.
		*/
		String 이름;//local variable 지역변수
	}
	
	public void m(B1 b) {
		
	}
	public void m1() {
		m(this);
	}
}

public class Ex1 {

	public static void main(String[] args) {

	}

}
