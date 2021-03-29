package fileUpload;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;

public class ClientSendFile extends JFrame implements ActionListener {

	FileDialog fd; // ���� ���� ���̾˷α�â
	JButton b1, b2; // J��ư
	JTextField tf; // �������� ���¸� ��Ÿ���� �ؽ�Ʈ�ʵ�.
	String directory = "", file = "", ipAddr = ""; // ����� ���丮�� ���ϸ� �׸��� ������ IP�ּ�

	public ClientSendFile(String ipAddr) {

		this.ipAddr = ipAddr;
		b1 = new JButton("���ϼ���");
		b1.addActionListener(this);
		tf = new JTextField(20);
		b2 = new JButton("��������");
		b2.addActionListener(this);

		add(b1, BorderLayout.NORTH);
		add(tf, BorderLayout.CENTER);
		add(b2, BorderLayout.SOUTH);

		setBounds(200, 200, 200, 200);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getActionCommand().equals("���ϼ���")) {
				fd = new FileDialog(this, "", FileDialog.LOAD); // ���̾�α�â ����
				fd.setVisible(true);
				tf.setText("");
				directory = fd.getDirectory(); // ���̾�α�â���� ���õ� ���丮��..
				file = fd.getFile(); // ������...
				tf.setText(directory + file);
			} else if (e.getActionCommand().equals("��������")) {
				Socket sock = new Socket(ipAddr, 7788); // �־����� ip�ּҿ� ��Ʈ��ȣ�� �����ϴ� ���ϻ���.
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));
				System.out.println("���ϸ� : " + file);
				bw.write(file + "\n");
				bw.flush();

				DataInputStream dis = new DataInputStream(new FileInputStream(new File(tf.getText())));
				DataOutputStream dos = new DataOutputStream(sock.getOutputStream());
				
				int i = 0;
				while ((i = dis.read()) != -1) {
					dos.write(i);
					dos.flush();
				}
				//System.out.println("����~ �� ��׿�..!!");

				// �ڿ�����
				dis.close();
				dos.close();
				sock.close();
				System.out.println("���� ���� �����ϲ���^^");
				this.setVisible(false);
			}
		} catch (Exception xe) {
			System.out.println(xe + "�����ϴ� �� �����ϼ̽��ϴ�..!!");
		}
	}

	public static void main(String[] args) {
		new ClientSendFile("127.0.0.1");
	}
}
