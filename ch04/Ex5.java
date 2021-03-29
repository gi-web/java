package ch04;

import java.util.Scanner;

public class Ex5 {

	public static void main(String[] args) {
		/*입력한 달숫자 별로 계절을 출력하시오.
		*(12~2:겨울,3~5:봄,6~8:여름,9~11:가을)
		*Hint : ||연산자 */
		Scanner sc = new Scanner(System.in);
		System.out.print("달(month)를 입력하세요.");
		int m = sc.nextInt();
		if(m==12||m==1||m==2) {
			System.out.println("겨울입니다.");
		}else if(m==3||m==4||m==5) {
			System.out.println("봄입니다.");
		}else if(m==6||m==7||m==8) {
			System.out.println("여름입니다.");
		}else if(m==9||m==10||m==11) {
			System.out.println("가을입니다.");
		}else{
			System.out.println("해당되는 계절이 없습니다.");
		}
	}

}








