package servlet;

//���ڻ�ȡ�趨�û���ͣ�Ĵ�������һ
//username
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class servlet_setstoptimes extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// ���ܿͻ��˵���Ϣ
		String username = req.getParameter("username");
		// �½�����Ķ���
		serviceactivity.service se = new serviceactivity.service();

		se.db.connectDB();

		int result = se.changestoptime(username);

		resp.setCharacterEncoding("UTF-8");
		// ���³ɹ�
		if (result != 0) {

			// String id = result.getString("id");

			PrintWriter out = resp.getWriter();
			out.print("update success");
			se.db.closeDB();
			out.flush();
			out.close();
		} else {

			PrintWriter out = resp.getWriter();
			out.print("update fail");
			se.db.closeDB();
			out.flush();
			out.close();

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

	}

}
