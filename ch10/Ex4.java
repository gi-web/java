package ch10;

abstract class Tv{
	//�ʵ�
	String color;
	boolean power;
	int ch;
	//�Ϲݸ޼ҵ�
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
	//�߻�޼ҵ�
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
