package serviceactivity;

import java.sql.ResultSet;
import java.sql.SQLException;

import db.DBmanager;

//���ڵ�¼��ע��
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

		// ��ȡDB����

		// �������ݿ�

		int rs = db.executeUpdate(sql);

		return rs;

	}

	// ��¼
	public ResultSet login(String password, String username) {
		// TODO Auto-generated method stub

		String sql = "select * from member where username='" + username
				+ "' and password='" + password + "'";

		
		
		
		
		// �������ݿ�

		ResultSet rs = db.executeQuery(sql);

		return rs;

	}

	// ��ѯ��Ƶֹͣ����
	public ResultSet getstoptimes(String username) {

		String sql = "select stoptimes from member where username='" + username
				+ "'";

		// ��ȡDB����
		db.connectDB();
		// �������ݿ�

		ResultSet rs = db.executeQuery(sql);

		return rs;

	}

	// ��ѯ�������
	public ResultSet getalerttimes(String username) {

		String sql = "select alerttime from member where username='" + username
				+ "'";

		// ��ȡDB����
		db.connectDB();
		// �������ݿ�

		ResultSet rs = db.executeQuery(sql);

		return rs;

	}

	// ����ֹͣ���� +1
	public int changestoptime(String username) {

		String sql = "select stoptimes from member where username='" + username
				+ "'";

		// ��ȡDB����
		db.connectDB();
		// �������ݿ�

		ResultSet rs = db.executeQuery(sql);

		try {
			while (rs.next()) {

				int beforetimes = rs.getInt(1);

				int nowtimes = beforetimes + 1;
				// Ȼ��������ݱ�ĸ���

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

	// ���ľ������

}
