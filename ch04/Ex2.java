package ch04;

import java.util.Scanner;

public class Ex2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//�Է��� ���ڰ� ¦������ Ȧ������ ����Ͻÿ�.
		System.out.print("���ڸ� �Է��ϼ���.");
		int a = sc.nextInt();//�Է��� ���ڸ� a�� ����
		if(a%2==0) {
			System.out.println(a +"�� ¦���Դϴ�.");
		} else {
			System.out.println(a +"�� Ȧ���Դϴ�.");
		}
	}
}






