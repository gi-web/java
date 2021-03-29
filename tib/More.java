package tib;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.PrintWriter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class More extends JFrame implements ActionListener { // 무박///하루당 아이템 6개 이하까지만 선택가능

	ImageIcon busan, background, background2, profileUpload, site1, user1, like, mail;

	JLabel labWelcome, labLogout, labelinfo1, labelclock1, labeldate1, labeld1, labelage1, labsex1, labcount1, lablike,
			labmail, labcount;

	TextArea ta, tainfo1, taclock1, tadate1, tad1, taage1, tasex1, tacount1, tasite1, tareview1;

	JButton btnLogout,btnupload, btnmodi, btndelete, btnback, btnlike, bt3;

	Label labday;

	List list, lireview1;
	PrintWriter out;

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public More() {
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

		like = new ImageIcon("tib/like.png");
		JPanel panellike = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(like.getImage(), 0, 0, null);
				setOpaque(false);
			}
		};

		mail = new ImageIcon("tib/mail.png");
		JPanel panelmail = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(mail.getImage(), 0, 0, null);
				setOpaque(false);
			}
		};

		user1 = new ImageIcon("tib/user.png");
		JPanel paneluser = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(user1.getImage(), 0, 0, null);
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

	/*	JPanel day1 = new JPanel();
		day1.setBounds(650, 340, 200, 250);
		day1.setBackground(Color.ORANGE);
		add(day1);*/
/////////////////////////////이미지 위치//////////////////////////////////////////////////
		panellogo.setLayout(null);
		panellogo.setBounds(180, 20, 180, 50);
		add(panellogo);

		Label labWelcome = new Label();
		panelbackground.add(labWelcome = new Label("Welcome"));
		labWelcome.setBounds(1100, 30, 70, 30);
		labWelcome.setBackground(new Color(0, 0, 0)); // 패널 뒷배경을 투명색으로 하는 setOpaque 가 안된다..


		panelprofile.setLayout(null);
		panelprofile.setBounds(220, 120, 200, 200);
		add(panelprofile);

		panelsite1.setLayout(null);
		panelsite1.setBounds(220, 400, 350, 170);
		add(panelsite1);

		paneluser.setLayout(null);
		paneluser.setBounds(220, 620, 100, 100);
		add(paneluser);

		btnupload = new JButton("등록하기");
		btnupload.setBounds(350, 500, 100, 30);
		btnupload.setBackground(new Color(251, 246, 240));
		panelbackground2.add(btnupload);
		btnupload.addActionListener(this);

		btnmodi = new JButton("수정하기");
		btnmodi.setBounds(470, 500, 100, 30);
		btnmodi.setBackground(new Color(251, 246, 240));
		panelbackground2.add(btnmodi);
		btnmodi.addActionListener(this);

		btndelete = new JButton("삭제하기");
		btndelete.setBounds(590, 500, 100, 30);
		btndelete.setBackground(new Color(251, 246, 240));
		panelbackground2.add(btndelete);
		btndelete.addActionListener(this);

		btnback = new JButton("뒤로가기");
		btnback.setBounds(710, 500, 100, 30);
		btnback.setBackground(new Color(251, 246, 240));
		panelbackground2.add(btnback);
		btnback.addActionListener(this);

		panelbackground2.add(ta = new TextArea("같이갈 사람 구함"));
		ta.setBounds(520, 40, 550, 200);
		ta.setFocusable(false);

		panelbackground2.add(tasite1 = new TextArea("좋았음"));
		tasite1.setBounds(420, 320, 650, 170);
		tasite1.setFocusable(false);

		panelbackground2.add(tareview1 = new TextArea("댓글을 남겨주세요. (200자 이내)", 5, 5, TextArea.SCROLLBARS_VERTICAL_ONLY));
		tareview1.setBounds(190, 540, 880, 100);
		tareview1.setForeground(Color.GRAY);

		 
		tareview1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {// MouseEvent이 부분 ctrl + space
				tareview1.setText("");
			}
		});

