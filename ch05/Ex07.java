package ch05;

public class Ex07 {
	public static void main(String[] args) {
		/*접근 지정자 : 클래스, 필드, 메소드 앞에 오는 접근 할 수 있는 권한 설정
		 * private, protected, public, 없는 경우(friendly)
		 * public : 모든 상황에 접근이 가능
		 * protected : 동일한 패키지 or 상속 일때만 가능
		 * private : 같은 클래스 내에서만 사용 가능
		 * */
		String s = new String("코로나");
		int len = s.length();
		System.out.println("len : " + len);
		
	}
}
