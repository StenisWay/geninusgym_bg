package Dao;

import java.util.List;

import android.bean.ClassInfo;

public interface ClassDao {

	List<ClassInfo> selectAll();
	List<ClassInfo> selectByCoach(String c_id);

	int insert(ClassInfo classInfo);

	int updateById(ClassInfo classInfo);

	int unRegisterById(ClassInfo classInfo);

}
