package test;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class WebGUI{
	
	public WebGUI() {
		try {
			Desktop d = Desktop.getDesktop();
			d.browse(new URI("http://jspstudy.co.kr"));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new WebGUI();
		
	}
}