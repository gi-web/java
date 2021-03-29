package ch04;

import java.util.Arrays;
import java.util.Random;

public class Lotto {
	public static void main(String[] args) {
		int lucky[] = getLotto();
		for (int i = 0; i < lucky.length; i++) {
			System.out.print(lucky[i]+"\t");
		}
	}
	
	//로또 번호 리턴(반환) 기능의 메소드 구현
	public static int[] getLotto() {
		Random r = new Random();
		int lotto[] = new int[6];
		for (int i = 0; i < lotto.length; i++) {
			//중복이 안되면 빠져 나오는 반복문
			while(true) {
				int j = r.nextInt(45)+1;
				lotto[i] = j;
				boolean flag = false;
				switch(i) {
					case 0: flag = true;
					case 1: if(j!=lotto[0]) flag = true;
					case 2: if(j!=lotto[0]&&j!=lotto[1]) flag = true;
					case 3: if(j!=lotto[0]&&j!=lotto[1]
							&&j!=lotto[2]) flag = true;
					case 4: if(j!=lotto[0]&&j!=lotto[1]
							&&j!=lotto[2]&&j!=lotto[3]) flag = true;
					case 5: if(j!=lotto[0]&&j!=lotto[1]
							&&j!=lotto[2]&&j!=lotto[3]&&j!=lotto[4]) flag = true;
				}//--switch
				if(flag) break;
			}//---while
		}//--for
		
		Arrays.sort(lotto);//자동 오름차순 정렬 (내림차순)
		return lotto;
	}
}










