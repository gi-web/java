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
	
	////////////////////Mate�� ����///////////////////////////
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
	
	
	/////////////////////Signin �� ����/////////////////////////////////////
	Signin signin;

	public JDatePicker(Signin signin) {
		super("Calendar Component Demo");
		this.signin = signin;//Signin �� �����ϴ� ���ΰ�?
		setLayout(new FlowLayout());
		
		add(new JLabel("Birthday: "));
		
		UtilDateModel model = new UtilDateModel();
		model.getMonth();
		model.setSelected(true);

		JDatePanelImpl datePanel = new JDatePanelImpl(model);//��¥������ datePanel�� ����
		datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		//�� ������ date �ǳڿ� ��¥�� �ø����ִ� ���̺��� ����� ���� ���ΰ�?
		
		add(datePicker);
		
		JButton buttonOK = new JButton("OK");//ok��ư�� �����Ѵ�.
		//ok��ư�� �츮�� �����ߴµ� ��¥�����ϴ� ��ư�� UtilDateModeld���� ����� ���� ũ�� ������
		//��� �ؾ� ���� �𸣰���
		buttonOK.addActionListener(this);//ok��ư�� �Ʒ� �̺�Ʈ�� �����Ѵ�.
		
		add(buttonOK);//��ư�� �ø���.
		
		setSize(400, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent event) {
		Date sdate = (Date) datePicker.getModel().getValue();
		//mate.talab2.setText(sdate.toString());//---->�����߰�
		signin.birthTf.setText(sdate.toString());//---->�����߰�
		//�� ������ sdate�� UtilDateModel�� �ִ°� ������ ���� ���� ��¥�� �ð��� ���� �����ΰ� ����
		//64�� ������ 		model.getMonth(); ���� ���� �ؽ�Ʈ �ʵ� �������� toString �ؾ� �Ұ� ������ �������� ���� �𸣰��� 

		dispose();
	}
}









