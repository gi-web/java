package ch11;

import java.util.StringTokenizer;

public class StringTokenizerEx1 {
	public static void main(String[] args) {
		String s1 = "�ڹ� JSP Android Spring";
		StringTokenizer st1 = new StringTokenizer(s1);
		int n1 = st1.countTokens();//������ ������ �Ͽ� ��ū�� ���ڿ��� ����
		for (int i = 0; i < n1; i++) {
			String s = st1.nextToken();
			System.out.println(s);
		}//---for
		System.out.println("-----------------------");
		String s2 = "����;����,�뱸,�λ�;����;���,��õ";
		StringTokenizer st2 = new StringTokenizer(s2,",;");
		String arr2[] = new String[st2.countTokens()];
		for (int i = 0; i < arr2.length; i++) {
			arr2[i] = st2.nextToken();
			System.out.println(arr2[i]);
		}//---for
		
	}
}














