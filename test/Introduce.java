package test;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UnsupportedLookAndFeelException;



import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Introduce extends JFrame implements ActionListener { //무박///하루당 아이템 6개 이하까지만 선택가능
	
	ImageIcon  busan, background, background2, profileUpload, site1, site2;
	JLabel labWelcome,labLogout, lablike, labmail, labtext1;
	TextArea ta1, ta2, ta3;
	JButton btnu;
	Label labday;
	
	
	public Introduce() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setTitle("Travle in Busan");

////////////////////////////////각위치별 Panel/////////////////////////////////////////////////////////////
		busan = new ImageIcon("tib/busanwhite157.png");
		JPanel panellogo = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(busan.getImage(), 0, 0, null);		
				setOpaque(false);
			}
		};
		
		profileUpload = new ImageIcon("tib/profileUpload.jpg");
		JPanel panelprofile = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(profileUpload.getImage(), 0, 0, null);		
				setOpaque(false);
			}
		};
		
	
		site1 = new ImageIcon("tib/marin.jpg");
		JPanel panelsite1 = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(site1.getImage(), 0, 0, null);		
				setOpaque(false);
			}
		};
		
		site2 = new ImageIcon("tib/site2.jpg");
		JPanel panelsite2 = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(site2.getImage(), 0, 0, null);		
				setOpaque(false);
			}
		};
		
		background2 = new ImageIcon("tib/beige.png");
		JPanel panelbackground2 = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(background2.getImage(), 0, 0, null);		
				setOpaque(false);
				
			}
		};
		
		background = new ImageIcon("tib/background1100.jpg");
		JPanel panelbackground = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(background.getImage(), 0, 0, null);		
				setOpaque(false);
				
			}
		};

/////////////////////////////////////////////////////////////////////////////////
		
		JPanel info = new JPanel();
		info.setBounds(450, 120, 220, 200);
		info.setBackground(Color.ORANGE);
		add(info);
		
		
		
		JPanel day1 = new JPanel();
		day1.setBounds(650, 340, 200, 250);
		day1.setBackground(Color.ORANGE);
		add(day1);

		/*JPanel write1 = new JPanel();
		write1.setBounds(600, 670, 650, 170);
		write1.setBackground(Color.ORANGE);
		add(write1);
		
		JPanel write2 = new JPanel();
		write2.setBounds(600, 870, 650, 170);
		write2.setBackground(Color.ORANGE);
		add(write2);*/
		

		
		
///////////////////////////////하단 등록하기 버튼/////////////////////////////////////////////////
		JPanel buttonupload = new JPanel();
		buttonupload.setBounds(700, 950, 90, 35);
		add(buttonupload);
		
		
/////////////////////////////이미지 위치//////////////////////////////////////////////////
		panellogo.setLayout(null);
		panellogo.setBounds(180, 20, 1100, 50);
		add(panellogo);
		panellogo.add(labWelcome=new JLabel("Welcome"));
		labWelcome.setBounds(950,0,100,50);
		panellogo.add(labLogout=new JLabel("logout"));
		labLogout.setBounds(1050,0,100,50);
		
		panelprofile.setLayout(null);
		panelprofile.setBounds(220, 120, 200, 200);
		add(panelprofile);
		
		
		panelsite1.setLayout(null);
		panelsite1.setBounds(220, 670, 350, 170);
		add(panelsite1);
	
		panelsite2.setLayout(null);
		panelsite2.setBounds(220, 870, 350, 170);
		add(panelsite2);
		
		
		
		
		panelbackground2.add(ta1 =new TextArea("본인을 소개하는 글을 작성해주세요 (500자 내)", 5 ,5, TextArea.SCROLLBARS_VERTICAL_ONLY));
		ta1.setBounds(520, 40, 550, 200);
		
		panelbackground2.add(ta2 =new TextArea("여행하시는 장소에 대하여 간력한 계획 소개글을 남겨주세요 (500자 내)", 5 ,5, TextArea.SCROLLBARS_VERTICAL_ONLY));
		ta2.setBounds(420, 590, 650, 170);
		
		panelbackground2.add(ta3 =new TextArea("여행하시는 장소에 대하여 간력한 계획 소개글을 남겨주세요(500자 내)", 5 ,5, TextArea.SCROLLBARS_VERTICAL_ONLY));
		ta3.setBounds(420, 790, 650, 170);
		ta3.setCaretPosition(0);
		
		
		
		
		panelbackground2.setLayout(null);
		panelbackground2.setBounds(180,80,1100,1100);
		add(panelbackground2);
		
		panelbackground.setLayout(null);
		panelbackground.setBounds(0,0,1500,1100);
		add(panelbackground);
		

//////////////////////////////폰트////////////////////////////////////////////////////////		
		Font top = new Font("맑은고딕",Font.BOLD,15);
		Font day = new Font("맑은고딕",Font.BOLD,20);
		labWelcome.setFont(top);
		labLogout.setFont(top);
		labWelcome.setForeground(Color.WHITE);
		labLogout.setForeground(Color.WHITE);
		/*labday.setFont(top);*/

	
		btnu = new JButton("등록하기");
		btnu.setBounds(0,0,80,30);
		btnu.setBackground(Color.white);
		buttonupload.add(btnu);
		btnu.addActionListener(this);
		
		setSize(1500,1100);
		setVisible(true);
		validate();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String item = ta1.getText(); //입력된 문자열 리턴
		//System.out.println(item.trim().length());
		if(item.trim().length()==0) {// 입력을 한 값이 공백이라면 , trim 빈값을 제거시키는 기능 
			MDialog jd = new MDialog(this, "알림", "입력하세요", true);
			int width = 200;
			int height = 150;
			int px = getX();
			int py = getY();
			int x = px+getWidth()/2-width/2;
			int y = py+getHeight()/2-height/2;
			
			
			/*
			 * Label labtext1 = new Label(); jd.add(labtext1 = new Label("입력하세요"));
			 */

			jd.setBounds(x, y, width, height);
			jd.setVisible(true);
		}
		ta1.setText(""); // 빈값으로 초기화 시킨다. // 자리만 차지하고 값은 없는것 -> 문자를 입력하세요 
		ta1.requestFocus(); // 포커스를 가져온다. 
	
	} 

	class MDialog extends JDialog implements ActionListener{
		
		Button btnu;
		
		public MDialog(Frame f, String title, String msg,boolean flag) {
			super(f, title, flag);
			setLayout(new FlowLayout());
			add(new Label(msg, Label.CENTER));
			add(btnu = new Button("확인"));
			btnu.addActionListener(this); ////////////// 중요!!
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();
		}
	}

	public static void main(String[] args) {
		new Introduce();
	}
}