package Dao;

import java.util.List;

import android.bean.Coach;

public interface CoachDao {
	 int insert(Coach coach);
	 
	 int unRegisterById(Coach coach);
	 
	 int updateById(Coach coach);
	 
	 List<Coach> selectAll();
}
