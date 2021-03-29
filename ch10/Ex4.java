package ch10;

abstract class Tv{
	//필드
	String color;
	boolean power;
	int ch;
	//일반메소드
	void powerOnOff() {
		power=!power;
	}
	void chUp() {
		ch++;
	}
	void chDown() {
		ch--;
		if(ch<0)
			ch = 0;
	}
	//추상메소드
	abstract void setModel();
}

interface RemoteControl{
	void turnOn();
	void turnoff();
}

class SMTv extends Tv implements RemoteControl{

	@Override
	public void turnOn() {
	}

	@Override
	public void turnoff() {
	}

	@Override
	void setModel() {
	}
	
}
class LGTv extends Tv implements RemoteControl{
	@Override
	public void turnOn() {
	}
	@Override
	public void turnoff() {
	}
	@Override
	void setModel() {
	}
}

public class Ex4 {
	public static void main(String[] args) {

	}
}
