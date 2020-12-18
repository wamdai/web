package login.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.domain.Users;
import login.servies.UserService;
import login.servies.impl.UserServiceImpl;

/**
 * 查询单个用户信息并且进行转发与jsp页面回显
 */
@WebServlet("/FindUserByIDServlet.do")
public class FindUserByIDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String ids=request.getParameter("id");
		Integer sid = Integer.parseInt(ids);
		
		 UserService us = new UserServiceImpl();
		Users user=us.findUserByID(sid);
				
				
		//存
		request.setAttribute("user", user);
				
		//转
		request.getRequestDispatcher("login/updateUser.jsp").forward(request, response);


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
