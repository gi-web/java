package tib;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

public class JDatePicker extends JFrame implements ActionListener {
	
	private JDatePickerImpl datePicker;
	
	////////////////////Mate와 연결///////////////////////////
	Mate mate;
	
	
	public JDatePicker(Mate mate) {
		super("Calendar Component Demo");
		this.mate = mate;
		setLayout(new FlowLayout());
		
		add(new JLabel("Birthday: "));
		
		UtilDateModel model = new UtilDateModel();
		model.getMonth();
		model.setSelected(true);

		JDatePanelImpl datePanel = new JDatePanelImpl(model);
		datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		
		add(datePicker);
		
		JButton buttonOK = new JButton("OK");
		buttonOK.addActionListener(this);
		
		add(buttonOK);
		
		setSize(400, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	
	
	/////////////////////Signin 과 연결/////////////////////////////////////
	Signin signin;

	public JDatePicker(Signin signin) {
		super("Calendar Component Demo");
		this.signin = signin;//Signin 과 연결하는 것인가?
		setLayout(new FlowLayout());
		
		add(new JLabel("Birthday: "));
		
		UtilDateModel model = new UtilDateModel();
		model.getMonth();
		model.setSelected(true);

		JDatePanelImpl datePanel = new JDatePanelImpl(model);//날짜가들어가는 datePanel을 생성
		datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		//위 문장은 date 판넬에 날짜를 올릴수있는 레이블을 만들어 놓는 것인가?
		
		add(datePicker);
		
		JButton buttonOK = new JButton("OK");//ok버튼을 생성한다.
		//ok버튼은 우리가 생성했는데 날짜선택하는 버튼은 UtilDateModeld에서 만든것 같아 크기 조절을
		//어떻게 해야 할지 모르겠음
		buttonOK.addActionListener(this);//ok버튼을 아래 이벤트와 연결한다.
		
		add(buttonOK);//버튼을 올린다.
		
		setSize(400, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent event) {
		Date sdate = (Date) datePicker.getModel().getValue();
		//mate.talab2.setText(sdate.toString());//---->여기추가
		signin.birthTf.setText(sdate.toString());//---->여기추가
		//위 문장의 sdate는 UtilDateModel에 있는것 같은데 지금 현재 날짜와 시간이 들어가는 변수인것 같음
		//64번 문장의 		model.getMonth(); 에서 넣은 텍스트 필드 변수값을 toString 해야 할것 같은데 변수명이 뭔지 모르겠음 

		dispose();
	}
}









