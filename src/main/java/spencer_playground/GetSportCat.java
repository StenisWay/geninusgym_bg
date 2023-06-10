package spencer_playground;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import Dao.SportBigIdDao;
import Dao.SportCatDao;
import DaoImpl.SportBigIdDaoImpl;
import DaoImpl.SportCatDaoImpl;
import android.bean.SportBigId;
import android.bean.SportCat;

@WebServlet("/GetSportCat")
public class GetSportCat extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private static SportCatDao sportCatDao = new SportCatDaoImpl();
	private static SportBigIdDao sportBigDao = new SportBigIdDaoImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<SportCat> list = sportCatDao.selectAll();
		Gson gson = new Gson();
		String jsonIn = gson.toJson(list);
		resp.getWriter().write(jsonIn);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<SportBigId> list = sportBigDao.selectAll();
		Gson gson = new Gson();
		String jsonIn = gson.toJson(list);
		resp.getWriter().write(jsonIn);
	}
}
