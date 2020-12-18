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
 * 对邮箱是否重复进行验证
 */
@WebServlet("/EmailServlet.do")
public class EmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//对邮箱是否重复进行验证
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        UserService us = new UserServiceImpl();
        Map<String, Object> hm = new HashMap<>();
        
        String email=request.getParameter("email");
    
        //为1邮箱存在  为0邮箱不存在
        int flagName=us.queryEmailname(email);
        if(flagName==1){
        	hm.put("code", 1);
        	hm.put("text", "输入的邮箱已存在，请重新输入！");
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
        out.close();	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
