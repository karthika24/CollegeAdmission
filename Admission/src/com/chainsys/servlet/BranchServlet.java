package com.chainsys.servlet;

import java.io.IOException;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.chainsys.dao.AdmissionDAO;
import com.chainsys.model.Branch;
import com.chainsys.services.ApplicationServices;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class BranchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int departments = Integer.parseInt(request.getParameter("departments"));
		Branch branch = new Branch();
		ApplicationServices app = new ApplicationServices();
		branch.setCourse_id(departments);
		Map<Integer, String> list = app.findBranch(branch);
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String jsoncourse = gson.toJson(list);
		response.getWriter().write(jsoncourse);
	}
}
