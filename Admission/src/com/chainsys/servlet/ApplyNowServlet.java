package com.chainsys.servlet;

import java.io.IOException;
import java.time.LocalDate;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.dao.AdmissionDAO;
import com.chainsys.exception.AdmissionException;
import com.chainsys.exception.PhoneException;
import com.chainsys.model.Application;
import com.chainsys.services.ApplicationServices;
import com.chainsys.services.CheckMarks;

@WebServlet("/ApplyNowServlet")
public class ApplyNowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String fathername = request.getParameter("fathername");
		String param = request.getParameter("gender");
		char gender = param.charAt(0);
		LocalDate dateofbirth = LocalDate.parse(request.getParameter("dateofbirth"));
		Long phonenumber = Long.parseLong(request.getParameter("phoneNumber"));
		String country = request.getParameter("country");
		String state = request.getParameter("state");
		String district = request.getParameter("district");
		String schoolname = request.getParameter("schoolname");
		int totalmark = Integer.parseInt(request.getParameter("totalmark"));
		String course = request.getParameter("course");
		int department = Integer.parseInt(request.getParameter("departments"));
		int branch = Integer.parseInt(request.getParameter("branch"));
		String type = request.getParameter("type");
		HttpSession session = request.getSession(false);
		int id = (int) session.getAttribute("Id");
		CheckMarks check = new CheckMarks();
		boolean select = check.checkMarks(totalmark, type);
		System.out.println("in servlet" + select);
		if (select) {
			Application application = new Application();
			application.setCountry(country);
			application.setCourse(course);
			application.setDate_of_birth(dateofbirth);
			application.setDistrict(district);
			application.setGender(gender);
			application.setPhone_number(phonenumber);
			application.setFather_name(fathername);
			application.setName(name);
			application.setSchool_name(schoolname);
			application.setState(state);
			application.setTotal_mark(totalmark);
			application.setDepartment(department);
			application.setBranch(branch);
			application.setType(type);
			application.setCreated_date(LocalDate.now());
			application.setModified_date(LocalDate.now());
			application.setCreated_by(id);
			application.setModified_by(id);
			application.setUser_id(id);
			boolean result;
			ApplicationServices app = new ApplicationServices();
			try {
				result = app.insertApplication(application);
				if (result) {
					request.setAttribute("RESULT", "Registration Successfully");
					RequestDispatcher rd = request.getRequestDispatcher("application.jsp");
					rd.forward(request, response);
				}
			} catch (AdmissionException e) {
				request.setAttribute("phoneerror", e.getMessage());
				RequestDispatcher rd = request.getRequestDispatcher("application.jsp");
				rd.forward(request, response);
			}
		} else {
			if ("merit".equalsIgnoreCase(type)) {
				request.setAttribute("error", "You are not eligible for merit!");
				RequestDispatcher rd = request.getRequestDispatcher("application.jsp");
				rd.forward(request, response);
			} 
		}
	}
}
