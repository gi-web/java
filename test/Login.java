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
    BufferedImage img = null;//����(�޸�)�� �̹����� �ø� �� ����
    JTextField idTextField;
    JPasswordField passwordField;
    JButton btn1,btn2,btn3,btn4,btn5;
    JCheckBox cb;

	public static void main(String[] args) {
		new Login();
	}
    // ������
	    public Login() {
	    	setUndecorated(true);//Ÿ��Ʋ�� ����
	        setTitle("�α���");
	        setSize(365, 590);
			setLayout(new BorderLayout());
	        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//�α��ν� â ����
	        //setDefaultCloseOperation(HIDE_ON_CLOSE); //ȭ�鿡�� ����(����� ���°� �ƴ�)

	        
    // ���̾ƿ� ����
	        setLayout(null); // ��ġ �����ڸ� null�� ������ ���
	        JLayeredPane layeredPane = new JLayeredPane();
	        layeredPane.setBounds(0, 0, 365, 590); // ������Ʈ�� ��ġ, ũ�⸦ �� �����ؾ���.
	        layeredPane.setLayout(null);

	        
	        // �г�1
	        // �̹��� �޾ƿ���
	        try {
	            img = ImageIO.read(new File("test/2.jpg"));//��� �̹���
	        } catch (IOException e) {
	            System.out.println("�̹��� �ҷ����� ����");
	            System.exit(0);
	        }
	        
	        MyPanel p1 = new MyPanel();
	        p1.setBounds(0, 0, 365, 590);
	        
	        
	        // id
	        idTextField = new JTextField(10);
	        idTextField.setBounds(65, 240, 238, 35);//id ��ġ ����, idâ ũ�� ����
	        idTextField.setOpaque(true);//idâ ����
	        idTextField.setForeground(Color.BLACK);
	        //loginTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());  ID �׵θ�
	        layeredPane.add(idTextField);
	        

	        pl1 = new PlaceHolder(idTextField, "ID");//ID placeholder
	        
	        
	        // ��й�ȣ
	        passwordField = new JPasswordField(15);
	        passwordField.setBounds(65, 274, 238, 35);//��й�ȣ ��ġ ����, ��й�ȣ ũ�� ����
	        passwordField.setOpaque(true);//��й�ȣ â ����
	        passwordField.setForeground(Color.BLACK);
	       //passwordField.setBorder(javax.swing.BorderFactory.createEmptyBorder()); ��й�ȣ �׵θ�
	        layeredPane.add(passwordField);
	        
	        pl1 = new PlaceHolder(passwordField, "password");//password placeholder
	        
	        
	        
	        
	        // �α��ι�ư �߰�

	        btn1 = new JButton(new ImageIcon("img/�α��� ��ư Ȱ��ȭ.png"));
	        btn1.setBounds(65, 312, 238, 45);//��ư ��ġ,��ư ũ�� ����
            btn1.setEnabled(true);
            
	        btn1.setCursor(new Cursor(Cursor.HAND_CURSOR));
	        
	        // ��ư ����ó��
	        btn1.setBorderPainted(false);//�α��� ��ư �׵θ�
	        btn1.setFocusPainted(false);
	        btn1.setContentAreaFilled(false);//��ư ���
	        
	        //id ����
	        cb = new JCheckBox("���̵�����");
	        cb.setFont(new Font("���� ���", Font.PLAIN, 12));
	        cb.setForeground(Color.GRAY);
	        cb.setBounds(62, 356, 85, 20);
	        cb.setOpaque(false);
	        cb.setCursor(new Cursor(Cursor.HAND_CURSOR));//�ո�� Ŀ��
	        
	        
	        //id ã��
	        btn2= new JButton("���̵� ã��");
	        btn2.setFont(new Font("���� ���", Font.PLAIN, 11));
	        btn2.setForeground(Color.GRAY);
	        btn2.setBorderPainted(false);
	        btn2.setContentAreaFilled(false);
        	btn2.setCursor(new Cursor(Cursor.HAND_CURSOR));//�ո�� Ŀ��
	        btn2.setBounds(35, 530, 93, 28);
	        
			JLabel label1 = new JLabel("|");
	        label1.setFont(new Font("���� ���", Font.PLAIN, 10));
	        label1.setForeground(Color.GRAY);
			label1.setBounds(130, 530, 2, 28);
	        //��й�ȣ ã��
			btn3 = new JButton("��й�ȣ ã��");
	        btn3.setFont(new Font("���� ���", Font.PLAIN, 11));
	        btn3.setForeground(Color.GRAY);
	        btn3.setBorderPainted(false);
	        btn3.setContentAreaFilled(false);
        	btn3.setCursor(new Cursor(Cursor.HAND_CURSOR));//�ո�� Ŀ��
	        btn3.setBounds(137, 530, 105, 28);
	        
			JLabel label2 = new JLabel("|");
	        label2.setFont(new Font("���� ���", Font.PLAIN, 10));
	        label2.setForeground(Color.GRAY);
			label2.setBounds(245, 530, 2, 28);
	        //ȸ������
	        btn4 = new JButton("ȸ������");
	        btn4.setFont(new Font("���� ���", Font.PLAIN, 11));
	        btn4.setForeground(Color.GRAY);
	        btn4.setBorderPainted(false);
	        btn4.setContentAreaFilled(false);
        	btn4.setCursor(new Cursor(Cursor.HAND_CURSOR));//�ո�� Ŀ��
	        btn4.setBounds(250, 530, 78, 28);

	        //â �ݱ� ��ư
	        btn5= new JButton("x");
	        btn5.setToolTipText("�ݱ�");//������ ��ư�� ��� �ݱ� ��ǳ��(ToolTip)
	        btn5.setFont(new Font("���� ���", Font.BOLD, 18));
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
			setResizable(true);//â ũ�� ����
	        setLocationRelativeTo(null);//ȭ�� �߾ӹ�ġ
	        setVisible(true);
			validate();

			
			//�巡�� ȭ�� �̵�
			addMouseMotionListener(new MouseMotionAdapter() {
			    public void mouseDragged(MouseEvent e) {
			      super.mouseDragged(e);
			      int x = e.getX();
			      int y = e.getY();
			      setLocation(x, y); // ��ġ ����
			    }
			});
			
			//â �ݱ� ���
			btn5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (e.getSource() == btn5) // x ��ư
						System.exit(0);
				}
			});
	    }

	    //�α��� �׼� �߰�
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
