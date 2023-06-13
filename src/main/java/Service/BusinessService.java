package Service;

import java.util.List;

import android.bean.Business;

public interface BusinessService {

	List<Business> findAll();

	boolean register(Business business);

	boolean editBusiness(Business business);

	boolean editSuspend(Business business);

}
