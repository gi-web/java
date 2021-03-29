package fileUpload;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;

public class FileUploadGUI extends JFrame {

	JButton btFile;
	JButton btUpload;
	JPanel jPanel1;
	JLabel lb;
	JTextField tfFile;
	JTextField tfHost;
	JFileChooser fileDial = new JFileChooser("C:/"); // 기준 경로 지정

	Socket sock;
	ObjectOutputStream oos;
	FileInputStream fis;
	File file1;
	PrintWriter pw;

	public FileUploadGUI() {
		initComponents();
	}

	private void initComponents() {
		setTitle("FileUpload");
		jPanel1 = new JPanel();
		tfHost = new JTextField();
		tfFile = new JTextField();
		btFile = new JButton();
		btUpload = new JButton();
		lb = new JLabel();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		tfHost.setText("localhost");
		tfHost.setBorder(BorderFactory.createTitledBorder("업로드 할 서버 IP 주소"));
		tfHost.setBounds(20, 20, 100, 50);
		
		tfFile.setBorder(BorderFactory.createTitledBorder("업로드 할 파일명"));

		btUpload.setText("Upload");
		btUpload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btUploadActionPerformed(evt);
			}
		});

		btFile.setText("파일찾기");
		btFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btFileActionPerformed(evt);
			}
		});
		
		setLayout();
		pack();
	}

	public void setLayout() {
		GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap()
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
								.addComponent(tfFile)
								.addComponent(tfHost, GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(btFile, GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
								.addComponent(btUpload, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addContainerGap()));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap()
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
								.addComponent(tfHost, GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
								.addComponent(btUpload, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
								.addComponent(btFile, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(tfFile, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE))
						.addContainerGap(25, Short.MAX_VALUE)));

		lb.setBorder(new SoftBevelBorder(BevelBorder.RAISED));

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap()
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
								.addComponent(lb, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addContainerGap()
				.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE)
				.addGap(18, 18, 18)
				.addComponent(lb, GroupLayout.PREFERRED_SIZE, 331, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(26, Short.MAX_VALUE)));
	}
	
	private void btFileActionPerformed(ActionEvent evt) {

		// 파일 다이얼로그를 띄워 업로드할 파일을 선택한다
		fileDial.showOpenDialog(this);
		File selFile = fileDial.getSelectedFile();
		tfFile.setText(selFile.getAbsolutePath());
		String filename = selFile.getName();
		// 파일이 이미지 파일이면 lb에 미리보기를 해주자
		filename = filename.toLowerCase(); // 파일 이름을 전부 소문자로 바꾸기
		if (filename.endsWith(".jpg") || filename.endsWith(".png") || filename.endsWith(".gif")) {
			lb.setIcon(new ImageIcon(selFile.getAbsolutePath()));
			lb.setText("");
			lb.setHorizontalAlignment(JLabel.CENTER);
		}
	}

	private void btUploadActionPerformed(ActionEvent evt) {
		// 파일을 서버에 전송하는 스레드 생성 및 동작
		SenderThread tr = new SenderThread();
		tr.start();
	}

	class SenderThread extends Thread {
		public void run() {
			// ftpserver에 접속하자(아이피, 포트번호)
			String serverip = tfHost.getText();
			int port = 7788;
			if (serverip == null || serverip.trim().isEmpty()) {
				JOptionPane.showMessageDialog(lb, "서버의 IP 주소를 입력하세요");
				tfHost.requestFocus();
				return;
			} // if------
			try {
				// 소켓 생성
				sock = new Socket(serverip, port);
				setTitle("##서버와 접속됨");
				oos = new ObjectOutputStream(sock.getOutputStream());
				file1 = fileDial.getSelectedFile();
				fis = new FileInputStream(file1);
				// 파일명을 서버에 전송한다.
				String fname = file1.getName();
				pw = new PrintWriter(sock.getOutputStream(), true);
				oos.writeUTF(fname);
				oos.flush();
				// 파일을 읽으면서 소켓출력 스트림을 통해 파일 데이터를 내보낸다.
				int input = 0, count = 0;
				byte[] data = new byte[1024];
				while ((input = fis.read(data)) != -1) {
					oos.write(data, 0, input);
					oos.flush();
					count += input;
					System.out.println(count + "바이트 전송중...");
				}
				if (pw != null)
					pw.close();
				if (oos != null)
					oos.close();
				if (fis != null)
					fis.close();
				if (sock != null)
					sock.close();
				JOptionPane.showMessageDialog(lb, "업로드 완료!");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String args[]) {
		new FileUploadGUI().setVisible(true);
	}
}
