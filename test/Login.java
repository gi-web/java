package test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.placeholder.PlaceHolder;

public class Login  extends JFrame implements ActionListener{
	

	PlaceHolder pl1;
    BufferedImage img = null;//버퍼(메모리)에 이미지를 올릴 때 쓰임
    JTextField idTextField;
    JPasswordField passwordField;
    JButton btn1,btn2,btn3,btn4,btn5;
    JCheckBox cb;

	public static void main(String[] args) {
		new Login();
	}
    // 생성자
	    public Login() {
	    	setUndecorated(true);//타이틀바 제거
	        setTitle("로그인");
	        setSize(365, 590);
			setLayout(new BorderLayout());
	        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//로그인시 창 닫음
	        //setDefaultCloseOperation(HIDE_ON_CLOSE); //화면에서 숨김(종료된 상태가 아님)

	        
    // 레이아웃 설정
	        setLayout(null); // 배치 관리자를 null로 설정할 경우
	        JLayeredPane layeredPane = new JLayeredPane();
	        layeredPane.setBounds(0, 0, 365, 590); // 컴포넌트의 위치, 크기를 꼭 설정해야함.
	        layeredPane.setLayout(null);

	        
	        // 패널1
	        // 이미지 받아오기
	        try {
	            img = ImageIO.read(new File("test/2.jpg"));//배경 이미지
	        } catch (IOException e) {
	            System.out.println("이미지 불러오기 실패");
	            System.exit(0);
	        }
	        
	        MyPanel p1 = new MyPanel();
	        p1.setBounds(0, 0, 365, 590);
	        
	        
	        // id
	        idTextField = new JTextField(10);
	        idTextField.setBounds(65, 240, 238, 35);//id 위치 설정, id창 크기 설정
	        idTextField.setOpaque(true);//id창 투명
	        idTextField.setForeground(Color.BLACK);
	        //loginTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());  ID 테두리
	        layeredPane.add(idTextField);
	        

	        pl1 = new PlaceHolder(idTextField, "ID");//ID placeholder
	        
	        
	        // 비밀번호
	        passwordField = new JPasswordField(15);
	        passwordField.setBounds(65, 274, 238, 35);//비밀번호 위치 설정, 비밀번호 크기 설정
	        passwordField.setOpaque(true);//비밀번호 창 투명
	        passwordField.setForeground(Color.BLACK);
	       //passwordField.setBorder(javax.swing.BorderFactory.createEmptyBorder()); 비밀번호 테두리
	        layeredPane.add(passwordField);
	        
	        pl1 = new PlaceHolder(passwordField, "password");//password placeholder
	        
	        
	        
	        
	        // 로그인버튼 추가

	        btn1 = new JButton(new ImageIcon("img/로그인 버튼 활성화.png"));
	        btn1.setBounds(65, 312, 238, 45);//버튼 위치,버튼 크기 설정
            btn1.setEnabled(true);
            
	        btn1.setCursor(new Cursor(Cursor.HAND_CURSOR));
	        
	        // 버튼 투명처리
	        btn1.setBorderPainted(false);//로그인 버튼 테두리
	        btn1.setFocusPainted(false);
	        btn1.setContentAreaFilled(false);//버튼 배경
	        
	        //id 저장
	        cb = new JCheckBox("아이디저장");
	        cb.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
	        cb.setForeground(Color.GRAY);
	        cb.setBounds(62, 356, 85, 20);
	        cb.setOpaque(false);
	        cb.setCursor(new Cursor(Cursor.HAND_CURSOR));//손모양 커서
	        
	        
	        //id 찾기
	        btn2= new JButton("아이디 찾기");
	        btn2.setFont(new Font("맑은 고딕", Font.PLAIN, 11));
	        btn2.setForeground(Color.GRAY);
	        btn2.setBorderPainted(false);
	        btn2.setContentAreaFilled(false);
        	btn2.setCursor(new Cursor(Cursor.HAND_CURSOR));//손모양 커서
	        btn2.setBounds(35, 530, 93, 28);
	        
			JLabel label1 = new JLabel("|");
	        label1.setFont(new Font("맑은 고딕", Font.PLAIN, 10));
	        label1.setForeground(Color.GRAY);
			label1.setBounds(130, 530, 2, 28);
	        //비밀번호 찾기
			btn3 = new JButton("비밀번호 찾기");
	        btn3.setFont(new Font("맑은 고딕", Font.PLAIN, 11));
	        btn3.setForeground(Color.GRAY);
	        btn3.setBorderPainted(false);
	        btn3.setContentAreaFilled(false);
        	btn3.setCursor(new Cursor(Cursor.HAND_CURSOR));//손모양 커서
	        btn3.setBounds(137, 530, 105, 28);
	        
			JLabel label2 = new JLabel("|");
	        label2.setFont(new Font("맑은 고딕", Font.PLAIN, 10));
	        label2.setForeground(Color.GRAY);
			label2.setBounds(245, 530, 2, 28);
	        //회원가입
	        btn4 = new JButton("회원가입");
	        btn4.setFont(new Font("맑은 고딕", Font.PLAIN, 11));
	        btn4.setForeground(Color.GRAY);
	        btn4.setBorderPainted(false);
	        btn4.setContentAreaFilled(false);
        	btn4.setCursor(new Cursor(Cursor.HAND_CURSOR));//손모양 커서
	        btn4.setBounds(250, 530, 78, 28);

	        //창 닫기 버튼
	        btn5= new JButton("x");
	        btn5.setToolTipText("닫기");//마수으 버튼을 대면 닫기 말풍선(ToolTip)
	        btn5.setFont(new Font("맑은 고딕", Font.BOLD, 18));
	        btn5.setForeground(Color.GRAY);
	        btn5.setBorderPainted(false);
	        btn5.setContentAreaFilled(false);
	        btn5.setBounds(320, 7, 50, 15);
        	btn5.setCursor(new Cursor(Cursor.HAND_CURSOR));
	        
        	
	        layeredPane.add(btn1);
	        layeredPane.add(btn2);
	        layeredPane.add(btn3);
	        layeredPane.add(btn4);
	        layeredPane.add(btn5);
	        layeredPane.add(p1);
	        add(label1);
	        add(label2);
	        add(cb);
	        add(layeredPane);
			setResizable(true);//창 크기 고정
	        setLocationRelativeTo(null);//화면 중앙배치
	        setVisible(true);
			validate();

			
			//드래그 화면 이동
			addMouseMotionListener(new MouseMotionAdapter() {
			    public void mouseDragged(MouseEvent e) {
			      super.mouseDragged(e);
			      int x = e.getX();
			      int y = e.getY();
			      setLocation(x, y); // 위치 조정
			    }
			});
			
			//창 닫기 기능
			btn5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (e.getSource() == btn5) // x 버튼
						System.exit(0);
				}
			});
	    }

	    //로그인 액션 추가
	    @Override
	    public void actionPerformed(ActionEvent e) {
        }

	    class MyPanel extends JPanel {
	    	

	    	@Override
	        public void paint(Graphics g) {
	        	super.paintComponents(g);
	        	super.paint(g);
	            g.drawImage(img, 0, 0, this);
	        }
	    }
}
