package login.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.domain.DownLoad;
import login.servies.DownLoadService;
import login.servies.impl.DownLoadServiceImpl;

/**
 * Servlet implementation class DownloadServlet
 * 资源下载
 */
@WebServlet("/DownloadServlet.do")
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	DownLoadService ds = new DownLoadServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1、根据id查询数据库参数
		String ids=request.getParameter("id");
		Integer id=Integer.parseInt(ids);
		
		DownLoad downLoad=ds.selectById(id);
		//获取要下载文件的路径 从数据库传入
		String path =request.getServletContext().getRealPath(downLoad.getPath());
		//2.获取要下载的文件名
		String fileName =path.substring(path.lastIndexOf("\\")+1);
		//3、设置content-disposition响应头控制浏览器以下载的形式打开文件
		response.setHeader("content-disposition", "attachment;filename="
				+URLEncoder.encode(fileName,"UTF-8"));
		//4.获取要下载的文件输入流
		FileInputStream in = new FileInputStream(path);
		int len=0;
		//5.创建数据缓冲区
		byte [] buffer =new byte[1024];
		
		ServletOutputStream out= response.getOutputStream();
		while((len=in.read(buffer))!=-1){
			out.write(buffer,0,len);
		}
		in.close();
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
