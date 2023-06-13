package Dao;

import java.util.List;

import android.bean.Business;

public interface BusinessDao {
	int insert(Business business);

	int unRegisterById(Business business);// 此不是真實刪除，

	int updateById(Business business);

	List<Business> selectAll();
}
