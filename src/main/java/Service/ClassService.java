package Service;

import java.util.List;

import android.bean.ClassInfo;

public interface ClassService {

	List<ClassInfo> findAll();

	boolean addInfo(ClassInfo classInfo);

	boolean editClass(ClassInfo classInfo);

	boolean editAvail(ClassInfo classInfo);

}
