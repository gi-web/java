package diary;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.table.DefaultTableModel;

public class Cash extends JPanel implements ActionListener {

	JTextField tf1, tf2, tf3, tf4, tf5;
	JLabel lb1, lb2, lb3, lb4, lb5;
	JButton btn1, btn2;
	JSpinner spi;
	String header[] = { "³¯Â¥", "¼öÀÔ", "ÁöÃâ", "³»¿ë" };
	private Object[][] contents;
	Calendar today = Calendar.getInstance();
	DefaultTableModel model;
	SimpleDateFormat sdf;
	String to;
	JTable table;
	public String id;
	//CashMgr mgr = new CashMgr();
	CashBean bean = new CashBean();
	String sumincome;
	String sumspending;


	public class Hint extends JTextField {

		Font gainFont = new Font("¸¼Àº °íµñ", Font.PLAIN, 25);
		Font lostFont = new Font("¸¼Àº °íµñ", Font.ITALIC, 25);

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
					if (getText().equals(hint) || getText().length() == 0) {
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

	public Cash(String id) {
		this.id = id;
		//sumincome = mgr.incomecash(id);
		//sumspending = mgr.spendingCash(id);
		setLayout(null);
		setBounds(0, 0, 600, 850);
		creatCash();
		cashTbl();
		setCash();
		btn1.addActionListener(this);
		btn2.addActionListener(this);
	}

	public void creatCash() {
		lb1 = new JLabel("¼öÀÔ :");
		lb1.setBounds(50, 35, 150, 100);
		lb1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 25));
		lb2 = new JLabel("ÁöÃâ :");
		lb2.setBounds(50, 90, 150, 100);
		lb2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 25));
		lb3 = new JLabel("³»¿ë :");
		lb3.setBounds(50, 140, 150, 100);
		lb3.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 25));
		
		lb4 = new JLabel("¼öÀÔ ÇÕ°è :");
		lb4.setBounds(50, 700, 150, 100);
		lb4.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		lb5 = new JLabel("ÁöÃâ ÇÕ°è :");
		lb5.setBounds(300, 700, 150, 100);
		lb5.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));		
				
		tf1 = new Hint("000"); // ¼öÀÔ ¼ýÀÚÄ­ ¼ýÀÚÀÔ·ÂÇÏ¸é ¾Ë¾Æ¼­ ÄÞ¸¶ Ãß°¡´Â ¾ÈµÇ´Â°Ç°­ 3,000¿ø Ã³·³;;
		tf1.setBounds(120, 62, 300, 50);
		tf1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 25));
		tf1.setBackground(null);
		tf1.setBorder(null);	

		tf2 = new Hint("000"); // ÁöÃâ ¼ýÀÚÄ­
		tf2.setBounds(120, 115, 300, 50);
		tf2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 25));
		tf2.setBackground(null);
		tf2.setBorder(null);

		tf3 = new Hint("³»¿ëÀ» ÀÔ·ÂÇÏ¼¼¿ä"); // ³»¿ë
		tf3.setBounds(120, 165, 300, 50);
		tf3.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 25));
		tf3.setBackground(null);
		tf3.setBorder(null);
		
		tf4 = new JTextField();
		tf4.setBounds(162, 730, 100, 40);
		tf4.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));

		tf5 = new JTextField();	
		tf5.setBounds(410, 730, 100, 40);
		tf5.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));

		btn1 = new JButton("ÀÔ·Â"); // ÀÔ·Â ¹öÆ°
		btn1.setBounds(50, 232, 85, 50);
		btn1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		btn2 = new JButton("»èÁ¦"); // »èÁ¦ ¹öÆ°
		btn2.setBounds(165, 232, 85, 50);
		btn2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));

		Calendar c = Calendar.getInstance();
		Date value = c.getTime(); // ÇöÀç³¯Â¥
		c.add(Calendar.YEAR, -50);
		Date start = c.getTime();
		c.add(Calendar.YEAR, 100);
		Date end = c.getTime();
		SpinnerDateModel date = new SpinnerDateModel(value, start, end, Calendar.YEAR);
		spi = new JSpinner(date);
		spi.setEditor(new JSpinner.DateEditor(spi, "yyyy/MM/dd"));
		spi.setBounds(50, 15, 160, 40);
		spi.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 22));

		tf1.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if (tf1.getText().length() >= 8) { // 8±ÛÀÚ¸¸ Çã¿ë
					e.consume();
				}
				char c = e.getKeyChar();
				if (!Character.isDigit(c)) { // ¼ýÀÚ¸¸ Çã¿ë
					e.consume();
					return;
				}
			}
		});
		tf2.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if (tf2.getText().length() >= 8) {
					e.consume();
				}
				char c = e.getKeyChar();
				if (!Character.isDigit(c)) {
					e.consume();
					return;
				}
			}
		});
		tf3.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if (tf3.getText().length() >= 20) {
					e.consume();
				}
			}
		});
	}

	public void setCash() {
		add(lb1);
		add(lb2);
		add(lb3);
		add(lb4);
		add(lb5);
		add(tf1);
		add(tf2);
		add(tf3);
		add(tf4);
		add(tf5);
		add(btn1);
		add(btn2);
		add(spi);
	}

