package ch03;

public class Ex3 {
	public static void main(String[] args) {
		int a = 10;
		int b = 0;
		//System.out.println(a/b);
		//& : and 연산자, | : or 연산자
		System.out.println((a>b)&(a<b));
		System.out.println((a>b)&&(a<b));
		/*&는 연산자는 결과에 관계없이 모든 코드가 실행되지만
		 * &&는 앞에 연산자의 결과가 false이면 뒤에 있는 코드 실행이 안됨.
		 * */
		//System.out.println((a<b)&(a/b==0));
		System.out.println((a<b)&&(a/b==0));
		System.out.println((a>b)||(a/b==0));
		
	}
}







