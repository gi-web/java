package login;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.List;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.placeholder.PlaceHolder;

import diary.MFrame;
import diary.TrayIconHandler;
import diary.Memo.Hint;
public class Login  extends JFrame implements ActionListener{
	ImageIcon icon = new ImageIcon (Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon.png")));
	JLabel msgl;
	PlaceHolder pl1;
    BufferedImage img = null;//버퍼(메모리)에 이미지를 올릴 때 쓰임
    JTextField idField;
    JPasswordField pwField;
    JButton logBtn,idSearchBtn,pwSearchBtn,signupBtn,exitBtn;
    JCheckBox cb;
    JLabel label1,label2;
	MemberMgr mgr;
	JoinFrame join;
	IdFrame ids;
	PwFrame pwds;
	MFrame mFrame;
	JLayeredPane layeredPane;
	public static void main(String[] args) {
		new Login();
	}
    // 생성자
	public class Hint extends JTextField {		
		Font gainFont = new Font("맑은 고딕", Font.PLAIN, 12);  
		Font lostFont = new Font("맑은 고딕", Font.PLAIN, 12); 
		
	public Hint(final String hint) {  			  
	    setText(hint);  
	    setFont(lostFont);  
	    setForeground(Color.GRAY);  
	    this.addFocusListener(new FocusAdapter() {  
			  
		      @Override  
		      public void focusGained(FocusEvent e) {  
		        if (getText().equals(hint)) {  
		          setText("");  
		          setFont(gainFont);  
		        } else {  
		          setText(getText());  
		          setFont(gainFont);  
		        }  
		      }  
		  
		      @Override  
		      public void focusLost(FocusEvent e) {  
		        if (getText().equals(hint)|| getText().length()==0) {  
		          setText(hint);  
		          setFont(lostFont);  
		          setForeground(Color.GRAY);  
		        } else {  
		          setText(getText());  
		          setFont(gainFont);  
		          setForeground(Color.BLACK);  
		        }  
		      }  
		    });  			  
		}
	}
	    public Login() {
	    	try {
	            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
	        }  catch (Exception e) { }
	        setIconImage(icon.getImage()); 
			mgr = new MemberMgr();
			msgl = new JLabel("");
	    	msgl.setBounds(67, 370, 250, 40);
			msgl.setFont(new Font("맑은 고딕",Font.PLAIN,12));
	    	setUndecorated(true);//타이틀바 제거
	        setTitle("로그인");
	        setSize(365, 590);
			setLayout(new BorderLayout());
	        //setDefaultCloseOperation(HIDE_ON_CLOSE); //화면에서 숨김(종료된 상태가 아님)
	        // 레이아웃 설정
	        setLayout(null); // 배치 관리자를 null로 설정할 경우
	        layeredPane = new JLayeredPane();
	        layeredPane.setBounds(0, 0, 365, 590); // 컴포넌트의 위치, 크기를 꼭 설정해야함.
	        layeredPane.setLayout(null);
	        // 패널1
	        // 이미지 받아오기
	        JLabel imageLabel = new JLabel();
            ImageIcon ii = new ImageIcon(this.getClass().getResource(
                    "tenor.gif"));
            imageLabel.setIcon(ii);
            imageLabel.setBounds(70, 20, 200, 200);
            layeredPane.add(imageLabel);
	        try {
	            img = ImageIO.read(new File("login/2.jpg"));//배경 이미지
	        } catch (IOException e) {
	            System.out.println("이미지 불러오기 실패");
	            System.exit(0);
	        }
	        MyPanel p1 = new MyPanel();
	        p1.setBounds(0, 0, 365, 590);
	        // id
	        idField = new Hint("아이디");
	        idField.setBounds(65, 240, 238, 35);//id 위치 설정, id창 크기 설정
	        idField.setOpaque(true);//id창 투명
	        //idField.setBorder(javax.swing.BorderFactory.createEmptyBorder());  //ID 테두리
	        layeredPane.add(idField);
	        // 비밀번호
	        pwField = new JPasswordField(15);
	        pwField.setBounds(65, 275, 238, 35);//비밀번호 위치 설정, 비밀번호 크기 설정
	        pwField.setOpaque(true);//비밀번호 창 투명
	        pwField.setForeground(Color.BLACK);
	        //pwField.setBorder(javax.swing.BorderFactory.createEmptyBorder()); //비밀번호 테두리
	        layeredPane.add(pwField);
	        pl1 = new PlaceHolder(pwField, "password");//password placeholder
	        //id 저장
	        cb = new JCheckBox("아이디저장");
	        cb.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
	        cb.setForeground(Color.GRAY);
	        cb.setBounds(62, 356, 85, 20);
	        cb.setOpaque(false);
	        cb.setCursor(new Cursor(Cursor.HAND_CURSOR));//손모양 커서
	        
			setBtn();
	        logBtn.addActionListener(this);
	        exitBtn.addActionListener(this);
	        signupBtn.addActionListener(this);
	        idSearchBtn.addActionListener(this);
	        pwSearchBtn.addActionListener(this);
	        idField.addActionListener(this);
	        pwField.addActionListener(this);
	        layeredPane.add(p1);
	    	add(msgl);
	        add(label1);
	        add(label2);
	        add(cb);
	        add(layeredPane);
			setResizable(true);//창 크기 고정
	        setLocationRelativeTo(null);//화면 중앙배치
	        setVisible(true);
			validate();
			//드래그 화면 이동
			p1.addMouseListener(new MouseAdapter() {
		    	public void mousePressed(MouseEvent e) {
		    		p1.mouseClickedLocation.x = e.getX();
		    		p1.mouseClickedLocation.y = e.getY();
		    	}
			});
			p1.addMouseMotionListener(new MouseMotionAdapter() {
			    public void mouseDragged(MouseEvent e) {
			        Login.this.setLocation(e.getLocationOnScreen().x - p1.mouseClickedLocation.x,
			                e.getLocationOnScreen().y - p1.mouseClickedLocation.y);
			    }
			});	
			TrayIconHandler.registerTrayIcon(
					Toolkit.getDefaultToolkit().getImage("diary/icon.png"),
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
			TrayIconHandler.addItem("      로그인                        ","맑은 고딕", Font.PLAIN, 12,  new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
						setVisible(true);
				}
			});
				TrayIconHandler.addItem("      종료                        ","맑은 고딕", Font.PLAIN, 12 , new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						System.exit(0);
					}
				});
	    }
	    
