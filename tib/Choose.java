package tib;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//import tibtest.GraphicsDrawLineEx.MyPanel;

public class Choose extends JFrame implements ActionListener{
	
	ImageIcon background, busanwhite, background2;
	JLabel labWelcome,labLogout;
	
	JLabel nameL,welL;
	JButton chBtn[]=new JButton[3];

	
public Choose() {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLayout(null);
	setTitle("Travle in Busan");
	
	busanwhite = new ImageIcon("tib/busanwhite350.png");
	JPanel panellogowhite = new JPanel() {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(busanwhite.getImage(), 0, 0, null);
			setOpaque(false);
		}
	};
	
	background = new ImageIcon("tib/background800.jpg");
	JPanel panelbackground = new JPanel() {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(background.getImage(), 0, 0, null);
			setOpaque(false);

		}
	};
	
	background2 = new ImageIcon("tib/background2.png");
	JPanel panelbackground2 = new JPanel() {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(background2.getImage(), 0, 0, null);
			g.setColor(Color.blue);
			g.drawLine(200,160, 500,160);
			setOpaque(false);

		}
	};
	
//////////////////////////////////////////////////////////////////////////////////////////
	
	

/// logo 사진이 제일 위에와야함//
	panellogowhite.setLayout(null);
	panellogowhite.setBounds(50, 50, 350, 100);
	add(panellogowhite);
	
	Font top = new Font("맑은고딕",Font.BOLD,20);
	Font top1 = new Font("맑은고딕",Font.BOLD,50);
	Font top2 = new Font("맑은고딕",Font.BOLD,45);

	Label labWelcome = new Label();
	panelbackground.add(labWelcome = new Label("Welcome"));
	labWelcome.setBounds(1100,30,70,30); 
	labWelcome.setBackground(new Color(0, 0, 0));
	labWelcome.setFont(top);
	labWelcome.setForeground(Color.WHITE);
	

	Label labLogout = new Label();
	panelbackground.add(labLogout = new Label("logout"));
	labLogout.setBounds(1230,30,70,30);
	labLogout.setBackground(new Color(0, 0, 0));
	labLogout.setFont(top);
	labLogout.setForeground(Color.WHITE);
	
	
	// background2 위치//
	panelbackground2.setLayout(null);
	panelbackground2.setBounds(150,180,1100,500);
	add(panelbackground2);

	// background 패널 위치는 제일 하단에 위치//
	panelbackground.setLayout(null);
	panelbackground.setBounds(0, 0, 1500, 800);
	add(panelbackground);
	

	panelbackground2.add(nameL=new JLabel("bean.name"));
	nameL.setBounds(200, 100, 300,50);
	nameL.setFont(top1);
	
	panelbackground2.add(welL=new JLabel("님 환영 합니다."));
	welL.setBounds(550, 100, 350,50);
	welL.setFont(top2);

	//MyDraw panel = new MyDraw();
	//this.add(panel,BorderLayout.CENTER);//안나타남
	 //this.panelbackground2.add(panel,BorderLayout.CENTER);//에러
	// panelbackground2.add(panel,BorderLayout.CENTER);//안나타남
	// panelbackground2.add(panel);
	 
	
	setSize(1500, 800);
	setVisible(true);
	validate();
			
	
}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
	}
	 class MyDraw extends JPanel{
	        public void paintComponent(Graphics g){
	            super.paintComponent(g);
	            g.setColor(Color.BLUE);
	            g.drawLine(200, 160, 900, 160);
	        }
	    }
	

	public static void main(String[] args) {
		new Choose();
	}

}
