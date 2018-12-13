package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conn_class2Basic {
	private String driverClassName = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/test?serverTimezone=GMT%2B8";
	private String userName = "root";
	private String password = "123456";

	private static Conn_class2Basic conn = null;
	
	private Conn_class2Basic() {
		try {
			Class.forName(driverClassName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
	
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, userName, password);
	}
	
	public static Conn_class2Basic getInstance() {
		if(null == conn) {
			conn = new Conn_class2Basic();
		}
		return conn;
	}
}
