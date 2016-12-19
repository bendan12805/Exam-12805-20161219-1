package exam.jdbc;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionFactory {
	private static final ConnectionFactory factory = 
			                  new ConnectionFactory();
	private Connection conn;

	private ConnectionFactory() {}

	public static ConnectionFactory getInstance() {

		return factory;
	}

	public Connection makeConnection() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/sakila", 
					"root", "mysql");
		} catch (Exception e) {
			System.out.println("数据库连接失败！");
			e.printStackTrace();
		}

		return conn;
	}

}

