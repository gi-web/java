package ch05;

class A6{
	A6(){
		/*this�� �ڱ� �ڽ��� ����Ű�� Ű����*/
		this("msg");
		System.out.println("����Ʈ ������");
		//����Ʈ �����ڸ� �ʿ��� �ڵ�
	}
	A6(int a){
		this("msg");
	}
	A6(String s){
		super();
		System.out.println("���ڿ� ������");
		//�����ڰ� �ؾ� �� ��Ȱ�� �ڵ尡 �� ����
	}
}

public class Ex6 {
	public static void main(String[] args) {
		A6 a = new A6();
	}
}






