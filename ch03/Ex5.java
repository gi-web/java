package ch03;

public class Ex5 {
	public static void main(String[] args) {
		//����,����,Ư������ : 1byte, �ѱ� : 2byte
		//A , �� 
		//80byte
		//System.out.println(Integer.toBinaryString(a));
		//System.out.println(Integer.toBinaryString(b));
		int a = 5;  //00000101 <- 1byte(8bit)
		int b = 10;//00001010
		int c = a&b;
		int d = a|b;
		System.out.println("c : " + c);
		System.out.println("d : " + d);
		int e = a^b;//^(XOR) �� ��Ʈ�� �ٸ� ���̸� 1�̰� ���� ���̸� 0
		int f = ~a;//~(����) : ��Ʈ���� 0�� 1�� 1�� 0���� �ٲٴ� ������
		System.out.println("e : " + e);
		System.out.println("f : " + f);
	}
}







