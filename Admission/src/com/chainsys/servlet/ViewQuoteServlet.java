package com.chainsys.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.dao.AdmissionDAO;
import com.chainsys.model.Quotation;
import com.chainsys.services.ApplicationServices;
import com.chainsys.services.ResultService;

@WebServlet("/ViewQuoteServlet")
public class ViewQuoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String department = request.getParameter("department");
		ResultService result = new ResultService();
		int quoteresult = result.collegeBidding(department);
        ApplicationServices app = new ApplicationServices();
		app.addResult(quoteresult);
		String name = app.getUsername(quoteresult);
		List<Quotation> list = app.viewQuotation(quoteresult);
		request.setAttribute("USER", list);
		request.setAttribute("result", name + " " + "Selected in the bidding");
		RequestDispatcher rd = request.getRequestDispatcher("biddingresult.jsp");
		rd.forward(request, response);
	}
}
