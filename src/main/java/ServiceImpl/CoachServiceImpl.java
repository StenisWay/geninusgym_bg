package ServiceImpl;

import java.util.List;

import Dao.CoachDao;
import DaoImpl.CoachDaoImpl;
import Service.CoachService;
import android.bean.Coach;

public class CoachServiceImpl implements CoachService{
	private CoachDao dao;
	
	public CoachServiceImpl() {
		dao = new CoachDaoImpl();
	}

	@Override
	public List<Coach> findAll() {
		return dao.selectAll();
	}
	
	

}
