package tib;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import jdk.jshell.Diag;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dialog;
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

import javax.print.attribute.standard.JobOriginatingUserName;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Login extends JFrame implements ActionListener{///
	
	ImageIcon  background, busanwhite;
	JLabel labWelcome,labLogout;
	JLabel idL, pwL;//id라벨변수명, pass 라벨 변수명
	TextField idTx, pwTx;//id텍스트 필드 변수명, pass텍스트필드 변수명
	JButton logBtn,mrBtn, btnLogo;//로그인 번튼 변수명, 회원가입(member registration) 버튼 변수명
	
	
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setTitle("Travle in Busan");

		
		busanwhite = new ImageIcon("tib/busanwhite350.png");//travel in busan
		
		JPanel panelLogowhite  = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(busanwhite.getImage(), 0, 0, null);		
				setOpaque(false);
			}
		};
		
		background = new ImageIcon("tib/background800.jpg");
		
		JPanel panelBackground = new JPanel() {
			
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(background.getImage(), 0, 0, null);		
				setOpaque(false);
				
			}
		};
		
		btnLogo = new JButton(busanwhite);
		btnLogo.setBounds(50, 50, 350, 100);
		btnLogo.setBackground(new Color(0, 0, 0));
		panelBackground.add(btnLogo);
		btnLogo.addActionListener(this);
		
		///logo 사진이 제일 위에와야함//
		panelLogowhite .setLayout(null);
		panelLogowhite .setBounds(50, 50, 350, 100);
		add(panelLogowhite );
		
		
		
	
		
		
		//background 패널 위치는 제일 하단에 위치//
		panelBackground.setLayout(null);
		panelBackground.setBounds(0,0,1500,800);
		add(panelBackground);
		
		
		
		
		panelBackground.add(idL=new JLabel("ID"));
		panelBackground.add(pwL=new JLabel("PASS"));
		panelBackground.add(idTx=new TextField(""));
		panelBackground.add(pwTx=new TextField(""));
		pwTx.setEchoChar('#');

				
		///폰트 위치, 색, 크기//////////////////////////////////////
		Font top = new Font("맑은고딕",Font.BOLD,25);
		Font top2 = new Font("맑은고딕",Font.BOLD,15);
		Font top3 = new Font("맑은고딕",Font.BOLD,15);
		idL.setFont(top);
		idTx.setFont(top3);
		idL.setBounds(600,600, 100,30);
		idTx.setBounds(730, 600,200,30);
		idL.setForeground(Color.WHITE);
		
		
		pwL.setFont(top);
		pwTx.setFont(top3);
		pwL.setBounds(600,640, 100,30);
		pwTx.setBounds(730, 640,200,30);
		idL.setForeground(Color.WHITE);
		pwL.setForeground(Color.WHITE);
		
		
		
		
		
		
		logBtn = new JButton("로그인");
		mrBtn = new JButton("회원가입");
		logBtn.setBackground(Color.WHITE);
		mrBtn.setBackground(Color.WHITE);
		logBtn.setBounds(650,690, 100,30);
		mrBtn.setBounds(770,690, 100, 30);
		panelBackground.add(logBtn);
		panelBackground.add(mrBtn);
		logBtn.setFont(top2);
		mrBtn.setFont(top2);
		
		//////////////////////dialog 창 띄우기//////////////////
		idTx.addActionListener(this);
		pwTx.addActionListener(this);
		logBtn.addActionListener(this);
		mrBtn.addActionListener(this);

		
		setSize(1500,800);
		setVisible(true);
		validate();
		setLocationRelativeTo(null);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//////텍스트필드 다얄로그///////////////////
		String  iditem= idTx.getText(), psitem= pwTx.getText(), 
				title = "알림",msg1 = "", msg2 = "";
		if (idTx == e.getSource() || pwTx == e.getSource() || logBtn == e.getSource()) {
			if (idTx == e.getSource()) {//id입력시 체크
				
				////////////실험용/////////////////
			    System.out.println(iditem.trim());
			    if (iditem.trim().equals("bean.getID().trim()")){   System.out.println("같음");}
			    if (iditem.trim() != "bean.getID().trim()") { System.out.println("다름");}
			    /////////////////////////////////////////////////////////////
			    
				 if (iditem.trim() !="bean.getID().trim()") {//아디가 틀렸으면 다시 입력 하라고 알려준다.
					msg1 = "아이디가 틀렸습니다";
					msg2 = "다시 입력해 주세요";
					idTx.requestFocus();
				}else {pwTx.requestFocus();}
				
			} else if (pwTx == e.getSource()) {//password 입력후 체크
			if(psitem.trim() != "bean.getID().trim())") {
				msg1 = "비밀번호가 틀렸습니다";
				msg2 = "다시 입력해 주세요";
				pwTx.setText("");
				pwTx.requestFocus();
				} else {logBtn.requestFocus();}
			} else if (logBtn == e.getSource()) {//login버튼 클릭시 체크
				if(!iditem.trim().equals( "bean.getID().trim()") && !psitem.trim().equals( "bean.getID().trim()" ) ){//id가 입력되지 않았으면 회원 가입 하라고 알려 준다.
				msg1 = "아이디가 없으세요?";
				msg2 = "회원가입을 해주세요";
				mrBtn.requestFocus();
			}else {
					msg1 = "Welcome 화면으로 ";
					msg2 = "이동하겠습니다.";
					this.setVisible(false);
					JFrame frame = new Choose();
					frame.setVisible(true);}
			}
			MDialog md = new MDialog(this, title, msg1, msg2, true);
			int width = 250;
			int height = 200;
			int x = getX() + getWidth() / 2 - width / 2;
			int y = getY() + getHeight() / 2 - height / 2;
			md.setBounds(x, y, width, height);
			md.setVisible(true);
		}else if(mrBtn==e.getSource()) {
			this.setVisible(false);
			JFrame frame = new Signin();
			frame.setVisible(true);
		}

	}// action
	
	class MDialog extends JDialog implements ActionListener{
		JButton btnu;
		JLabel msg1L;
		JLabel msg2L;
		
		public MDialog(Frame f,String title, String msg1,String msg2, boolean flag) {
			super(f, title, flag);
			int xmsg = msg1.length();
				
				
			setLayout(null);
			add(msg1L = new JLabel(msg1));
			add(msg2L = new JLabel(msg2));
		     			
			add(btnu = new JButton("확인"));
			
								
			msg1L.setBounds(60,20,200,30);
			msg2L.setBounds(60,60,200,30);
			btnu.setBounds(80,100,70,30);
			btnu.addActionListener(this);
						
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();
			
		}
		
		
	}
	

	public static void main(String[] args) {
		new Login();
	}
}
