package ch04;

import java.util.Scanner;

public class Ex10 {

	public static void main(String[] args) {
		//문제1.1~30사이의 값중에 3의 배수의 합을 구하시오.
		int sum = 0;
		for (int i = 1; i < 31; i++) {
			if(i%3==0) {
				sum+=i;
			}//if
		}//for
		System.out.println("sum : " + sum);
		//문제2.1~30사이의 값중에 짝수와 홀수의 합을 각각 구하시오.
		int sum1 = 0/*짝수의합*/, sum2 = 0/*홀수의 합*/;
		for (int i = 1; i < 31; i++) {
			if(i%2==0) {
				sum1+=i;
			}else if(i%2!=0) {
				sum2+=i;
			}
		}//--for
		System.out.println("짝수의 합 : " + sum1);
		System.out.println("홀수의 합 : " + sum2);
		//문제3.입력한 숫자의 구구단을 출력하시오.
		Scanner sc = new Scanner(System.in);
		System.out.print("출력할 구구단 숫자를 입력하세요.");
		//int a = sc.nextInt();
		int a = 0;
		for (int i = 1; i < 10; i++) {
			System.out.println(a + " X " + i + " = " +(a*i));
		}
		System.out.println();
		/*문제4.1~50사이 숫자 중에 3,6,9게임에 숫자의 합은?
		* 3+6+9+13+16+19+23.....+30+31+32....+39+43+....49=627
		* Hint %, / 잘 사용
		*/
		sum = 0;
		for (int i = 1; i < 51; i++) {
			int j = i%10;
			int n = i/10;
			if(j==3||j==6||j==9) {
				System.out.print(i+"  ");
				sum+=i;
			}else if(n==3) {
				System.out.print(i+"  ");
				sum+=i;
			}
		}
		System.out.println("\nsum : " + sum);
	}
}







