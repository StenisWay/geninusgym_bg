//package spencer_playground;
//
//import java.io.IOException;
//import java.lang.reflect.Type;
//import java.util.List;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//import com.google.gson.reflect.TypeToken;
//
//import Dao.SportDataDao;
//import DaoImpl.SportDataDaoImpl;
//import android.bean.SportData;
//
//@WebServlet("/DeleteSportData")
//public class DeleteSportData extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//	private static final Gson Gson = new GsonBuilder().setDateFormat("yyyy/MM/dd HH:mm:ss").setLenient().create();
//	private static final SportDataDao SportDataDaoImpl = new SportDataDaoImpl();
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String sd_record_id = req.getReader().readLine();		
//		Integer a = SportDataDaoImpl.deleteSet(sd_record_id);
//		System.out.println(a.toString());
//		resp.getWriter().write(a.toString());
//	}
//}
