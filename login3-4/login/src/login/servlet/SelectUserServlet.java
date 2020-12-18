package login.servlet;

import java.util.List;
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
 * 查询所有用户信息显示在userchange.jsp页面
 */
@WebServlet("/SelectUserServlet.do")
public class SelectUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
	
        UserService us = new UserServiceImpl();
        List<Users> list=us.selectUserAll();
        request.setAttribute("list", list);
    	request.getRequestDispatcher("login/userChange.jsp").forward(request, response);
    	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
