package spencer_playground;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import Dao.ClassDao;
import DaoImpl.ClassDaoImpl;
import android.bean.ClassInfo;

@WebServlet("/ClassInfo/*")
public class ClassInfoController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private static final Gson Gson = new GsonBuilder().setDateFormat("yyyy/MM/dd HH:mm:ss").create();
	private static final ClassDao classDaoImpl = new ClassDaoImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//super.doGet(req, resp);
		String c_id = req.getPathInfo().substring(1);
		
		List<ClassInfo> list = classDaoImpl.selectByCoach(c_id);
		String json = Gson.toJson(list);
		System.out.println("json" + json);
		resp.getWriter().write(json);
	}
}
