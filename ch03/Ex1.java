package ch03;

public class Ex1 {

	public static void main(String[] args) {
		int a = 10;
		int b = 10;
		//a = a + 1
		int c = ++a;// 1이 증가 후에 c에 대입
		int d = b++;//대입 후에 1이 증가
		//한줄 복사 : ctrl + alt + 방향키
		System.out.println("a : " + a);
		System.out.println("b : " + b);
		System.out.println("c : " + c);
		//실행 : ctrl + F11
		System.out.println("d : " + d);
	}

}
