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

/**
 * 更新用户修改信息
 */
@WebServlet("/UpdateUserByIDServlet.do")
public class UpdateUserByIDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        HttpSession session = request.getSession(true);

        String ids=request.getParameter("id");
		Integer sid = Integer.parseInt(ids);
		String userName=request.getParameter("userName");
        String Name=request.getParameter("Name");
        String email=request.getParameter("email");
        String shengfen=request.getParameter("shengfen");
        String city=request.getParameter("city");
        String password=request.getParameter("password");
        
        UserService us = new UserServiceImpl();
        Users users =new Users(sid,userName,password,Name,email,shengfen,city);
		int rows = us.updateUsers(users);
		
		if(rows >0){

			response.getWriter().print(" <script>alert('修改学生信息成功'); location.href='UserChangeServlet.do' </script>");
		}else{
			response.getWriter().print(" <script>alert('修改学生信息失败'); location.href='UserChangeServlet.do' </script>");
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
