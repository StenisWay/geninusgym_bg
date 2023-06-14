package Dao;

import java.util.List;

import android.bean.Notify;

public interface NotifyDao {
	int insert(Notify notify);
	
	int delete(Integer nt_id);
	
	int update(Notify notify);
	
	List<Notify> selectALL();
}
