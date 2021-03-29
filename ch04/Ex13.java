package ch04;

public class Ex13 {
	public static void main(String[] args) {
		//break : 반복문에서 중간에 종료되는 기능 예약어
		//문제.1~100사이의 합을 구하시오. 만약 합이 200이하의 값으로 만드세요.
		int sum = 0;
		for (int i = 1; i < 101; i++) {
			if(sum>200) {
				sum-=i;//200이 넘기전에 더해진 i값은 뺀다.
				System.out.println(i-1);
				break;
			}
			sum+=i;
		}
		System.out.println("sum : " + sum);
		//////////////////////////////////////
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 2; j++) {
				if(i+j>3) {break;}//for2를 빠져나옴.
				System.out.println(i+j);
			}//--for2
			System.out.println("---");
		}//--for1
		///////////////////////////////////////
		ns://ns 영역의 시작
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 2; j++) {
				if(i+j>3) {break ns;}//전체 반복문을 빠져나옴.
			}
		}	
			
	}
}








