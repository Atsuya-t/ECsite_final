package dao;

import java.sql.SQLException;

public class UserDao extends Dao{

	public int login(String name,String pass) {
		int userId=-1;
		try {
			connection();

			pst = cnct.prepareStatement("select user_id from user where login_cd=? and login_pw=?");
			pst.setString(1,name);
			pst.setString(2,pass);
			rs = pst.executeQuery();

			if(rs.next()) {
				userId = rs.getInt("user_id");
			}


		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally{
			close();
		}

		return userId;
	}
}
