package util;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
	private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=libraryManagement";
	private static final String USER = "sa";
	private static final String PASSWORD = "123$";
	
	public static Connection openConnection(){
		Connection conn = null;
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	public static void closeConnection(Connection conn, CallableStatement callSt) {
		if(conn!=null) {
			try {
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		Connection conn = ConnectionDB.openConnection();
		if(conn!=null) System.out.println("ok");
		else System.out.println("not oke");
	}
}
