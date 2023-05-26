package Dao;

import java.util.List;

import android.bean.BodyData;

public interface BodyDataDao {
	int insert(BodyData bodyData);

	int updateById(BodyData bodyData);

	List<BodyData> selectAll();
	
	BodyData selectById(String id);
}
