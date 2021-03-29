package ch05;

class A8{
	public String name;//이름
	public int age;//나이
}

class B8{
	public String name;//이름
	private int age;//나이  : 1이상...
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		if(age<1) age = 1;
		this.age = age;
	}
	
}

public class Ex8 {
	public static void main(String[] args) {
		A8 a1 = new A8();
		a1.name = "홍길동";
		a1.age = 26;
		A8 a2 = new A8();
		a2.name = "홍길자";
		a2.age = -10;
		//////////////////////////
		B8 b1 = new B8();
		b1.name = "강호동";
		/* b1.age = -10; */
		b1.setAge(-10);
		System.out.println(b1.name +"의 나이는 " + b1.getAge());
		//Math
	}
}





