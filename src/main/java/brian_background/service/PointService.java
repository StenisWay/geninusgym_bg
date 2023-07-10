package brian_background.service;

import Dao.PointDao;
import DaoImpl.PointDaoImpl;
import android.bean.Point;

public interface PointService {

   Integer getPoint(String m_id);
	
   public Boolean transaction(String m_id ,Integer point);
   
}
