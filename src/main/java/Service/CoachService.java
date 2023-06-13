package Service;

import java.util.List;

import android.bean.Coach;
import android.bean.Member;

public interface CoachService {
	
	boolean register(Coach coach);
	
	boolean editCoach(Coach coach);
	
	boolean editSuspend(Coach coach);

	List<Coach> findAll();

	

}
