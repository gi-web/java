package ch04;

import java.util.Scanner;

public class Ex5 {

	public static void main(String[] args) {
		/*�Է��� �޼��� ���� ������ ����Ͻÿ�.
		*(12~2:�ܿ�,3~5:��,6~8:����,9~11:����)
		*Hint : ||������ */
		Scanner sc = new Scanner(System.in);
		System.out.print("��(month)�� �Է��ϼ���.");
		int m = sc.nextInt();
		if(m==12||m==1||m==2) {
			System.out.println("�ܿ��Դϴ�.");
		}else if(m==3||m==4||m==5) {
			System.out.println("���Դϴ�.");
		}else if(m==6||m==7||m==8) {
			System.out.println("�����Դϴ�.");
		}else if(m==9||m==10||m==11) {
			System.out.println("�����Դϴ�.");
		}else{
			System.out.println("�ش�Ǵ� ������ �����ϴ�.");
		}
	}

}








