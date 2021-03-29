package ch07;

public class Ex1 {

	public static void main(String[] args) {
		//배열 선언
		int arr1[] = new int[10];
		int[] arr2 = new int[10];
		int arr3[] = new int[] {1,2,3,4,5};
		int arr4[] = {1,2,3,4,5};
		String str1[] = new String[3];//클래스 타입의 기본값은 null이다.
		System.out.println(str1[0]);
		System.out.println(str1[1]);
		System.out.println(str1[2]);
		Ex1 e = new Ex1();
		Ex1 e1 = null;//null : 객체를 가르키고 있지 않은 상태
		System.out.println(e.toString());//만들어지 객체가 가지고 있는 메소드 호출
		System.out.println(e1.toString());//없는 객체에 메소드 호출
	}
}





