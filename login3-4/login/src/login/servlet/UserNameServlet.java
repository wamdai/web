package login.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import login.servies.UserService;
import login.servies.impl.UserServiceImpl;

/**
 * ajax判断用户名是否存在
 */
@WebServlet("/UserNameServlet.do")
public class UserNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	//对用户名是否重复进行验证
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        UserService us = new UserServiceImpl();
        Map<String, Object> hm = new HashMap<>();
        
        String userName=request.getParameter("userName");
    
        //为1用户名存在  为0用户名不存在
        int flagName=us.queryUsername(userName);
        if(flagName==1){
        	hm.put("code", 1);
        	hm.put("text", "输入的用户名已存在，请重新输入！");
        }else{
        	hm.put("code", 0);
        }
        
        
        
        //调用谷歌的gson库将map类型转换成json字符串
        String jsonStr = new Gson().toJson(hm);
        //字符流输出字符串
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print(jsonStr);
        out.flush();
        out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
