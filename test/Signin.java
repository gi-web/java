package test;

import java.awt.Graphics;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.print.attribute.standard.JobOriginatingUserName;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Signin extends JFrame {///

	ImageIcon background, busanwhite, background2;
	JLabel labWelcome, labLogout;
	
	JLabel nameL;//닉네임 레이블
	JTextField nameTf;//닉네임
	JButton checkNBtn;//닉네임 중복확인
	
	JLabel idL;//id 레이블
	JTextField idTf; //id입력하는 텍스트 필드 변수
	JButton checkIBtn;//id 중복확인
	
	JLabel passL;
	JPasswordField passTf; //password입력하는 텍스트 필드 변수
	JButton checkPBtn;//password 확인
	
	JLabel passL2;
	JPasswordField passTf2; //password 재입력하는 텍스트 필드 변수
	JButton checkPBtn2;//password 재확인
	
	JRadioButton rMan, rWoman;
	
	JTextField birthTf; //생년월일 입력하는 텍스트 필드 변수
	JButton calBtn;//생년월일 선택하는 버튼
	
	JTextField emailTf; //생년월일 입력하는 텍스트 필드 변수
	
	JComboBox comboTel;//핸드폰 번호 입력
	JTextField telTf2, telTf3;
	

	JPanel pMain;
	JPanel[] p;
	

	public Signin() {
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

		background = new ImageIcon("tib/background1100.jpg");
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
				setOpaque(false);

			}
		};
//////////////////////////////////////////////////////////////////////////////////////////

		/// logo 사진이 제일 위에와야함//
		panellogowhite.setLayout(null);
		panellogowhite.setBounds(50, 50, 350, 100);
		add(panellogowhite);

		// background2 위치//
		panelbackground2.setLayout(null);
		panelbackground2.setBounds(150,180,1100,900);
		add(panelbackground2);

		// background 패널 위치는 제일 하단에 위치//
		panelbackground.setLayout(null);
		panelbackground.setBounds(0, 0, 1500, 1100);
		add(panelbackground);
		
		pMain = new JPanel();
		pMain.setLayout(new GridLayout(8,1));
		panelbackground2.add(pMain);
		pMain.setBounds(500, 50, 500,500);
		/*pMain.setBackground(bg);*/
		
		p = new JPanel[8];
		for(int i = 0;i<p.length;i++) {
			p[i] = new JPanel();
			pMain.add(p[i]);
		}
		
		Font top = new Font("맑은고딕",Font.BOLD,20);
		//p[0].setLayout(null);
		//p[0].add( nameL=new JLabel("닉네임"));
		//p[0].add(nameTf=new JTextField());
		//p[0].add(checkNBtn= new JButton("중복확인"));
		nameL=new JLabel("닉네임");
		nameTf=new JTextField();
		checkNBtn= new JButton("중복확인");
		nameL.setBounds(430,70,100,30);
		nameL.setFont(top);
		nameTf.setBounds(510, 70, 200, 30);
		nameTf.setFont(top);
		
		
		p[1].add(new JLabel("ID 입력"));
		p[1].add(idTf = new JPasswordField(20));
		p[1].add(checkIBtn = new JButton("중복확인"));
		
		
		p[2].add(new JLabel("PASS 입력   "));
		p[2].add(passTf = new JPasswordField(20));
		p[2].add(checkPBtn = new JButton("확  인"));
		
		p[3].add(new JLabel("PASS 재입력  "));
		p[3].add(passTf2 = new JPasswordField(20));
		p[3].add(checkPBtn2 = new JButton("확  인"));
		
		p[4].add(new JLabel("성별 : "));
		rMan = new JRadioButton("남자", true);
		rWoman = new JRadioButton("여자");
		ButtonGroup group = new ButtonGroup();
		group.add(rMan);
		group.add(rWoman);
		p[4].add(rMan);
		p[4].add(rWoman);
		
		p[5].add(new JLabel("생년월일"));
		p[5].add(birthTf = new JTextField(20));
		p[5].add(calBtn = new JButton("달력"));//텍스트 필드위에 어떻게 달력 이미지가 이쓴 버튼릉 넣는지 모르겠음
		
		
		p[6].add(new JLabel("Email 주소"));
		p[6].add(emailTf=new JTextField(20));
		
		p[7].add(new JLabel("핸드폰 : "));
		String[] tel1 = { "010", "011", "016", "017", "018", "019" };
		comboTel = new JComboBox(tel1);
		p[7].add(comboTel);
		p[7].add(new JLabel("-"));
		telTf2 = new JTextField(4);
		p[7].add(telTf2);
		p[7].add(new JLabel("-"));
		telTf3 = new JTextField(4);
		p[7].add(telTf3);
		
		
		
		setSize(1500, 1100);
		setVisible(true);
		validate();
	}

	public static void main(String[] args) {
		/*
		try {
			UIManager.setLookAndFeel("ch.randelshofer.quaqua.QuaquaLookAndFeel");

			JFrame.setDefaultLookAndFeelDecorated(true);
		} catch (Exception e) {
			
		}
		*/
		new Signin();
	}
}
