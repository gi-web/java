package ch16;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextEx2 extends MFrame 
implements ActionListener{
	
	TextField tf;
	TextArea ta;
	Button btn;
	
	public TextEx2() {
		super(260,300);
		setTitle("MyChat v1.0");
		setLayout(new BorderLayout());
		add(ta = new TextArea(),BorderLayout.CENTER);
		Color c[] = MColor.rColor2();
		ta.setBackground(c[0]);
		ta.setForeground(c[1]);
		ta.setEditable(false);
		//Panel : middle container
		Panel p = new Panel();
		p.add(tf = new TextField(22));
		p.add(btn = new Button("SEND"));
		add(p, BorderLayout.SOUTH);
		tf.addActionListener(this);//컴포넌트랑 이벤트핸들러 연결
		btn.addActionListener(this);
		validate();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String s = tf.getText();
		if(s.length()==0)
			s = "입력을 하세요.";
		ta.append(s+"\n");
		tf.setText("");
		tf.requestFocus();
	}
	
	public static void main(String[] args) {
		new TextEx2();
	}
}


