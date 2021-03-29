package ch08;

class Animal{
	void move() {
		System.out.println("동물이 움직인다.");
	}
}

class Human extends Animal{
	@Override
	void move() {
		//하위클래스에서 오버라이딩 된 메소드 호출방식.(super.메소드)
		//super.move();
		System.out.println("사람이 두발로 걷는다.");
	}
}
class Tiger extends Animal{
	@Override
	void move() {
		System.out.println("호랑이가 네발로 뛴다.");
	}
}
class Eagle extends Animal{
	@Override
	void move() {
		System.out.println("독수리가 날개로 난다.");
	}
}


public class Ex4 {
	public static void main(String[] args) {
		/*다형성 : 상위클래스의 레퍼런스 변수가 하위클래스의 오버라이딩 된 메소드를
		   다양하게 호출 가능한 형태
		*/
		Animal ani = new Human();
		ani.move();
		ani = new Tiger();
		ani.move();
		ani = new Eagle();
		ani.move();
	}
}






