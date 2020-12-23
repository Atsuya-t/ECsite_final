package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Dao {
	String url = "jdbc:mysql://localhost/ec_ans?useSSL=false";
	String id = "root";
	String pw = "password";
	Connection cnct = null;
	Statement st = null;
	PreparedStatement pst = null;
	ResultSet rs = null;

	void connection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		cnct = DriverManager.getConnection(url,id,pw);
	}

	public void close() {
		try {
			if (rs!=null) rs.close();
			if (st!=null) st.close();
			if (pst!=null) pst.close();
			if (cnct!=null) cnct.close();
		}catch(Exception ex){

		}
	}
}
