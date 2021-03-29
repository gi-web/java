package tib;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Event;
import java.awt.FlowLayout;
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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.time.Clock;
import java.util.Date;

import javax.print.attribute.standard.JobOriginatingUserName;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;
import oracle.net.aso.v;

//장소사진 사이즈 : 417 * 320

public class Mate extends JFrame implements ActionListener {

	JLabel labWelcome, labLogout, lab0, lab1, lab2, lab3, lab4, lab5, lab6, lab7, lab8, labelinfo1, labelclock1,
			labeldate1, labeld1, labelage1, labgender1, labcount1, labelinfo2, labelclock2, labeldate2, labeld2, labelage2,
			labgender2, labcount2, labelinfo3, labelclock3, labeldate3, labeld3, labelage3, labgender3, labcount3;

	JButton btn, btna, btnb, 
				btnm1, btnm2, btnm3, 
				btndate, btnclock, btnf,btnage, btngender, btnarray,btnLogout;;

	ImageIcon busan, background, background2, friends, clock, date, age, gender, array, profile1, profile2, profile3,
			profile4, profile5;

	TextArea ta;

	TextArea ta1, ta2, ta3, tainfo1, taclock1, tadate1, tad1, taage1, tagender1, tacount1, tainfo2, taclock2, tadate2,
			tad2, taage2, tagender2, tacount2, talab1, talab2,
			talab3, talab4, talab5, talab6, talab7, talab8;



	public Mate() {// 각 메뉴 아이콘 클릭시 선택할 수 있는 창 pop up띄우기
		
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setTitle("Travle in Busan");

		busan = new ImageIcon("tib/busanwhite157.png");
		JPanel panellogo = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(busan.getImage(), 0, 0, null);
				setOpaque(false);
			}
		};

		friends = new ImageIcon("tib/friends.png");
		JPanel panelf = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(friends.getImage(), 0, 0, null);
				setOpaque(false);
			}
		};

		clock = new ImageIcon("tib/clock.png");
		JPanel panelc = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(clock.getImage(), 0, 0, null);
				setOpaque(false);
			}
		};

		date = new ImageIcon("tib/date.png");
		JPanel paneld = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(date.getImage(), 0, 0, null);
				setOpaque(false);
			}
		};

		age = new ImageIcon("tib/age.png");
		JPanel panela = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(age.getImage(), 0, 0, null);
				setOpaque(false);
			}
		};

		gender = new ImageIcon("tib/gender.png");
		JPanel panelgender = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(gender.getImage(), 0, 0, null);
				setOpaque(false);
			}
		};

		array = new ImageIcon("tib/array.png");
		JPanel panelarray = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(array.getImage(), 0, 0, null);
				setOpaque(false);
			}
		};

		profile1 = new ImageIcon("tib/profile1.jpg");
		JPanel panelp1 = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(profile1.getImage(), 0, 0, null);
				setOpaque(false);
			}
		};

		profile2 = new ImageIcon("tib/profile2.jpg");
		JPanel panelp2 = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(profile2.getImage(), 0, 0, null);
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

		background = new ImageIcon("tib/background800.jpg");
		JPanel panelbackground = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(background.getImage(), 0, 0, null);
				setOpaque(false);
			}
		};

///////////////////////////////////이미지 위치////////////////////////////////////////////
		// 페이지 로고//  
		panellogo.setLayout(null);
		panellogo.setBounds(180, 20, 180, 50);
		add(panellogo);

		// friends 로고//
		panelf.setLayout(null);
		panelf.setBounds(200, 100, 100, 100);
		add(panelf);

		// 프로필1//
		panelp1.setLayout(null);
		panelp1.setBounds(200, 260, 200, 200);
		add(panelp1);

		// 프로필2//
		panelp2.setLayout(null);
		panelp2.setBounds(200, 480, 200, 200);
		add(panelp2);

	

		///////////////////////////////// 라벨위치//////////////////////////////////////////////

		Label labWelcome = new Label();
		panelbackground.add(labWelcome = new Label("Welcome"));
		labWelcome.setBounds(1100, 30, 70, 30);
		labWelcome.setBackground(new Color(0, 0, 0)); // 패널 뒷배경을 투명색으로 하는 setOpaque 가 안된다..

		btnLogout = new JButton("Logout");
		btnLogout.setBounds(1200, 30, 90, 30);
		btnLogout.setBackground(new Color(0, 0, 0));
		panelbackground.add(btnLogout);
	

