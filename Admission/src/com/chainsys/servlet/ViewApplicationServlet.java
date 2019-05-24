package com.chainsys.servlet;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.chainsys.model.Application;
import com.chainsys.services.ApplicationServices;

@WebServlet("/ViewApplication")
public class ViewApplicationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long phonenumber = Long.parseLong(request.getParameter("phonenumber"));
		List<Application> list = new LinkedList<Application>();
		ApplicationServices app = new ApplicationServices();
		list = app.viewApplication(phonenumber);
		request.setAttribute("USER", list);
		RequestDispatcher rd = request.getRequestDispatcher("user.jsp");
		rd.forward(request, response);
	}
}
