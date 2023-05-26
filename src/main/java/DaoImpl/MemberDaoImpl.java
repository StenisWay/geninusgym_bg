package DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import static util.CommonConstants.*;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.zaxxer.hikari.HikariDataSource;

import Dao.MemberDao;
import android.bean.Member;

public class MemberDaoImpl implements MemberDao{
	
	private static final HikariDataSource ds;
	static {
			ds = new HikariDataSource(); 
			ds.setJdbcUrl(url);
			ds.setUsername(username); 
			ds.setPassword(password);
			ds.addDataSourceProperty("cachePrepStmts", true);
			ds.addDataSourceProperty("prepStmtCacheSize", 250);
			ds.addDataSourceProperty("prepStmtCacheSqlLimit", 2048);
	}

	@Override
	public int insert(Member member) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteById(String id) {
		String sql = "DELETE FROM member WHERE (m_id = ?)";
		
		try(
			Connection conn = ds.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
		)
		{
			pstmt.setString(1, id);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public int updateById(Member member) {
		//
		return 0;
	}

	@Override
	public List<Member> selectAll() {
		String sql = "SELECT * FROM MEMBER";
		List<Member> list = null;
		
		try (
				Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
		){
			while(rs.next()) {
				Member member = new Member();
				member.setM_id(rs.getString("m_id"));
				member.setM_pwd(rs.getString("m_pwd"));
				member.setM_name(rs.getString("m_name"));
				member.setM_gen(rs.getInt("m_gen"));
				member.setM_cell(rs.getString("m_cell"));
				member.setM_twid(rs.getString("m_twid"));
				member.setM_addr(rs.getString("m_addr"));
				member.setM_ed_date(rs.getTimestamp("m_ed_date"));
				member.setM_add_time(rs.getTimestamp("m_add_time"));
				member.setM_modi_time(rs.getTimestamp("m_modi_time"));
				member.setB_id(rs.getString("b_id"));
				member.setM_email(rs.getString("m_email"));
				member.setM_pic(rs.getBytes("m_pic"));
				member.setM_sus(rs.getBoolean("m_sus"));
				
				list.add(member);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
