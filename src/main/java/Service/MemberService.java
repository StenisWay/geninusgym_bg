package Service;

import java.util.List;

import android.bean.Member;



public interface MemberService {
	
	boolean register(Member member);
	
	boolean editMember(Member member);
	
	boolean editSuspend(Member member);
	
	
	List<Member> findAll();

}
