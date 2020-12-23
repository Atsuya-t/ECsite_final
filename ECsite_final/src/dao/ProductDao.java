package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import model.ProductBean;

public class ProductDao extends Dao {
	public ArrayList<ProductBean> search() {
		ArrayList<ProductBean> productList = new ArrayList<ProductBean>();

		try {
			connection();
			st = cnct.createStatement();
			rs = st.executeQuery("select * from product");

			while (rs.next()) {
				productList.add(
						new ProductBean(
								rs.getInt("pro_cd"),
								rs.getString("pro_name"),
								rs.getInt("stock_no"),
								rs.getInt("pro_price"),
								0, "", ""));
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return productList;
	}

	public ArrayList<ProductBean> search(String keyword, int category) {
		ArrayList<ProductBean> productList = new ArrayList<ProductBean>();

		try {
			connection();

			String sql = "select * from product where pro_name like ? and cat_id=?";
			pst = cnct.prepareStatement(sql);
			pst.setString(1, "%" + keyword + "%");
			pst.setInt(2, category);
			rs = pst.executeQuery();

			while (rs.next()) {
				productList.add(
						new ProductBean(
								rs.getInt("pro_cd"),
								rs.getString("pro_name"),
								rs.getInt("stock_no"),
								rs.getInt("pro_price"),
								0, "", ""));
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return productList;
	}

	public ArrayList<ProductBean> search(String keyword) {
		ArrayList<ProductBean> productList = new ArrayList<ProductBean>();

		try {
			connection();

			String sql = "select * from product where pro_name like ?";
			pst = cnct.prepareStatement(sql);
			pst.setString(1, "%" + keyword + "%");
			rs = pst.executeQuery();

			while (rs.next()) {
				productList.add(
						new ProductBean(
								rs.getInt("pro_cd"),
								rs.getString("pro_name"),
								rs.getInt("stock_no"),
								rs.getInt("pro_price"),
								0, "", ""));
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return productList;
	}

	public ArrayList<ProductBean> search(int category) {
		ArrayList<ProductBean> productList = new ArrayList<ProductBean>();

		try {
			connection();

			String sql = "select * from product where cat_id=?";
			pst = cnct.prepareStatement(sql);
			pst.setInt(1, category);
			rs = pst.executeQuery();

			while (rs.next()) {
				productList.add(
						new ProductBean(
								rs.getInt("pro_cd"),
								rs.getString("pro_name"),
								rs.getInt("stock_no"),
								rs.getInt("pro_price"),
								0, "", ""));
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return productList;
	}

	public ProductBean select(int proCd) {
		ProductBean productBean = new ProductBean();

		try {
			connection();

			String sql = "select * from product where pro_cd=?";
			pst = cnct.prepareStatement(sql);
			pst.setInt(1, proCd);
			rs = pst.executeQuery();

			if (rs.next()) {
				productBean = new ProductBean(
						rs.getInt("pro_cd"),
						rs.getString("pro_name"),
						rs.getInt("stock_no"),
						rs.getInt("pro_price"),
						rs.getInt("cat_id"),
						rs.getString("pro_img"),
						rs.getString("pro_msg"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return productBean;
	}
}
