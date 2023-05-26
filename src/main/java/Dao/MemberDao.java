package Dao;

import java.util.List;
import android.bean.Member;

public interface MemberDao {
	 int insert(Member member);
	 
	 int deleteById(String id);
	 
	 int updateById(Member member);
	 
	 List<Member> selectAll();
}
