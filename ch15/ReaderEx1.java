package ch15;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class ReaderEx1 {
	public static void main(String[] args) {
		try {
			InputStream is = System.in;
			Reader reader = new InputStreamReader(is);
			while(true) {
				int i = reader.read();//내부적 대기 상태 -> 키보드 입력하면 실행
				System.out.print((char)i);
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}





