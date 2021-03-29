package tib;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
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
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.print.attribute.standard.JobOriginatingUserName;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import tib.More.MBack;

public class Option extends JFrame implements ActionListener{
	
	JLabel lab1, lab2, lab3, lab4, lab5, lab6, lab7,lab8,labWelcome,labLogout;
	JButton btnf, btna, btnb,btn1,btnc;
	ImageIcon busan, background,background2,date;
	TextArea ta;
	Checkbox box[] = new Checkbox[2];
	JRadioButton rMan, rWoman;
	TextField fi,fi2,fi3;
	
	String ra1[] = {"기간 선택","무박","1박2일","2박3일","3박4일"}; 
	String ra2[] = {"부산시 구 선택","강서구","금정구","기장군","남구","동구","동래구","부산진구","북구","사상구","사하구","서구","수영구","연제구","영도구","중구","해운대구"};
	String ra3[] = {"연령 선택","10대","20대","30대","40대","50대이상"};
	JComboBox<String> combo1,combo2,combo3;
	
	public Option() {//각 메뉴 아이콘 클릭시 선택할 수 있는 창 pop up띄우기
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setTitle("Travle in Busan");
		
		SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd");//HH:mm:ss
		SimpleDateFormat format2 = new SimpleDateFormat ( "yyyy년 MM월dd일 HH시mm분ss초");
				
		Date time = new Date();
				
		String time1 = format1.format(time);
		String time2 = format2.format(time);
		
		busan = new ImageIcon("tib/busanwhite157.png");
		JPanel panellogo = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(busan.getImage(), 0, 0, null);		
				setOpaque(false);
			}
		};		
		
		background2 = new ImageIcon("tib/background2.png");
		JPanel panelbackground2 = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(background2.getImage(), 0, 0, null);		
				setOpaque(false);//안배경
				
			}
		};
			
		background = new ImageIcon("tib/background1100.jpg");
		JPanel panelbackground = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(background.getImage(), 0, 0, null);		
				setOpaque(false);//바깥배경
				
			}
		};
		
		date = new ImageIcon("tib/date.png");
		JPanel panelka = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(date.getImage(), 0, 0, null);		
				setOpaque(false);//바깥배경
			}
		};
	
////////////////// 하단 버튼 다음//////////////////////////////////////
			
		btn1 = new JButton("다음");  
		// 메인) 버튼 위치,크기 설정
		btn1.setBounds(650,700,100, 30);
		btn1.addActionListener(this);
