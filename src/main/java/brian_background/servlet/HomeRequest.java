package brian_background.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import Dao.ClassInfoDao;
import DaoImpl.ClassInfoImpl;
import android.bean.Member;
import brian_background.model.HomeMessage;
import brian_background.service.MeHomeService;
import brian_background.serviceimpl.MeHomeServiceImpl;

@WebServlet("/member/home")
public class HomeRequest extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private MeHomeService service;
	
	@Override
	public void init() throws ServletException {
		service = new MeHomeServiceImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		JsonObject respBody = new JsonObject();
		String mString = req.getParameter("message");
		System.out.println(mString);
		if (service.timeCompare(mString)) {
			service.personPlus();
			respBody.addProperty("sucess", true);
		}else {
			respBody.addProperty("sucess", false);
		}
		resp.getWriter().write(respBody.toString());
	}
	
}
