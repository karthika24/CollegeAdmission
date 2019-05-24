/**
 * 
 */
package com.chainsys.model;

import java.time.LocalDate;

/**
 * description application model
 * @author kart2115
 *
 */
public class Application {
	private int application_id;
	private String name;
	private String father_name;
	private char gender;
	private LocalDate date_of_birth;
	private Long phone_number;
	private String country;
	private String state;
	private String district;
	private String school_name;
	private int total_mark;
	private String course;
	private int department;
	private String departmentname;
	private String branchname;
	private int branch;
	private String type;
	private int created_by;
	private LocalDate created_date;
	private int modified_by;
	private LocalDate modified_date;
	private int user_id;

	public int getApplication_id() {
		return application_id;
	}

	public void setApplication_id(int application_id) {
		this.application_id = application_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFather_name() {
		return father_name;
	}

	public void setFather_name(String father_name) {
		this.father_name = father_name;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public LocalDate getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(LocalDate date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public Long getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(Long phone_number) {
		this.phone_number = phone_number;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getSchool_name() {
		return school_name;
	}

	public void setSchool_name(String school_name) {
		this.school_name = school_name;
	}

	public int getTotal_mark() {
		return total_mark;
	}

	public void setTotal_mark(int total_mark) {
		this.total_mark = total_mark;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getCreated_by() {
		return created_by;
	}

	public void setCreated_by(int created_by) {
		this.created_by = created_by;
	}

	public LocalDate getCreated_date() {
		return created_date;
	}

	public void setCreated_date(LocalDate created_date) {
		this.created_date = created_date;
	}

	public int getModified_by() {
		return modified_by;
	}

	public void setModified_by(int modified_by) {
		this.modified_by = modified_by;
	}

	public LocalDate getModified_date() {
		return modified_date;
	}

	public void setModified_date(LocalDate modified_date) {
		this.modified_date = modified_date;
	}

	public int getDepartment() {
		return department;
	}

	public void setDepartment(int department) {
		this.department = department;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + application_id;
		result = prime * result + branch;
		result = prime * result + ((branchname == null) ? 0 : branchname.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((course == null) ? 0 : course.hashCode());
		result = prime * result + created_by;
		result = prime * result + ((created_date == null) ? 0 : created_date.hashCode());
		result = prime * result + ((date_of_birth == null) ? 0 : date_of_birth.hashCode());
		result = prime * result + department;
		result = prime * result + ((departmentname == null) ? 0 : departmentname.hashCode());
		result = prime * result + ((district == null) ? 0 : district.hashCode());
		result = prime * result + ((father_name == null) ? 0 : father_name.hashCode());
		result = prime * result + gender;
		result = prime * result + modified_by;
		result = prime * result + ((modified_date == null) ? 0 : modified_date.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phone_number == null) ? 0 : phone_number.hashCode());
		result = prime * result + ((school_name == null) ? 0 : school_name.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + total_mark;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Application other = (Application) obj;
		if (application_id != other.application_id)
			return false;
		if (branch != other.branch)
			return false;
		if (branchname == null) {
			if (other.branchname != null)
				return false;
		} else if (!branchname.equals(other.branchname))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (course == null) {
			if (other.course != null)
				return false;
		} else if (!course.equals(other.course))
			return false;
		if (created_by != other.created_by)
			return false;
		if (created_date == null) {
			if (other.created_date != null)
				return false;
		} else if (!created_date.equals(other.created_date))
			return false;
		if (date_of_birth == null) {
			if (other.date_of_birth != null)
				return false;
		} else if (!date_of_birth.equals(other.date_of_birth))
			return false;
		if (department != other.department)
			return false;
		if (departmentname == null) {
			if (other.departmentname != null)
				return false;
		} else if (!departmentname.equals(other.departmentname))
			return false;
		if (district == null) {
			if (other.district != null)
				return false;
		} else if (!district.equals(other.district))
			return false;
		if (father_name == null) {
			if (other.father_name != null)
				return false;
		} else if (!father_name.equals(other.father_name))
			return false;
		if (gender != other.gender)
			return false;
		if (modified_by != other.modified_by)
			return false;
		if (modified_date == null) {
			if (other.modified_date != null)
				return false;
		} else if (!modified_date.equals(other.modified_date))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phone_number == null) {
			if (other.phone_number != null)
				return false;
		} else if (!phone_number.equals(other.phone_number))
			return false;
		if (school_name == null) {
			if (other.school_name != null)
				return false;
		} else if (!school_name.equals(other.school_name))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (total_mark != other.total_mark)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (user_id != other.user_id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Application [application_id=" + application_id + ", name=" + name + ", father_name=" + father_name
				+ ", gender=" + gender + ", date_of_birth=" + date_of_birth + ", phone_number=" + phone_number
				+ ", country=" + country + ", state=" + state + ", district=" + district + ", school_name="
				+ school_name + ", total_mark=" + total_mark + ", course=" + course + ", department=" + department
				+ ", departmentname=" + departmentname + ", branchname=" + branchname + ", branch=" + branch + ", type="
				+ type + ", created_by=" + created_by + ", created_date=" + created_date + ", modified_by="
				+ modified_by + ", modified_date=" + modified_date + ", user_id=" + user_id + "]";
	}
}
