package DaoImpl;

import static util.CommonConstants.password;
import static util.CommonConstants.route;
import static util.CommonConstants.url;
import static util.CommonConstants.username;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.zaxxer.hikari.HikariDataSource;

import Dao.PointDao;
import android.bean.Point;

public class PointDaoImpl implements PointDao{
	private HikariDataSource ds;
	public PointDaoImpl(){
		try {
			ds = (HikariDataSource) new InitialContext().lookup(route);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	@Override
	public int insert(Point point) {
		
		String sql = "INSERT INTO point ("
				+ "p_id" //ID p_id
				+ "m_id" //會員 ID m_id
				+ "p_left" //點數餘額 p_left
				+ "p_card" //信用卡綁定 p_card
				+ "p_rec" //點數交易記錄（課程花費 / 點數儲值 ） p_rec
				+ "p_modi_time" //點數異動時間 p_modi_time
				+ ") VALUES(?,?,?,?,?,NOW())";
		return 0;
	}

	@Override
	public List<Point> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Point selectById(Point point) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Boolean updateById(String m_id, Integer point) {
		String spl = "update point set p_left = ? where m_id = ?";
		try (Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(spl);) {
			pstmt.setInt(1, point);
			pstmt.setString(2, m_id);
			if (pstmt.executeUpdate() >= 1) {
				return true;
			}
			else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	@Override
	public Integer selectPointById(String m_id) {
		String sql = "SELECT * FROM Point WHERE m_id = ?;";
		try (
				Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				
		){
			System.out.println("id");
			System.out.println(m_id);
			Point point = new Point();
			pstmt.setString(1, m_id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
//				point.setP_id(rs.getInt("p_id"));
//				point.setM_id("m_id");
				point.setP_left( rs.getInt("p_left"));
			}
			System.out.println("點數");
			System.out.println(point.getP_left());
			return point.getP_left();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

}
