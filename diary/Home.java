package diary;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Home extends JPanel {
	
	JLabel lb1, lb2;
	JList list1, list2;
	JScrollPane sp1, sp2;

	public Home() {
	setBounds(0, 0, 600, 850);
	
	lb1 = new JLabel("Memo list");
	lb1.setBounds(100, 71, 100, 30);
	lb1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
	lb2 = new JLabel("To to list");
	lb2.setBounds(390, 71, 100, 30);
	lb2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
	
	list1 = new JList();
	list1.setBounds(20, 100, 270, 300);
	list1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
	
	sp1 = new JScrollPane(list1, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	sp1.setBounds(20, 100, 270, 300);
	sp1.setPreferredSize(new Dimension(12, 42));
	
	list2 = new JList();
	list2.setBounds(300, 100, 250, 300);
	list2.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
	
	sp2 = new JScrollPane(list2, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	sp2.setBounds(300, 100, 250, 300);
	sp2.setPreferredSize(new Dimension(300, 302));
	
	add(sp1);
	add(sp2);
	add(lb1);
	add(lb2);
	
	
}

	
	
	public static void main(String[] args) {

	}

}


