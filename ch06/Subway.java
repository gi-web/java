package ch06;

public class Subway {
	public String lineNumber;//³ë¼±¹øÈ£
	public int passengerCount;//½Â°´¼ö
	public int money;//ÁöÇÏÃ¶ÀÇ ¼öÀÔ

	//»ı¼ºÀÚ
	public Subway(String lineNumber) {
		this.lineNumber = lineNumber;
	}
	//¸Ş¼Òµå
	public void take(int money) {
		this.money += money;
		passengerCount++;
	}
	public void showInfo() {
		System.out.println("ÁöÇÏÃ¶ : " + lineNumber);
		System.out.println("½Â°´ : " + passengerCount);
		System.out.println("¼öÀÔ : " + money);
		System.out.println("-----------------------");
	}
	
}