////////////////////////////////////////////////////////////////////////////////////////////////////////
		Label labelinfo1 = new Label();
		panelbackground2.add(labelinfo1 = new Label("닉네임"));
		labelinfo1.setBounds(280, 40, 50, 23);
		labelinfo1.setBackground(new Color(251, 246, 240));

		panelbackground2.add(tainfo1 = new TextArea("값이 저장됨", 5, 5, TextArea.SCROLLBARS_NONE));
		tainfo1.setBounds(350, 40, 140, 23);
		tainfo1.setFocusable(false);

		Label labelclock1 = new Label();
		panelbackground2.add(labelclock1 = new Label("기간"));
		labelclock1.setBounds(280, 70, 50, 23);
		labelclock1.setBackground(new Color(251, 246, 240));

		panelbackground2.add(taclock1 = new TextArea("값이 저장됨", 5, 5, TextArea.SCROLLBARS_NONE));
		taclock1.setBounds(350, 70, 140, 23);
		taclock1.setFocusable(false);

		Label labeldate1 = new Label();
		panelbackground2.add(labeldate1 = new Label("날짜"));
		labeldate1.setBounds(280, 100, 50, 23);
		labeldate1.setBackground(new Color(251, 246, 240));

		panelbackground2.add(tadate1 = new TextArea("값이 저장됨", 5, 5, TextArea.SCROLLBARS_NONE));
		tadate1.setBounds(350, 100, 140, 23);
		tadate1.setFocusable(false);

		Label labeld1 = new Label();
		panelbackground2.add(labeld1 = new Label("구별"));
		labeld1.setBounds(280, 130, 50, 23);
		labeld1.setBackground(new Color(251, 246, 240));

		panelbackground2.add(tad1 = new TextArea("값이 저장됨", 5, 5, TextArea.SCROLLBARS_NONE));
		tad1.setBounds(350, 130, 140, 23);
		tad1.setFocusable(false);

		Label labelage1 = new Label();
		panelbackground2.add(labelage1 = new Label("희망연령"));
		labelage1.setBounds(280, 160, 50, 23);
		labelage1.setBackground(new Color(251, 246, 240));

		panelbackground2.add(taage1 = new TextArea("값이 저장됨", 5, 5, TextArea.SCROLLBARS_NONE));
		taage1.setBounds(350, 160, 140, 23);
		taage1.setFocusable(false);

		Label labsex1 = new Label();
		panelbackground2.add(labsex1 = new Label("성별"));
		labsex1.setBounds(280, 190, 50, 23);
		labsex1.setBackground(new Color(251, 246, 240));

		
		
		
		panelbackground2.add(tasex1 = new TextArea("값이 저장됨", 5, 5, TextArea.SCROLLBARS_NONE));
		tasex1.setBounds(350, 190, 140, 23);
		tasex1.setFocusable(false);

		Label labcount1 = new Label();
		panelbackground2.add(labcount1 = new Label("희망인원"));
		labcount1.setBounds(280, 220, 50, 23);
		labcount1.setBackground(new Color(251, 246, 240));

		panelbackground2.add(tacount1 = new TextArea("입력하세요", 5, 5, TextArea.SCROLLBARS_NONE));
		tacount1.setBounds(350, 220, 140, 23);

/////////////////////////////////////////////////////////////////////////////////////

		btnLogout = new JButton("Logout");
		btnLogout.setBounds(1200, 30, 90, 30);
		btnLogout.setBackground(new Color(0, 0, 0));
		panelbackground.add(btnLogout);
		
		btnlike = new JButton(like);// 버튼에 이미지 이름만 추가하면 이미지형태의 버튼이 만들어짐
		btnlike.setBounds(40, 500, 30, 30);
		btnlike.setBackground(new Color(251, 246, 240));
		panelbackground2.add(btnlike);

		Label lablike = new Label();
		panelbackground2.add(lablike = new Label("좋아요(3)"));
		lablike.setBounds(80, 500, 100, 30);
		lablike.setBackground(new Color(251, 246, 240));

		bt3 = new JButton(mail);// 버튼에 이미지 이름만 추가하면 이미지형태의 버튼이 만들어짐
		bt3.setBounds(190, 500, 30, 30);
		bt3.setBackground(new Color(251, 246, 240));
		panelbackground2.add(bt3);
		bt3.addActionListener(this);

		Label labmail = new Label();
		panelbackground2.add(labmail = new Label("쪽지보내기"));
		labmail.setBounds(230, 500, 100, 30);
		labmail.setBackground(new Color(251, 246, 240));
		
		
		panelbackground2.add(lireview1 = new List(5,false)); //댓글 list창
		lireview1.setBounds(40, 650, 1030, 200);
		
		
		panelbackground2.setLayout(null);
		panelbackground2.setBounds(180, 80, 1100, 1100);
		add(panelbackground2);

		panelbackground.setLayout(null);
		panelbackground.setBounds(0, 0, 1500, 1100);
		add(panelbackground);
//////////////////////////////폰트////////////////////////////////////////////////////////		
		Font top = new Font("맑은고딕", Font.BOLD, 15);
		Font day = new Font("맑은고딕", Font.BOLD, 20);
		labWelcome.setFont(top);
		btnLogout.setFont(top);
	    labWelcome.setForeground(Color.WHITE);
		btnLogout.setForeground(Color.WHITE);


		setSize(1500, 1100);
		setVisible(true);
		validate();
	}
