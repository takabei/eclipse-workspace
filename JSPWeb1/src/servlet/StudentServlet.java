package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import cn.itcast.servlet.BaseServlet;
import damain.Student;
import service.StudentService;
import utils.PageBean;
import utils.Pagination;


public class StudentServlet extends BaseServlet{
	private static final long serialVersionUID = 1L;
	private StudentService studentService = new StudentService();
	
	
	/**
	 * 获取当前页码
	 * @param req
	 * @return
	 */
	private int getPc(HttpServletRequest req) {
		int pc = 1;
		String param = req.getParameter("pc");
		if(param != null && !param.trim().isEmpty()) {
			try {
				pc = Integer.parseInt(param);
			} catch(RuntimeException e) {}
		}
		return pc;
	}
	
	/**
	 * 截取url，页面中的分页导航中需要使用它做为超链接的目标！
	 * @param req
	 * @return
	 */
	
	private String getUrl(HttpServletRequest req) {
		String url = req.getRequestURI() + "?" + req.getQueryString();
		int index = url.lastIndexOf("&pc=");
		if(index != -1) {
			url = url.substring(0, index);
		}
		return url;
	}
	
	public String findList(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int pc = getPc(req);
		String url = getUrl(req);
		PageBean<Student> pb = studentService.findList(pc);
		pb.setUrl(url);
		req.setAttribute("pb", pb);
		req.setAttribute("page", Pagination.getPagination(pc, pb.getTp(), pb.getTr(), pb.getUrl()));
		return  "f:student/list.jsp";
	}

}
