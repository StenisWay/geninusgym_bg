package Dao;

import java.util.List;
import android.bean.Member;

public interface MemberDao {
	 int insert(Member member);
	 
	 int unRegisterById(Member member);// 此不是真實刪除，
	 
	 int updateById(Member member);
	 
	 List<Member> selectAll();
	 
	 List<Member> selectIdName();
	 
	 Member selelctByUsernameAndPassword(Member member);
}
