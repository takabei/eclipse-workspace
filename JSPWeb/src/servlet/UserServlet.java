package servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.servlet.BaseServlet;
import dao.User;
import service.UserService;

public class UserServlet extends BaseServlet{

	private static final long serialVersionUID = 1L;
	private UserService userService = new UserService();
	
	public String Login(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		System.out.println("username = "+username);
		System.out.println("password = " + password);
		User user = new User();
		user.setPassword(password);
		user.setUsername(username);
		
		Map<String, Object> map = checkout(user);
		if(map.size() > 0) {
			req.setAttribute("error", map);
			return "f:user/Login.jsp";
		}
		boolean bool = userService.Login(user);
		if(bool) {
			req.getSession().setAttribute("SessionUser", user);
			return "r:index.jsp";
		}
		else {
			req.setAttribute("err", "用户名或密码错误!");
			return "f:user/Login.jsp";
		}
	}
	
	private Map<String, Object> checkout(User user){
		Map<String, Object> map = new HashMap<String, Object>();
		String username = user.getUsername();
		if(username == null || username.trim().isEmpty() ) {
			map.put("username", "用户名不能为空!");
		} else if(!user.getUsername().matches("[a-zA-Z0-9]{1,10}")) {
			map.put("username", "用户名的长度不符合规则:1-10个字符");
		}
		
		String password = user.getPassword();
		if(password == null || password.trim().isEmpty())
			map.put("password", "密码不能为空!");
		else if(!user.getPassword().matches("[a-zA-Z0-9]{1,10}"))
			map.put("password", "密码的长度不符合规则:1-10个字符");
		return map;
	}
//	public static void main(String[] args) {
//		System.out.println("123".matches("[a-zA-Z0-9]{1,10}"));
//	}
}
