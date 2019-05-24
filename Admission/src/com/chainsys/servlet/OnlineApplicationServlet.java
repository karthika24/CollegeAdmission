package com.chainsys.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.chainsys.services.ApplicationServices;

@WebServlet("/OnlineApplicationServlet")
public class OnlineApplicationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		int id = (int) session.getAttribute("Id");
		ApplicationServices app = new ApplicationServices();
		boolean result = app.checkApplication(id);
		if (result == true) {
			request.setAttribute("ERROR", "Already applied");
			RequestDispatcher rd = request.getRequestDispatcher("viewapplication.jsp");
			rd.include(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("application.jsp");
			rd.include(request, response);
		}
	}
}
