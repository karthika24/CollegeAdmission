package com.chainsys.services;

import java.util.List;

import com.chainsys.dao.QuotationDAO;
import com.chainsys.model.Quotation;

public class AdminServices {
	QuotationDAO dao = new QuotationDAO();
	public List<Quotation>  viewQuotationByDept(String dept) {
		List<Quotation> list = dao.viewQuotationByDept(dept);
		return list;
		
	}

}
