package spencer_playground;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import Dao.BodyDataDao;
import Dao.MemberDao;
import DaoImpl.BodyDataDaoImpl;
import DaoImpl.MemberDaoImpl;
import android.bean.BodyData;
import android.bean.Member;

@WebServlet("/GetMemberStatic")
public class GetMemberStatic extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Gson Gson = new GsonBuilder().setDateFormat("yyyy/MM/dd HH:mm:ss").create();
	private static final BodyDataDao bodyDataDaoImpl = new BodyDataDaoImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = Gson.fromJson(req.getReader(), BodyData.class).getM_id();
		BodyData bodyData = bodyDataDaoImpl.selectById(id);
		System.out.println(id + bodyData.getM_id());
		String resBody = Gson.toJson(bodyData);
		resp.getWriter().write(resBody.toString());
	}
}
