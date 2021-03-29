package ch18;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class ImageViewEx1 extends MFrame {
	
	Image img;
	
	public ImageViewEx1() {
		super(450, 650);
		img = Toolkit.getDefaultToolkit().getImage("ch18/img1.jpg");
	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(img, 0, 0, this);
	}
	
	public static void main(String[] args) {
		new ImageViewEx1();
	}

}



