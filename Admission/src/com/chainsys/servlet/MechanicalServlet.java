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
import com.chainsys.services.AdminServices;

@WebServlet("/MechanicalServlet")
public class MechanicalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String department = "mechanical engineering";
		AdminServices admin=new AdminServices();
		List<Quotation> list = admin.viewQuotationByDept(department);
		request.setAttribute("USER", list);
		RequestDispatcher rd = request.getRequestDispatcher("quotation.jsp");
		rd.forward(request, response);
	}
}
