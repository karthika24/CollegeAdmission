package com.chainsys.model;

/**
 * quotation model
 * @author kart2115
 *
 */
public class Quotation {
	private int id;
	private int user_id;
	private String name;
	private String course;
	private int branch;
	private int department;
	private float quote;
	private String departmentname;
	private String branchname;
	private int total_mark;
	private float total_fees;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public int getBranch() {
		return branch;
	}
	public void setBranch(int branch) {
		this.branch = branch;
	}
	public int getDepartment() {
		return department;
	}
	public void setDepartment(int department) {
		this.department = department;
	}
	public float getQuote() {
		return quote;
	}
	public void setQuote(float quote) {
		this.quote = quote;
	}
	public String getDepartmentname() {
		return departmentname;
	}
	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}
	public String getBranchname() {
		return branchname;
	}
	public void setBranchname(String branchname) {
		this.branchname = branchname;
	}
	public int getTotal_mark() {
		return total_mark;
	}
	public void setTotal_mark(int total_mark) {
		this.total_mark = total_mark;
	}
	public float getTotal_fees() {
		return total_fees;
	}
	public void setTotal_fees(float total_fees) {
		this.total_fees = total_fees;
	}
	@Override
	public String toString() {
		return "Quotation [id=" + id + ", user_id=" + user_id + ", name=" + name + ", course=" + course + ", branch="
				+ branch + ", department=" + department + ", quote=" + quote + ", departmentname=" + departmentname
				+ ", branchname=" + branchname + ", total_mark=" + total_mark + ", total_fees=" + total_fees + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + branch;
		result = prime * result + ((branchname == null) ? 0 : branchname.hashCode());
		result = prime * result + ((course == null) ? 0 : course.hashCode());
		result = prime * result + department;
		result = prime * result + ((departmentname == null) ? 0 : departmentname.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + Float.floatToIntBits(quote);
		result = prime * result + Float.floatToIntBits(total_fees);
		result = prime * result + total_mark;
		result = prime * result + user_id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Quotation other = (Quotation) obj;
		if (branch != other.branch)
			return false;
		if (branchname == null) {
			if (other.branchname != null)
				return false;
		} else if (!branchname.equals(other.branchname))
			return false;
		if (course == null) {
			if (other.course != null)
				return false;
		} else if (!course.equals(other.course))
			return false;
		if (department != other.department)
			return false;
		if (departmentname == null) {
			if (other.departmentname != null)
				return false;
		} else if (!departmentname.equals(other.departmentname))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Float.floatToIntBits(quote) != Float.floatToIntBits(other.quote))
			return false;
		if (Float.floatToIntBits(total_fees) != Float.floatToIntBits(other.total_fees))
			return false;
		if (total_mark != other.total_mark)
			return false;
		if (user_id != other.user_id)
			return false;
		return true;
	}
}
