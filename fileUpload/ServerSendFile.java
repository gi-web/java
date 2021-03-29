package fileUpload;

import java.net.*;
import java.io.*;

public class ServerSendFile {

	public ServerSendFile() {
		ServerSocket ss;
		try {
			ss = new ServerSocket(7788);
			System.out.println("���������� �����Ͽ����ϴ�..!!");

			Socket s = ss.accept();
			System.out.println("���� " + s + " �� ����Ǿ����ϴ�..!!");

			InputStream in = s.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in));

			System.out.println("��Ʈ���� ������ϴ�..!!");
			String fileName = "C:/Java/eclipse-workspace/myJava/fileUpload/" +br.readLine();

			FileOutputStream out = new FileOutputStream(fileName);
			System.out.println("��ü ����");
			int i = 0;
			while ((i = in.read()) != -1) {
				out.write((char) i);
			}
			System.out.println("���� ���� �Ϸ�");
			
			// �ý�������
			br.close();
			in.close();
			out.close();
			s.close();
			ss.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new ServerSendFile();
	}
}