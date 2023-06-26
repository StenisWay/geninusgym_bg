package brian_background.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Dao.BranchDao;
import DaoImpl.BranchDaoImpl;
import android.bean.Branch;

@WebServlet("/member/branch")
public class BranchServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private BranchDao branchDao;
	
	@Override
	public void init() throws ServletException {
		branchDao = new BranchDaoImpl();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Gson gson = new Gson();
		List<Branch> branchs = branchDao.selectAll();
		resp.getWriter().write(gson.toJson(branchs));
	}

}
