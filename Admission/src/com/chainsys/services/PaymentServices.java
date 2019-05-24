package com.chainsys.services;

import java.util.List;

import com.chainsys.dao.AdmissionDAO;
import com.chainsys.dao.ApplicationDAO;
import com.chainsys.dao.MeritDAO;

public class PaymentServices {
	public List<String> getName(int branch) {
		ApplicationDAO dao=new ApplicationDAO();
		List<String> list=dao.getName(branch);
		return list;
	}
    
	public Float viewFees(int branch) {
		MeritDAO dao=new MeritDAO();
		float fees=dao.viewFees(branch);
		return fees;
	}
}
