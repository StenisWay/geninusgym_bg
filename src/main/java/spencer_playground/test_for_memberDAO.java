package spencer_playground;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import Dao.MemberDao;
import Dao.SportCatDao;
import DaoImpl.MemberDaoImpl;
import DaoImpl.SportCatDaoImpl;
import android.bean.Member;
import android.bean.SportCat;


@WebServlet("/test_for_memberDAO")
public class test_for_memberDAO extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Gson Gson = new GsonBuilder().setDateFormat("yyyy/MM/dd HH:mm:ss").create();
	private static final SportCatDao SportCatDaoImple = new SportCatDaoImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		SportCat sportCat = Gson.fromJson(req.getReader(), SportCat.class);
		//String id = req.getReader().readLine();
		int result = SportCatDaoImple.update(sportCat);
		JsonObject resBody = new JsonObject();
		resBody.addProperty("result", result);
		resp.getWriter().write(resBody.toString());
	}
}

