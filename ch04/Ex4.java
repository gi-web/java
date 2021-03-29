package ch04;

import java.util.Scanner;

public class Ex4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//입력한 숫자가 양수,음수,0을 구분하시오.
		System.out.print("숫자를 입력하세요.");
		int a = sc.nextInt();
		if(a>0) {
			System.out.println("양수입니다.");
		}else if(a<0) {
			System.out.println("음수입니다.");
		}else if(a==0) {
			System.out.println("0입니다.");
		}
	}
}










