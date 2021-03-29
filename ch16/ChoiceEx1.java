package ch16;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ChoiceEx1 extends MFrame 
implements ItemListener{
	
	String sair[] = {"대한항공","아시아나","에어부산","진에어"};
	String scity[] = {"서 울","대 전","대 구","부 산","제주도"};
	Choice air, city;
	
	public ChoiceEx1() {
		super(300, 300 , new Color(100,200,100));
		setTitle("Choice Example2");
		air = new Choice();
		city = new Choice();
		for (int i = 0; i < sair.length; i++) {
			air.add(sair[i]);
		}
		for (int i = 0; i < scity.length; i++) {
			city.add(scity[i]);
		}
		add(air); add(city);
		//city 초이스에 33라인 메소드(itemStateChanged) 호출(연결)
		city.addItemListener(this);//
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		repaint();//내부적으로 paint 메소드 호출
	}
	
	@Override //그림을 그리는 메소드. 객체를 생성하면 자동적으로 한번 호출
	public void paint(Graphics g/*붓*/) {
		g.setColor(Color.RED);
		String str = "항공사 선택 : " + air.getSelectedItem();
		g.drawString(str, 30, 120);
		g.setColor(Color.BLUE);
		str = "도시 선택 : " + city.getSelectedItem();
		g.drawString(str, 30, 150);
	}
	
	public static void main(String[] args) {
		new ChoiceEx1();
	}
}



