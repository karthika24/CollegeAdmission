package com.chainsys.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

@WebServlet("/AdmissionType")
public class AdmissionType extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession(false);
       int id= (int) session.getAttribute("Id");
       ApplicationServices app = new ApplicationServices();
		String name=app.getType(id);
		List<Quotation> list=app.applicationType(id, name);		
		if("merit".equalsIgnoreCase(name)) {
			request.setAttribute("USER", list);
			RequestDispatcher rd = request.getRequestDispatcher("merit.jsp");
			rd.forward(request, response);
		}
		else if("management".equalsIgnoreCase(name)) {
			request.setAttribute("USER", list);
			RequestDispatcher rd = request.getRequestDispatcher("management.jsp");
			rd.forward(request, response);
		}
	}
}
