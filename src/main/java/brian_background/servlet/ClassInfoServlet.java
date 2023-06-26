package brian_background.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Dao.ClassInfoDao;
import DaoImpl.ClassInfoImpl;
import brian_background.model.ClassInfoReturn;

@WebServlet("/member/classinfo")
public class ClassInfoServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private ClassInfoDao classInfoImpl;
	@Override
	public void init() throws ServletException {
		classInfoImpl = new ClassInfoImpl();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Gson gson = new Gson();
		List<ClassInfoReturn> classInfoReturns = classInfoImpl.selectAll();
		resp.getWriter().write(gson.toJson(classInfoReturns));
	}
	
}
