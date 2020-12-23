package controller;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");

		if(name.equals("") || pass.equals("")) {
			request.setAttribute("errmsg","入力がされていない箇所があります");
			RequestDispatcher rd = request.getRequestDispatcher("/view/Login.jsp");
			rd.forward(request,response);
			return;
		}

		UserDao userDao = new UserDao();
		int userId = userDao.login(name, pass);

		if(userId == -1) {
			request.setAttribute("errmsg","入力した値が間違っています。");
			RequestDispatcher rd = request.getRequestDispatcher("/view/Login.jsp");
			rd.forward(request,response);
		}else {
			HttpSession session = request.getSession(true);
			session.setAttribute("userId",userId);
			RequestDispatcher rd = request.getRequestDispatcher("/search");
			rd.forward(request,response);
		}
	}

}
