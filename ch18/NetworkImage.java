package ch18;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.MalformedURLException;
import java.net.URL;

public class NetworkImage extends MFrame{

	Image img;
	
	public NetworkImage() {
		super(650, 450);
		URL url;
		try {
			url = new URL("http://www.visitbusan.net/uploadImgs/files/cntnts/20191222164810529_thumbL");
			img = Toolkit.getDefaultToolkit().getImage(url);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(img, 0, 0, this);
	}
	
	public static void main(String[] args) {
		new NetworkImage();
	}
}
