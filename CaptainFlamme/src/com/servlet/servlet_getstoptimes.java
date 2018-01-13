package com.servlet;

//用于获取用户暂停的次数
//username
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class servlet_getstoptimes extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// 接受客户端的信息
		String username = req.getParameter("username");
		// 新建服务的对象
		com.serviceactivity.service se = new com.serviceactivity.service();
		se.db.connectDB();
		try {
			ResultSet result = se.getstoptimes(username);

			resp.setCharacterEncoding("UTF-8");

			while (result.next()) {
				// String id = result.getString("id");

				int times = result.getInt(1);

				PrintWriter out = resp.getWriter();
				out.print(times);

				out.flush();
				out.close();
				se.db.closeDB();
			}

			// result.beforeFirst();
			// if(!result.next()){
			// // System.out.println("daskl");
			// PrintWriter out = resp.getWriter();
			// out.print(" ");
			//
			// out.flush();
			//
			// out.close();
			// // System.out.println("daskl");
			//
			// }

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			se.db.closeDB();
		}

	}

}
