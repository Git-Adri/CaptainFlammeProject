package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class servlet_login extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// 接受客户端的信息
		
		String password = req.getParameter("password");
		String username = req.getParameter("username");
		// 新建服务的对象
	//System.out.println(password+studentId);	
		
		serviceactivity.service s = new serviceactivity.service();
		
		s.db.connectDB();
		try {

			
			resp.setCharacterEncoding("UTF-8");
			
			
			
			
	        ResultSet  rs =s.login(password, username);
         
	 
	 if(rs.next()){
			PrintWriter out = resp.getWriter();
			
		System.out.println("login success");	
			s.db.closeDB();
			out.print("login success");

			out.flush();
			out.close();}
	 
	 
	 else {
		 PrintWriter out = resp.getWriter();
			
			
			s.db.closeDB();
			out.print("login fail");

			out.flush();
			out.close();
	}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			s.db.closeDB();
		}

	}
}
	
	
	
	
	

