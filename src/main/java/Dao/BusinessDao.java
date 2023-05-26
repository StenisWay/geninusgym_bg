package Dao;

import java.util.List;

import android.bean.Business;

public interface BusinessDao {
	int insert(Business business);

	int unRegisterById(String id);// 此不是真實刪除，

	int updateById(Business business);

	List<Business> selectAll();
}
