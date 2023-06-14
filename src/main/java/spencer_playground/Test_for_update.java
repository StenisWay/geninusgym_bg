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

import Dao.NotifyDao;
import Dao.SportBigIdDao;
import Dao.SportCatDao;
import DaoImpl.NotifyDaoImpl;
import android.bean.Notify;
import android.bean.SportBigId;
import android.bean.SportCat;

@WebServlet("/Test_for_update")
public class Test_for_update extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Gson Gson = new GsonBuilder().setDateFormat("yyyy/MM/dd HH:mm:ss").create();
	private static final NotifyDao notifyDaoImpl = new NotifyDaoImpl();
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Notify notify = Gson.fromJson(req.getReader(), Notify.class);
		//String id = req.getReader().readLine();
		int result = notifyDaoImpl.update(notify);
		JsonObject resBody = new JsonObject();
		resBody.addProperty("result", result);
		resp.getWriter().write(resBody.toString());
	}
}
