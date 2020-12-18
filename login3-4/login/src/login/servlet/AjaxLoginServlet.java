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
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import login.domain.Users;
import login.servies.UserService;
import login.servies.impl.UserServiceImpl;

/**
 * Ajax登录
 */
@WebServlet("/AjaxLoginServlet.do")
public class AjaxLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        HttpSession session = request.getSession(true);
        UserService us = new UserServiceImpl();
        
        Map<String, Object> hm = new HashMap<>();
        
        String id=request.getParameter("id");
        //id不为2时执行if  为2时直接判断其他状态
        System.out.println("id!!!+"+id);
        String userName=request.getParameter("userName");
        String password=request.getParameter("password");
        String yanzhengma=request.getParameter("yanzhengma");
        String rememberMe=request.getParameter("dl");
        String code=(String) session.getAttribute("vcode");
     
    	if(id.equals("1")){
        	hm.put("text", "抱歉，您必须先登录才能访问该资源");
    		//request.getRequestDispatcher("login/error.jsp").forward(request, response);
        }
        
        if(session.isNew()) {
        	hm.put("text", "抱歉，您的登录已过期，请重新登录！");
    		//request.getRequestDispatcher("login/error.jsp").forward(request, response);
        }
       
      
        if(yanzhengma.equals(code)){
        	
          //  Users user = us.queryUser(userName, password);
            //为1用户名存在  为0用户名不存在
            int flagName=us.queryUsername(userName);
            //System.out.println("flagName:"+flagName);
            if(flagName==1){
            	//为1密码正确  为0密码错误
            	int flagPwd=us.queryUserPwd(userName,password);
            	if(flagPwd==1){
            		Users users =us.queryUser(userName, password);
    	        	if(rememberMe.equals("1")){
    	        		session.setMaxInactiveInterval(60*60*24*7);
    	        	}else if (rememberMe.equals("0")) {
    	        		session.setMaxInactiveInterval(10);
					}
    	        	session.setAttribute("userName",userName);
    	        	session.setAttribute("role", users.getRole());
    	        	hm.put("codes", 0);
    	        	hm.put("text", "登录成功！");
    	        	
    	        	//request.getRequestDispatcher("LoginServlet.do").forward(request, response);
            	}else {
            		hm.put("codes", 1);
            		hm.put("text", "抱歉，您输入的密码不正确");
            		//request.getRequestDispatcher("login/error.jsp").forward(request, response);
    			}
            }else if(flagName==0){
            	hm.put("codes", 1);
            	hm.put("text", "抱歉，您输入的用户名不存在");
        		//request.getRequestDispatcher("login/error.jsp").forward(request, response);
            }
        }else{
        	hm.put("codes", 1);
        	hm.put("text", "抱歉，您输入的验证码不正确");
    		//request.getRequestDispatcher("login/error.jsp").forward(request, response);
   
        }
        
        System.out.println("用户名："+userName+"密码："+password);
        System.out.println("codes="+hm.get("codes"));
        //调用谷歌的gson库将map类型转换成json字符串
        String jsonStr = new Gson().toJson(hm);
        //字符流输出字符串
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print(jsonStr);
        out.flush();
        out.close();
      //  request.getRequestDispatcher("LoginServlet.do").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
