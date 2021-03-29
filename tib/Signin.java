package tib;

import java.awt.Graphics;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Container;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.print.attribute.standard.JobOriginatingUserName;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Signin extends JFrame implements ActionListener {

	ImageIcon background, busanwhite, background2,profil;
	Button welcomeBtn, logoutBtn;
	
	JLabel proL;
	JButton proCallBtn, proReBtn, proChBtn;
	FileDialog getImg;//�̹����������� 
	ImagePanel panelProfil;
	
	JLabel lavel[];
	String lavelStr[] = {"�г���","ID �Է�", "PASS �Է�","PASS ���Է�","����","�������","Email �ּ�","�ڵ�����ȣ"};
	JTextField nameTf;//�г���
	JButton checkNBtn;//�г��� �ߺ�Ȯ��
	
	JTextField idTf; //id�Է��ϴ� �ؽ�Ʈ �ʵ� ����
	JButton checkIBtn;//id �ߺ�Ȯ��
	
	JTextField passTf; //password�Է��ϴ� �ؽ�Ʈ �ʵ� ����
	JButton checkPBtn;//password Ȯ��
	JLabel passL;//�н����� ���� �˷��ִ� ���̺�
	
	JTextField passTf2; //password ���Է��ϴ� �ؽ�Ʈ �ʵ� ����
	JButton checkPBtn2;//password ��Ȯ��
	
	Choice genderC;
	String sGen[]= {"��","��"};
	
	JTextField birthTf; //������� �Է��ϴ� �ؽ�Ʈ �ʵ� ����
	JButton calBtn;//������� �����ϴ� ��ư
	Image calImg;//�޷±׸�
	
	
	JTextField emailTf; //email �Է��ϴ� �ؽ�Ʈ �ʵ� ����
	
	
	JComboBox comboTel;//�ڵ��� ��ȣ �Է�
	JTextField telTf2, telTf3;
	JLabel bar1, bar2;

	  
	JTextArea proTf;
	
	JButton saveSiBtn;

	JPanel pMain;
	JPanel[] p;
	
	Signin signin;
	
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
				
		background = new ImageIcon("tib/background1000.jpg");
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
		
		

		/// logo ������ ���� �����;���//
		panellogowhite.setLayout(null);
		panellogowhite.setBounds(50, 50, 350, 100);
		add(panellogowhite);
		
		Font top = new Font("�������",Font.BOLD,20);
		Font top2 = new Font("�������",Font.BOLD,15);
		Font top3 = new Font("�������",Font.BOLD,12);
		Font top4 = new Font("���� ���" ,Font.BOLD,9 );
		
		welcomeBtn = new Button();
		panelbackground.add(welcomeBtn = new Button("Welcome"));
		welcomeBtn.setBounds(1100,30,100,30); 
		welcomeBtn.setBackground(new Color(0, 0, 0));
		welcomeBtn.setFont(top);
		welcomeBtn.setForeground(Color.WHITE);
		
		
		logoutBtn = new Button();
		panelbackground.add(logoutBtn = new Button("logout"));
		logoutBtn.setBounds(1230,30,70,30);
		logoutBtn.setBackground(new Color(0, 0, 0));
		logoutBtn.setFont(top);
		logoutBtn.setForeground(Color.WHITE);
		
		
		
		// background2 ��ġ//
		panelbackground2.setLayout(null);
		panelbackground2.setBounds(150,180,1100,730);
		add(panelbackground2);

		// background �г� ��ġ�� ���� �ϴܿ� ��ġ//
		panelbackground.setLayout(null);
		panelbackground.setBounds(0, 0, 1500, 1000);
		add(panelbackground);
		
				
		
		
		
		panelbackground2.add(proL=new JLabel("���� ��������� 200 X 200"));
		proL.setBounds(105, 330, 200,30);
		proL.setFont(top2);
		
		panelbackground2.add(proCallBtn = new JButton("�̹����ҷ�����"));
		proCallBtn.setBounds(70, 375, 125,30);
		proCallBtn.setBackground(Color.WHITE);
		
		panelbackground2.add(proReBtn = new JButton("��       ��"));
		proReBtn.setBounds(200, 375, 125,30);
		proReBtn.setFont(top2);
		proReBtn.setBackground(Color.WHITE);

		
		
		int j = 100;
		lavel = new JLabel[8];
		for (int i = 0; i < lavel.length; i++) {
			panelbackground2.add(lavel[i] = new JLabel(lavelStr[i]));
			lavel[i].setBounds(470,j, 140, 30);
			lavel[i].setFont(top);
			j += 40;
		}
		
		panelbackground2.add(nameTf=new JTextField("  10�� �̳�"));
		panelbackground2.add(checkNBtn= new JButton("�ߺ�Ȯ��"));
		nameTf.setBounds(610,100,200, 30);
		checkNBtn.setBounds(820, 100, 100,30);
		checkNBtn.setBackground(Color.WHITE);

		nameTf.setFont(top2);
		nameTf.setForeground(Color.GRAY);
		checkNBtn.setFont(top2);
		nameTf.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				nameTf.setText("");
			}
		});
		
		
		panelbackground2.add(idTf=new JTextField("  10�� �̳�"));
		panelbackground2.add(checkIBtn= new JButton("�ߺ�Ȯ��"));
		idTf.setBounds(610,140 ,200, 30);
		checkIBtn.setBounds(820, 140, 100,30);
		idTf.setFont(top2);
		idTf.setForeground(Color.GRAY);
		checkIBtn.setFont(top2);
		checkIBtn.setBackground(Color.WHITE);

		idTf.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				idTf.setText("");
			}
		});
		
		panelbackground2.add(passTf=new JTextField());
		//passTf.setEchoChar('#');
		panelbackground2.add(checkPBtn= new JButton("Ȯ      ��"));
		passTf.setBounds(610,179 ,200, 30);
		checkPBtn.setBounds(820, 179, 100,30);
		passTf.setFont(top2);
		checkPBtn.setFont(top2);
		checkPBtn.setBackground(Color.WHITE);

		panelbackground2.add( passL = new JLabel("��й�ȣ�� Ư������ �����빮�� 1���̻� ���"));
		passL.setFont(top4);
		passL.setBounds(610,210, 300,10);
		//idTf.setF
		
		panelbackground2.add(passTf2=new JTextField());
		//passTf2.setEchoChar('#');
		panelbackground2.add(checkPBtn2= new JButton("Ȯ      ��"));
		passTf2.setBounds(610,221 ,200, 30);
		checkPBtn2.setBounds(820, 220, 100,30);
		passTf2.setFont(top2);
		checkPBtn2.setFont(top2);
		checkPBtn2.setBackground(Color.WHITE);

		
		genderC = new Choice();
		genderC.add(sGen[0]);
		genderC.add(sGen[1]);
		panelbackground2.add(genderC);
		genderC.setBounds(610,260,200,30);
		genderC.setFont(top2);
		genderC.setBackground(Color.WHITE);

		
		//panelbackground2.add(birthTf=new JTextField("2020-11-11",CENTER_ALIGNMENT));//����
		panelbackground2.add(birthTf=new JTextField("2020-11-11"));//�ؽ�Ʈ �ʵ� �߰��� ��ġ�ϰ� �ϴ� ���?
		birthTf.setBounds(610,300 ,170, 30);
		birthTf.setFont(top2);
		
		//�ؽ�Ʈ �ʵ����� ��� �޷� �̹����� �̾� ��ư �ִ��� �𸣰��� - ������
		panelbackground2.add(calBtn = new JButton(new ImageIcon("tib/calender.png")));
		calBtn.setBounds(780,300,30,30);
		calBtn.setFont(top2);
		calBtn.setBackground(Color.WHITE);

		
		panelbackground2.add(emailTf=new JTextField(""));
		emailTf.setBounds(610,340 ,200, 30);
		emailTf.setFont(top2);
		
		
		JPanel p = new JPanel();
		p.setLayout(null);
		String[] tel1 = { "010", "011", "016", "017", "018", "019" };
		comboTel = new JComboBox(tel1);
		p.add(comboTel);
		comboTel.setBounds(0,0,60,30);
		comboTel.setBackground(Color.WHITE);
		comboTel.setFont(top2);
		
		p.add( bar1 =new JLabel("-"));
		bar1.setBounds(65,0,5,30);
		bar1.setBackground(Color.WHITE);
		bar1.setFont(top2);
		

		telTf2 = new JTextField(4);
		p.add(telTf2);
		telTf2.setBounds(75,0,55,30);
		telTf2.setBackground(Color.WHITE);
		telTf2.setFont(top2);

		
		p.add( bar2 =new JLabel("-"));
		bar2.setBounds(135,0,5,30);
		bar2.setBackground(Color.WHITE);
		bar2.setFont(top2);
		
		telTf3 = new JTextField(4);
		p.add(telTf3);
		telTf3.setBounds(145,0,55,30);
		telTf3.setBackground(Color.WHITE);
		telTf3.setFont(top2);
		
		panelbackground2.add(p);
		p.setBounds(610, 380, 200, 30);
		p.setBackground(Color.WHITE);
				
		
		panelbackground2.add(proTf=new JTextArea("50���̻�  500�����Ϸ� ���μҰ��� �ּ���"));
		proTf.setBounds(70,450 ,960, 200);
		proTf.setFont(top2);
		proTf.setForeground(Color.gray);
		
		
		proTf.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				proTf.setText("");
			}
		});
		
		panelbackground2.add(saveSiBtn = new JButton("��  ��"));
		saveSiBtn.setBounds(500, 670, 100,30);
		saveSiBtn.setFont(top2);
		saveSiBtn.setBackground(Color.WHITE);

		

		
		
		//////////////�̹��� ���� �����ͼ� �ֱ�///////////////////
		panelProfil = new ImagePanel();
		panelbackground2.add(panelProfil);
		panelProfil.setBounds(95,110, 200, 200);
		
		String s="tib/user.png";
		 panelProfil.setPath(s);//�̹��� �ǳڿ� �̹����� �����´�
		 panelProfil.repaint();//�̹��� �ǳڿ� �̹����� �׸���.
		
		getImg = new FileDialog(this,"�̹��� ����",FileDialog.LOAD);
		
		///////////////////////////�̹�Ʈ ����//////////////////////
		proCallBtn.addActionListener(this);
		proReBtn.addActionListener(this);
		
		welcomeBtn.addActionListener(this);
		logoutBtn.addActionListener(this);
		
		calBtn.addActionListener(this);
		
		/////////////////diallog â ���� ����/////////////////////////////////////
       
		//nameTf.addActionListener(this);
		//idTf.addActionListener(this);
		//passTf.addActionListener(this);
		//passTf2.addActionListener(this);
		checkNBtn.addActionListener(this);
		checkIBtn.addActionListener(this);
		checkPBtn.addActionListener(this);
		checkPBtn2.addActionListener(this);
		//emailTf.addActionListener(this);
		//telTf2.addActionListener(this);
		//telTf3.addActionListener(this);
		
		//proTf.addActionListener(this);
		
		
		saveSiBtn.addActionListener(this);
		
		setSize(1500, 1000);
		setVisible(true);
		validate();
		setLocationRelativeTo(null);//�ǳ��� �߰��� ��ġ ��Ų��. 
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object obj = e.getSource();
		
		
		if(proCallBtn==obj||proReBtn==obj) {//������ �̹��� ��������
			 getImg.setVisible(true);
			 String s=getImg.getDirectory()+getImg.getFile();
			 panelProfil.setPath(s);//�̹��� �ǳڿ� �̹����� �����´�
			 panelProfil.repaint();//�̹��� �ǳڿ� �̹����� �׸���.
			 return;
		} else if (welcomeBtn==obj){//welcome ��ư�� ������ choose Ŭ������ �Ѿ��.
			JFrame frame = new Choose();
			frame.setVisible(true);
			return;
	   } else if (logoutBtn == obj){//logout ��ư�� ������ ����ȴ�.
			System.exit(0);
	   }else if (calBtn == obj){// �޷� ��ư�� ������ ���� ������ �����Ҽ� �ִ�. 
		   // new  SwingCalendar(this);//�̷��Ը� �ص� JDatePicker�� ȣ���
		   
	//////////////////////////dialogâ ����///////////////////////////////////////////////		
	   } else if (saveSiBtn == obj ||checkNBtn == obj||checkIBtn == obj||checkPBtn == obj
			   ||checkPBtn2 == obj/*||emailTf== obj||telTf2 == obj||telTf3== obj*/) {
		   String title="�˸�", msg1="", msg2="",
				 nameitem=nameTf.getText(),  iditem=idTf.getText(), passitem=passTf.getText(),
				 pass2item=passTf2.getText(), emailitem=emailTf.getText(),
				 tel1item=telTf2.getText(), tel2item=telTf3.getText(), proitem=proTf.getText();
		 
	        if(saveSiBtn == obj||checkNBtn == obj) {   		
			   	 if (nameitem.trim().length() >10 || nameitem.trim().length() == 0 || nameitem.trim().equals("bean.name")){//�г��� �ߺ� Ȯ��
			   		msg1 = "����� �� ���� �г����Դϴ�.";
			   		msg2 = "�ٽ� ����� �ߺ�Ȯ�� ���ּ���";
		   			nameTf.requestFocus();
		   			}else {
		   				msg1 = "��� ������";
				   		msg2 = "�г��� �Դϴ�. ";
				   		idTf.requestFocus();	
		   			}
			
			}else if(saveSiBtn == obj||checkIBtn == obj) {	   	
			   	   if (iditem.trim().length() >10 || iditem.trim().length() == 0 ||iditem.trim().equals("bean.name")){//ID �ߺ� Ȯ��
			   		   msg1 = "����� �� ���� ID�Դϴ�.";
			   		   msg2 = "�ٽ� ����� �ߺ�Ȯ�� ���ּ���";
			   		   idTf.requestFocus();
		   			}else {
		   				msg1 = "��� ������";
				   		msg2 = "ID�Դϴ�.";
				   		passTf.requestFocus();	
		   			}
			}else if(saveSiBtn == obj||checkPBtn == obj) {   	   
			   	 if(passitem.trim().length() == 0) {//�н�����κ� �������� Ȯ��
			   		msg1 = "�н����带 ";
			   		msg2 = "�Է��� �ּ���";
			   		passTf.requestFocus();
			   	 } else {//�빮�ڿ� Ư������ ��� Ȯ��
			   		int count = 0;
			   		for(int i=0; i<passitem.length();i++ ) {//�н�����κ� Ư�������ִ��� Ȯ��
			   			char c = passitem.charAt(i);
			   			if(c=='~'||c=='@'||c=='#'||c=='$'||c=='%'||c=='^'||c=='&'||c=='*') {
			   			count ++;
			   			if(count == 1) break; //Ư������ 1�� ��������� Ư������ for�� ����
			   			}//Ư������ if
			   		}//Ư������for
			   		if(count ==0) {//Ư�����ڰ� ������ �ʾ�����
			   			msg1 = " Ư�����ڸ�";
			   			msg2 = "1���̻� ����� �ּ���";
			   			passTf.requestFocus();
			   		}	else {//Ư�����ڸ� 1���̻� ��������� �빮�� ��� üũ
				   			count =0;
				   			for(int j=0; j<passitem.length() ;j++) {
			   					char c= passitem.charAt(j);
			   					if('A'<= c && c<='Z') { // �νľȉ�
								/*
								 * if('A'==c||'B'==c||'C'==c||'D'==c||'E'==c||'F'==c||'G'==c||'H'==c||'I'==c||'J
								 * '==c||
								 * 'K'==c||'L'==c||'M'==c||'N'==c||'O'==c||'P'==c||'Q'==c||'R'==c||'S'==c||'T'==
								 * c|| 'U'==c||'V'==c||'W'==c||'X'==c||'Y'==c||'Z'==c) {
								 */
			   						count ++;
			   						if(count ==1) break;
			   					}//�빮�� �����ϸ� for�� ���
			   				}//�빮�� for
					   		if(count==0)  {//�빮�ڸ� ������� �ʾ�����
					   			msg1 = "���� �빮�ڸ� ";
					   			msg2 = "1���̻� ����� �ּ���.";
					   			passTf.requestFocus();
					   			}else {
						   		msg1 = "��� ������";
						   		msg2 = "��й�ȣ �Դϴ�. ";
						   		passTf2.requestFocus();
						   		}	
				   		}//Ư�����ڸ� ����
			   	 
			  }//�н����尡 �ԷµǾ����	 
			} else if(saveSiBtn == obj/*||passTf2 == obj*/||checkPBtn2==obj) { 
				if(passitem.trim().length() == 0) {//�н�����κ� �������� Ȯ��
			   		msg1 = "�н����带 ";
			   		msg2 = "�Է��� �ּ���";
			   		passTf.requestFocus();
			   	 }
				else if( !passitem.equals(pass2item)) {
			   		msg1 = "��й�ȣ��";
		   			msg2 = "��ġ���� �ʽ��ϴ�.";
		   			passTf2.requestFocus();
			   	 }else {
			   		 msg1 = "��й�ȣ��";
			   		 msg2 = "�ٸ��� �ԷµǾ����ϴ�. ";
			   		genderC.requestFocus();
			   	 }
			}else if(saveSiBtn == obj) {
				 if(emailitem.trim().length() == 0) {
			   		msg1 = "�̸��� �ּҸ�";
			   		msg2 = "�Է��� �ּ���";
			   		emailTf.requestFocus();
		   			}
			//}else if(saveSiBtn == obj||telTf2== obj) {   		
				 else if(tel1item.trim().length() == 0) {
			   		msg1 = "��ȭ��ȣ��";
			   		msg2 = "�Է��� �ּ���";
			   		telTf2.requestFocus();
		   			}
			//}else if(saveSiBtn == obj||telTf3== obj) {   		
				 else if(tel2item.trim().length() == 0) {
			   		msg1 = "��ȭ��ȣ��";
			   		msg2 = "�Է��� �ּ���";
			   		telTf3.requestFocus();
		   			}
			//}else if(saveSiBtn == obj||proTf== obj) {   		
				 else  if(proitem.trim().length() == 0||proitem.trim().length() <50 || proitem.trim().length() >500) {
			   		msg1 = "50���̻� 500�� ���Ϸ� ";
			   		msg2 = "���μҰ��� ���ּ���";
			   		telTf3.requestFocus();
		   		}else {
		   			//JFrame frame = new Login();
					//frame.setVisible(true);
					}
		   	}
	    		   					   
		   MDialog md = new MDialog(this, title, msg1, msg2, true);
			int width = 250;
			int height = 200;
			int x = getX() + getWidth() / 2 - width / 2;
			int y = getY() + getHeight() / 2 - height / 2;
			md.setBounds(x, y, width, height);
			md.setVisible(true);
					   
		 }//��� ������ �Է��� ���	   		
		
		
		}//action
	
	/////////////�̹��� �������� Ŭ����////////
	
	class ImagePanel extends JPanel{
		
		Image image;
		Toolkit toolkit = getToolkit();//�̹����� �������� ���ؼ� 
		
		public void setPath(String src) {
			image = toolkit.getImage(src);//��μ���
		}
		
		public void paint(Graphics g) {
			g.clearRect(0,0,200,200);
			if(image != null)
				g.drawImage(image ,0,0,this);//��ΰ� �������� ���
		}
		
	}//ImagePanelŬ����


	class MDialog extends JDialog implements ActionListener{
		JButton btnu;
		JLabel msg1L;
		JLabel msg2L;
		
		public MDialog(Frame f,String title, String msg1,String msg2, boolean flag) {
			super(f, title, flag);
							
			setLayout(null);
			add(msg1L = new JLabel(msg1));
			add(msg2L = new JLabel(msg2));
		     			
			add(btnu = new JButton("Ȯ��"));
			
								
			msg1L.setBounds(60,20,200,30);
			msg2L.setBounds(60,60,200,30);
			btnu.setBounds(80,100,70,30);
			btnu.addActionListener(this);
		    }
		
		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();
			}
		}//MDialog Ŭ����
		
		

	
	public static void main(String[] args) {
		
		new Signin();
	}
}