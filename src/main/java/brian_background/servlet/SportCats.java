package brian_background.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Dao.SportCatDao;
import DaoImpl.SportCatDaoImpl;
import android.bean.SportCat;
import brian_background.model.ClassInfoReturn;

@WebServlet("/sportcats")
public class SportCats extends HttpServlet{
	
	private SportCatDao service = null;
	
	@Override
	public void init() throws ServletException {
		service = new SportCatDaoImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Gson gson = new Gson();
		List<SportCat> sportCats = service.selectAll();
		resp.getWriter().write(gson.toJson(sportCats));
	}

}
