package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDao;
import po.PageBean;

public class ListServlet extends HttpServlet {
	private StudentDao studentDao = new StudentDao();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String code = req.getParameter("pageCode");
		int pageCode = 1;
		if (code != null)
			pageCode = Integer.parseInt(code);
		String url = req.getRequestURI() + "?" + req.getQueryString();
		int index = url.lastIndexOf("&pc=");
		if (index != -1) {
			url = url.substring(0, index);
		}
		PageBean pageBean = studentDao.findPage(pageCode);
		pageBean.setUrl(url);
		req.setAttribute("pageBean", pageBean);
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
