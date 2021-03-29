package ch01;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;


public class MyFrame2 extends Frame implements ActionListener{
	
	Button btn;
	boolean flag = false;
	
	public MyFrame2() {
		setTitle("MyFrame2");
		setSize(300, 300);
		setVisible(true);
		btn = new Button("¹öÆ°");
		add(btn,"South");
		btn.addActionListener(this);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		setBackground(rColor());
	}
	
	public Color rColor() {
		Random rd = new Random();
		int r = rd.nextInt(256); 
		int g = rd.nextInt(256); 
		int b = rd.nextInt(256); 
		return new Color(r,g,b);
	}
	
	public static void main(String[] args) {
		new MyFrame2();
	}
}






