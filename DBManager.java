package javaproject;
import javaproject.Main;
import java.sql.*;
final class DBManager {
	private Connection con = null;

	final private String driver = "com.mysql.cj.jdbc.Driver";
	final private String url = "jdbc:mysql://localhost:3306/oil_db?serverTimezone=UTC";
	final private String user = "root";
	final private String password = "1234";

	public DBManager() {
		connect();
	}

	public Connection getCon() {
		if (con == null) {
			connect();
			if (con == null) {
				getCon();
			}
		}

		return con;
	}

	private void connect() {
		if (con == null) {
			try {
				Class.forName(driver);
				this.con = DriverManager.getConnection(url, user, password);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			if (this.con == null) {
				System.out.println("DB 연결 실패");
			} else {
				System.out.println("DB 연결 성공");
			}
		}

	}

	void closeDB() {
		if (this.con != null) {
			try {
				this.con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	void closeDB(PreparedStatement pstmt, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	void closeDB(PreparedStatement pstmt) {

		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}