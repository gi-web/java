package fileUpload;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;

public class ClientSendFile extends JFrame implements ActionListener {

	FileDialog fd; // 파일 전송 다이알로그창
	JButton b1, b2; // J버튼
	JTextField tf; // 파일전송 상태를 나타내줄 텍스트필드.
	String directory = "", file = "", ipAddr = ""; // 저장될 디렉토리와 파일명 그리고 접속할 IP주소

	public ClientSendFile(String ipAddr) {

		this.ipAddr = ipAddr;
		b1 = new JButton("파일선택");
		b1.addActionListener(this);
		tf = new JTextField(20);
		b2 = new JButton("파일전송");
		b2.addActionListener(this);

		add(b1, BorderLayout.NORTH);
		add(tf, BorderLayout.CENTER);
		add(b2, BorderLayout.SOUTH);

		setBounds(200, 200, 200, 200);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getActionCommand().equals("파일선택")) {
				fd = new FileDialog(this, "", FileDialog.LOAD); // 다이얼로그창 생성
				fd.setVisible(true);
				tf.setText("");
				directory = fd.getDirectory(); // 다이얼로그창에서 선택된 디렉토리를..
				file = fd.getFile(); // 파일을...
				tf.setText(directory + file);
			} else if (e.getActionCommand().equals("파일전송")) {
				Socket sock = new Socket(ipAddr, 7788); // 주어지는 ip주소와 포트번호로 접속하는 소켓생성.
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));
				System.out.println("파일명 : " + file);
				bw.write(file + "\n");
				bw.flush();

				DataInputStream dis = new DataInputStream(new FileInputStream(new File(tf.getText())));
				DataOutputStream dos = new DataOutputStream(sock.getOutputStream());
				
				int i = 0;
				while ((i = dis.read()) != -1) {
					dos.write(i);
					dos.flush();
				}
				//System.out.println("이햐~ 다 썼네요..!!");

				// 자원정리
				dis.close();
				dos.close();
				sock.close();
				System.out.println("파일 전송 종료하께요^^");
				this.setVisible(false);
			}
		} catch (Exception xe) {
			System.out.println(xe + "접속하는 데 실패하셨습니다..!!");
		}
	}

	public static void main(String[] args) {
		new ClientSendFile("127.0.0.1");
	}
}
