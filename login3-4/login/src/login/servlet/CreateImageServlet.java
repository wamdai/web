package login.servlet;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import login.utils.CreateCodeImage;

/**
 *创建验证码图片
 */
@WebServlet("/CreateImageServlet.do")
public class CreateImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//File file =new File("G:/zuoye/eclipase`s/login/WebContent/login/images/test.jpeg");
		
		/*// 禁止缓存
         response.setHeader("Cache-Control", "no-cache");
         response.setHeader("Pragma", "no-cache");
         response.setDateHeader("Expires", -1);
*/
		
		//吧验证码图片生成的过程封装在utils包下面的createimage类里面
		CreateCodeImage createCodeImage = new CreateCodeImage();
		//产生四位随机字符
		String vcode=createCodeImage.createCode();
		String vcode1=this.getCode(vcode);
		System.out.println(vcode1);
		//获取session对象
		HttpSession session = request.getSession(true);
		//将产生的四位数随机字符串存放在session中
		session.setAttribute("vcode", vcode);
		//设置返回的内容
		response.setContentType("img/jpeg");
		//浏览器不缓存响应内容 验证码图片点击一下刷新一下
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		//设置验证码失效时间
		response.setDateHeader("Expires", 0);
		//以字节流发过去，交给img的src属性刷新
		BufferedImage image=createCodeImage.createImage(vcode);
		
		ServletOutputStream out=response.getOutputStream();
		ImageIO.write(image, "JPEG", out);	
	
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

	public String getCode(String code) {
		return code;
	}
}
