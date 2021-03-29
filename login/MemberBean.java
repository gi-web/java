package login;

// 빈즈네이밍 : 테이블 + Bean(관례)
// 빈즈 : 레코드(한줄) 단위의 데이터 덩어리
public class MemberBean {
	
	private String MB_Id;
	private String MB_Name;
	private String Pwd;
	private String Email;
	
					//getXxx
	public String getMB_Id() {
		return MB_Id;
	}
						//setXxx(타입 컬럼명)
	public void setMB_Id(String id) {
		this.MB_Id = id;
	}
	
	
	public String getMB_Name() {
		return MB_Name;
	}
	public void setMB_Name(String name) {
		this.MB_Name = name;
	}
	
	
	public String getPwd() {
		return Pwd;
	}
	public void setPwd(String pwd) {
		this.Pwd = pwd;
	}
	
	
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		this.Email = email;
	}
	
}
