package diary;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class Cal extends JPanel implements ActionListener, Runnable {
	JButton todayBtn;
	JButton btnBefore, btnAfter;
	JButton btnDate;
	Font f;
	JLabel l[] = new JLabel[7];
	String days[] = { "��", "��", "ȭ", "��", "��", "��", "��" };
	Calendar today = Calendar.getInstance();
	Calendar now;
	Calendar cal = new GregorianCalendar();
	int year,month,date,calDayOfMon,calLastDate;;
	Date dt;
	JLabel time;
	JPanel p1;
	JPanel centerPane = new JPanel(new BorderLayout());
	JPanel datePane = new JPanel(new GridLayout(0, 7));
	plan plan;
	
	public Cal() {
		setToday();
		setDate();
		date();
		dateP();
		setLayout(null);
		setBounds(0, 0, 600, 850); // ��ġ,������
		
		time = new JLabel();
		Font fontLabel = new Font("���� ���", Font.PLAIN, 30);
		time.setFont(fontLabel);
		time.setBounds(20, 15, 300, 45);
		add(btnBefore = new JButton("��"));
		add(btnAfter = new JButton("��"));
		f = new Font("Serfi", Font.BOLD, 50);
		btnBefore.setFont(f);
		btnAfter.setFont(f);
		btnBefore.setBorderPainted(false);
		btnBefore.setContentAreaFilled(false);
		btnAfter.setBorderPainted(false);
		btnAfter.setContentAreaFilled(false);
		btnBefore.setBounds(405, 120, 100, 45);
		btnAfter.setBounds(485, 120, 100, 45);
		p1 = new JPanel();
		p1.setLayout(new GridLayout(1, 1));
		for (int i = 0; i < days.length; i++) {
			p1.add(l[i] = new JLabel(days[i], JLabel.CENTER));
			l[i].setFont(new Font("���� ���", Font.PLAIN, 20));
		}
		p1.setBackground(new Color(180,239,236));
		p1.setBounds(10, 170, 570, 20);
		l[0].setForeground(new Color(255, 0, 0));// �Ͽ��� "��" RGB�� �� �ִ´�.
		l[6].setForeground(new Color(0, 0, 255));
		
		// run �ߵ��ؾ� �ϴµ�...-> start�� ���� �ؾ���
		// �� start�� ���µ�... Thread��ü�� ������.. ������ this�� �־��ָ� ��!
		Thread th = new Thread(this); // runnable�� ������ �ִ� this�� �ͼ� �����带 �ߵ��ϰ� �Ѵ�.
		th.start();
		btnBefore.addActionListener(this);
		btnAfter.addActionListener(this);
		add(todayBtn);
		add(time);
		add(p1);
		setVisible(true);
		validate();
	}
	public void setToday(){
		dt = new Date();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy�� MM�� dd�� E����");
		todayBtn = new JButton(sdf1.format(dt));
		f = new Font("���� ���", Font.PLAIN, 20);
		todayBtn.setFont(f);
		todayBtn.setBorderPainted(false);
		todayBtn.setContentAreaFilled(false);
		todayBtn.setBounds(2, 55, 265, 45);
		todayBtn.addActionListener(this);
		todayBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	public void setDate() {
		year = today.get(Calendar.YEAR);
		month = today.get(Calendar.MONTH)+1;
		date = today.get(Calendar.DATE);
		calDayOfMon = today.get(Calendar.DAY_OF_MONTH);
	}
	public void date() {
		add(btnDate = new JButton(year + "�� " + month + "��"));
		btnDate.setHorizontalAlignment(SwingConstants.LEFT);
		btnDate.setBounds(2, 120, 150, 45);
		btnDate.setBorderPainted(false);
		btnDate.setContentAreaFilled(false);
		f = new Font("���� ���", Font.PLAIN, 20); // �Ⱑ ���� ǥ���ϴ� �ؽ�Ʈ �ʵ��� ���� �Ӽ�
		btnDate.setFont(f);
	}
	public void dateP() {
		datePane.setVisible(false); // �г� �����
		datePane.removeAll(); // ��¥ ����� �� �����
		datePane.setVisible(true); // �г� �����
		datePane.setBounds(5, 200, 580, 550);
		dayPrint(year,month);
		add(datePane);
	}
    public void calInput(int gap){
        if (gap==-1 || gap ==1)
        {
      	  month+=(gap);
      	  if (month<=0)
      	  {
                month = 12;
                year  =year- 1;
      	  }
      	  else if (month>=13)
      	  {
                month = 1;
                year =year+ 1;
      	  }
        }
        else if(gap == 12){	year++;	}
        else if(gap == -12){	year--;	
        	}
        }
	public void dayPrint(int y, int m) {
		Calendar cal = Calendar.getInstance();
		cal.set(y, m - 1, 1); // ����� ù���� ��ü �����.
		int week = cal.get(Calendar.DAY_OF_WEEK); // 1�Ͽ� ���� ���� �Ͽ��� : 0
		int lastDate = cal.getActualMaximum(Calendar.DAY_OF_MONTH); // �� ���� ������ ��
		for (int i = 1; i < week; i++) { // ��¥ ��� �������� ���� ���
			datePane.add(new JLabel(" "));
		}
		for (int i = 1; i <= lastDate; i++) {
			//JLabel lbl = new JLabel(String.valueOf(i), JLabel.CENTER);
			JButton btn = new JButton(String.valueOf(i));
			cal.set(y, m - 1, i);
			int outWeek = cal.get(Calendar.DAY_OF_WEEK);
			if (outWeek == 1) {
				btn.setForeground(Color.RED);
			} else if (outWeek == 7) {
				btn.setForeground(Color.BLUE);
			}
			if(i==date&&m==today.get(Calendar.MONTH)+1) {
				btn.setText("��"+btn.getText());
			}
			btn.setBackground(new Color(180,239,236));
			datePane.setBackground(new Color(180,239,236));
			btn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
//					System.out.println(cal.get(Calendar.YEAR));
//					System.out.println(cal.get(Calendar.MONTH)+1);
//					//System.out.println(cal.get(Calendar.DATE));
//					System.out.println(btn.getText());
					
					plan = new plan(cal.get(Calendar.YEAR),cal.get(Calendar.MONTH),btn.getText());
					
				}
			});
			datePane.add(btn);
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
			if (e.getSource()==btnBefore) { // ����
                calInput(-1);
			} else if (e.getSource()==btnAfter) { // ������
                calInput(1);		
			}else if (e.getSource()==todayBtn) {
				setDate();
			}
			btnDate.setText(year+"�� "+month+"��");
			dateP();
		}
	public void run() {
		// run���� �ð��� ���� �� ���ָ� �ȴ�.
		while (true) {
			Date date = new Date();
			int ampm = cal.get(Calendar.AM_PM);
			String strAmpm = (ampm == Calendar.AM) ? "����" : "����";
			SimpleDateFormat sdf = new SimpleDateFormat(strAmpm + " " + "h:mm:ss");
			time.setText(sdf.format(date));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	private class plan extends JFrame{
		JPanel plan;
		String date;
		int yy;
		int mm;
		Calendar today = Calendar.getInstance();
		String[] mon = { "1", "2", "3", "4", "5", "6","7","8","9","10","11","12" };
		public plan(int yy, int mm ,String date) {
			this.date = date;
			this.yy = yy;
			this.mm = mm;
			System.out.println(yy);
			System.out.println(mm);
			System.out.println(date);
			setTitle("���� �߰�");
			setSize(500,350);
			setVisible(true);
			setResizable(false);
			setLocationRelativeTo(null);//�߾ӹ�ġ
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			setLayout(new BorderLayout());
			plan = new JPanel();
			plan.setLayout(new GridLayout(4, 0));
			add(plan);
			JPanel p1 = new JPanel();
			JLabel tt = new JLabel("���� ����");
			tt.setFont(new Font("���� ���",Font.PLAIN,13));
			JTextField title = new JTextField(20);
			p1.add(tt);
			p1.add(title);
			plan.add(p1);
			JPanel p2 = new JPanel();
			JLabel str = new JLabel("������");
			JComboBox month = new JComboBox(mon);
			month.setSelectedIndex(mm);
			p2.add(str);
			p2.add(month);
			plan.add(p2);
			JPanel p3 = new JPanel();
			JLabel end = new JLabel("������");
			p3.add(end);
			plan.add(p3);
			JPanel p4 = new JPanel();
			JLabel con = new JLabel("����");
			JTextField text = new JTextField(30);
			p4.add(con);
			p4.add(text);
			plan.add(p4);
		}
	}
}
