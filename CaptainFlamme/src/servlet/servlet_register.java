package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class servlet_register extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// 接受客户端的信息
		String name = req.getParameter("username");
		String phonenumber = req.getParameter("phonenumber");
		String password = req.getParameter("password");
		String realname = req.getParameter("realname");
		String sex= req.getParameter("sex");
		
		// 新建服务的对象
		
		serviceactivity.service s = new serviceactivity.service();
		s.db.connectDB();
		
		try {

			
			resp.setCharacterEncoding("UTF-8");
		//	System.out.println(name+phonenumber+password+studentId);
			int re =s.register(name, sex, realname, phonenumber, password);
         
			if (re!=0) {
				
			
			
			PrintWriter out = resp.getWriter();
			
			System.out.println(re);
			
			out.print("register success");

			out.flush();
			out.close();
			}else {
				PrintWriter out = resp.getWriter();
				
				System.out.println(re);
				
				out.print("register fail");

				out.flush();
				out.close();	
			}
			
			s.db.closeDB();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			s.db.closeDB();
		}

	}
}
	
	
	
	
	

