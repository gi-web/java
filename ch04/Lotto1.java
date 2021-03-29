package ch04;

import java.util.Random;

public class Lotto1 {
	public static void main(String[] args) {
		// 로또 : 1~45 사이의 중복없는 6개의 번호를 리턴
		Random r = new Random();
		int lotto[] = new int[6];
		
		for (int i = 0; i < lotto.length; i++) {
			lotto[i] = r.nextInt(45)+1;//0~44사이의 난수
			for (int j = 0; j < lotto.length; j++) {
				if(lotto[i]==lotto[j]);
				lotto[j]=r.nextInt(45)+1;
			}
			System.out.print(lotto[i] + "\t");
		}
		
		
	}
}





