package ch15;

import java.io.FileWriter;

public class FileWriterEx1 {
	public static void main(String[] args) {
		String str = "Dream as if you'll live forever\n"
				+ "Live as if you'll die today\n"
				+ "-제임스딘-";
		try {
			//파일 없다면 만들어진다.
			FileWriter fw = new FileWriter("ch15/bbb.txt");
			fw.write(str);
			fw.flush();
			fw.close();
			System.out.println("End~~");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}





