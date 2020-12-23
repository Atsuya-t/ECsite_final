package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import model.CategoryBean;

public class CategoryDao extends Dao {

	public ArrayList<CategoryBean> selectAll() {
		ArrayList<CategoryBean> catList = new ArrayList<CategoryBean>();

		try {
			connection();
			st = cnct.createStatement();
			rs = st.executeQuery("select * from category");

			while (rs.next()) {
				catList.add(new CategoryBean(rs.getInt("cat_id"), rs.getString("cat_name")));
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return catList;
	}

	public String select(int catId) {
		String catName = "";

		try {
			connection();

			String sql = "select * from category where cat_id=?";
			pst = cnct.prepareStatement(sql);
			pst.setInt(1, catId);
			rs = pst.executeQuery();

			if (rs.next()) {
				catName = rs.getString("cat_name");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return catName;
	}
}
