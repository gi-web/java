package fileUpload;

import java.net.*;
import java.io.*;

public class ServerSendFile {

	public ServerSendFile() {
		ServerSocket ss;
		try {
			ss = new ServerSocket(7788);
			System.out.println("서버소켓을 생성하였습니다..!!");

			Socket s = ss.accept();
			System.out.println("소켓 " + s + " 와 연결되었습니다..!!");

			InputStream in = s.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in));

			System.out.println("스트림을 얻었습니다..!!");
			String fileName = "C:/Java/eclipse-workspace/myJava/fileUpload/" +br.readLine();

			FileOutputStream out = new FileOutputStream(fileName);
			System.out.println("객체 생성");
			int i = 0;
			while ((i = in.read()) != -1) {
				out.write((char) i);
			}
			System.out.println("파일 전송 완료");
			
			// 시스템정리
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