package ch05;

class A3{
	int a;
	/*생성자 : 객체를 만드는 특별한 메서드
	 * 1.클래스명과 동일
	 * 2.리턴타입 선언 자체가 없다.
	 * 3.만약에 클래스 안에 생성자 구현X. JVM이 디폴트 생성자를 제공
	 * 4.생성자가 하나라도 정의 되어 있으면 JVM 디폴트 생성자 제공 안함.
	 * */
	A3(){
		System.out.println("생성자 호출");
	}
	A3(String s){
		
	}
	A3(int a){
		
	}
	
}

public class Ex3 {
	public static void main(String[] args) {
		//생성자 많이 존재하는 이유 : 객체가 생성되는 다양한 case.
		A3 aa = new A3();
		A3 bb = new A3("하하");
		A3 cc = new A3(23);
		new String();//String 클래스는 생성자 15개 선언.
	}
}












