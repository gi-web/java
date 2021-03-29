package ch14;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ex4 {
	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader("ch14/ccc.txt");
			int i;
			while((i=fr.read())!=-1) {
				System.out.print((char)i);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("파일이 없네요.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}









