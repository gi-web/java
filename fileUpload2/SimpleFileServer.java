package fileUpload2;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleFileServer {
	public static void main(String[] args) {
		ServerSocket server = null;
		try {
			server = new ServerSocket(1818);
		} catch (IOException e) {
			e.printStackTrace();
		}

		FileInputStream fis = null;
		OutputStream os = null;

		Socket socket = null;

		try {
			socket = server.accept();
			os = socket.getOutputStream();
			fis = new FileInputStream("fileUpload/apple.gif");

			byte[] dataBuff = new byte[10000];
			int length = fis.read(dataBuff);
			while (length != -1) {
				os.write(dataBuff, 0, length);
				length = fis.read(dataBuff);
			}
			System.out.println("전송 선공");

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null) {
					fis.close();
				}
				if (os != null) {
					os.close();
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
