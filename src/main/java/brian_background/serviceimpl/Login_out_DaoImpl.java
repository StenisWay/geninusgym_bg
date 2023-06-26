package brian_background.serviceimpl;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import DaoImpl.MemberDaoImpl;
import android.bean.Member;
import brian_background.service.*;
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
		if (member.getM_id() == null) {
			return null;
		}
		if (member.getM_id().length() < 6 || member.getM_id().length() > 12) {
			return null;
		}
		if (member.getM_pwd() == null) {
			return null;
		}
		return new MemberDaoImpl().selelctByUsernameAndPassword(member);
	}

}
