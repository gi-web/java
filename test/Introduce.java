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

public class Introduce extends JFrame implements ActionListener { //����///�Ϸ�� ������ 6�� ���ϱ����� ���ð���
	
	ImageIcon  busan, background, background2, profileUpload, site1, site2;
	JLabel labWelcome,labLogout, lablike, labmail, labtext1;
	TextArea ta1, ta2, ta3;
	JButton btnu;
	Label labday;
	
	
	public Introduce() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setTitle("Travle in Busan");

////////////////////////////////����ġ�� Panel/////////////////////////////////////////////////////////////
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
		

		
		
///////////////////////////////�ϴ� ����ϱ� ��ư/////////////////////////////////////////////////
		JPanel buttonupload = new JPanel();
		buttonupload.setBounds(700, 950, 90, 35);
		add(buttonupload);
		
		
/////////////////////////////�̹��� ��ġ//////////////////////////////////////////////////
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
		
		
		
		
		panelbackground2.add(ta1 =new TextArea("������ �Ұ��ϴ� ���� �ۼ����ּ��� (500�� ��)", 5 ,5, TextArea.SCROLLBARS_VERTICAL_ONLY));
		ta1.setBounds(520, 40, 550, 200);
		
		panelbackground2.add(ta2 =new TextArea("�����Ͻô� ��ҿ� ���Ͽ� ������ ��ȹ �Ұ����� �����ּ��� (500�� ��)", 5 ,5, TextArea.SCROLLBARS_VERTICAL_ONLY));
		ta2.setBounds(420, 590, 650, 170);
		
		panelbackground2.add(ta3 =new TextArea("�����Ͻô� ��ҿ� ���Ͽ� ������ ��ȹ �Ұ����� �����ּ���(500�� ��)", 5 ,5, TextArea.SCROLLBARS_VERTICAL_ONLY));
		ta3.setBounds(420, 790, 650, 170);
		ta3.setCaretPosition(0);
		
		
		
		
		panelbackground2.setLayout(null);
		panelbackground2.setBounds(180,80,1100,1100);
		add(panelbackground2);
		
		panelbackground.setLayout(null);
		panelbackground.setBounds(0,0,1500,1100);
		add(panelbackground);
		

//////////////////////////////��Ʈ////////////////////////////////////////////////////////		
		Font top = new Font("�������",Font.BOLD,15);
		Font day = new Font("�������",Font.BOLD,20);
		labWelcome.setFont(top);
		labLogout.setFont(top);
		labWelcome.setForeground(Color.WHITE);
		labLogout.setForeground(Color.WHITE);
		/*labday.setFont(top);*/

	
		btnu = new JButton("����ϱ�");
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
		String item = ta1.getText(); //�Էµ� ���ڿ� ����
		//System.out.println(item.trim().length());
		if(item.trim().length()==0) {// �Է��� �� ���� �����̶�� , trim ���� ���Ž�Ű�� ��� 
			MDialog jd = new MDialog(this, "�˸�", "�Է��ϼ���", true);
			int width = 200;
			int height = 150;
			int px = getX();
			int py = getY();
			int x = px+getWidth()/2-width/2;
			int y = py+getHeight()/2-height/2;
			
			
			/*
			 * Label labtext1 = new Label(); jd.add(labtext1 = new Label("�Է��ϼ���"));
			 */

			jd.setBounds(x, y, width, height);
			jd.setVisible(true);
		}
		ta1.setText(""); // ������ �ʱ�ȭ ��Ų��. // �ڸ��� �����ϰ� ���� ���°� -> ���ڸ� �Է��ϼ��� 
		ta1.requestFocus(); // ��Ŀ���� �����´�. 
	
	} 

	class MDialog extends JDialog implements ActionListener{
		
		Button btnu;
		
		public MDialog(Frame f, String title, String msg,boolean flag) {
			super(f, title, flag);
			setLayout(new FlowLayout());
			add(new Label(msg, Label.CENTER));
			add(btnu = new Button("Ȯ��"));
			btnu.addActionListener(this); ////////////// �߿�!!
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