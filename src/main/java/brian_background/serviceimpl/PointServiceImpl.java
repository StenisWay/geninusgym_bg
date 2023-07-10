package brian_background.serviceimpl;

import java.util.List;

import Dao.PointDao;
import DaoImpl.PointDaoImpl;
import android.bean.Point;
import brian_background.service.PointService;

public class PointServiceImpl implements PointService{

private PointDao dao = new PointDaoImpl();

	
	@Override
	public Integer getPoint(String m_id) {
		return dao.selectPointById(m_id);
		
	}
	
	@Override
	public synchronized Boolean transaction(String m_id ,Integer transactionPoint) {

		Integer left_point = getPoint(m_id);
		left_point += transactionPoint;
		return dao.updateById(m_id, left_point);
	}
	



}
