package login.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class QuanxianFilter
 */
@WebFilter("/QuanxianFilter")
public class QuanxianFilter implements Filter {

	private String notCheckPath; //不要求过滤的地址，从web.xml中读取
    public QuanxianFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request =(HttpServletRequest)req;
		String path = request.getServletPath();
		System.out.println("请求地址uri："+path);
		if (notCheckPath.indexOf(path)==-1) {
			HttpSession session =request.getSession();
			System.out.println("role:"+session.getAttribute("role"));
			if (session.getAttribute("role").equals("2")) {
				request.setAttribute("text", "没有访问权限");
				request.getRequestDispatcher("login/error.jsp").forward(request, resp);
			}else {
				chain.doFilter(req, resp);
				System.out.println("通过验证！");
			}
		}else {
			chain.doFilter(req, resp);
			System.out.println("地址不需要过滤");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		notCheckPath = fConfig.getInitParameter("notCheckPath");
	}

}
