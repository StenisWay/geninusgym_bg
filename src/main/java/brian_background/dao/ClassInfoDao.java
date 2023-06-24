package brian_background.dao;

import java.util.List;

import brian_background.model.ClassInfoReturn;

public interface ClassInfoDao {

	List<ClassInfoReturn> selectAll();
	
}
