package ch15;

import java.io.OutputStream;

public class OutputStreamEx1 {
	public static void main(String[] args) {
		try {
			int i = 'A';
			char c = 'b';
			char c1 = '한';
			OutputStream os = System.out;
			os.write(i);
			os.write(c);
			os.write(c1);
			os.flush();//스트림에 남아 있는 data를 비운다.
			os.close();//더이상 사용하지 않는 스트림 close한다.
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}





