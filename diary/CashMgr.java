package diary;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

import login.Login;
import login.MemberMgr;

public class CashMgr {

	private DBConnectionMgr pool;

	public CashMgr() {
		pool = DBConnectionMgr.getInstance();

	}

	// 리스트 가져옴
	public Vector<CashBean> getListMember() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		Vector<CashBean> vlist = new Vector<CashBean>();
		try {
			con = pool.getConnection();
			sql = "select * from tbl_cash order by Cs_no";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				CashBean bean = new CashBean();
				bean.setCs_no(rs.getInt("nob"));
				bean.setIncome(rs.getString("inc"));
				bean.setSpending(rs.getString("spd"));
				bean.setCs_contents(rs.getString("con"));
				bean.setCs_date(rs.getString("date"));
				vlist.addElement(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return vlist;
	}
	
	//리스트 가져옴
		public Vector<CashBean> getListCash(String id){
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = null;
			Vector<CashBean> vlist = new Vector<CashBean>();
			try {
				con = pool.getConnection();
				sql = "select cs_date, income, spending, cs_contents from tbl_cash where MB_Id =?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					CashBean bean = new CashBean();
					bean.setCs_date(rs.getString("cs_date"));
					bean.setIncome(rs.getString("income"));
					bean.setSpending(rs.getString("spending"));
					bean.setCs_contents(rs.getString("cs_contents"));
					pstmt.setString(1, bean.getMB_Id());
					vlist.addElement(bean);
				}		
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				pool.freeConnection(con, pstmt, rs);
			}
			return vlist;
		}

	// 가계부 추가
	public boolean insertCash(CashBean bean) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		boolean flag = false;
		try {
			con = pool.getConnection();
			sql = "insert into tbl_cash(mb_id, cs_no, Income, Spending , Cs_contents, Cs_date)"
					+ "values(?, seqcs_no.nextval, ?, ?, ?, ?)";

			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, bean.getMB_Id());
			pstmt.setString(2, bean.getIncome());
			pstmt.setString(3, bean.getSpending());
			pstmt.setString(4, bean.getCs_contents());
			pstmt.setString(5, bean.getCs_date());

			int cnt = pstmt.executeUpdate(); // insert , update, delete < 요 3개는 executeupdate 하고 int cnt에 적용 ? 결과값은 굳이
												// 안받아도?
			if (cnt == 1)
				flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
		return flag;
	}

	// 합계
	public String spendingCash(String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		String Spending = null;

		try {
			con = pool.getConnection();
			sql = "select nvl(sum(Spending),0) from tbl_cash where MB_Id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next())
				Spending = rs.getString(1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return Spending;
	}
	
	public String incomecash(String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		String Spending = null;

		try {
			con = pool.getConnection();
			sql = "select nvl(sum(income),0) from tbl_cash where Mb_Id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next())
				Spending = rs.getString(1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return Spending;
	}

	// 가계부 수정
	public boolean updateCash(CashBean bean) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		boolean flag = false;
		try {
			con = pool.getConnection();
			sql = "update tbl_cash set" + "income = ?, " + "Spending = ?, " + "cs_contents = ?, " + "cs_date = ?"
					+ "where mb_id = ?" + "cs_no = ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bean.getIncome());
			pstmt.setString(2, bean.getSpending());
			pstmt.setString(3, bean.getCs_contents());
			pstmt.setString(4, bean.getCs_date());
			int cnt = pstmt.executeUpdate();
			if (cnt == 1)
				flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
		return flag;
	}

	// 삭제
	public boolean deleteCash(int Cs_no) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		boolean flag = false;
		try {
			con = pool.getConnection();
			sql = "delete from tbl_cash where = ?";
			pstmt = con.prepareStatement(sql);
			int cnt = pstmt.executeUpdate();
			if (cnt == 1)
				flag = true;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
		return flag;
	}

}
