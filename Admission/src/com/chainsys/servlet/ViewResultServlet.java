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

@WebServlet("/ViewResultServlet")
public class ViewResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		int id = (int) session.getAttribute("Id");
         ApplicationServices app = new ApplicationServices();
		boolean result = app.checkResult(id);
		if (result == true) {
			request.setAttribute("ERROR", "your application were selected");
			RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
			rd.forward(request, response);
		} else {
			request.setAttribute("ERROR", "your application were not selected. Apply for some other courses.");
			RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
			rd.forward(request, response);
		}
	}
}
