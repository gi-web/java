package ch07;

public class Ex4 {
	public static void main(String[] args) {
		//배열 복사
		int arr1[] = {10,20,30,40,50};
		int arr2[] = new int[arr1.length];
		for (int i = 0; i < arr2.length; i++) {
			arr2[i] = arr1[i];
			System.out.println(arr2[i]);
		}
		System.out.println("-------------------");
		int arr3[] = new int[arr1.length];
		//arraycopy(복사할배열,복사할 첫위치,대상배열,복사 첫위치,개수)
		System.arraycopy(arr1, 0, arr3, 0, arr1.length);
		for (int i = 0; i < arr3.length; i++) {
			System.out.println(arr3[i]);
		}
		////////////////////////////////////////////
		String str[] = {"카카오","유튜브","인스타","틱톡","트위터"};
		for (int i = 0; i < str.length; i++) {
			System.out.println(str[i]);
		}
		System.out.println("----------------");
		for (String st : str) { //1.5
			System.out.println(st);
		}
		
		
	}
}






