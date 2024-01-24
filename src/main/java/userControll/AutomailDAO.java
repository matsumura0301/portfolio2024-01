package userControll;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AutomailDAO {
	private final String DSN = "jdbc:mysql://localhost:3306/automail";
	private final String USER = "root";
	private final String PASSWORD ="pass";
	
	Connection conn = null;

    public Connection getConnection() {
    	
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		
    		conn = DriverManager.getConnection(DSN, USER, PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			
		}catch(SQLException e){
			e.printStackTrace();
		}
    	
    return conn;
    }

	//Connection 型変数に関するリソース解放
	public void close(Connection conn) {
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	//Statement 型変数に関するリソース解放
	public void close(Statement stmt) {
		if(stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public void close(ResultSet rset) {
		if(rset != null) {
			try {
				rset.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}