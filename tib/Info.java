package tib;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.List;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class Info extends JFrame implements ActionListener {

	JLabel lab1, lab2, lab3, lab4, lab5, lab6, lab7, lab8;
	ImageIcon busan, background, background2, bts, bts1, map, site1,site2,site3;
	JButton btn1, btfn, btna, btnb, btnmap, btnLogout, btnLogo;
	TextField fi, fi2, fi3, fi4, fi5, fi6, fi7, fi8, fi9,fi0;
	TextArea ta1, ta2, ta3, ta4, ta5, ta6;
	List list;
	String food[] = { "Â¥Àå¸é", "Â«»Í", "¿ìµ¿" };
	Button logoutBtn;
	Place place;
	Choose choose;
	Login login;
	TibMap tibMap;
	
	int UC_SEQ;
	URL url = null;
	TibMapMgr mgr = null;
	int position = 1; 
	Vector<TravelBean> vlist = null;
	TravelBean bean;
	WeatherBean wbean;
	RssReadMgr mgr1;
	Image skyImg, ptyImg;

	
	public Info(int UC_SEQ) {
		try {
			mgr = new TibMapMgr();
			mgr1 = new RssReadMgr();
			wbean = mgr1.getTownForecast(UC_SEQ);
			
			this.UC_SEQ = UC_SEQ;
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setLayout(null);
			setTitle("Travle in Busan");

			busan = new ImageIcon("tib/busanwhite157.png");
			JPanel panelLogo = new JPanel() {
				public void paintComponent(Graphics g) {
					super.paintComponent(g);
					g.drawImage(busan.getImage(), 0, 0, null);
					setOpaque(false);
				}
			};
			map = new ImageIcon("tib/map.png");
			JPanel panelMap = new JPanel() {
				public void paintComponent(Graphics g) {
					super.paintComponent(g);
					g.drawImage(busan.getImage(), 0, 0, null);
					setOpaque(false);
				}
			};
			background2 = new ImageIcon("tib/background2.png");
			JPanel panelBackground2 = new JPanel() {
				public void paintComponent(Graphics g) {
					super.paintComponent(g);
					g.drawImage(background2.getImage(), 0, 0, null);
					setOpaque(false);// ¾È¹è°æ

				}
			};
			background = new ImageIcon("tib/background1100.jpg");
			JPanel panelBackground = new JPanel() {
				public void paintComponent(Graphics g) {
					super.paintComponent(g);
					g.drawImage(background.getImage(), 0, 0, null);
					setOpaque(false);// ¹Ù±ù¹è°æ
				}
			};
///////////////////////////¿©±âÃß°¡//////////////////////////////////////////////////////////////////////////////

			bean = mgr.getTravel(UC_SEQ);

			url = new URL("https://www.visitbusan.net/" + bean.getMAIN_IMG_THUMB());

			site1 = new ImageIcon(url);
			JPanel panelSite1 = new JPanel() {
				public void paintComponent(Graphics g) {
					super.paintComponent(g);
					g.drawImage(site1.getImage(), 0, 0, null);
					setOpaque(false);// ¹Ù±ù¹è°æ
				}
			};
			panelSite1.setLayout(null);
			panelSite1.setBounds(220, 120, 417, 320);
			add(panelSite1);
			
//////////////////////////////////////////////////////////////////////////////////////////////////////////
			//¼Ò°³±ÛÀÌ ¾È³ª¿Â´Ù...
			
			panelBackground2.add(ta1 = new TextArea(bean.getITEMCNTNTS(), 5, 5, TextArea.SCROLLBARS_VERTICAL_ONLY));
			ta1.setBounds(40, 390, 1020, 330);
			
			
			
			///////// Áöµµ¹öÆ°
			panelBackground2.add(btnmap = new JButton(map));
			btnmap.setBounds(1010, 40, 45, 45);
			btnmap.setBackground(new Color(251, 246, 240));
			btnmap.addActionListener(this);

			panelBackground2.add(btna = new JButton("ÀÌÀü"));
			btna.setBounds(500, 750, 100, 30);
			btna.addActionListener(this);

			panelBackground2.add(fi0 = new TextField("264",15));
			fi0.setBounds(530, 40, 500, 30);
			
			panelBackground2.add(ta6 = new TextArea(fi0.getText()));
			ta6.setBounds(530, 70, 300, 200);
			
			
			panelLogo.setLayout(null);
			panelLogo.setBounds(180, 20, 180, 50);
			add(panelLogo);
			add(panelLogo);

			btnLogo = new JButton(busan);
			btnLogo.setBounds(180, 20, 180, 50);
			btnLogo.setBackground(new Color(0, 0, 0));
			panelBackground.add(btnLogo);
			btnLogo.addActionListener(this);

			btnLogout = new JButton("Logout");
			btnLogout.setBounds(1190, 30, 90, 30);
			btnLogout.setBackground(new Color(0, 0, 0));
			panelBackground.add(btnLogout);
			btnLogout.addActionListener(this);

			panelBackground2.setLayout(null);
			panelBackground2.setBounds(180, 80, 1100, 800);
			panelBackground2.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 5), "¡Ú"));
			panelBackground2.setBackground(new Color(0, 0, 0, 50));
			add(panelBackground2);

			panelBackground.setLayout(null);
			panelBackground.setBounds(0, 0, 1500, 1000);
			add(panelBackground);

			Font title = new Font("¸¼Àº°íµñ", Font.BOLD, 30);
			Font list = new Font("¸¼Àº°íµñ", Font.BOLD, 15);
			Font top = new Font("¸¼Àº°íµñ", Font.BOLD, 12);

			ta1.setFont(list);
			fi0.setForeground(Color.BLACK);
			btna.setBackground(Color.WHITE);
			btnLogout.setFont(top);
			btnLogout.setForeground(Color.WHITE);

			setSize(1500, 1000);
			setVisible(true);
			validate();
			
			setLocationRelativeTo(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object obj = e.getSource();
		if (btna == obj) {
			new MBack(this, "¾Ë¸²", "", true);
			this.setVisible(false);
			place = new Place();
			place.setVisible(true);
		} else if (btnmap == obj) {
			tibMap = new TibMap(UC_SEQ);
		} else if (btnLogout == obj) {
			this.setVisible(false);
			login = new Login();
			login.setVisible(true);
		}
		
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if(wbean!=null) {
			g.setColor(Color.WHITE);
			g.drawString("¿©ÇàÁ¤º¸ : " + wbean.getMAIN_TITLE(), 20, 100);
			g.drawString("ÇöÀç±â¿Â : " + wbean.getTemp(), 20, 120);
			g.drawString("ÇöÀç³¯¾¾ : " + wbean.getWfKor(), 20, 140);
			
			String sky = wbean.getSky();
			if (sky.equals("1")) {
                sky = "sunshine.png";
			} else if(sky.equals("2")) {
				sky = "sunny_cloudy1.png";
			}else if(sky.equals("3")) {
				sky = "sunny_cloudy2.png";
			}else if(sky.equals("4")) {
				sky = "over_cloudy.png";
			}
			
			//System.out.println(sky);
			skyImg = Toolkit.getDefaultToolkit().getImage("tib/"+sky);
			g.drawString("ÇÏ´Ã³¯¾¾ : ", 20, 180);
			g.drawImage(skyImg, 80, 160 ,this);
           
		
			String pty = wbean.getPty();
			if (pty.equals("0")) {
				pty = "no_rain.png";
			} else if(pty.equals("1")) {
				pty = "rain.png";
			}else if(pty.equals("2")) {
				pty = "rain_snow.png";
			}else if(pty.equals("3")) {
				pty = "snow.png";
			}
             
			//System.out.println(pty);
			ptyImg = Toolkit.getDefaultToolkit().getImage("tib/"+pty);
			g.drawString("°­¼ö»óÅÂ : ",120, 180);
			g.drawImage(ptyImg, 180, 160 ,this);
				
		}
	}

	class MBack extends JDialog implements ActionListener {

		int width = 200;
		int height = 145;
		JButton btnu;
		JLabel msg1L;
		Frame f;
		int xmsg;

		public MBack(Frame f, String title, String msg, boolean flag) {
			super(f, title, flag);
			this.f = f;
			xmsg = msg.length();

			setLayout(null);
			add(msg1L = new JLabel("µÚ·Î °¡°Ú½À´Ï±î?"));
			add(btnu = new JButton("yes"));

			msg1L.setBounds(40, 20, 150, 25);
			Font top = new Font("¸¼Àº°íµñ", Font.BOLD, 13);
			msg1L.setFont(new Font("¸¼Àº°íµñ", Font.BOLD, 13));
			btnu.setBackground(Color.WHITE);

			btnu.setBounds(60, 65, 60, 30);
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
}