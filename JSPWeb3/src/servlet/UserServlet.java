package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import po.User;
import sun.print.resources.serviceui;
public class UserServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private UserDao userDao = new UserDao();
	private StudentServlet serviceui = new StudentServlet();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		User user = new User(username, password);
		user = userDao.Login(user);
		if(user == null) {
			req.setAttribute("error", "用户名或密码错误");
			req.getRequestDispatcher("/Login.jsp").forward(req, resp);
			return;
		}
		else {
			req.getSession().setAttribute("User", user);
			serviceui.doGet(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
