package diary;

import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SpinnerDateModel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Memo extends JPanel implements ActionListener, ItemListener {
	String[] items = { "Note", "To do" };
	JTextPane tp;
	JScrollPane taSp;
	JComboBox<String> cb;

	JLabel lb;
	JTextField tf1, tf2;
	JSpinner spi;
	JPanel p;
	JButton btn1, btn2, btn3, btn4; // 1 : 파일열기, 2 : 저장 , 3 : 할일 추가하기
	JFileChooser fc;
	JCheckBox cbx1;
	JScrollPane scrollpane;
	ImageIcon xyimg;
	JPanel p1;
	Vector<JCheckBox> vcb;
	Vector<JTextField> vtf;
	MFrame mFrame;
	String filename;
	int y;
	public Memo() {
		vcb = new Vector<JCheckBox>();
		vtf = new Vector<JTextField>();
		setLayout(null);
		createTodo();
		createNote();
		setNote();
		btn3.addActionListener(this);
		btn4.addActionListener(this);
	}

	public class Hint extends JTextField {
		Font gainFont = new Font("맑은 고딕", Font.PLAIN, 25);
		Font lostFont = new Font("맑은 고딕", Font.ITALIC, 25);

		public Hint(final String hint) {
			setText(hint);
			setFont(lostFont);
			setForeground(Color.WHITE);

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
					if (getText().equals(hint) || getText().length() == 0) {
						setText(hint);
						setFont(lostFont);
						setForeground(Color.WHITE);
					} else {
						setText(getText());
						setFont(gainFont);
						setForeground(Color.BLACK);
					}
				}
			});
		}
	}

	public void createNote() {
		removeAll();
		setBackground(new Color(254, 207, 88));
		tp = new JTextPane();
		tp.setBounds(12, 100, 530, 620);
		tp.setFont(new Font("맑은 고딕", Font.PLAIN, 23));
		scrollpane = new JScrollPane(tp, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollpane.setBounds(10, 100, 550, 620);

		cb = new JComboBox<String>(items);
		cb.setBounds(450, 40, 70, 30);
		cb.setPreferredSize(new Dimension(12, 42));
		lb = new JLabel("Today is");
		lb.setBounds(40, 6, 200, 100);
		lb.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		tf1 = new Hint("제목을 쓰세요");
		tf1.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if (tf1.getText().length() >= 20) { // 20자 제한
					e.consume();
				}
			}
		});
		tf1.setBounds(150, 30, 270, 50);
		tf1.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		tf1.setBackground(null);
		tf1.setBorder(null);
		cb.addItemListener(this); // 할일로 전환 하는 아이템리스너

		btn1 = new JButton("파일 열기");
		btn1.setBounds(300, 745, 125, 30);
		btn1.setFont(new Font("맑은 고딕", Font.BOLD, 18));

		btn2 = new JButton("저장");
		btn2.setBounds(450, 745, 80, 30);
		btn2.setFont(new Font("맑은 고딕", Font.BOLD, 18));

		fc = new JFileChooser();
		FileNameExtensionFilter picture = new FileNameExtensionFilter("JPEG files (*.png)", "png");
		fc.setFileFilter(picture);
		fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		btn1.addActionListener(this);
		btn2.addActionListener(this);
	}

	ImageIcon imageSetSize(ImageIcon icon, int i, int j) {
		Image ximg = icon.getImage();
		Image yimg = ximg.getScaledInstance(i, j, java.awt.Image.SCALE_SMOOTH);
		xyimg = new ImageIcon(yimg);
		return xyimg;
	}

	public void setNote() {
		setBackground(new Color(254, 207, 88));
		removeAll();
		add(lb);
		add(tf1);
		add(scrollpane);
		add(cb);
		add(btn1);
		add(btn2);
	}

	public void createTodo() {
		cb = new JComboBox<String>(items);
		cb.setBounds(450, 40, 70, 30);
		cb.setPreferredSize(new Dimension(12, 42));
		cb.addItemListener(this);

		Calendar c = Calendar.getInstance();
		Date value = c.getTime(); // 현재날짜
		c.add(Calendar.YEAR, -50);
		Date start = c.getTime();
		c.add(Calendar.YEAR, 100);
		Date end = c.getTime();
		SpinnerDateModel date = new SpinnerDateModel(value, start, end, Calendar.YEAR);
		spi = new JSpinner(date);
		spi.setEditor(new JSpinner.DateEditor(spi, "yyyy-MM-dd"));
		spi.setBounds(50, 40, 145, 30);
		spi.setFont(new Font("맑은 고딕", Font.BOLD, 20));

		btn3 = new JButton("할 일 추가하기");
		btn3.setBounds(220, 40, 200, 30);
		btn3.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		btn4 = new JButton("삭제");
		btn4.setBounds(50, 90, 145, 30);
		btn4.setFont(new Font("맑은 고딕", Font.BOLD, 22));
	}

	public void setTodo() {
		removeAll();
		setBackground(new Color(30, 112, 163));
		setLayout(null);
		add(btn3);
		add(btn4);
		add(spi);
		add(cb);
		for (int i = 0; i < vcb.size(); i++) {
			y = (i+1)*50 + 100;
			JCheckBox cb =  vcb.elementAt(i);
			JTextField tf =  vtf.elementAt(i);
			cb.setBounds(50, y, 30, 30);
			tf.setBounds(100, y, 500, 30);
			add(cb);
			add(tf);
		}
	}
	
	public void itemStateChanged(ItemEvent e) {
		int index = cb.getSelectedIndex();
		if (e.getStateChange() == ItemEvent.SELECTED) {
			if (index == 0) {
				setNote();
			} else if (index == 1) {
				setTodo();
			}
		}
		repaint();
		validate();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn1) {
			int val = fc.showOpenDialog(this);
			if (val == JFileChooser.APPROVE_OPTION) {
				// 열기
				filename = fc.getSelectedFile().getAbsolutePath();
				try {
					BufferedImage img = ImageIO.read(new File(filename));
					ImageIcon pictureImage = new ImageIcon(img);
					imageSetSize(pictureImage, 500, 300);
					tp.insertIcon(xyimg);
				} catch (IOException e2) {
					System.out.println("실패");
				}
			} else {
				// 취소
			}
		} else if (e.getSource() == btn2) {
			int val = fc.showSaveDialog(this);
			if (val == JFileChooser.APPROVE_OPTION) {
				String content = tp.getText();								//저장
				File file = fc.getSelectedFile();
				try {
					FileWriter fw = new FileWriter(file.getPath()+".txt");
					fw.write(filename);
					fw.write(content);
					fw.flush();
					fw.close();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		} else if (e.getSource() == btn3) {
			vcb.addElement(cbx1 = new JCheckBox("", false));
			vtf.addElement(tf2 = new Hint("할 일을 입력하세요"));
			add(cbx1);
			add(tf2);
			tf2.setFont(new Font("맑은 고딕", Font.BOLD, 25));
			y = 150;
			y = vcb.size()*50 + 100;
			cbx1.setBounds(50, y, 30, 30);
			tf2.setBounds(100, y, 500, 30);
			cbx1.setBorder(null);
			cbx1.setBackground(null);
			tf2.setBorder(null);
			tf2.setBackground(null);
			//System.out.println(vcb.size());
			//System.out.println(y);
		} else if (e.getSource() == btn4) {
			for (int i = 0; i <  vcb.size(); i++) {
				JCheckBox cb = vcb.elementAt(i);
				JTextField tf = vtf.elementAt(i);
				if(cb.isSelected()) {
					vcb.remove(cb);
					vtf.remove(tf);
					remove(cb);
					remove(tf);
					i--;
					cb.setBounds(50, y, 30, 30);
					tf.setBounds(100, y, 500, 30);
					System.out.println(y);
					System.out.println(vcb.size());
				}
			}
			for (int i = 0; i < vcb.size(); i++) {
				JCheckBox cb =  vcb.elementAt(i);
				JTextField tf =  vtf.elementAt(i);
				remove(cb);
				remove(tf);
				y = (i+1)*50 + 100;
				cb.setBounds(50, y, 30, 30);
				tf.setBounds(100, y, 500, 30);
				add(cb);
				add(tf);
			}
		}
		validate();
		repaint();
	}
}



