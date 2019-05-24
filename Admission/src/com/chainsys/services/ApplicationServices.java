package com.chainsys.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.chainsys.dao.AdmissionDAO;
import com.chainsys.dao.ApplicationDAO;
import com.chainsys.dao.QuotationDAO;
import com.chainsys.dao.ResultDAO;
import com.chainsys.exception.AdmissionException;
import com.chainsys.model.Application;
import com.chainsys.model.Branch;
import com.chainsys.model.Course;
import com.chainsys.model.Quotation;

public class ApplicationServices {
	ApplicationDAO dao = new ApplicationDAO();

	public Map<Integer, String> findCourse(Course course) {
		Map<Integer, String> list = dao.findByStream(course);
		return list;
	}

	public Map<Integer, String> findBranch(Branch branch) {
		Map<Integer, String> list = dao.findByCourse(branch);
		return list;
	}

	public List<Application> viewApplication(Long phonenumber) {
		List<Application> list = new ArrayList<Application>();
		list = dao.findAll(phonenumber);
		return list;
	}

	public String getType(int id) {
		String name = dao.getType(id);
		return name;
	}

	public List<Quotation> applicationType(int id, String type) {
		QuotationDAO dao = new QuotationDAO();
		List<Quotation> list = dao.applicationType(id, type);
		return list;

	}

	public boolean insertApplication(Application application) throws AdmissionException {
		boolean result = dao.insertApplication(application);
		return result;
	}

	public boolean checkApplication(int id) {
		boolean result = dao.checkApplication(id);
		return result;
	}

	public Quotation addQuotation(int id, String type) {
		QuotationDAO dao = new QuotationDAO();
		Quotation qobj = dao.addQuotation(id, type);
		return qobj;
	}

	public boolean addResult(int id) {
		ResultDAO dao = new ResultDAO();
		return dao.addResult(id);
	}

	public boolean checkResult(int id) {
		ResultDAO dao = new ResultDAO();
		boolean result = dao.checkResult(id);
		return result;
	}

	public String getUsername(int id) {
		QuotationDAO dao = new QuotationDAO();
		String name = dao.getUsername(id);
		return name;
	}

	public List<Quotation> viewQuotation(int id) {
		QuotationDAO dao = new QuotationDAO();
		List<Quotation> list = dao.viewQuotation(id);
		return list;
	}

	public boolean insertQuotation(Quotation quotation) {
		QuotationDAO dao = new QuotationDAO();
		return dao.insertQuotation(quotation);
	}
	
	public boolean checkQuotation(int id) {
		QuotationDAO dao = new QuotationDAO();
		boolean check = dao.checkQuotation(id);
		return check;
	}
}
