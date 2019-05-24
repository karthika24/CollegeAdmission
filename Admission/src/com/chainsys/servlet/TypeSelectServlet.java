package com.chainsys.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.chainsys.dao.AdmissionDAO;
import com.chainsys.model.Quotation;
import com.chainsys.services.ApplicationServices;

@WebServlet("/TypeSelectServlet")
public class TypeSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String type = request.getParameter("pay");
		HttpSession session = request.getSession(false);
		int id = (int) session.getAttribute("Id");
		ApplicationServices app = new ApplicationServices();
		Quotation qobj = app.addQuotation(id, type);
		if ("merit".equalsIgnoreCase(type)) {
			request.setAttribute("result", "Payment Successful");
			RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
			rd.forward(request, response);
		} else if ("management".equalsIgnoreCase(type)) {
			float quote = Float.parseFloat(request.getParameter("quote"));
			qobj.setQuote(quote);
			boolean check = app.checkQuotation(id);
			if (check == true) {
				request.setAttribute("RESULT", "your quotation already added! view result");
				RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
				rd.forward(request, response);
			} else {
				app.insertQuotation(qobj);
				request.setAttribute("RESULT", qobj.getName() + " " + "your quotation noted");
				RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
				rd.forward(request, response);
			}
		}
	}
}
