package diary;

// 빈즈네이밍 : 테이블 + Bean(관례)
// 빈즈 : 레코드(한줄) 단위의 데이터 덩어리
public class CashBean {

	private String MB_Id;
	private int Cs_no;
	private String Income;
	private String Spending;
	private String Cs_contents;
	private String Cs_date;

	// getXxx
	public String getMB_Id() {
		return MB_Id;
	}

	// setXxx(타입 컬럼명)
	public void setMB_Id(String id) {
		this.MB_Id = id;
	}
	//////////////////////////////////////////////

	public int getCs_no() {
		return Cs_no;
	}

	public void setCs_no(int nob) {
		this.Cs_no = nob;
	}

	//////////////////////////////////////////////

	public String getIncome() {
		return Income;
	}

	public void setIncome(String inc) {
		this.Income = inc;
	}

	//////////////////////////////////////////////

	public String getSpending() {
		return Spending;
	}

	public void setSpending(String spd) {
		this.Spending = spd;
	}

	//////////////////////////////////////////////

	public String getCs_contents() {
		return Cs_contents;
	}

	public void setCs_contents(String con) {
		this.Cs_contents = con;
	}

	//////////////////////////////////////////////
	public String getCs_date() {
		return Cs_date;
	}

	public void setCs_date(String date) {
		this.Cs_date = date;
	}

	//////////////////////////////////////////////

}
