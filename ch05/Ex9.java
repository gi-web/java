package ch05;

import ch05_1.Ex10;

class A9{
	protected int a;
}

public class Ex9 {
	public static void main(String[] args) {
		/*protected : ������ ��Ű����  ����� public ����(������)
		 * SUN���� �����Ǵ� ��κ��� �ʵ�� �޼ҵ�� public
		 * ���࿡ protected�� ����� �ʵ�� �޼ҵ带 ����Ϸ��� ��ӹۿ� 
		 * ����� ����. ������ ������ ����� Ŭ������ SUN�� Ŭ������ ������
		 * ��Ű�� ���� �Ұ��� �ϱ� ������...
		 * */
		A9 a1 = new A9();
		a1.a = 22;//������ ��Ű���̱� ������ ���� ����
		Ex10 e1 = new Ex10();
		e1.a = 22;//public ����
		//e1.b = 23;//protected �Ұ���
	}
}






