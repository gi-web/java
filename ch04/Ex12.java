package ch04;

public class Ex12 {

	public static void main(String[] args) {
		//while문을 이용해서 1~10까지 합을 구하시오.
		int sum =0;
		int i =1;
		while(i<11) {
			sum+=i;
			i++;
		}
		System.out.println("sum : " + sum);
		
		//break : 자기를 감싸고 있는 반복문을 빠져 나옴.
		int j = 0;
		while(true) {
			if(j==5) {break;}
			j++;
			System.out.println(j);
		}
		//do-while문은 일단은 무조건 실행을 한번 먼저함.
		int k = 0;
		do {
			if(k==5) {break;}
			k++;
		} while (true);
	}
}