///////////////////////////////////////메뉴바 라벨 위치////////////////////////////////////////////////////
		Label lab0 = new Label();
		panelbackground2.add(lab0 = new Label("당신의 여행 친구를 찾아보세요"));
		lab0.setBounds(150, 40, 800, 50);
		lab0.setBackground(new Color(251,246,240));

		Label lab1 = new Label();
		panelbackground2.add(lab1 = new Label("기간"));
		lab1.setBounds(20, 120, 33, 30);
		lab1.setBackground(new Color(251,246,240));

		btnclock = new JButton(clock);// 버튼에 이미지 이름만 추가하면 이미지형태의 버튼이 만들어짐
		btnclock.setBounds(55, 120, 33, 30);
		btnclock.setBackground(new Color(251,246,240));
		panelbackground2.add(btnclock);
		btnclock.addActionListener(this);// 이거 꼭 추가해주기!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

		panelbackground2.add(talab1 = new TextArea("선택완료", 5, 5, TextArea.SCROLLBARS_NONE));
		talab1.setBounds(95, 125, 75, 25);
		talab1.setFocusable(false);

		Label lab2 = new Label();
		panelbackground2.add(lab2 = new Label("날짜"));
		lab2.setBounds(175, 120, 33, 30);
		lab2.setBackground(new Color(251,246,240));

		btndate = new JButton(date);// 버튼에 이미지 이름만 추가하면 이미지형태의 버튼이 만들어짐
		btndate.setBounds(210, 120, 33, 30);
		btndate.setBackground(new Color(251,246,240));
		panelbackground2.add(btndate);
		btndate.addActionListener(this);// 이거 꼭 추가해주기!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

		panelbackground2.add(talab2 = new TextArea("선택완료", 5, 5, TextArea.SCROLLBARS_NONE));
		talab2.setBounds(250, 125, 130, 25);
		talab2.setFocusable(false);

		Label lab3 = new Label();
		panelbackground2.add(lab3 = new Label("구별 여행지"));
		lab3.setBounds(390, 120, 90, 30);
		lab3.setBackground(new Color(251,246,240));

		btnf = new JButton("검색하세요");
		btnf.setBounds(480, 123, 100, 25);
		btnf.setBackground(new Color(251,246,240));
		panelbackground2.add(btnf);
		btnf.addActionListener(this);// 이거 꼭 추가해주기!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!


		Label lab4 = new Label();
		panelbackground2.add(lab4 = new Label("연령"));
		lab4.setBounds(590, 120, 33, 30);
		lab4.setBackground(new Color(251,246,240));

		btnage = new JButton(age);// 버튼에 이미지 이름만 추가하면 이미지형태의 버튼이 만들어짐
		btnage.setBounds(630, 120, 33, 30);
		btnage.setBackground(new Color(251,246,240));
		panelbackground2.add(btnage);
		btnage.addActionListener(this);// 이거 꼭 추가해주기!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

		panelbackground2.add(talab4 = new TextArea("선택완료", 5, 5, TextArea.SCROLLBARS_NONE));
		talab4.setBounds(670, 125, 75, 25);
		talab4.setFocusable(false);

		Label lab5 = new Label();
		panelbackground2.add(lab5 = new Label("성별"));
		lab5.setBounds(750, 120, 33, 30);
		lab5.setBackground(new Color(251,246,240));

		btngender = new JButton(gender);// 버튼에 이미지 이름만 추가하면 이미지형태의 버튼이 만들어짐
		btngender.setBounds(790, 120, 33, 30);
		btngender.setBackground(new Color(251,246,240));
		panelbackground2.add(btngender);
		btngender.addActionListener(this);// 이거 꼭 추가해주기!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

		panelbackground2.add(talab5 = new TextArea("선택완료", 5, 5, TextArea.SCROLLBARS_NONE));
		talab5.setBounds(830, 125, 75, 25);
		talab5.setFocusable(false);

		Label lab6 = new Label();
		panelbackground2.add(lab6 = new Label("정렬기준"));
		lab6.setBounds(910, 120, 70, 30);
		lab6.setBackground(new Color(251,246,240));
		

		btnarray = new JButton(array);// 버튼에 이미지 이름만 추가하면 이미지형태의 버튼이 만들어짐
		btnarray.setBounds(980, 120, 33, 30);
		btnarray.setBackground(new Color(251,246,240));
		panelbackground2.add(btnarray);
		btnarray.addActionListener(this);// 이거 꼭 추가해주기!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!


		panelbackground2.add(talab6 = new TextArea("선택완료", 5, 5, TextArea.SCROLLBARS_NONE));
		talab6.setBounds(1020, 125, 75, 25);
		talab6.setFocusable(false);


		Label labelinfo1 = new Label();
		panelbackground2.add(labelinfo1 = new Label("ID"));
		labelinfo1.setBounds(250, 180, 50, 23);
		labelinfo1.setBackground(new Color(251,246,240));

		panelbackground2.add(tainfo1 = new TextArea("값이 저장됨", 5, 5, TextArea.SCROLLBARS_NONE));
		tainfo1.setBounds(310, 180, 140, 23);
		tainfo1.setFocusable(false);

		Label labelclock1 = new Label();
		panelbackground2.add(labelclock1 = new Label("기간"));
		labelclock1.setBounds(250, 210, 50, 23);
		labelclock1.setBackground(new Color(251,246,240));

		panelbackground2.add(taclock1 = new TextArea("값이 저장됨", 5, 5, TextArea.SCROLLBARS_NONE));
		taclock1.setBounds(310, 210, 140, 23);
		taclock1.setFocusable(false);

		Label labeldate1 = new Label();
		panelbackground2.add(labeldate1 = new Label("예정일자"));
		labeldate1.setBounds(250, 240, 50, 23);
		labeldate1.setBackground(new Color(251,246,240));

		panelbackground2.add(tadate1 = new TextArea("값이 저장됨", 5, 5, TextArea.SCROLLBARS_NONE));
		tadate1.setBounds(310, 240, 140, 23);
		tadate1.setFocusable(false);

		Label labeld1 = new Label();
		panelbackground2.add(labeld1 = new Label("구별"));
		labeld1.setBounds(250, 270, 50, 23);
		labeld1.setBackground(new Color(251,246,240));

		panelbackground2.add(tad1 = new TextArea("값이 저장됨", 5, 5, TextArea.SCROLLBARS_NONE));
		tad1.setBounds(310, 270, 140, 23);
		tad1.setFocusable(false);

		Label labelage1 = new Label();
		panelbackground2.add(labelage1 = new Label("연령"));
		labelage1.setBounds(250, 300, 50, 23);
		labelage1.setBackground(new Color(251,246,240));

		panelbackground2.add(taage1 = new TextArea("값이 저장됨", 5, 5, TextArea.SCROLLBARS_NONE));
		taage1.setBounds(310, 300, 140, 23);
		taage1.setFocusable(false);

		Label labgender1 = new Label();
		panelbackground2.add(labgender1 = new Label("성별"));
		labgender1.setBounds(250, 330, 50, 23);
		labgender1.setBackground(new Color(251,246,240));

		panelbackground2.add(tagender1 = new TextArea("값이 저장됨", 5, 5, TextArea.SCROLLBARS_NONE));
		tagender1.setBounds(310, 330, 140, 23);
		tagender1.setFocusable(false);

		Label labcount = new Label();
		panelbackground2.add(labcount = new Label("희망인원"));
		labcount.setBounds(250, 360, 50, 23);
		labcount.setBackground(new Color(251,246,240));

		panelbackground2.add(tacount1 = new TextArea("값이 저장됨", 5, 5, TextArea.SCROLLBARS_NONE));
		tacount1.setBounds(310, 360, 140, 23);

