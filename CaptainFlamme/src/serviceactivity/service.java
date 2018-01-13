package serviceactivity;

import java.sql.ResultSet;
import java.sql.SQLException;

import db.DBmanager;

//用于登录和注册
public class service {

	public static DBmanager db = DBmanager.createInstance();

	public int register(String username, String sex, String realname,
			String phonenumber, String password) {

		String sql = " insert into member(username,password,realname,sex,telephone) values('"
				+ username
				+ "','"
				+ password
				+ "','"
				+ realname
				+ "','"
				+ sex
				+ "','" + phonenumber + "')";

		// 获取DB对象

		// 连接数据库

		int rs = db.executeUpdate(sql);

		return rs;

	}

	// 登录
	public ResultSet login(String password, String username) {
		// TODO Auto-generated method stub

		String sql = "select * from member where username='" + username
				+ "' and password='" + password + "'";

		
		
		
		
		// 连接数据库

		ResultSet rs = db.executeQuery(sql);

		return rs;

	}

	// 查询视频停止次数
	public ResultSet getstoptimes(String username) {

		String sql = "select stoptimes from member where username='" + username
				+ "'";

		// 获取DB对象
		db.connectDB();
		// 连接数据库

		ResultSet rs = db.executeQuery(sql);

		return rs;

	}

	// 查询警告次数
	public ResultSet getalerttimes(String username) {

		String sql = "select alerttime from member where username='" + username
				+ "'";

		// 获取DB对象
		db.connectDB();
		// 连接数据库

		ResultSet rs = db.executeQuery(sql);

		return rs;

	}

	// 更改停止次数 +1
	public int changestoptime(String username) {

		String sql = "select stoptimes from member where username='" + username
				+ "'";

		// 获取DB对象
		db.connectDB();
		// 连接数据库

		ResultSet rs = db.executeQuery(sql);

		try {
			while (rs.next()) {

				int beforetimes = rs.getInt(1);

				int nowtimes = beforetimes + 1;
				// 然后进行数据表的更新

				String newsql = "update member set stoptimes=" + nowtimes
						+ " where username='" + username + "'";
				System.out.println(newsql);
				int a = db.executeUpdate(newsql);
				return a;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;

	}

	// 更改警告次数

}
