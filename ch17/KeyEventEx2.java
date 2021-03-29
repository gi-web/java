package ch17;

import java.awt.Button;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class KeyEventEx2 extends MFrame{
	
	Button move;
	
	public KeyEventEx2() {
		super(400, 500, new Color(100,200,100));
		setLayout(null);
		move = new Button("move");
		move.setBounds(200, 250 , 50 ,30);
		move.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {
				int code = e.getKeyCode();
				String txt = KeyEvent.getKeyText(code);
				//System.out.println(code + " : " + txt);
				int x = move.getX();
				int y = move.getY();
				if(txt.equals("Right")) {
					if(x>getWidth()-67) {return;}
					x+=10;
				}else if(txt.equals("Left")) {
					if(x<12) {return;}
					x-=10;
				}else if(txt.equals("Up")) {
					if(y<37) {return;}
					y-=10;
				}else if(txt.equals("Down")) {
					if(y>getHeight()-49) {return;}
					y+=10;
				}
				move.setLocation(x, y);
			}
		});
		add(move);
		move.requestFocus();
		validate();
	}
	
	public static void main(String[] args) {
		new KeyEventEx2();
	}
}



