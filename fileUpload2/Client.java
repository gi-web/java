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
 
    // JLabel 에 설정된 이미지를 서버에 업로드한다
            uploadImg(jLabel);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    // JLabel 에 포함된 ImageIcon 데이터를 BufferedImage 로 변환하여
    // 서버로 전송한다
    private static void uploadImg(JLabel jLabel) {
        ImageIcon icon = (ImageIcon)jLabel.getIcon();
        BufferedImage bi = (BufferedImage)icon.getImage();
        Socket socket = null;
        try {
            socket = new Socket("localhost",1234);
            OutputStream outStream = socket.getOutputStream();
            ImageIO.write(bi, "jpg", outStream);
            outStream.close();
            System.out.println("클라이언트: 이미지 파일 업로드 완료");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
