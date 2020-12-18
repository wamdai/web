package login.servlet;

import java.util.List;
import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.domain.DownLoad;
import login.servies.DownLoadService;
import login.servies.impl.DownLoadServiceImpl;

/**
 * Servlet implementation class GetDownloadListServlet
 * 获取要下载文件列表，在jsp页面显示
 */
@WebServlet("/GetDownloadListServlet.do")
public class GetDownloadListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		
		//查询数据库路径，回显到jsp页面
		DownLoadService ds = new DownLoadServiceImpl();
		List<DownLoad> list =ds.selectAll();
		
		
		request.getSession().setAttribute("list", list);
		request.getRequestDispatcher("login/download.jsp").forward(request, response);
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
