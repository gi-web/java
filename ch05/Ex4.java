package ch05;

class A4{
	/*JVM은 생성자가 하나도 없을때 디폴트 생성자를 제공을 한다.
	 * 매개변수 int를 받는 생성자 존재하기 때문에 디폴트 생성자는 따로 정의.
	 * */
	A4(){
		
	}
	A4(int a){
		
	}
}

public class Ex4 {
	public static void main(String[] args) {
		A4 aa = new A4();
		A4 bb = new A4(22);
	}
	
	
}
