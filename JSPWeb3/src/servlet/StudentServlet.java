package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDao;
import javafx.scene.control.Pagination;
import po.Student;

public class StudentServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private StudentDao studentDao = new StudentDao();
	
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//获取地址栏上的页码参数pagenow=33
		String page = request.getParameter("pagenow");
		int pagenow = 0;
		if(page==null){
			pagenow = 1;
		}else{
			pagenow = Integer.parseInt(page);
		}
		
		int pagesize = 24;
		List<Student> lists = new ArrayList<Student>();
		StudentDao studentDao = new StudentDao();
		lists = studentDao.findByPage(pagenow, pagesize);
		
		//计算一下，后台数据库有多少条数据
		int total = studentDao.findTotal();
		
		//计算一下，总共分了多少页？
		int pagetotal = 0;
		if(total % pagesize == 0){
			pagetotal = total / pagesize;
		}else{
			pagetotal = total / pagesize + 1;
		}
		
		
		//将获取的数据，请求转发到前台的jsp页面
		//将学生列表的数据放到request域中，方便请求转发，带到前台jsp页面数据
		request.setAttribute("pagenow", pagenow);
		request.setAttribute("lists", lists);
		request.setAttribute("pagetotal", pagetotal);
		request.getRequestDispatcher("/index.jsp").forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}


}
