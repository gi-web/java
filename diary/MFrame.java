package diary;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.MenuItem;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;

import diary.SetFrame.MenuActionListener;
import login.Login;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;


public class MFrame extends JFrame implements MouseListener,ActionListener{
	
	 Point mouseClickedLocation = new Point(0, 0);
	JPanel contentPane;
	JTextField textField;
	JPanel homepl, memopl, cashpl;
	Cal calpl;
	JLabel cal, cal1, home, memo, cash, chat, set,exit;
	ChatFrame chatF;
	SetFrame setF;
	ImageIcon icon = new ImageIcon (Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon.png")));
	static MFrame mFrame;
	Login login;
	JPopupMenu popup;
	JMenuItem item1, item2, item3 ,item4;
	Font f;
	String id;
	
	public MFrame(String id) {
		this.id = id;
        setIconImage(icon.getImage()); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1220, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().setLayout(null);
    	setUndecorated(true); 		//타이틀바 안보이게 
   	
    	setPanel();
		getContentPane().add(homepl);
		
	    setBackground(new Color(0,0,0,0));
		setLabel();
        setLocationRelativeTo(null);
        pop();
        
		addMouseListener(new MouseAdapter() {
	    	public void mousePressed(MouseEvent e) {
	    		mouseClickedLocation.x = e.getX();
	    		mouseClickedLocation.y = e.getY();
	    	}
		});
		addMouseMotionListener(new MouseMotionAdapter() {
		    public void mouseDragged(MouseEvent e) {
		        MFrame.this.setLocation(e.getLocationOnScreen().x - mouseClickedLocation.x,
		                e.getLocationOnScreen().y - mouseClickedLocation.y);
		    }
		});	
		TrayIconHandler.registerTrayIcon(
				Toolkit.getDefaultToolkit().getImage("Diary/icon.png"),
				"Diary",
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						setVisible(true);
					}
				}
			);
		TrayIconHandler.addItem("      열기                        ","맑은 고딕", Font.BOLD, 12,  new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(true);
			}
		});
		TrayIconHandler.addItem("      로그아웃                        ","맑은 고딕", Font.PLAIN, 12,  new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				login = new Login();
				login.setVisible(true);
			}
		});
			TrayIconHandler.addItem("      종료                        ","맑은 고딕", Font.PLAIN, 12 , new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
		validate(); 
    }  	
	public void setLabel(){
		cal = new JLabel("");
		cal.addMouseListener(this);
		cal.setIcon(new ImageIcon(MFrame.class.getResource("/diary/Cal_on.png")));
		cal.setBounds(565, 0, 35, 35);
	    cal.setCursor(new Cursor(Cursor.HAND_CURSOR));
		calpl.add(cal);
		cal1 = new JLabel("");
		cal1.addMouseListener(this);
		cal1.setIcon(new ImageIcon(MFrame.class.getResource("/diary/Cal_off.png")));
		cal1.setBounds(565, 0, 35, 35);
		cal1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		home = new JLabel("");
		home.addMouseListener(this);
		home.setIcon(new ImageIcon(MFrame.class.getResource("/diary/HOME.png")));
		home.setBounds(1172, 55, 55, 155);
		home.setCursor(new Cursor(Cursor.HAND_CURSOR));
		getContentPane().add(home);
		memo = new JLabel("");
		memo.addMouseListener(this);
		memo.setIcon(new ImageIcon(MFrame.class.getResource("/diary/MEMO.png")));
		memo.setBounds(1175, 220, 55, 155);
		memo.setCursor(new Cursor(Cursor.HAND_CURSOR));
		getContentPane().add(memo);
		cash = new JLabel(""); 
		cash.addMouseListener(this);
		cash.setIcon(new ImageIcon(MFrame.class.getResource("/diary/CASH.png")));
		cash.setBounds(1175, 380, 55, 155);
		cash.setCursor(new Cursor(Cursor.HAND_CURSOR));
		getContentPane().add(cash);
		chat = new JLabel("");
		chat.addMouseListener(this);
		chat.setIcon(new ImageIcon(MFrame.class.getResource("/diary/CHAT.png")));
		chat.setBounds(1175, 540, 55, 150);
		chat.setCursor(new Cursor(Cursor.HAND_CURSOR));
		getContentPane().add(chat);
		
		set = new JLabel("");
		set.addMouseListener(this);
		set.setIcon(new ImageIcon(MFrame.class.getResource("/diary/SET.png")));
		set.setBounds(1175, 700, 55, 100);
		set.setCursor(new Cursor(Cursor.HAND_CURSOR));
		getContentPane().add(set);
		
		exit = new JLabel("");
		exit.addMouseListener(this);
		exit.setIcon(new ImageIcon(MFrame.class.getResource("/diary/exit2.png")));
		exit.setBounds(1175, -4, 55, 55);
		exit.setCursor(new Cursor(Cursor.HAND_CURSOR));
		getContentPane().add(exit);
	}
	public void pop() {
		popup = new JPopupMenu();
		item1 = new JMenuItem("폰트");
		item2 = new JMenuItem("테마");
		item3 = new JMenuItem("로그아웃");
		item4 = new JMenuItem("종료");
		f = new Font("맑은 고딕", Font.PLAIN, 25);
		item1.setFont(f);
		item2.setFont(f);
		item3.setFont(f);
		item4.setFont(f);
		item1.setHorizontalAlignment(SwingConstants.RIGHT);
		item2.setHorizontalAlignment(SwingConstants.RIGHT);
		item3.setHorizontalAlignment(SwingConstants.RIGHT);
		item4.setHorizontalAlignment(SwingConstants.RIGHT);
		popup.add(item1);
		popup.add(item2);
		popup.add(item3);
		popup.add(item4);
		item3.addActionListener(this);
		item4.addActionListener(this);
	}
	@Override
	public void mousePressed(MouseEvent e) {
		Object obj = e.getSource();
		if(obj==cal) {
			remove(calpl);
			getContentPane().add(cal1);
		}else if(obj==cal1) {
			remove(cal1);
			calpl.add(cal);
			getContentPane().add(calpl);
		}else if(obj==home) {
			remove(memopl);
			remove(cashpl);
			memo.setBounds(1175, 220, 55, 155);
			cash.setBounds(1175, 380, 55, 155);
			home.setBounds(1172, 55, 55, 155);
			getContentPane().add(homepl);
		}else if(obj==memo) { 
			remove(homepl);
			remove(cashpl);
			home.setBounds(1175, 55, 55, 155);
			cash.setBounds(1175, 380, 55, 155);
			memo.setBounds(1172, 220, 55, 155);
			getContentPane().add(memopl);
		}else if(obj==cash) { 
			remove(homepl);
			remove(memopl);
			home.setBounds(1175, 55, 55, 155);
			memo.setBounds(1175, 220, 55, 155);
			cash.setBounds(1172, 380, 55, 155);
			getContentPane().add(cashpl);
		}else if(obj==chat) {
			if(chatF==null) 
				chatF = new ChatFrame();
			else
				chatF.setVisible(true);
				chatF.setAlwaysOnTop(true);
		}else if(obj==set) {
			popup.show(e.getComponent(), -130,-60);
		}else if(obj==exit) {
			dispose();
		} 
		//else if(obj==set) setUp();
		validate();
		repaint();
	}
	public void setPanel() {
		calpl = new Cal(); // 달력
		calpl.setBounds(0, 0, 600, 800);
		calpl.setBackground(new Color(180,239,236));
		getContentPane().add(calpl);
		
		homepl = new Home();
		homepl.setLayout(null);
		homepl.setBounds(600, 0, 572, 800);
		homepl.setBackground(new Color(180,239,236));
		//getContentPane().add(homepl);
		
		memopl  = new Memo();
		memopl.setBounds(600, 0, 572, 800);
		memopl.setBackground(new Color(254,207,88));
		
		cashpl = new Cash(id);
		cashpl.setBounds(600, 0, 572, 800);
		cashpl.setBackground(new Color(173,217,220));
		//getContentPane().add(cashpl);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand(); 
		switch(cmd) { // 메뉴 아이템의 종류 구분
		case"로그아웃" :
			dispose();
			login = new Login();
			login.setVisible(true); break;
		case "종료" :
			System.exit(0); break;
		}
	}
	public static void main(String[] args) {
		new MFrame("abc").setVisible(true);;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
	}
	@Override
	public void mouseReleased(MouseEvent e) {
	}
	@Override
	public void mouseEntered(MouseEvent e) {
	}
	@Override
	public void mouseExited(MouseEvent e) {
	}
}
