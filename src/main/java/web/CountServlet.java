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
		 * �Ȳ鿴��û��count��cookie�����û�У���Ӹ�Cookie ֵΪ1
		 * ����н�ֵ��1�� �ٽ�cookie��ֵ���͸������
		 */
		String count = CookieUtil.finsCookie("count", request);
		if (count==null) {
			CookieUtil.addCookie("count", "1", 30*24*60*60, "/day06-lab", response);
			out.println("��ĵ�һ�θ����ң�");
		}else {
			int number = Integer.parseInt(count)+1;
			CookieUtil.addCookie("count", number+"", 30*24*60*60,"/day06-lab", response);
			out.println("���ǵ�"+number+"�η��ʣ�");
		}
	}

}
