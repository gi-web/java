package fileUpload2;

import java.awt.image.*;
import java.io.*;
import java.net.*;
import javax.imageio.ImageIO;
public class Server {
   
   public static void main(String[] args) {
       
       ServerSocket ss = null;
       try {
           ss = new ServerSocket(1234);
           
           System.out.println("���� �۵�....");
           Socket socket = ss.accept();
           InputStream is = socket.getInputStream();
           BufferedImage bimg = ImageIO.read(is);
           FileOutputStream fout = new FileOutputStream("C:\\Java\\eclipse-workspace\\myJava\\fileUpload\\copy.jpg");
           ImageIO.write(bimg, "jpg", fout);
           fout.close();
           
           System.out.println("����: �̹������� �� ���Ͽ� ����Ϸ�");
       } catch (IOException ex) {
           ex.printStackTrace();
       }
   }
}
