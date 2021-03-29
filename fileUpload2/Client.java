package fileUpload2;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.Socket;
import javax.imageio.ImageIO;
import javax.swing.*;
 
public class Client {
    
    public static void main(String[] args) {
 
        JLabel jLabel = new JLabel();
        File imgFile = new File("C:\\Users\\admin\\Documents\\copy.jpg");
        BufferedImage bufferedImg = null;
        try {
            bufferedImg = ImageIO.read(imgFile);
            ImageIcon imgIcon = new ImageIcon(bufferedImg);
            jLabel.setIcon(imgIcon);
 
    // JLabel �� ������ �̹����� ������ ���ε��Ѵ�
            uploadImg(jLabel);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    // JLabel �� ���Ե� ImageIcon �����͸� BufferedImage �� ��ȯ�Ͽ�
    // ������ �����Ѵ�
    private static void uploadImg(JLabel jLabel) {
        ImageIcon icon = (ImageIcon)jLabel.getIcon();
        BufferedImage bi = (BufferedImage)icon.getImage();
        Socket socket = null;
        try {
            socket = new Socket("localhost",1234);
            OutputStream outStream = socket.getOutputStream();
            ImageIO.write(bi, "jpg", outStream);
            outStream.close();
            System.out.println("Ŭ���̾�Ʈ: �̹��� ���� ���ε� �Ϸ�");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