///////////////////////////////////////////////////////////////////////
		//페이지 로고//
		panellogo.setLayout(null);
		panellogo.setBounds(180, 30, 1100, 2000);
		add(panellogo);
		panellogo.add(labWelcome=new JLabel("Welcome"));
		labWelcome.setBounds(950,0,500,50);
		panellogo.add(labLogout=new JLabel("logout"));
		labLogout.setBounds(1050,0,500,50);
		
		panellogo.add(lab1=new JLabel("빅데이터로 알려주는 여행지 정보"));
		lab1.setBounds(320,60,1100,50);
		
		panellogo.add(lab2 = new JLabel("여행기간별 여행추천 정보를 제공해 드립니다."));
		lab2.setBounds(336,100,1100,50);
		
		panellogo.add(lab3 = new JLabel("기간"));
		lab3.setBounds(270,160,1100,50);
		/*panellogo.add(btnf = new JButton("기간 선택"));
		btnf.setBounds(470,170,350,30);*/
		panellogo.add(combo1 = new JComboBox<String>(ra1));
		combo1.setBounds(470,170,350,30);
		
		panellogo.add(lab4 = new JLabel("여행일자"));
		lab4.setBounds(270,240,190,50);
		panellogo.add(fi = new TextField(time1,5));
		fi.setBounds(470,251,320,30);
		
		panellogo.add(btnc = new JButton(date));
		btnc.setBounds(790,250,30,30);
		
		panellogo.add(lab5 = new JLabel("구별 선택"));
		lab5.setBounds(270,330,1100,50);
		/*panellogo.add(btna = new JButton("부산시 구 선택"));
		btna.setBounds(470,340,350,30);*/
		panellogo.add(combo2 = new JComboBox<String>(ra2));
		combo2.setBounds(470,340,350,30);
		
		panellogo.add(lab6 = new JLabel("희망연령 선택"));
		lab6.setBounds(270,420,1100,50);
		/*panellogo.add(btnb = new JButton("연령 선택"));
		btnb.setBounds(470,430,350,30);*/
		panellogo.add(combo3 = new JComboBox<String>(ra3));
		combo3.setBounds(470,430,350,30);
		
		panellogo.add(lab7 = new JLabel("희망성별 선택"));
		lab7.setBounds(270,510,1100,50);
		
		panellogo.add(rMan = new JRadioButton("남자",true));
		panellogo.add(rWoman = new JRadioButton("여자"));
		ButtonGroup group = new ButtonGroup();
		group.add(rMan);
		group.add(rWoman);
		rMan.setBounds(500,530,50,15);
		rWoman.setBounds(680,530,50,15);
		
		
		
	
		panelbackground2.setLayout(null);
		panelbackground2.setBounds(180,80,1100,600);
		panelbackground2.setBorder(new TitledBorder(new LineBorder(Color.BLACK,5),"★"));
		panelbackground2.setBackground(new Color(0,0,0,50));
		add(panelbackground2);
		
		panelbackground.setLayout(null);
		panelbackground.setBounds(0,0,1500,1100);
		add(panelbackground);
////////////////////////////////////////////////////////////////////////////////////		
		//폰트//
		Font title = new Font("맑은고딕",Font.BOLD,30);
		Font list = new Font("맑은고딕",Font.BOLD,20);
		Font top = new Font("맑은고딕",Font.BOLD,15);

		lab1.setFont(title);
		lab2.setFont(list);
		lab3.setFont(list);
		lab4.setFont(list);
		lab5.setFont(list);
		lab6.setFont(list);
		lab7.setFont(list);
		fi.setFont(list);
		labWelcome.setFont(top);
		labLogout.setFont(top);
		labWelcome.setForeground(Color.WHITE);
		labLogout.setForeground(Color.WHITE);
		btn1.setBackground(Color.WHITE);
		//btnf.setBackground(Color.WHITE);
		combo1.setBackground(Color.WHITE);
		combo2.setBackground(Color.WHITE);
		combo3.setBackground(Color.WHITE);
		//btna.setBackground(Color.WHITE);
		//btnb.setBackground(Color.WHITE);
		btnc.setBackground(Color.WHITE);
		rMan.setForeground(Color.BLACK);
		rWoman.setForeground(Color.BLACK);	
		
		panelbackground.add(btn1);
	
		setSize(1500,800);
		setVisible(true);
		validate();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(btn1==obj) {
			JFrame frame = new Place();
			frame.setVisible(true);
	  }
	}
	
	
	class MBack extends JDialog implements ActionListener {
		
		int width = 200;
		int height = 145;
		JButton btnu;
		JLabel msg1L;
		Frame f;

		public MBack(Frame f, String title, String msg, boolean flag) {
			super(f, title, flag);
			this.f = f;
			int xmsg = msg.length();
			
			setLayout(null);
			add(msg1L = new JLabel("sibar"));
			add(btnu = new JButton("확인"));
			msg1L.setBounds(40,20,150,25);

			btnu.setBounds(60,55,60,30);
			btnu.addActionListener(this);
			layset();
		}
		
		public void layset() {
			int px = f.getX();
			int py = f.getY();
			int x = px+f.getWidth()/2;
			int y = py+f.getHeight()/2;
			setBounds(x, y, width, height);
			setVisible(true);
			//validate();
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();
		}
	}
	
	
	////JFrame 배경색상 지정//////////////////////////////////////////
	public static void main(String[] args) {
		new Option();
	}
}
