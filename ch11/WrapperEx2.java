package ch11;


public class WrapperEx2 {
	public static void main(String[] args) {
		char data[] = {'A','a','4',' ','#'};
		for (int i = 0; i < data.length; i++) {
			if(Character.isUpperCase(data[i]))//~~이다 아니다 : is~
				System.out.println(data[i] + " : 대문자");
			if(Character.isLowerCase(data[i]))
				System.out.println(data[i] + " : 소문자");
			if(Character.isDigit(data[i]))
				System.out.println(data[i] + " : 숫자");
			if(Character.isWhitespace(data[i]))
				System.out.println(data[i] + " : 공백숫자");
		}//---for
	}//--main
}//--class















