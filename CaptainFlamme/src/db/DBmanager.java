package db;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

//������Ҫ����ɺ����ݿ�����ӣ��Ի��������ݿ�����Ľ��з����ϵĶ��壬��������ʹ��
public class DBmanager {

	
	
	// ���ݿ����ӳ���
    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String USER = "Captain";
    public static final String PASS = "123456";
    public static final String URL = "jdbc:mysql://localhost:3306/Captain";

    // ��̬��Ա��֧�ֵ�̬ģʽ
    private static DBmanager per = null;
    private Connection conn = null;
    private Statement stmt = null;
	
	private PreparedStatement pstmt;
	// �����ѯ���صĽ������
	private ResultSet resultSet;

    
    private DBmanager() {
    }

    public static DBmanager createInstance() {
        if (per == null) {
            per = new DBmanager();
            per.initDB();
        }
        return per;
    }

    public void initDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
 // �������ݿ⣬��ȡ���+����
    public void connectDB() {
        System.out.println("Connecting to database...");
        try {
            conn = (Connection) DriverManager.getConnection(URL, USER, PASS);
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("SqlManager:Connect to database successful.");
    }
    
    
 // �ر����ݿ� �رն����ͷž��
    public void closeDB() {
        System.out.println("Close connection to database..");
        try {
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Close connection successful");
    }

    // ��ѯ
    public ResultSet executeQuery(String sql) {
        ResultSet rs = null;
        try {
        	connectDB();
         
        	rs = stmt.executeQuery(sql);
            closeDB();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    // ����/ɾ��/�޸�
    public int executeUpdate(String sql) {
        int ret = 0;
        try {
            ret = stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ret;
    }

    
    
    public List<Map<String, Object>> cexecuteQuery(String sql,
			List<Object> params) throws SQLException {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		int index = 1;
		pstmt = conn.prepareStatement(sql);
		if (params != null && !params.isEmpty()) {
			for (int i = 0; i < params.size(); i++) {
				pstmt.setObject(index++, params.get(i));
			}
		}
		resultSet = pstmt.executeQuery();
		ResultSetMetaData metaData = resultSet.getMetaData();
		int cols_len = metaData.getColumnCount();
		while (resultSet.next()) {
			Map<String, Object> map = new HashMap<String, Object>();
			for (int i = 0; i < cols_len; i++) {
				String cols_name = metaData.getColumnName(i + 1);
				Object cols_value = resultSet.getObject(cols_name);
				if (cols_value == null) {
					cols_value = "";
				}
				map.put(cols_name, cols_value);
			}
			list.add(map);
		}
		System.out.println("��ѯ���ݿ�ɹ�!!");
		return list;
	}


    
    
	
}