////////////////////////////////////2째 등록 인물///////////////////////////////////////////////////////////

		Label labelinfo2 = new Label();
		panelbackground2.add(labelinfo2 = new Label("ID"));
		labelinfo2.setBounds(250, 400, 50, 23);
		labelinfo2.setBackground(new Color(251,246,240));

		panelbackground2.add(tainfo2 = new TextArea("값이 저장됨", 5, 5, TextArea.SCROLLBARS_NONE));
		tainfo2.setBounds(310, 400, 140, 23);
		tainfo2.setFocusable(false);

		Label labelclock2 = new Label();
		panelbackground2.add(labelclock2 = new Label("기간"));
		labelclock2.setBounds(250, 430, 50, 23);
		labelclock2.setBackground(new Color(251,246,240));

		panelbackground2.add(taclock2 = new TextArea("값이 저장됨", 5, 5, TextArea.SCROLLBARS_NONE));
		taclock2.setBounds(310, 430, 140, 23);
		taclock2.setFocusable(false);

		Label labeldate2 = new Label();
		panelbackground2.add(labeldate2 = new Label("예정일자"));
		labeldate2.setBounds(250, 460, 50, 23);
		labeldate2.setBackground(new Color(251,246,240));

		panelbackground2.add(tadate2 = new TextArea("값이 저장됨", 5, 5, TextArea.SCROLLBARS_NONE));
		tadate2.setBounds(310, 460, 140, 23);
		tadate2.setFocusable(false);

		Label labeld2 = new Label();
		panelbackground2.add(labeld2 = new Label("구별"));
		labeld2.setBounds(250, 490, 50, 23);
		labeld2.setBackground(new Color(251,246,240));

		panelbackground2.add(tad2 = new TextArea("값이 저장됨", 5, 5, TextArea.SCROLLBARS_NONE));
		tad2.setBounds(310, 490, 140, 23);
		tad2.setFocusable(false);

		Label labelage2 = new Label();
		panelbackground2.add(labelage2 = new Label("연령"));
		labelage2.setBounds(250, 520, 50, 23);
		labelage2.setBackground(new Color(251,246,240));

		panelbackground2.add(taage2 = new TextArea("값이 저장됨", 5, 5, TextArea.SCROLLBARS_NONE));
		taage2.setBounds(310, 520, 140, 23);
		taage2.setFocusable(false);

		Label labelgender2 = new Label();
		panelbackground2.add(labelgender2 = new Label("성별"));
		labelgender2.setBounds(250, 550, 50, 23);
		labelgender2.setBackground(new Color(251,246,240));

		panelbackground2.add(tagender2 = new TextArea("값이 저장됨", 5, 5, TextArea.SCROLLBARS_NONE));
		tagender2.setBounds(310, 550, 140, 23);
		tagender2.setFocusable(false);

		Label labcount2 = new Label();
		panelbackground2.add(labcount2 = new Label("희망인원"));
		labcount2.setBounds(250, 580, 50, 23);
		labcount2.setBackground(new Color(251,246,240));

		panelbackground2.add(tacount2 = new TextArea("값이 저장됨", 5, 5, TextArea.SCROLLBARS_NONE));
		tacount2.setBounds(310, 580, 140, 23);