public void setBtn() {
	// 로그인버튼 추가
	ImageIcon img = new ImageIcon("login/로그인 버튼 비활성화.png");
	ImageIcon img2 = new ImageIcon("login/로그인 버튼 활성화.png");
	logBtn = new JButton(img);
	add(logBtn);
	logBtn.setBounds(65, 312, 238, 45);
	logBtn.setRolloverIcon(img2); // 버튼에 마우스가 올라갈떄 이미지 변환
	logBtn.setBorderPainted(false); // 버튼 테두리 설정해제
	logBtn.setPreferredSize(new Dimension(230, 30)); // 버튼 크기 지정
	logBtn.setBorderPainted(false);
	logBtn.setOpaque(false);
	logBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
	// 로그인 버튼 투명처리
	logBtn.setBorderPainted(false);// 로그인 버튼 테두리
	logBtn.setFocusPainted(false);
	logBtn.setContentAreaFilled(false);// 버튼 배경
    //id 찾기 버튼
    idSearchBtn= new JButton("아이디 찾기");
    idSearchBtn.setFont(new Font("맑은 고딕", Font.PLAIN, 11));
    idSearchBtn.setForeground(Color.GRAY);
    idSearchBtn.setBorderPainted(false);
    idSearchBtn.setContentAreaFilled(false);
    idSearchBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));//손모양 커서
    idSearchBtn.setBounds(35, 530, 93, 28);
	label1 = new JLabel("|");
    label1.setFont(new Font("맑은 고딕", Font.PLAIN, 10));
    label1.setForeground(Color.GRAY);
	label1.setBounds(130, 530, 2, 28);
    //비밀번호 찾기 버튼
	pwSearchBtn = new JButton("비밀번호 찾기");
	pwSearchBtn.setFont(new Font("맑은 고딕", Font.PLAIN, 11));
	pwSearchBtn.setForeground(Color.GRAY);
	pwSearchBtn.setBorderPainted(false);
	pwSearchBtn.setContentAreaFilled(false);
	pwSearchBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));//손모양 커서
	pwSearchBtn.setBounds(137, 530, 105, 28);
	label2 = new JLabel("|");
    label2.setFont(new Font("맑은 고딕", Font.PLAIN, 10));
    label2.setForeground(Color.GRAY);
	label2.setBounds(245, 530, 2, 28);
    //회원가입 버튼
	signupBtn = new JButton("회원가입");
	signupBtn.setFont(new Font("맑은 고딕", Font.PLAIN, 11));
	signupBtn.setForeground(Color.GRAY);
	signupBtn.setBorderPainted(false);
	signupBtn.setContentAreaFilled(false);
	signupBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));//손모양 커서
	signupBtn.setBounds(250, 530, 78, 28);
    //창 닫기 버튼
    exitBtn= new JButton("x");
    exitBtn.setToolTipText("닫기");//마수으 버튼을 대면 닫기 말풍선(ToolTip)
    exitBtn.setFont(new Font("맑은 고딕", Font.BOLD, 18));
    exitBtn.setForeground(Color.GRAY);
    exitBtn.setBorderPainted(false);
    exitBtn.setContentAreaFilled(false);
    exitBtn.setBounds(320, 7, 50, 15);
    exitBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
    
    layeredPane.add(logBtn);
    layeredPane.add(idSearchBtn);
    layeredPane.add(pwSearchBtn);
    layeredPane.add(signupBtn);
    layeredPane.add(exitBtn);
}
public void fr() {
	//회원 가입창을 로그인창 중앙에 오게 설정
	int width = 430;
	int height = 490;
	int px = getX();
	int py = getY();
	int x = px+getWidth()/2-width/2;
	int y = py+getHeight()/2-height/2;
	join.setBounds(x, y, width, height);
}
	    class MyPanel extends JPanel {
	        Point mouseClickedLocation = new Point(0, 0);
	        public void paint(Graphics g) {
	            g.drawImage(img, 0, 0, this);
	        }
	    }
	    @Override
	    public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
			String id = idField.getText();
			String pwd = pwField.getText();
				/* 엔터키, 로그인버튼 로그인*/
			if(obj==logBtn) {
			if(mgr.loginMember(id, pwd)) {
					if(mFrame==null) {
							System.out.println("성공");
    						dispose();
	    					mFrame = new MFrame(id);
	    					mFrame.setVisible(true);
						}else {
							mFrame.setVisible(true);
						}
					}else 
						msgl.setText("계정 또는 비밀번호를 다시 확인해 주세요.");
						msgl.setForeground(Color.RED);
				}else if(obj==exitBtn/*닫기*/) {
					System.exit(0);
	    		}else if(obj==signupBtn/*회원가입*/) {
	    			if(join==null) {
					//회원가입 프레임 불러옴
					join = new JoinFrame();
					fr();
	    			}else {
	    				join.setVisible(true);
	    			}
	    		}else if(obj==idSearchBtn/*아이디 찾기*/) {
	    			if(ids==null) {
					//회원가입 프레임 불러옴
	    			ids = new IdFrame();
	    			}else {
	    			ids.setVisible(true);
	    			}
	    		}else if(obj==pwSearchBtn/*비밀번호 찾기*/) {
	    			if(pwds==null) {
	    				pwds = new PwFrame();
	    			}else {
	    				pwds.setVisible(true);
	    			}
	    		}
	    }
	    /*아이디 찾기 프레임*/
	    private class IdFrame extends JFrame {
	    	private JPanel contentPane;
	    	private JLabel lbJoin, lblName, lblUsername, fine;
	    	private JButton joinBtn;
	    	private JTextField MB_Id;
	    	private JTextField MB_Name;
	    	private JTextField Email;
	    	private JPasswordField Pwd,PwdC;
	    	MemberMgr mgr;
	    	List mlist;
	    	public IdFrame() {
	    		mgr = new MemberMgr();
	    				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    		setSize(450, 400);
	    		setLocationRelativeTo(null);
	    		contentPane = new JPanel();
	    		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	    		setContentPane(contentPane);
	    		contentPane.setLayout(null);
	    		contentPane.setBackground(new Color(238,236,255));
	
	    		lbJoin = new JLabel("아이디 찾기");
	    		Font f1 = new Font("맑은 고딕", Font.BOLD, 20); 
	    		lbJoin.setFont(f1); 
	    		lbJoin.setBounds(159, 41, 120, 30);

	    		lblName = new JLabel("이름");
	    		lblName.setBounds(69, 113, 69, 20);
	    		contentPane.add(lbJoin);
	    		contentPane.add(lblName);
	    		
	    		lblUsername = new JLabel("이메일");
	    		lblUsername.setBounds(69, 163, 69, 20);
	    		contentPane.add(lblUsername);
	    		
	    		fine = new JLabel();
	    		fine.setBounds(150, 260, 200, 30);
	    		contentPane.add(fine);
	    				
	    		Font f2 = new Font("맑은 고딕", Font.BOLD, 12); 
	    		lblName.setFont(f2); 
	    		lblUsername.setFont(f2); 
	    		fine.setFont(f2);
	    		
	    		MB_Name = new JTextField();
	    		MB_Name.setColumns(10);
	    		MB_Name.setBounds(159, 113, 186, 35);
	    		contentPane.add(MB_Name);
	    		
	    		Email = new JTextField();
	    		Email.setColumns(10);
	    		Email.setBounds(159, 163, 186, 35);
	    		contentPane.add(Email);
	    		
	    		joinBtn = new JButton("아이디 찾기");
	    		joinBtn.setBounds(205, 210, 139, 29);
	    		contentPane.add(joinBtn);
	    		
	    		setVisible(true);
	    		//아이디 찾기
	    		joinBtn.addActionListener(new ActionListener() {
	    			@Override
	    			public void actionPerformed(ActionEvent e) {
	    			 String name = MB_Name.getText();
	    			 String email = Email.getText();
	    			 String MB_ID = mgr.fineMember(name, email);
	    			 if(MB_ID!=null) {
	    				 fine.setText("찾으시는 아이디는 '" + MB_ID + "' 입니다.");
	    			 }else {
	    				 fine.setText("해당 정보가 없습니다.");
	    			 }
	    		  }
	    	});
	    }
	}
	    /*비밀번호 찾기 프레임*/
	    private class PwFrame extends JFrame {
	    	private JPanel contentPane;
	    	private JLabel lbJoin, lblName, lblUsername, lblemail, fine;
	    	private JButton joinBtn;
	    	private JTextField MB_Id, MB_Name, Email;
	    	MemberMgr mgr;
	    	
	    	public PwFrame() {
	    		mgr = new MemberMgr();
	    		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    		setSize(420, 420);
	    		setLocationRelativeTo(null);
	    		contentPane = new JPanel();
	    		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	    		setContentPane(contentPane);
	    		contentPane.setLayout(null);
	    		contentPane.setBackground(new Color(254,215,216));
	    		
	    		lbJoin = new JLabel("비밀번호 찾기");
	    		Font f1 = new Font("맑은 고딕", Font.BOLD, 20); 
	    		lbJoin.setFont(f1); 
	    		lbJoin.setBounds(135, 41, 150, 20);
	    		contentPane.add(lbJoin);  		
	    		
	    		lblName = new JLabel("이름");
	    		lblName.setBounds(69, 113, 69, 20);
	    		contentPane.add(lblName);
	    		lblUsername = new JLabel("아이디");
	    		lblUsername.setBounds(69, 163, 69, 20);
	    		contentPane.add(lblUsername);
	    		lblemail = new JLabel("이메일");
	    		lblemail.setBounds(69, 210, 69, 20);
	    		contentPane.add(lblemail);
	    		fine = new JLabel();
	    		fine.setBounds(100, 300, 250, 50);
	    		contentPane.add(fine);
	    		
	    		Font f2 = new Font("맑은 고딕", Font.BOLD, 12); 
	    		lblName.setFont(f2); 
	    		lblUsername.setFont(f2); 
	    		lblemail.setFont(f2); 
	    		fine.setFont(f2);

	    		MB_Name = new JTextField();
	    		MB_Name.setColumns(10);
	    		MB_Name.setBounds(159, 113, 186, 35);
	    		contentPane.add(MB_Name);
	    		
	    		MB_Id = new JTextField();
	    		MB_Id.setColumns(10);
	    		MB_Id.setBounds(159, 163, 186, 35);
	    		contentPane.add(MB_Id);
	    		
	    		Email = new JTextField();
	    		Email.setColumns(10);
	    		Email.setBounds(159, 210, 186, 35);
	    		contentPane.add(Email);
	    		
	    		joinBtn = new JButton("비밀번호찾기");
	    		joinBtn.setBounds(205, 265, 139, 29);
	    		contentPane.add(joinBtn);
	    		setVisible(true);
	    		//비밀번호찾기
	    		joinBtn.addActionListener(new ActionListener() {
	    			@Override
	    			public void actionPerformed(ActionEvent e) {
	    				 String name = MB_Name.getText();
	    				 String mb_id = MB_Id.getText();
	    				 String email = Email.getText();
	    				 String pwd = mgr.pwdmember(name, mb_id, email);
	    				 if(pwd!=null) {
	    					 fine.setText("찾으시는 비밀번호는 '" + pwd + "'\n 입니다.");
	    				 }else {
	    					 fine.setText("해당 정보가 없습니다.");
	    				 }
	    			}
	    		});
	    	}
	    }
	    /*회원가입 프레임*/
	    private class JoinFrame extends JFrame implements ActionListener{
	    	private JPanel contentPane;
	    	private JLabel lbJoin;
	    	private JButton joinBtn;
	    	private JTextField MB_Id;
	    	private JTextField MB_Name;
	    	private JTextField Email;
	    	private JPasswordField Pwd,PwdC;
	    	private JLabel lblName,lblUsername,lblpw,lblpwConfirm,lblEmail; 
	    	Font f1,f2;
	    	MemberBean bean;
	    	MemberMgr mgr;
	    	List list;
	    	
	    	public JoinFrame() {
	    		mgr = new MemberMgr();
	    		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    		setSize(430, 490);
	    		setLocationRelativeTo(null);
	    		contentPane = new JPanel();
	    		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	    		setContentPane(contentPane);
	    		contentPane.setBackground(new Color(93,118,149));
	    		contentPane.setLayout(null);
	    		
	    		lbJoin = new JLabel("회원가입");
	    		f1 = new Font("맑은 고딕", Font.BOLD, 20); 
	    		lbJoin.setFont(f1); 
	    		lbJoin.setBounds(159, 41, 101, 20);
	    		contentPane.add(lbJoin);
	    		
	    		lblName = new JLabel("이름");
	    		lblName.setBounds(69, 113, 69, 20);
	    		contentPane.add(lblName);
	    		lblUsername = new JLabel("아이디");
	    		lblUsername.setBounds(69, 163, 69, 20);
	    		contentPane.add(lblUsername);
	    		lblpw = new JLabel("비밀번호");
	    		lblpw.setBounds(69, 210, 69, 20);
	    		contentPane.add(lblpw);
	    		lblpwConfirm = new JLabel("비밀번호 확인");
	    		lblpwConfirm.setBounds(69, 257, 80, 20);
	    		contentPane.add(lblpwConfirm);
	    		lblEmail = new JLabel("이메일");
	    		lblEmail.setBounds(69, 304, 69, 20);
	    		contentPane.add(lblEmail);
	    		
	    		f2 = new Font("맑은 고딕", Font.BOLD, 12); 
	    		lblName.setFont(f2); 
	    		lblUsername.setFont(f2); 
	    		lblpw.setFont(f2); 
	    		lblpwConfirm.setFont(f2); 
	    		lblEmail.setFont(f2); 
	    		MB_Name = new JTextField();
	    		MB_Name.setColumns(10);
	    		MB_Name.setBounds(159, 113, 186, 35);
	    		contentPane.add(MB_Name);
	    		
	    		MB_Id = new JTextField();
	    		MB_Id.setColumns(10);
	    		MB_Id.setBounds(159, 163, 186, 35);
	    		contentPane.add(MB_Id);
	    		
	    		Pwd = new JPasswordField();
	    		Pwd.setColumns(10);
	    		Pwd.setBounds(159, 210, 186, 35);
	    		contentPane.add(Pwd);
	    		
	    		PwdC = new JPasswordField();
	    		PwdC.setColumns(10);
	    		PwdC.setBounds(159, 257, 186, 35);
	    		contentPane.add(PwdC);
	    		Email = new JTextField();
	    		Email.setColumns(10);
	    		Email.setBounds(159, 304, 186, 35);
	    		contentPane.add(Email);
	    		
	    		joinBtn = new JButton("회원가입완료");
	    		joinBtn.setBounds(206, 363, 139, 29);
	    		contentPane.add(joinBtn);
	    		
	    		joinBtn.addActionListener(this);
	    		setVisible(true);
	    		//회원가입완료 액션
	    		}
	    	@Override
	    	public void actionPerformed(ActionEvent e) {
	    		if(Pwd.getText().equals(PwdC.getText()))/*비밀번호 동일한지 확인*/ {
	    			bean = new MemberBean();
	    			bean.setMB_Id(MB_Id.getText());
	    			bean.setMB_Name(MB_Name.getText());
	    			bean.setPwd(Pwd.getText());
	    			bean.setEmail(Email.getText());
	    			if(mgr.insertMember(bean)) {
	    				JOptionPane.showMessageDialog(null, "회원가입이 완료되었습니다.");
	    				dispose();
	    			}/*비밀번호가 다르면 로그인 실패*/
	    		}else JOptionPane.showMessageDialog(null, "비밀번호를 다시 확인해주세요.");
	    	}
	   }
}


