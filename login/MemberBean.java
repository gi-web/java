package login;

// ������̹� : ���̺� + Bean(����)
// ���� : ���ڵ�(����) ������ ������ ���
public class MemberBean {
	
	private String MB_Id;
	private String MB_Name;
	private String Pwd;
	private String Email;
	
					//getXxx
	public String getMB_Id() {
		return MB_Id;
	}
						//setXxx(Ÿ�� �÷���)
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
