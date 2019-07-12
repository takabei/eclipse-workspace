package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import po.User;

public class UserServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserDao userDao = new UserDao();
	private ListServlet listServlet = new ListServlet();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String pass = req.getParameter("pass");
		User user = new User(name,pass);
		System.out.println(user);
		int num = userDao.login(user);
		if(num == 1) {
			listServlet.doGet(req, resp);
		} else {
			req.setAttribute("error", "用户名或密码错误!");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
