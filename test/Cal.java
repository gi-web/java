package test;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Cal extends JFrame implements ActionListener, Runnable {

	JButton bt1;
	int arr[] = new int[42];
	JButton btn[] = new JButton[42];
	Label l[] = new Label[7];

	Font f;

	String days[] = { "일", "월", "화", "수", "목", "금", "토" };
	int year, month, day, todays, memoday = 0;
	Calendar today;
	Calendar cal;

	JButton btnBefore, btnAfter;
	JButton btnDate;

	Label lbl, lbl1;

	public Cal() {

		setLayout(null);
		setBounds(0, 0, 600, 850); // 위치,사이즈

		today = Calendar.getInstance(); // 디폴트의 타임 존 및 로케일을 사용해 달력을 가져옵니다.
		cal = new GregorianCalendar();
		/*
		 * GregorianCalendar 는,Calendar 의 구상 서브 클래스이며, 세계의 대부분의 지역에서 사용되는 표준적인 달력 시스템을
		 * 제공합니다.
		 */

		lbl = new Label();
		Font fontLabel = new Font("맑은 고딕", Font.PLAIN, 30);
		lbl.setFont(fontLabel);
		lbl.setBounds(20, 15, 300, 45);

		year = today.get(Calendar.YEAR);
		month = today.get(Calendar.MONTH) + 1;// 1월의 값이 0

		Date date1 = new Date();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy년 MM월 dd일 E요일");
		JButton bt1 = new JButton(sdf1.format(date1));
		f = new Font("맑은 고딕", Font.PLAIN, 18);
		bt1.setFont(f);
		bt1.setBorderPainted(false);
		bt1.setContentAreaFilled(false);
		bt1.setBounds(0, 55, 260, 45);

		add(btnDate = new JButton(year + "년 " + month + "월"));
		f = new Font("맑은 고딕", Font.PLAIN, 19); // 년가 월을 표시하는 텍스트 필드의 글자 속성
		btnDate.setFont(f);
		btnDate.setBorderPainted(false);
		btnDate.setContentAreaFilled(false);

		add(btnBefore = new JButton("∧"));
		add(btnAfter = new JButton("∨"));
		f = new Font("Serfi", Font.BOLD, 50);
		btnBefore.setFont(f);
		btnAfter.setFont(f);
		btnBefore.setBorderPainted(false);
		btnBefore.setContentAreaFilled(false);
		btnAfter.setBorderPainted(false);
		btnAfter.setContentAreaFilled(false);
		btnDate.setBounds(5, 120, 150, 45);
		btnBefore.setBounds(400, 120, 100, 45);
		btnAfter.setBounds(480, 120, 100, 45);

		Panel p1 = new Panel();
		p1.setLayout(new GridLayout(1, 1));
		for (int i = 0; i < days.length; i++) {
			p1.add(l[i] = new Label(days[i], Label.CENTER));
		}
		p1.setBounds(20, 175, 550, 20);
		f = new Font("맑은 고딕", Font.PLAIN, 16);
		p1.setFont(f);
		l[0].setForeground(new Color(255, 0, 0));// 일요일 "일" RGB의 색 넣는다.
		l[6].setForeground(new Color(0, 0, 255));

		Panel p2 = new Panel();

		p2.setLayout(new GridLayout(6, 7));
		for (int i = 0; i < btn.length; i++) {
			btn[i] = new JButton();
			p2.add(btn[i]);
			btn[i].setBorderPainted(true);
			btn[i].setContentAreaFilled(false);

		}
		p2.setBounds(20, 200, 550, 600);

		// run 발동해야 하는데...-> start를 실행 해야해
		// 난 start가 없는데... Thread객체를 만들자.. 걔한테 this를 넣어주면 돼!
		Thread th = new Thread(this); // runnable을 가지고 있는 this가 와서 쓰레드를 발동하게 한다.
		th.start();

		add(bt1);
		add(lbl);
		add(p1);
		add(p2);
		setVisible(true);
		validate();

	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

	public void run() {
		// run에서 시간이 가는 걸 해주면 된다.
		while (true) {
			Date date = new Date();
			int ampm = cal.get(Calendar.AM_PM);
			String strAmpm = (ampm == Calendar.AM) ? "오전" : "오후";
			SimpleDateFormat sdf = new SimpleDateFormat(strAmpm + " " + "hh:mm:ss");
			// System.out.println(sdf.format(date)); // 얘를 Frame에 갖다놔야 한다.
			lbl.setText(sdf.format(date));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {
		new Cal();
	}
}
