package servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import pojo.User;

public class UserServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private UserDao userDao = new UserDao();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		User user = new User();
		user.setPassword(password);
		user.setUsername(username);
		
		boolean bool = userDao.Login(user);
		if(bool) {
			req.getSession().setAttribute("SessionUser", user);
			resp.sendRedirect("index.jsp");
		}
		else {
			req.setAttribute("err", "用户名或密码错误!");
			req.getRequestDispatcher("Login.jsp").forward(req, resp);
		}
	}
	
	
	
	
}
