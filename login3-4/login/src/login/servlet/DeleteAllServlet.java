package login.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.servies.UserService;
import login.servies.impl.UserServiceImpl;

/**
 * Servlet implementation class DeleteAllServlet
 */
@WebServlet("/DeleteAllServlet.do")
public class DeleteAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		//获取所有勾选的表单中的value值
		String [] ids = request.getParameterValues("checkbox");
		
		//数据类型转换
		int length = ids.length;
		Integer [] sid = new Integer[length];
		for(int i=0;i<length;i++){
			sid[i] = Integer.parseInt(ids[i]);
			System.out.println(sid[i]);
		}
		
		UserService us = new UserServiceImpl();
		
		int rows =us.delUsersAll(sid);
		
		if(rows >0){
			response.getWriter().print(" <script>alert('批量删除成功'); location.href='UserChangeServlet.do' </script>");
		}else{
			response.getWriter().print(" <script>alert('批量删除失败'); location.href='UserChangeServlet.do' </script>");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
