package com.chainsys.servlet;

import java.io.IOException;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.chainsys.dao.AdmissionDAO;
import com.chainsys.model.Course;
import com.chainsys.services.ApplicationServices;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class CourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String course = request.getParameter("course");
		Course courseobj = new Course();
        ApplicationServices app = new ApplicationServices();
		if ("engineering".equals(course)) {
			int stream_id = 101;
			courseobj.setStream_id(stream_id);
		} else if ("arts".equals(course)) {
			int stream_id = 102;
			courseobj.setStream_id(stream_id);
		}
		Map<Integer, String> list = app.findCourse(courseobj);
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String jsoncourse = gson.toJson(list);
		response.getWriter().write(jsoncourse);
	}
}