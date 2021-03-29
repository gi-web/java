package ch16;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;

import oracle.net.aso.v;

public class DesignEx2 extends MFrame{

	TextField tf;
	TextArea ta;
	Button btn1, btn2;
	Panel p1, p2;
	
	public DesignEx2() {
		super(500,400);
		setTitle("디자인 예제2");
		setLayout(new BorderLayout());
		p1 = new Panel();
		p1.add(tf = new TextField("Hello 홍길동~~", 30));
		
		p2 = new Panel();
		p2.add(btn1 = new Button("마우스 시험용"));
		p2.add(btn2 = new Button("종료"));
		
		add(p1, BorderLayout.NORTH);
		add(ta = new TextArea());
		add(p2, BorderLayout.SOUTH);
		
		validate();
	}
	
	
	public static void main(String[] args) {
		new DesignEx2();
	}
}

