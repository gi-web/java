package login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class MemberMgr{
	
	private DBConnectionMgr pool;
	
	public MemberMgr() {
		pool = DBConnectionMgr.getInstance();		
	}
	
	//리스트 가져옴
	public Vector<MemberBean> getListMember(){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		Vector<MemberBean> vlist = new Vector<MemberBean>();
		try {
			con = pool.getConnection();
			sql = "select * from tbl_Member order by MB_id";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberBean bean = new MemberBean();
				bean.setMB_Id(rs.getString("Id"));
				bean.setMB_Name(rs.getString("Name"));
				bean.setPwd(rs.getString("Pwd"));
				bean.setEmail(rs.getString("Email"));
				vlist.addElement(bean);
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			pool.freeConnection(con, pstmt, rs);
		}return vlist;
	}

	
	//회원가입
	public boolean insertMember(MemberBean bean) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		boolean flag = false;
		try {
			con = pool.getConnection();
			sql = "insert into tbl_Member(MB_Id, MB_Name, Pwd, Email)" + "values(?,? ,? ,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bean.getMB_Id());
			pstmt.setString(2, bean.getMB_Name());
			pstmt.setString(3, bean.getPwd());
			pstmt.setString(4, bean.getEmail()); // 여기 1, 2, 3 은 위에 sql문에 물음표 순서
			int cnt = pstmt.executeUpdate(); // insert , update, delete  < 요 3개는 executeupdate 하고 int cnt에 적용 ? 결과값은 굳이 안받아도?
			if(cnt==1) flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
		return flag;
	}
	
//로그인
	public boolean loginMember(String MB_Id, String Pwd) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		boolean flag = false;
		try {
			con = pool.getConnection();
			sql = "select * from tbl_member where MB_Id=? and Pwd=?";
			pstmt = con.prepareStatement(sql);
			//? 세팅
			pstmt.setString(1, MB_Id);
			pstmt.setString(2, Pwd);
			rs = pstmt.executeQuery();
            flag = rs.next();//조건에 맞는 결과값이 있으면 true 없으면 false
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		
		return flag;
	}
	
	//아이디 찾기
	public String fineMember(String Name, String Email) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		String MB_ID = null;
		try {
			con = pool.getConnection();
			sql = "select MB_Id from tbl_member where MB_Name=? and Email=?";
			pstmt = con.prepareStatement(sql);
			//? 세팅
			pstmt.setString(1, Name);
			pstmt.setString(2, Email);
			rs = pstmt.executeQuery();
			if(rs.next())
				MB_ID = rs.getString("MB_Id");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return MB_ID ;
	}
	//비밀번호 찾기
	public String pwdmember(String Name, String Id, String Email) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		String Pwd = null;
		try {
			con = pool.getConnection();
			sql = "select Pwd from tbl_member where MB_Name=? and MB_Id = ? and Email=?";
			pstmt = con.prepareStatement(sql);
			//? 세팅
			pstmt.setString(1, Name);
			pstmt.setString(2, Id);
			pstmt.setString(3, Email);
			rs = pstmt.executeQuery();
			if(rs.next())
				Pwd = rs.getString("Pwd");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return Pwd ;
	}
}
