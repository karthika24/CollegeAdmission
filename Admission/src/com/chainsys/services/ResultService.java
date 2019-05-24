package com.chainsys.services;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import com.chainsys.dao.QuotationDAO;
import com.chainsys.model.Quotation;

public class ResultService {
	public int collegeBidding(String department) {
		QuotationDAO dao = new QuotationDAO();
		int bitting = 0;
		List<Quotation> student = dao.viewQuotationByDept(department);
		Map<Integer, Integer> quotelist = new HashMap<>();
		int size = student.size();
		System.out.println(size);
		for (Quotation q : student) {
			System.out.println(q);
			quotelist.put(q.getUser_id(), (int) q.getQuote());
		}
		int maxValueInMap = (Collections.max(quotelist.values())); 
		for (Entry<Integer, Integer> entry : quotelist.entrySet()) { 
			if (entry.getValue() == maxValueInMap) {
				bitting = entry.getKey();
			}
		}
		return bitting;
	}
}
