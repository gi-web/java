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
	
	JLabel nameL;//�г��� ���̺�
	JTextField nameTf;//�г���
	JButton checkNBtn;//�г��� �ߺ�Ȯ��
	
	JLabel idL;//id ���̺�
	JTextField idTf; //id�Է��ϴ� �ؽ�Ʈ �ʵ� ����
	JButton checkIBtn;//id �ߺ�Ȯ��
	
	JLabel passL;
	JPasswordField passTf; //password�Է��ϴ� �ؽ�Ʈ �ʵ� ����
	JButton checkPBtn;//password Ȯ��
	
	JLabel passL2;
	JPasswordField passTf2; //password ���Է��ϴ� �ؽ�Ʈ �ʵ� ����
	JButton checkPBtn2;//password ��Ȯ��
	
	JRadioButton rMan, rWoman;
	
	JTextField birthTf; //������� �Է��ϴ� �ؽ�Ʈ �ʵ� ����
	JButton calBtn;//������� �����ϴ� ��ư
	
	JTextField emailTf; //������� �Է��ϴ� �ؽ�Ʈ �ʵ� ����
	
	JComboBox comboTel;//�ڵ��� ��ȣ �Է�
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

		/// logo ������ ���� �����;���//
		panellogowhite.setLayout(null);
		panellogowhite.setBounds(50, 50, 350, 100);
		add(panellogowhite);

		// background2 ��ġ//
		panelbackground2.setLayout(null);
		panelbackground2.setBounds(150,180,1100,900);
		add(panelbackground2);

		// background �г� ��ġ�� ���� �ϴܿ� ��ġ//
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
		
		Font top = new Font("�������",Font.BOLD,20);
		//p[0].setLayout(null);
		//p[0].add( nameL=new JLabel("�г���"));
		//p[0].add(nameTf=new JTextField());
		//p[0].add(checkNBtn= new JButton("�ߺ�Ȯ��"));
		nameL=new JLabel("�г���");
		nameTf=new JTextField();
		checkNBtn= new JButton("�ߺ�Ȯ��");
		nameL.setBounds(430,70,100,30);
		nameL.setFont(top);
		nameTf.setBounds(510, 70, 200, 30);
		nameTf.setFont(top);
		
		
		p[1].add(new JLabel("ID �Է�"));
		p[1].add(idTf = new JPasswordField(20));
		p[1].add(checkIBtn = new JButton("�ߺ�Ȯ��"));
		
		
		p[2].add(new JLabel("PASS �Է�   "));
		p[2].add(passTf = new JPasswordField(20));
		p[2].add(checkPBtn = new JButton("Ȯ  ��"));
		
		p[3].add(new JLabel("PASS ���Է�  "));
		p[3].add(passTf2 = new JPasswordField(20));
		p[3].add(checkPBtn2 = new JButton("Ȯ  ��"));
		
		p[4].add(new JLabel("���� : "));
		rMan = new JRadioButton("����", true);
		rWoman = new JRadioButton("����");
		ButtonGroup group = new ButtonGroup();
		group.add(rMan);
		group.add(rWoman);
		p[4].add(rMan);
		p[4].add(rWoman);
		
		p[5].add(new JLabel("�������"));
		p[5].add(birthTf = new JTextField(20));
		p[5].add(calBtn = new JButton("�޷�"));//�ؽ�Ʈ �ʵ����� ��� �޷� �̹����� �̾� ��ư�� �ִ��� �𸣰���
		
		
		p[6].add(new JLabel("Email �ּ�"));
		p[6].add(emailTf=new JTextField(20));
		
		p[7].add(new JLabel("�ڵ��� : "));
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
