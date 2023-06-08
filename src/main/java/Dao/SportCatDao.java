package Dao;

import java.util.List;

import android.bean.SportCat;

public interface SportCatDao {
	int insert(SportCat sportCat);
	
	int delete(Integer sc_id);
	
	int update(SportCat sportCat);
	
	List<SportCat> selectAll();
}
