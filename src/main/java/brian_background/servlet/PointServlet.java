package brian_background.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import Dao.PointDao;
import Dao.SportCatDao;
import DaoImpl.PointDaoImpl;
import DaoImpl.SportCatDaoImpl;
import android.bean.Member;
import android.bean.Point;
import brian_background.model.HomeMessage;
import brian_background.service.PointService;
import brian_background.serviceimpl.PointServiceImpl;


@WebServlet("/member/point")
public class PointServlet extends HttpServlet{

	private PointService service = null;
	
	@Override
	public void init() throws ServletException {
		service = new PointServiceImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Gson gson = new Gson();
		HttpSession session = req.getSession();
		Member member = (Member) session.getAttribute("member");
		Integer left_point = service.getPoint(member.getM_id());
		System.out.println(session.getId());
		Point point = new Point();
		point.setP_left(left_point);
		System.out.println(member.getM_id());
		System.out.println(left_point);
	
		resp.getWriter().write(gson.toJson(point, Point.class));
	} 
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Gson gson = new Gson();
		HomeMessage message = gson.fromJson(req.getReader(),HomeMessage.class);
		Integer trasactionNumber = Integer.parseInt(message.getMessage());
		HttpSession session = req.getSession();
		Member member = (Member) session.getAttribute("member");
		Boolean success = service.transaction(member.getM_id(), trasactionNumber);
		JsonObject respBody = new JsonObject();
		
		if (success) {
			respBody.addProperty("message", "success");
		}else {
			respBody.addProperty("message", "false");
		}
		
		resp.getWriter().write(gson.toJson(respBody));
//		service.setFlag(); 
		
	}

}
