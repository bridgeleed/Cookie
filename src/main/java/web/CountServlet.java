package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.CookieUtil;

public class CountServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		/**
		 * 先查看有没有count的cookie，如果没有，添加该Cookie 值为1
		 * 如果有将值加1后 再将cookie的值发送给浏览器
		 */
		String count = CookieUtil.finsCookie("count", request);
		if (count==null) {
			CookieUtil.addCookie("count", "1", 30*24*60*60, "/day06-lab", response);
			out.println("你的第一次给了我！");
		}else {
			int number = Integer.parseInt(count)+1;
			CookieUtil.addCookie("count", number+"", 30*24*60*60,"/day06-lab", response);
			out.println("你是第"+number+"次访问！");
		}
	}

}
