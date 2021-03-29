package tib;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class Place extends JFrame implements ActionListener {

	JLabel lab1, lab2, lab3, lab4, lab5, lab6, lab7, lab8, lab9, lab0, lab11, lab12, lab13, lab14, lab15, lab16;
	ImageIcon busan, background, background2, site2, site3, site4, bts, bts1;
	JButton btn1, btna, btnb, btnc, btnd, btne, btnf, btng, btnh, btni, btnj, btnk, labLogout, labWelcome, btnLogo;
	TextField fi, fi2, fi3, fi4, fi5, fi6, fi7, fi8, fi9;
	TextArea ta1, ta2, ta3, ta4, ta5, ta6;
	JPanel p1, p2;
	List li1, li2, li3, li4, li5;
	JButton btn[] = new JButton[2], btnq[] = new JButton[2], btnw[] = new JButton[2];
	Button logoutBtn, welcomeBtn;
	String str1[] = { "더보기", "list 담기" };
	String str2[] = { "더보기", "list 담기" };
	String str3[] = { "더보기", "list 담기" };
	int mode = 0;
	Info infoF;

	URL url = null;
	String url2 = "http://jspstudy.co.kr/tib/map.jsp?";
	TibMapMgr mgr = null;
	int position = 1;
	Vector<TravelBean> vlist = null;
	TravelBean bean[];
	JPanel panelLogo,panelBackground2,panelSite2,panelSite3,panelSite4,panelBackground,info;

	public Place() {

		mgr = new TibMapMgr();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setTitle("Travle in Busan");

		busan = new ImageIcon("tib/busanwhite157.png");
		panelLogo = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(busan.getImage(), 0, 0, null);
				setOpaque(false);
			}
		};

		background2 = new ImageIcon("tib/beige.png");
		panelBackground2 = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(background2.getImage(), 0, 0, null);
				setOpaque(false);// 안배경
			}
		};
		
		setPosition(position);
		
		info.add(lab4 = new JLabel(" 무박 "));
		info.add(btn1 = new JButton("삭제"));
		btn1.setBounds(1330, 680, 30, 20);
		btn1.addActionListener(this);

		info.add(li1 = new List(7, false));

		info.add(lab5 = new JLabel("1일차"));
		info.add(btna = new JButton("삭제"));
		btna.setBounds(1330, 680, 20, 10);
		btna.addActionListener(this);

		info.add(li2 = new List(7, false));

		info.add(lab6 = new JLabel("2일차"));
		info.add(btnb = new JButton("삭제"));
		btnb.setBounds(1330, 680, 30, 20);
		btnb.addActionListener(this);

		info.add(li3 = new List(7, false));

		info.add(lab7 = new JLabel("3일차"));
		info.add(btnc = new JButton("삭제"));
		btnc.setBounds(1330, 680, 30, 20);
		btnc.addActionListener(this);

		info.add(li4 = new List(7, false));

		info.add(lab14 = new JLabel("4일차"));
		info.add(btnd = new JButton("삭제"));
		btnd.setBounds(1330, 680, 30, 20);
		btnd.addActionListener(this);

		info.add(li5 = new List(7, false));

		for (int i = 0; i < btn.length; i++) {
			panelBackground2.add(btn[i] = new JButton(str1[i]));
			btn[i].addActionListener(this);
		}
		btn[0].setBounds(870, 55, 100, 30);
		btn[1].setBounds(870, 105, 100, 30);

		for (int i = 0; i < btnq.length; i++) {
			panelBackground2.add(btnq[i] = new JButton(str2[i]));
			btnq[i].addActionListener(this);
		}

		btnq[0].setBounds(870, 235, 100, 30);
		btnq[1].setBounds(870, 285, 100, 30);

		for (int i = 0; i < btnw.length; i++) {
			panelBackground2.add(btnw[i] = new JButton(str3[i]));
			btnw[i].addActionListener(this);
		}
		btnw[0].setBounds(870, 415, 100, 30);
		btnw[1].setBounds(870, 465, 100, 30);

		panelBackground2.add(btnj = new JButton("다음"));
		btnj.setBounds(970, 530, 100, 30);
		btnj.addActionListener(this);

		panelBackground2.add(btnk = new JButton("이전"));
		btnk.setBounds(840, 530, 100, 30);
		btnk.addActionListener(this);

		panelBackground2.add(btni = new JButton("저장"));
		btni.setBounds(970, 570, 100, 30);
		btni.addActionListener(this);

		//panelLogo.setLayout(null);
		//panelLogo.setBounds(180, 20, 180, 50);
		//add(panelLogo);

		btnLogo = new JButton(busan);
		btnLogo.setBounds(180, 20, 180, 50);
		btnLogo.setBackground(new Color(0, 0, 0));
		panelBackground.add(btnLogo);
		btnLogo.addActionListener(this);

		welcomeBtn = new Button();
		panelBackground.add(welcomeBtn = new Button("Welcome"));
		welcomeBtn.setBounds(1070, 30, 100, 30);
		welcomeBtn.setBackground(new Color(0, 0, 0));
		welcomeBtn.setForeground(Color.WHITE);
		welcomeBtn.addActionListener(this);

		logoutBtn = new Button();
		panelBackground.add(logoutBtn = new Button("Logout"));
		logoutBtn.setBounds(1190, 30, 90, 30);
		logoutBtn.setBackground(new Color(0, 0, 0));
		logoutBtn.setForeground(Color.WHITE);
		logoutBtn.addActionListener(this);

		panelSite2.setLayout(null);
		panelSite2.setBounds(220, 95, 350, 170);
		add(panelSite2);

		panelSite3.setLayout(null);
		panelSite3.setBounds(220, 280, 350, 170);
		add(panelSite3);

		panelSite4.setLayout(null);
		panelSite4.setBounds(220, 465, 350, 170);
		add(panelSite4);

		panelBackground2.setLayout(null);
		panelBackground2.setBounds(180, 80, 1100, 620);
		panelBackground2.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 5), "★"));
		panelBackground2.setBackground(new Color(0, 0, 0, 50));
		add(panelBackground2);

		panelBackground.setLayout(null);
		panelBackground.setBounds(0, 0, 1500, 800);
		add(panelBackground);

		Font top = new Font("맑은고딕", Font.BOLD, 15);

		lab1.setFont(top);
		lab2.setFont(top);

		lab4.setFont(top);
		lab5.setFont(top);
		lab6.setFont(top);
		lab7.setFont(top);
		lab8.setFont(top);
		lab9.setFont(top);

		lab11.setFont(top);
		lab12.setFont(top);

		lab14.setFont(top);
		fi.setFont(top);
		fi2.setFont(top);

		fi4.setFont(top);
		fi5.setFont(top);

		fi7.setFont(top);
		fi8.setFont(top);


		lab4.setForeground(Color.WHITE);
		lab5.setForeground(Color.WHITE);
		lab6.setForeground(Color.white);
		lab7.setForeground(Color.WHITE);
		lab14.setForeground(Color.WHITE);
		btn1.setForeground(Color.BLACK);
		btna.setForeground(Color.BLACK);
		btnb.setForeground(Color.BLACK);
		btnc.setForeground(Color.BLACK);

		btnd.setForeground(Color.BLACK);

		btn1.setBackground(Color.WHITE);
		btna.setBackground(Color.WHITE);
		btnb.setBackground(Color.WHITE);
		btnc.setBackground(Color.WHITE);
		btn[0].setBackground(Color.WHITE);
		btn[1].setBackground(Color.WHITE);
		btnq[0].setBackground(Color.WHITE);
		btnq[1].setBackground(Color.WHITE);
		btnw[0].setBackground(Color.WHITE);
		btnw[1].setBackground(Color.WHITE);
		btnd.setBackground(Color.WHITE);

		btni.setBackground(Color.WHITE);
		btnj.setBackground(Color.WHITE);
		btnk.setBackground(Color.WHITE);

		welcomeBtn.setFont(top);
		logoutBtn.setFont(top);
		welcomeBtn.setForeground(Color.WHITE);
		welcomeBtn.setBackground(Color.BLACK);
		logoutBtn.setForeground(Color.WHITE);
		logoutBtn.setBackground(Color.BLACK);
		
		setSize(1500, 800);
		setVisible(true);
		repaint();
		validate();
		setLocationRelativeTo(null);
	}

	public void setPosition(int position) {
		try {

			vlist = mgr.getListTravel(position);

			bean = new TravelBean[vlist.size()];
			for (int i = 0; i < bean.length; i++) {
				bean[i] = vlist.elementAt(i);
			}

			url = new URL("https://www.visitbusan.net/" + bean[0].getMAIN_IMG_THUMB());
			site2 = new ImageIcon(url);
			panelSite2 = new JPanel() {
				public void paintComponent(Graphics g) {
					super.paintComponent(g);
					g.drawImage(site2.getImage(), 0, 0, null);
					setOpaque(false);// 바깥배경
				}
			};

			url = new URL("https://www.visitbusan.net/" + bean[1].getMAIN_IMG_THUMB());
			site3 = new ImageIcon(url);
			panelSite3 = new JPanel() {
				public void paintComponent(Graphics g) {
					super.paintComponent(g);
					g.drawImage(site3.getImage(), 0, 0, null);
					setOpaque(false);// 바깥배경

				}
			};

			url = new URL("https://www.visitbusan.net/" + bean[2].getMAIN_IMG_THUMB());
			site4 = new ImageIcon(url);
			panelSite4 = new JPanel() {
				public void paintComponent(Graphics g) {
					super.paintComponent(g);
					g.drawImage(site4.getImage(), 0, 0, null);
					setOpaque(false);// 바깥배경

				}
			};

			background = new ImageIcon("tib/background800.jpg");
			panelBackground = new JPanel() {
				public void paintComponent(Graphics g) {
					super.paintComponent(g);
					g.drawImage(background.getImage(), 0, 0, null);
					setOpaque(false);// 바깥배경
				}
			};

			info = new JPanel();
			info.setBounds(1295, 8, 140, 750);
			info.setBorder(new TitledBorder(new LineBorder(Color.WHITE, 5), ""));
			info.setBackground(new Color(0, 0, 0, 50));
			add(info);
			
			if(lab1!=null) panelBackground2.remove(lab1);
			panelBackground2.add(lab1 = new JLabel("장소 이름"));
			lab1.setBounds(400, 30, 100, 50);

			if(fi!=null) panelBackground2.remove(fi);
			panelBackground2.add(fi = new TextField(bean[0].getMAIN_TITLE()));
			fi.setBounds(510, 41, 300, 30);
			
			if(lab2!=null) panelBackground2.remove(lab2);
			panelBackground2.add(lab2 = new JLabel("장소 주소"));
			lab2.setBounds(400, 70, 100, 50);
			
			if(fi2!=null) panelBackground2.remove(fi2);
			panelBackground2.add(fi2 = new TextField(bean[0].getADDR1(), 5));
			fi2.setBounds(510, 81, 300, 30);

		
///////////////////////////////////////////////////////////////////////////
			if(lab8!=null) panelBackground2.remove(lab8);
			panelBackground2.add(lab8 = new JLabel("장소 이름"));
			lab8.setBounds(400, 210, 100, 50);
			
			if(fi4!=null) panelBackground2.remove(fi4);
			panelBackground2.add(fi4 = new TextField(bean[1].getMAIN_TITLE(), 5));
			fi4.setBounds(510, 221, 300, 30);

			if(lab9!=null) panelBackground2.remove(lab9);
			panelBackground2.add(lab9 = new JLabel("장소 주소"));
			lab9.setBounds(400, 250, 100, 50);
			
			if(fi5!=null) panelBackground2.remove(fi5);
			panelBackground2.add(fi5 = new TextField(bean[1].getADDR1(), 5));
			fi5.setBounds(510, 261, 300, 30);

///////////////////////////////////////////////////////////////////////////
			if(lab11!=null) panelBackground2.remove(lab11);
			panelBackground2.add(lab11 = new JLabel("장소 이름"));
			lab11.setBounds(400, 390, 100, 50);
			
			if(fi7!=null) panelBackground2.remove(fi7);
			panelBackground2.add(fi7 = new TextField(bean[2].getMAIN_TITLE(), 5));
			fi7.setBounds(510, 401, 300, 30);

			if(lab12!=null) panelBackground2.remove(lab12);
			panelBackground2.add(lab12 = new JLabel("장소 주소"));
			lab12.setBounds(400, 430, 100, 50);
			
			if(fi8!=null) panelBackground2.remove(fi8);
			panelBackground2.add(fi8 = new TextField(bean[2].getADDR1(), 5));
			fi8.setBounds(510, 441, 300, 30);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		String cmd = e.getActionCommand();
		int id = li1.getSelectedIndex();
		int id2 = li2.getSelectedIndex();
		int id3 = li3.getSelectedIndex();
		int id4 = li4.getSelectedIndex();
		int id5 = li5.getSelectedIndex();
		if (btnk == obj) {// 이전
			if(position>3)position-=3;
			setPosition(position);
			panelBackground.repaint();
			
		} else if (btnj == obj) {// 다음
			position+=3;
			setPosition(position);
			panelBackground.repaint();
		} else if (obj == btn[1]) {
			mode = 0;
			new MDialog1(this, "알림", "", true);// list1
		} else if (obj == btn[0]) {
			this.setVisible(false);
			infoF = new Info(bean[0].getUC_SEQ());
			infoF.setVisible(true);// 더보기1
		} else if (obj == btnq[1]) {
			mode = 1;
			new MDialog1(this, "알림", "", true);// list2
		} else if (obj == btnq[0]) {
			this.setVisible(false);
			infoF = new Info(bean[1].getUC_SEQ());
			infoF.setVisible(true);// 더보기1
		} else if (obj == btnw[1]) {
			mode = 2;
			new MDialog1(this, "알림", "", true);
			;// list3
		} else if (obj == btnw[0]) {
			this.setVisible(false);
			infoF = new Info(bean[2].getUC_SEQ());
			infoF.setVisible(true);// 더보기1
		} else if (obj == btn1) {
			li1.remove(id);
		} else if (obj == btna) {
			li2.remove(id2);
		} else if (obj == btnb) {
			li3.remove(id3);
		} else if (obj == btnc) {
			li4.remove(id4);
		} else if (obj == btnd) {
			li5.remove(id5);
		} else if (welcomeBtn == obj) {
			this.setVisible(false);
			Choose Choose = new Choose();
			Choose.setVisible(true);
		} else if (logoutBtn == obj) {
			this.setVisible(false);
			Login Login = new Login();
			Login.setVisible(true);
		}
	}

	class MBack extends JDialog implements ActionListener {

		int width = 200;
		int height = 145;
		JButton btnu, btn;
		JLabel msg1L;
		Frame f;

		public MBack(Frame f, String title, String msg, boolean flag) {
			super(f, title, flag);
			this.f = f;
			//int xmsg = msg.length();

			setLayout(null);
			add(msg1L = new JLabel("뒤로 가겠습니까?"));
			add(btnu = new JButton("네"));
			add(btn = new JButton("아니오"));

			msg1L.setBounds(40, 20, 150, 25);
			//Font top = new Font("맑은고딕", Font.BOLD, 13);
			msg1L.setFont(new Font("맑은고딕", Font.BOLD, 13));
			btnu.setBackground(Color.WHITE);
			btn.setBackground(Color.WHITE);

			btn.setBounds(10, 65, 80, 30);
			btn.addActionListener(this);

			btnu.setBounds(100, 65, 80, 30);
			btnu.addActionListener(this);

			layset();
		}

		public void layset() {
			int px = f.getX();
			int py = f.getY();
			int x = px + f.getWidth() / 2;
			int y = py + f.getHeight() / 2;
			setBounds(x, y, width, height);
			setVisible(true);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();
		}
	}

	class MDialog1 extends JDialog implements ActionListener {

		Checkbox cb1_1, cb1_2, cb1_3, cb1_4, cb1_5;
		Checkbox ch[] = new Checkbox[5];
		String str[] = { "무박", "1일차", "2일차", "3일차", "4일차" };
		CheckboxGroup cbg;
		int width = 300;
		int height = 130;
		Button save;
		Frame f;

		public MDialog1(Frame f, String title, String msg, boolean flag) {
			super(f, title, flag);
			this.f = f;
			setLayout(new FlowLayout());

			cbg = new CheckboxGroup();
			Panel p = new Panel();
			for (int i = 0; i < ch.length; i++) {
				p.add(ch[i] = new Checkbox(str[i], cbg, false));

			}
			/*
			 * p.add(cb1_1 = new Checkbox("무박", cbg, true)); p.add(cb1_2 = new
			 * Checkbox("1일차", cbg, false)); p.add(cb1_3 = new Checkbox("2일차", cbg, false));
			 * p.add(cb1_4 = new Checkbox("3일차", cbg, false)); p.add(cb1_5 = new
			 * Checkbox("4일차", cbg, false));
			 */
			add(p);
			add(save = new Button("SAVE"));
			save.addActionListener(this);
			layset();
		}

		public void layset() {
			int px = f.getX();
			int py = f.getY();
			int x = px + f.getWidth() / 2;
			int y = py + f.getHeight() / 2;
			setBounds(x, y, width, height);
			setVisible(true);
			// validate();
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			//String cmd = e.getActionCommand();
			String s = e.getActionCommand();
			/*
			 * String item =fi.getText(); String item1 =fi4.getText(); String item2
			 * =fi7.getText();
			 */
			String item = "";
			if (mode == 0)
				item = fi.getText();
			else if (mode == 1)
				item = fi4.getText();
			else if (mode == 2)
				item = fi7.getText();

			if (s.equals("SAVE")) {
				Checkbox cb = cbg.getSelectedCheckbox();
				if (cb == ch[0])
					li1.add(item);
				else if (cb == ch[1])
					li2.add(item);
				else if (cb == ch[2])
					li3.add(item);
				else if (cb == ch[3])
					li4.add(item);
				else if (cb == ch[4])
					li5.add(item);
			}
			dispose();
		}
	}

	public static void main(String[] args) {
		new Place();

	}

}
