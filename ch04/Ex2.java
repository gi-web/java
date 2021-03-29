package ch04;

import java.util.Scanner;

public class Ex2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//입력한 숫자가 짝수인지 홀수인지 출력하시오.
		System.out.print("숫자를 입력하세요.");
		int a = sc.nextInt();//입력한 숫자를 a에 리턴
		if(a%2==0) {
			System.out.println(a +"는 짝수입니다.");
		} else {
			System.out.println(a +"는 홀수입니다.");
		}
	}
}







