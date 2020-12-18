package login.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import login.domain.Users;
import login.servies.UserService;
import login.servies.impl.UserServiceImpl;
import login.utils.PageBean;

/**
 * 
 * 用户管理 
 */
@WebServlet(name = "UserChangeServlet.do", urlPatterns = { "/UserChangeServlet.do" })
public class UserChangeServlet extends HttpServlet {
private static final long serialVersionUID = 1L;

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        UserService us = new UserServiceImpl();
        HttpSession session = request.getSession(true);
		//request.getRequestDispatcher("login/userChange.jsp").forward(request, response);


        //获取用户当前的页码
		String pageNO =request.getParameter("pageNos");

		//获取用户提交的查询信息
		String userName =request.getParameter("userName");
		String Name =request.getParameter("Name");
		String email =request.getParameter("email");
		String shengfen =request.getParameter("shengfen");

		//判断用户是否是第一次访问
		if(pageNO ==null){
			pageNO="1";
		}
		
		//获取用户当前的页码
		Integer pageNos =Integer.parseInt(pageNO);
		
		
		//每次显示的数据
		Integer pageSize=4;
		
		//调
		PageBean<Users> pb =us.getPageBean(pageNos, pageSize,userName,Name,email,shengfen);
		
		
		//存
		request.setAttribute("pb", pb);
		request.setAttribute("userName", userName);
		request.setAttribute("Name", Name);
		request.setAttribute("email", email);
		request.setAttribute("shengfen", shengfen);	
		//转
		request.getRequestDispatcher("login/userChange.jsp").forward(request, response);

	 }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}