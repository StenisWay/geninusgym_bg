package Dao;

import java.util.List;

import android.bean.SportData;

public interface SportDataDao {
	int insert(SportData sportData);
	
	int deleteSet(String sd_record_id);
	
	List<SportData> selectAll();
}
