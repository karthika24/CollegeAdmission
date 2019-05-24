package com.chainsys.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.chainsys.exception.AdmissionException;
import com.chainsys.exception.PhoneException;
import com.chainsys.model.Application;
import com.chainsys.model.Branch;
import com.chainsys.model.Course;
import com.chainsys.servlet.LoginServlet;
import com.chainsys.util.ConnectionUtil;

public class ApplicationDAO {
	static final Logger log= Logger.getLogger(ApplicationDAO.class);
	/**
	 * @param application
	 * @return boolean
	 * @throws PhoneException
	 * @throws SQLException
	 */
	public boolean insertApplication(Application application) throws AdmissionException {
		PropertyConfigurator.configure("D:\\chain sys\\Dev-Workspace\\Admission\\src\\log4j.properties");
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		boolean success = false;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "insert into trn_application(application_id,name,father_name,gender,date_of_birth,phone_number,country,state,district,school_name,total_mark,course,department,branch,type,created_by,created_date,modified_by,modified_date,user_id) values(application_id_seq.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			log.debug(sql);
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, application.getName());
			preparedStatement.setString(2, application.getFather_name());
			preparedStatement.setString(3, String.valueOf(application.getGender()));
			preparedStatement.setDate(4, Date.valueOf(application.getDate_of_birth()));
			preparedStatement.setLong(5, application.getPhone_number());
			preparedStatement.setString(6, application.getCountry());
			preparedStatement.setString(7, application.getState());
			preparedStatement.setString(8, application.getDistrict());
			preparedStatement.setString(9, application.getSchool_name());
			preparedStatement.setInt(10, application.getTotal_mark());
			preparedStatement.setString(11, application.getCourse());
			preparedStatement.setInt(12, application.getDepartment());
			preparedStatement.setInt(13, application.getBranch());
			preparedStatement.setString(14, application.getType());
			preparedStatement.setInt(15, application.getCreated_by());
			preparedStatement.setDate(16, Date.valueOf(application.getCreated_date()));
			preparedStatement.setInt(17, application.getModified_by());
			preparedStatement.setDate(18, Date.valueOf(application.getModified_date()));
			preparedStatement.setInt(19, application.getUser_id());
			int rows = preparedStatement.executeUpdate();
			if (rows > 0) {
				success = true;
			}
		} catch (SQLException e) {
			throw new AdmissionException("Phone number already exist");
		} finally {
			ConnectionUtil.close(connection, preparedStatement, resultSet);
		}
		return success;
	}

	public List<Application> findAll(Long phonenumber) {
		List<Application> list = new LinkedList<Application>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Application application;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select a.application_id as application_id, a.name as name,a.father_name as father_name,a.gender as gender,a.date_of_birth as date_of_birth,\r\n"
					+ "a.phone_number as phone_number,a.country as country,a.state as state,a.district as district,a.school_name as school_name,\r\n"
					+ "a.total_mark as total_mark,a.course as course,c.name as department,b.name as branch from trn_application a join branch b on\r\n"
					+ "b.branch_id=a.branch join course c on c.course_id=a.department where a.phone_number=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, phonenumber);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				application = new Application();
				application.setApplication_id(resultSet.getInt("application_id"));
				application.setName(resultSet.getString("name"));
				application.setFather_name(resultSet.getString("father_name"));
				application.setGender(resultSet.getString("gender").charAt(0));
				application.setDate_of_birth(resultSet.getDate("date_of_birth").toLocalDate());
				application.setPhone_number(resultSet.getLong("phone_number"));
				application.setCountry(resultSet.getString("country"));
				application.setState(resultSet.getString("state"));
				application.setDistrict(resultSet.getString("district"));
				application.setSchool_name(resultSet.getString("school_name"));
				application.setTotal_mark(resultSet.getInt("total_mark"));
				application.setCourse(resultSet.getString("course"));
				application.setDepartmentname(resultSet.getString("department"));
				application.setBranchname(resultSet.getString("branch"));
				list.add(application);
			}
			ConnectionUtil.close(connection, preparedStatement, resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean checkApplication(int id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		boolean result = false;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select name from trn_application where user_id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(connection, preparedStatement, resultSet);
		}
		return result;

	}

	public List<String> getTotal(int id) {
		List<String> list = new ArrayList<String>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql1 = "select name,total_mark from trn_application where user_id=?";
			preparedStatement = connection.prepareStatement(sql1);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				list.add(resultSet.getString("name"));
				list.add(String.valueOf(resultSet.getInt("total_mark")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * return course name by stream type
	 * 
	 * @param course
	 * @return map
	 */
	public Map<Integer, String> findByStream(Course course) {
		Map<Integer, String> list = new HashMap<>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select course_id,name from course where stream_id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, course.getStream_id());
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				list.put(resultSet.getInt("course_id"), resultSet.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(connection, preparedStatement, resultSet);
		}
		return list;
	}

	/**
	 * @param branch
	 * @return map
	 */
	public Map<Integer, String> findByCourse(Branch branch) {
		Map<Integer, String> list = new HashMap<>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select branch_id,name from branch where course_id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, branch.getCourse_id());
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				list.put(resultSet.getInt("branch_id"), resultSet.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(connection, preparedStatement, resultSet);
		}
		return list;
	}

	public List<String> getName(int branch) {
		List<String> list = new ArrayList<String>();
		try {
			Connection connection = ConnectionUtil.getConnection();
			String sql = "select a.name as branch_name, b.name as course_name from branch a join course b on a.course_id=b.course_id where a.branch_id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, branch);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				String branchname = resultSet.getString("branch_name");
				String coursename = resultSet.getString("course_name");
				list.add(branchname);
				list.add(coursename);
			}
			ConnectionUtil.close(connection, preparedStatement, resultSet);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return list;
	}

	public String getType(int id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String name = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select type from trn_application where user_id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				name = resultSet.getString("type");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(connection, preparedStatement, resultSet);
		}
		return name;
	}

}
