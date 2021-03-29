package ch09;

//Shape : 도형을 추상화 시킨 클래스
abstract class Shape{
	int x, y;//추상클래스는 일반적인 필드 선언 가능
	void move(int x, int y) {//추상클래스는 일반적인 메소드 선언 가능
		this.x=x;
		this.y=y;
	}
	abstract void draw();//추상메소드 : 상속받는 클래스는 강제적으로 오버라이딩
}


//삼각형
class Triangle extends Shape{
	@Override
	void draw() {
		System.out.println("삼각형 그리기");
	}
}
//사각형
class Rectangle extends Shape{
	@Override
	void draw() {
		System.out.println("사각형 그리기");
	}
}
//원
class Circle extends Shape{
	@Override
	void draw() {
		System.out.println("원 그리기");
	}
}

public class Ex3 {
	public static void main(String[] args) {
		//Shape s = new Shape();
	}
}


