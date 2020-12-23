package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CategoryDao;
import dao.ProductDao;
import model.CategoryBean;
import model.ProductBean;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		if (session == null) {
			RequestDispatcher rd = request.getRequestDispatcher("/view/Login.jsp");
			rd.forward(request, response);
			return;
		}

		int proCd = Integer.parseInt(request.getParameter("procd"));
		ProductDao productDao = new ProductDao();
		CategoryDao categoryDao = new CategoryDao();

		ProductBean productBean = productDao.select(proCd);
		String categoryName = categoryDao.select(productBean.getCatId());
		session.setAttribute("product", productBean);
		request.setAttribute("catName", categoryName);

		RequestDispatcher rd = request.getRequestDispatcher("/view/ProductDetail.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		if (session == null) {
			RequestDispatcher rd = request.getRequestDispatcher("/view/Login.jsp");
			rd.forward(request, response);
			return;
		}

		request.setCharacterEncoding("UTF-8");
		String keyword = request.getParameter("keyword");
		String cate = request.getParameter("category");

		//カテゴリー情報取得
		CategoryDao categoryDao = new CategoryDao();
		ArrayList<CategoryBean> categoryList = categoryDao.selectAll();
		request.setAttribute("catList", categoryList);

		//検索機能使わないルート
		if (keyword == null && cate == null) {
			RequestDispatcher rd = request.getRequestDispatcher("/view/Search.jsp");
			rd.forward(request, response);
			return;
		}

		//検索ルート
		ProductDao productDao = new ProductDao();
		ArrayList<ProductBean> productList = new ArrayList<ProductBean>();
		int category = Integer.parseInt(cate);
		//カテゴリー"すべて"選択は-1で設定
		if (keyword != "" && category == -1) {
			productList = productDao.search(keyword);
		} else if (keyword == "" && category != -1) {
			productList = productDao.search(category);
		} else if (keyword != "" && category != -1) {
			productList = productDao.search(keyword, category);
		} else {
			productList = productDao.search();
		}

		if (productList.size() == 0) {
			request.setAttribute("errmsg", "検索結果が0件です。");
		}

		request.setAttribute("searchResult", productList);

		RequestDispatcher rd = request.getRequestDispatcher("/view/Search.jsp");
		rd.forward(request, response);

	}

}