/////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		panelbackground2.add(ta1 = new TextArea("사람구함"));
		ta1.setBounds(480, 180, 500, 200);
		ta1.setFocusable(false);

		btnm1 = new JButton("더보기");
		btnm1.setBounds(1005, 260, 75, 30);
		btnm1.setBackground(new Color(251,246,240));
		panelbackground2.add(btnm1);
		btnm1.addActionListener(this);
		
		panelbackground2.add(ta2 = new TextArea("사람구함"));
		ta2.setBounds(480, 400, 500, 200);
		ta2.setFocusable(false);

		btnm2 = new JButton("더보기");
		btnm2.setBounds(1005, 480, 75, 30);
		btnm2.setBackground(new Color(251,246,240));
		panelbackground2.add(btnm2);
		btnm2.addActionListener(this);
	

		
		btna = new JButton("이전");
		btna.setBounds(450, 610, 80, 30);
		btna.setBackground(new Color(251,246,240));
		panelbackground2.add(btna);
		
		btnb = new JButton("다음");
		btnb.setBounds(600, 610, 80, 30);
		btnb.setBackground(new Color(251,246,240));
		panelbackground2.add(btnb);
		
		
/////////////////////////////////////////////////////////////////////////////////

		
		panelbackground2.setLayout(null);
		panelbackground2.setBounds(180, 80, 1100, 650);
		add(panelbackground2);

		panelbackground.setLayout(null);
		panelbackground.setBounds(0, 0, 1500, 800);
		add(panelbackground);

