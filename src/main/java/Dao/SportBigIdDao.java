package Dao;

import java.util.List;

import android.bean.SportBigId;

public interface SportBigIdDao {
	int insert(SportBigId sportBigId);
	
	int delete(Integer sb_id);
	
	int update(SportBigId sportBigId);
	
	List<SportBigId> selectAll();
}
