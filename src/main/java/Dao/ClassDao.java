package Dao;

import java.util.List;

import android.bean.ClassInfo;

public interface ClassDao {

	List<ClassInfo> selectAll();

	int insert(ClassInfo classInfo);

	int updateById(ClassInfo classInfo);

	int unRegisterById(ClassInfo classInfo);

}