public void cashTbl() {
		
		String[] row = new String[4];
		//Vector<CashBean> list = mgr.getListCash(id);

		//String[][] contents = new String[list.size()][4];

		int sumIncome = 0;
		int sumSpending = 0;

		/*
		 * for (int i = 0; i < list.size(); i++) { CashBean cashBean = (CashBean)
		 * list.get(i);
		 * 
		 * contents[i][0] = cashBean.getCs_date(); contents[i][1] =
		 * cashBean.getIncome(); contents[i][2] = cashBean.getSpending(); contents[i][3]
		 * = cashBean.getCs_contents();
		 * 
		 * }
		 */
		
		sdf = new SimpleDateFormat("yy/MM/dd");
		model = new DefaultTableModel(contents, header);
		table = new JTable(model);
		JScrollPane sp = new JScrollPane(table);

		tf4.setText(sumincome);
		tf5.setText(sumspending);
		//System.out.println(contents[list.size()][1]); //¼öÀÔÇÕ°è
		//System.out.println(contents[list.size()][2]); //ÁöÃâÇÕ°è

		sp.setLocation(15, 300);
		sp.setSize(550, 420);
		add(sp);
		

	}

//public static String getMoneyForm(String str) {
//    if (str == null)
//        return "";
//
//    int offset = str.indexOf(".");
//    String work_str = "";
//    String nonwork_str = "";
//
//    if (offset > 0) {
//        work_str = str.substring(0, offset);
//        nonwork_str = str.substring(offset, str.length());
//    }
//    else {
//        work_str = str;
//    }
//
//    DecimalFormat df = new DecimalFormat("###,##0");
//    double d = 0.0D;
//
//    try {
//        d = Double.valueOf(work_str).doubleValue();
//    }
//    catch (Exception e) {
//        d = 0.0D;
//    }
//    return df.format(d) + nonwork_str;
//}

	@Override
	public void actionPerformed(ActionEvent e) {
		String inputStr[] = new String[5];
		inputStr[0] = (String) sdf.format(spi.getValue());
		inputStr[1] = tf1.getText();// ¼öÀÔ
		inputStr[2] = tf2.getText();// ÁöÃâ
		inputStr[3] = tf3.getText();// ³»¿ë
		tf1.setText("");
		tf2.setText("");
		tf3.setText("");
		if (e.getSource() == btn1) {
			model.addRow(inputStr);
			bean.setMB_Id(id);
			bean.setIncome(inputStr[1]);
			bean.setSpending(inputStr[2]);
			bean.setCs_contents(inputStr[3]);
			bean.setCs_date(inputStr[0]);
			/*
			 * if (mgr.insertCash(bean)) {
			 * 
			 * }
			 */
		} else if (e.getSource() == btn2) {
			model.removeRow(table.getSelectedRow());
		}
	}

	public static void main(String[] args) {
	}
}
