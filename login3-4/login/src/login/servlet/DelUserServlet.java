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
 * 删除单个用户
 */
@WebServlet("/DelUserServlet.do")
public class DelUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ids=request.getParameter("id");
		Integer id = Integer.parseInt(ids);
		
		UserService us = new UserServiceImpl();
		
		Integer rows = us.delUserById(id);
		
		if(rows >0){
			response.getWriter().print(" <script>alert('删除成功'); location.href='UserChangeServlet.do' </script>");
		}else{
			response.getWriter().print(" <script>alert('删除失败'); location.href='UserChangeServlet.do' </script>");
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
