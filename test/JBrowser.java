package test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.Desktop;

public class JBrowser {
	public static void main(String[] args) {
		try {
			Desktop.getDesktop().browse(new URI("http://mdago.tistory.com/"));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
}