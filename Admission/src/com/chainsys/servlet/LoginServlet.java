package com.chainsys.servlet;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.chainsys.dao.AdmissionDAO;
import com.chainsys.model.User;
import com.chainsys.services.UserServices;
import com.cs.auth.Authentication;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final Logger log= Logger.getLogger(LoginServlet.class);
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PropertyConfigurator.configure("D:\\chain sys\\Dev-Workspace\\Admission\\src\\log4j.properties");
		String username = request.getParameter("email");
		String password = request.getParameter("password");
		User user = new User();
		user.setEmail(username);
		user.setPassword(password);
		UserServices userservices = new UserServices();
		int id = userservices.get_user_id(user);
		String name=userservices.viewUserName(id);
		try {
			boolean success = Authentication.isLogin(username, password);
			if (success == true) {
				log.debug("Login Success");
				HttpSession session = request.getSession();
				session.setAttribute("Id", id);
				session.setAttribute("NAME", name);
				RequestDispatcher rd = request.getRequestDispatcher("homepage.jsp");
				rd.forward(request, response);
			} else {
				request.setAttribute("ERROR", "Invalid Email or Password. Try again");
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.include(request, response);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}