package brian_background.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import android.bean.Member;
import brian_background.dao.*;
public class Login_out_DaoImpl implements Login_out_Dao{
	
	private DataSource ds;
	public Login_out_DaoImpl() {
		try {
			ds = (DataSource) new InitialContext().lookup("java:/comp/env/jdbc/example");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Member login(Member member) {
		return selelctByUsernameAndPassword(member);
	}

	@Override
	public Member selelctByUsernameAndPassword(Member member) {
		String sql = "select * from MEMBER where USERNAME = ? and PASSWORD = ?";
		try (Connection conn = ds.getConnection();
			 PreparedStatement pstmt = conn.prepareStatement(sql);
					 
				) {
			pstmt.setString(1, member.getM_id());
			pstmt.setString(2, member.getM_pwd());
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					member = new Member();
					member.setM_name(rs.getString("m_name"));
					member.setM_gen(rs.getInt("m_gen"));
					member.setM_cell(rs.getString("m_cell"));
					member.setM_twid(rs.getString("m_twid"));
					member.setM_addr(rs.getString("m_addr"));
					member.setM_ed_date(rs.getTimestamp("m_ed_date"));
					member.setB_id(rs.getString("b_id"));
					member.setM_email(rs.getString("m_email"));
					member.setM_pic(rs.getBytes("m_pic"));
					member.setM_sus(rs.getBoolean("m_sus"));
					return member;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}


}
