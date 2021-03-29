package net.codejava.swing;

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

public class JDatePickerDemo extends JFrame implements ActionListener {
	
	private JDatePickerImpl datePicker;
	
	public JDatePickerDemo() {
		super("Calendar Component Demo");
		setLayout(new FlowLayout());
		
		add(new JLabel("Birthday: "));
		
		UtilDateModel model = new UtilDateModel();
		model.setDate(1990, 8, 24);
		model.setSelected(true);

		JDatePanelImpl datePanel = new JDatePanelImpl(model);

		datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		
		add(datePicker);
		
		JButton buttonOK = new JButton("OK");
		buttonOK.addActionListener(this);
		
		add(buttonOK);
		
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new JDatePickerDemo().setVisible(true);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		Date selectedDate = (Date) datePicker.getModel().getValue();
		JOptionPane.showMessageDialog(this, "The selected date is " + selectedDate);
	}

}