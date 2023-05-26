package spencer_playground;
import Dao.MemberDao;
import DaoImpl.MemberDaoImpl;
import android.bean.Member;
public class Test_main {
	public static void main(String[] args) {
		MemberDao dao = new MemberDaoImpl();
		Member member = new Member();
		member.setB_id("R05221016");
		member.setM_name("HaHaPoint");
		dao.updateById(member);
	}
}
