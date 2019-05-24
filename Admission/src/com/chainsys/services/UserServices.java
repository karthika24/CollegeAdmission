package com.chainsys.services;

import com.chainsys.dao.AdmissionDAO;
import com.chainsys.model.User;

public class UserServices {
	AdmissionDAO dao = new AdmissionDAO();
	public int get_user_id(User user) {
		int id = dao.get_user_id(user);
		return id;
		
	}
	public String viewUserName(int id) {
	String name=dao.viewUserName(id);
	return name;
	}
	public boolean insertUser(User user) throws ClassNotFoundException {
		boolean result = dao.insertUser(user);
		return result;
	}
}
