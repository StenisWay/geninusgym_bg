package ServiceImpl;

import java.sql.Timestamp;
import java.util.List;

import Dao.MemberDao;
import DaoImpl.MemberDaoImpl;
import Service.MemberService;
import android.bean.Member;


public class MemberServiceImpl implements MemberService{
	private MemberDao dao;
	
	public MemberServiceImpl(){
		dao = new MemberDaoImpl();
	}
	
	@Override
	public boolean register(Member member) {
		String m_id = member.getM_id();
		if(m_id == null) {
			return false;
		}
		String m_pwd = member.getM_pwd();
		if(m_pwd == null) {
			return false;
		}
		String m_name = member.getM_name();
		if(m_name == null) {
			return false;
		}
		Integer m_gen = member.getM_gen();
		if(m_gen == null) {
			return false;
		}
		String m_cell = member.getM_cell();
		if(m_cell == null) {
			return false;
		}
		String m_twid = member.getM_twid();
		if(m_twid == null) {
			return false;
		}
		String m_addr = member.getM_addr();
		if(m_addr == null) {
			return false;
		}
		Timestamp m_ed_date = member.getM_ed_date();
		if(m_ed_date == null) {
			return false;
		}
		String b_id = member.getB_id();
		if(b_id == null) {
			return false;
		}
		String m_email = member.getM_email();
		if(m_email == null) {
			return false;
		}
		byte[] m_pic = member.getM_pic();
		if(m_pic == null) {
			return false;
		}
		
		return dao.insert(member) >= 1 ;
	}

	@Override
	public List<Member> findAll() {
		return dao.selectAll();
	}



	


}