////////////////////////////////////////////////////////////////////////////////////		
		// 폰트//
		Font title = new Font("맑은고딕", Font.BOLD, 30);
		Font list = new Font("맑은고딕", Font.BOLD, 15);
		Font top = new Font("맑은고딕", Font.BOLD, 15); // logout, welcome

		labWelcome.setFont(top);
		btnLogout.setFont(top);
	    labWelcome.setForeground(Color.WHITE);
		btnLogout.setForeground(Color.WHITE);

		lab0.setFont(title);
		lab1.setFont(list);
		lab2.setFont(list);
		lab3.setFont(list);
		lab4.setFont(list);
		lab5.setFont(list);
		lab6.setFont(list);

		setSize(1500, 800);
		setVisible(true);
		validate();
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(btnclock==obj) {
			new MDialog(this, "여행기간을 선택해주세요.","", true);
		} else if(btndate==obj) { // 날짜 선택 창을 엑스표 누르면 전체창도 같이 종료가 된다.
			new JDatePicker(this).setVisible(true);
		}else if(btnf==obj) {
			new MFind(this, "여행구별을 선택해주세요.","", true);
		}else if(btnage==obj) {
			new MAge(this, "연령을 선택해주세요.","", true);
		}else if(btngender==obj) {
			new MGender(this, "성별을 선택해주세요.","", true);
		}else if(btnarray==obj) {
			new MArray(this, "정렬기준을 선택해주세요.","", true);
		}else if(btnm1==obj) {
			JFrame frame = new More();
			frame.setVisible(true);
		}else if(btnm2==obj) {
			JFrame frame = new More();
			frame.setVisible(true);
		}
	}
