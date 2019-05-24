package com.chainsys.services;

public class CheckMarks {
	public boolean checkMarks(int mark,String type) {
	    boolean result=false;
		int percentage=mark/12;
		if("merit".equalsIgnoreCase(type)&&(percentage>75)) {
		   result=true;	
		}
		else if("merit".equalsIgnoreCase(type)&&(percentage<75))
		{
			result=false;
		}
		else if("management".equalsIgnoreCase(type)&&(percentage>75))
		{
			result=false;
		}
		else if("management".equalsIgnoreCase(type)&&(percentage<75))
		{
			result=true;
		}
		System.out.println(result);
		return result;
		
	}

}