//////////////////////////////////////////////////////////////////////////////////////////

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		String item = tareview1.getText();
		
		if (btnupload == obj) {
			new MUpdate1(this, "알림", "", true);
		}  else if (item.trim().length()==0) {
			new MUpdate2(this, "알림", "", true);
		} else if (item.trim().length()>200) {
			new MUpdate3(this, "알림", "", true);
		} else if (btnmodi == obj) {
			new MModi(this, "알림", "", true);
		} else if (btndelete == obj) {
			new MDelete(this, "알림", "", true);
		} else if (btnback == obj) {
			new MBack(this, "알림", "", true);
			JFrame frame = new Mate();
			frame.setVisible(true);
		} else if (bt3 == obj) {
			new Message("TO:");
		}
		
		tareview1.setText("");
		tareview1.requestFocus(); 
	}

	public void sendMessage(String msg) {
		out.println(msg);
	}

	class Message extends Frame implements ActionListener {

		Button send, close;
		TextField name;
		TextArea ta;
		String mode;// to/from
		String id = "aaa";
		/*Frame f;
		int width = 300;
		int height = 110;*/

		public Message(String mode) {
			setTitle("쪽지보내기");
			this.mode = mode;
			layset("");
			validate();
		}

		public void layset(String msg) {
			addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					dispose();
				}
			});
			Panel p1 = new Panel();
			p1.add(new Label(mode, Label.CENTER));
			name = new TextField(id, 20);
			p1.add(name);
			add(BorderLayout.NORTH, p1);

			ta = new TextArea("");
			add(BorderLayout.CENTER, ta);
			ta.setText(msg);
			Panel p2 = new Panel();
			if (mode.equals("TO:")) {
				p2.add(send = new Button("send"));
				send.addActionListener(this);
			}
			p2.add(close = new Button("close"));
			close.addActionListener(this);
			add(BorderLayout.SOUTH, p2);

			setBounds(650, 500, 250, 250);
			setVisible(true);
		}
		
	/*	public void layset() {
			int px = f.getX();
			int py = f.getY();
			int x = px+f.getWidth()/2;
			int y = py+f.getHeight()/2;
			setBounds(x, y, width, height);
			setVisible(true);
			//validate();
		}*/

		public void actionPerformed(ActionEvent e) {
			//table에 쪽지 저장하는 메소드 호출
			
			setVisible(false);
			dispose();
		}
		
		
	}

/////////////////////////////////////////////////////////////////////////////////
	class MUpdate1 extends JDialog implements ActionListener {
		int width = 200;
		int height = 145;
		JButton btnu;
		JLabel msg1L;
		Frame f;

		public MUpdate1(Frame f, String title, String msg, boolean flag) {
			super(f, title, flag);
			this.f = f;
			int xmsg = msg.length();

			setLayout(null);
			add(msg1L = new JLabel("등록을 하시겠습니까?"));
			add(btnu = new JButton("확인"));
			msg1L.setBounds(30, 20, 150, 25);

			btnu.setBounds(60, 55, 60, 30);
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
			// validate();
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();
		}
	}
	
	class MUpdate2 extends JDialog implements ActionListener {
		int width = 200;
		int height = 145;
		JButton btnu;
		JLabel msg1L;
		Frame f;

		public MUpdate2(Frame f, String title, String msg, boolean flag) {
			super(f, title, flag);
			this.f = f;
			int xmsg = msg.length();

			setLayout(null);
			add(msg1L = new JLabel("댓글을 입력해주세요."));
			add(btnu = new JButton("확인"));
			msg1L.setBounds(30, 20, 150, 25);

			btnu.setBounds(60, 55, 60, 30);
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
			// validate();
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();
		}
	}
	
	class MUpdate3 extends JDialog implements ActionListener {
		int width = 200;
		int height = 145;
		JButton btnu;
		JLabel msg1L;
		Frame f;

		public MUpdate3(Frame f, String title, String msg, boolean flag) {
			super(f, title, flag);
			this.f = f;
			int xmsg = msg.length();

			setLayout(null);
			add(msg1L = new JLabel("200자 이내로 작성해주세요."));
			add(btnu = new JButton("확인"));
			msg1L.setBounds(30, 20, 150, 25);

			btnu.setBounds(60, 55, 60, 30);
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
			// validate();
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();
		}
	}
	

	class MModi extends JDialog implements ActionListener {

		int width = 200;
		int height = 145;
		JButton btnu;
		JLabel msg1L;
		Frame f;

		public MModi(Frame f, String title, String msg, boolean flag) {
			super(f, title, flag);
			this.f = f;
			int xmsg = msg.length();

			setLayout(null);
			add(msg1L = new JLabel("수정 하시겠습니까?"));
			add(btnu = new JButton("확인"));
			msg1L.setBounds(40, 20, 150, 25);

			btnu.setBounds(60, 55, 60, 30);
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
			// validate();
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();
		}
	}

	class MDelete extends JDialog implements ActionListener {

		int width = 200;
		int height = 145;
		JButton btnu;
		JLabel msg1L;
		Frame f;

		public MDelete(Frame f, String title, String msg, boolean flag) {
			super(f, title, flag);
			this.f = f;
			int xmsg = msg.length();

			setLayout(null);
			add(msg1L = new JLabel("삭제 하시겠습니까?"));
			add(btnu = new JButton("확인"));
			msg1L.setBounds(40, 20, 150, 25);

			btnu.setBounds(60, 55, 60, 30);
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
			// validate();
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();
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
			add(msg1L = new JLabel("나가시겠습니까?"));
			add(btnu = new JButton("확인"));
			msg1L.setBounds(40, 20, 150, 25);

			btnu.setBounds(60, 55, 60, 30);
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
			// validate();
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();
		}
	}

	public static void main(String[] args) {
		new More();
	}
}