////////////////////////////////////////////////////////////////////////////////
	class MArray extends JDialog implements ActionListener {
		
		Checkbox cb1, cb2, cb3;
		CheckboxGroup cbg;
		int width = 300;
		int height = 110;
		Button save;
		Frame f;
	
		public MArray(Frame f, String title, String msg, boolean flag) {
			super(f, title, flag);
			this.f = f;
			setLayout(new FlowLayout());

			cbg = new CheckboxGroup();
			Panel p = new Panel();
			p.add(cb1 = new Checkbox("등록순", cbg, true));
			p.add(cb2 = new Checkbox("오래된순", cbg, false));
			p.add(cb3 = new Checkbox("좋아요순", cbg, false));
			p.add(cb3 = new Checkbox("리뷰순", cbg, false));
	
		
			add(p);
			add(save = new Button("SAVE"));
			save.addActionListener(this);
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
	
	
	
	
	
/////////////////////////////////////////////////////////////////////////////////
	class MGender extends JDialog implements ActionListener {
		
		Checkbox cb1, cb2, cb3;
		CheckboxGroup cbg;
		int width = 200;
		int height = 110;
		Button save;
		Frame f;
	
		public MGender(Frame f, String title, String msg, boolean flag) {
			super(f, title, flag);
			this.f = f;
			setLayout(new FlowLayout());

			cbg = new CheckboxGroup();
			Panel p = new Panel();
			p.add(cb1 = new Checkbox("여성", cbg, true));
			p.add(cb2 = new Checkbox("남성", cbg, false));
			p.add(cb3 = new Checkbox("상관없음", cbg, false));
		
			add(p);
			add(save = new Button("SAVE"));
			save.addActionListener(this);
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
	
	
	
	
	
/////////////////////////////////////////////////////////////////////////////////
	
	class MAge extends JDialog implements ActionListener {
		
		Checkbox cb1, cb2, cb3,cb4, cb5;
		CheckboxGroup cbg;
		int width = 300;
		int height = 110;
		Button save;
		Frame f;
	
		public MAge(Frame f, String title, String msg, boolean flag) {
			super(f, title, flag);
			this.f = f;
			setLayout(new FlowLayout());

			cbg = new CheckboxGroup();
			Panel p = new Panel();
			p.add(cb1 = new Checkbox("10대", cbg, true));
			p.add(cb2 = new Checkbox("20대", cbg, false));
			p.add(cb3 = new Checkbox("30대", cbg, false));
			p.add(cb4 = new Checkbox("40대", cbg, false));
			p.add(cb5 = new Checkbox("50대 이상", cbg, false));
			add(p);
			add(save = new Button("SAVE"));
			save.addActionListener(this);
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
	
/////////////////////////////////////////////////////////////////////////////////
	
	
//////////////////////////////////////////////////////////////////////////
	class MFind extends JDialog implements ActionListener, ItemListener{

		String scity[] = {"전체선택","강서구","금정구","기장군","남구","동구","동래구","부산진구","북구","사상구","사하구","서구","수영구","연제구","영도구","중구","해운대구"};
		Choice city;
		int width = 250;
		int height = 150;
		Button save;
		Frame f;
	
		public MFind(Frame f, String title, String msg, boolean flag) {
			super(f, title, flag);
			this.f = f;
			setLayout(new FlowLayout());

			city = new Choice();
			for (int i = 0; i < scity.length; i++) {
				city.add(scity[i]);
			}
			add(city);
			city.addItemListener(this);

			add(save = new Button("SAVE"));
			save.addActionListener(this);
			layset();
		}
		public void layset() {
			int px = f.getX();
			int py = f.getY();
			int x = px+f.getWidth()/2;
			int y = py+f.getHeight()/2;
			setBounds(x, y, width, height);
			setVisible(true);
			validate();
		}
		@Override
		public void itemStateChanged(ItemEvent arg0) {
			repaint();
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();
		}
		public void paint(Graphics g) {
			g.setColor(Color.BLACK);
			String str = "부산시 구 : " + city.getSelectedItem();   /*+" 를 검색";*/
			g.drawString(str, 70, 95);
		}
	}
	
////////////////////////////////////////////////////////////////////////////
	class MDialog extends JDialog implements ActionListener {
		
		Checkbox cb1, cb2, cb3,cb4;
		CheckboxGroup cbg;
		int width = 300;
		int height = 120;
		Button save;
		Frame f;

		public MDialog(Frame f, String title, String msg, boolean flag) {
			super(f, title, flag);
			this.f = f;
			setLayout(new FlowLayout());

			cbg = new CheckboxGroup();
			Panel p = new Panel();
			p.add(cb1 = new Checkbox("무박여행", cbg, true));
			p.add(cb2 = new Checkbox("1박2일", cbg, false));
			p.add(cb3 = new Checkbox("2박3일", cbg, false));
			p.add(cb4 = new Checkbox("3박이상", cbg, false));
			add(p);
			add(save = new Button("SAVE"));
			save.addActionListener(this);
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


	//// JFrame 배경색상 지정//////////////////////////////////////////
	public static void main(String[] args) {
		new Mate();
	}
	
}
