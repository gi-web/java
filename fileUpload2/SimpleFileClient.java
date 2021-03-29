package fileUpload2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class SimpleFileClient {
	public static void main(String[] args) {

		Socket socket = null;
		InputStreamReader isr = null;
		FileOutputStream fos = null;

		try {
			socket = new Socket("127.0.0.1", 1818);
			InputStream in = socket.getInputStream();

			fos = new FileOutputStream("fileUpload/apple2.gif");
			byte[] data = new byte[10000];
			int length = in.read(data);
			System.out.print("다운중 ");
			while (length != -1) {
				fos.write(data, 0, length);
				length = in.read(data);
			}

			System.out.println("\n파일 저장 성공");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fos != null) {
					fos.close();
				}
				if (isr != null) {
					isr.close();
				}
				if (socket != null) {
					socket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
