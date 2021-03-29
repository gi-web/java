package test1;


import java.awt.BorderLayout;
import java.awt.FileDialog;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ImageTest1 implements ActionListener{
	
	JPanel panel;
	FileDialog getImg;
	JButton button;
	JFrame frame;
	ImagePanel panel1;
	
	public ImageTest1() {
	    frame = new JFrame("�̹��� �ҷ�����");
		button = new JButton("�̹��� �ҷ�����");
		panel = new JPanel(); 
		panel1 = new ImagePanel(); // �̹����� �ҷ����� ���� �г�
		frame.setBounds(500, 400, 480, 640);
		frame.add(panel1);
		getImg = new FileDialog(frame,"�̹��� ����",FileDialog.LOAD);
		button.addActionListener(this);
		panel.add(button);
		frame.add(panel,BorderLayout.SOUTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // �޸𸮿��� ���� ���
		frame.setVisible(true);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		getImg.setVisible(true);
		String s = getImg.getDirectory() +  getImg.getFile();
		panel1.setPath(s);
		panel1.repaint();
	}
	
	class ImagePanel extends JPanel {
		
		Image image;
		Toolkit toolkit = getToolkit(); // �̹����� �������� ���ؼ�

		public void setPath(String src) {
			image = toolkit.getImage(src); // ��� ����
		}

		@Override
		public void paint(Graphics g) {
			g.clearRect(0, 0, 480, 640);
			if (image != null)
				g.drawImage(image, 0, 0, this); // ��ΰ� ������ �� ���
		}
	}
	
	public static void main(String[] args) {
		new ImageTest1();
	}
}


