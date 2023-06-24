package brian_background.dao;

import java.util.List;

import android.bean.Member;

public interface Login_out_Dao {
	
	Member login(Member member);
	
	Member selelctByUsernameAndPassword(Member member);

	

}
