package com.chainsys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chainsys.model.Quotation;
import com.chainsys.util.ConnectionUtil;

public class QuotationDAO {
	public boolean insertQuotation(Quotation quotation) {
		boolean success = false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "insert into quotation(quotation_id,user_name,user_id,course,department,branch,total_mark,quote) values(quatation_id_seq.nextval,?,?,?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, quotation.getName());
			preparedStatement.setInt(2, quotation.getUser_id());
			preparedStatement.setString(3, quotation.getCourse());
			preparedStatement.setString(4, quotation.getDepartmentname());
			preparedStatement.setString(5, quotation.getBranchname());
			preparedStatement.setInt(6, quotation.getTotal_mark());
			preparedStatement.setFloat(7, quotation.getQuote());
			int rows = preparedStatement.executeUpdate();
			if (rows > 0) {
				success = true;
			}
			ConnectionUtil.close(connection, preparedStatement, resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return success;
	}

	public List<Quotation> viewQuotationByDept(String department) {
		List<Quotation> list = new ArrayList<Quotation>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Quotation quotation;
		try {
			connection = ConnectionUtil.getConnection();
			String sql1 = "select quotation_id,user_id,user_name,course,department,branch,quote,total_mark from quotation where department=?";
			preparedStatement = connection.prepareStatement(sql1);
			preparedStatement.setString(1, department);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				quotation = new Quotation();
				quotation.setId(resultSet.getInt("quotation_id"));
				quotation.setUser_id(resultSet.getInt("user_id"));
				quotation.setName(resultSet.getString("user_name"));
				quotation.setCourse(resultSet.getString("course"));
				quotation.setDepartmentname(resultSet.getString("department"));
				quotation.setBranchname(resultSet.getString("branch"));
				quotation.setQuote(resultSet.getFloat("quote"));
				quotation.setTotal_mark(resultSet.getInt("total_mark"));
				list.add(quotation);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Quotation> applicationType(int id, String type) {
		List<Quotation> list = new ArrayList<Quotation>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Quotation quotation;
		try {
			connection = ConnectionUtil.getConnection();
			String sql1 = "select a.user_id,a.name,a.course,a.total_mark,b.name as department,c.name as branch,d.total_fees from trn_application a \r\n"
					+ "join branch b on b.branch_id=a.branch join course c on c.course_id=a.department \r\n"
					+ "join merit d on d.branch_id=a.branch where type=? and user_id=?";
			preparedStatement = connection.prepareStatement(sql1);
			preparedStatement.setString(1, type);
			preparedStatement.setInt(2, id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				quotation = new Quotation();
				quotation.setUser_id(resultSet.getInt("user_id"));
				quotation.setName(resultSet.getString("name"));
				quotation.setTotal_mark(resultSet.getInt("total_mark"));
				quotation.setCourse(resultSet.getString("course"));
				quotation.setDepartmentname(resultSet.getString("department"));
				quotation.setBranchname(resultSet.getString("branch"));
				quotation.setTotal_fees(resultSet.getFloat("total_fees"));
				list.add(quotation);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean checkQuotation(int id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		boolean result = false;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select user_name from quotation where user_id=?";
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

	public Quotation addQuotation(int id, String type) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Quotation quotation = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql1 = "select a.user_id,a.name,a.course,a.total_mark,b.name as department,c.name as branch,d.total_fees from trn_application a \r\n"
					+ "join branch b on b.branch_id=a.branch join course c on c.course_id=a.department \r\n"
					+ "join merit d on d.branch_id=a.branch where type=? and user_id=?";
			preparedStatement = connection.prepareStatement(sql1);
			preparedStatement.setString(1, type);
			preparedStatement.setInt(2, id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				quotation = new Quotation();
				quotation.setUser_id(resultSet.getInt("user_id"));
				quotation.setName(resultSet.getString("name"));
				quotation.setTotal_mark(resultSet.getInt("total_mark"));
				quotation.setCourse(resultSet.getString("course"));
				quotation.setDepartmentname(resultSet.getString("department"));
				quotation.setBranchname(resultSet.getString("branch"));
				quotation.setTotal_fees(resultSet.getFloat("total_fees"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return quotation;
	}

	public List<Quotation> viewQuotation(int id) {
		List<Quotation> list = new ArrayList<Quotation>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Quotation quotation;
		try {
			connection = ConnectionUtil.getConnection();
			String sql1 = "select quotation_id,user_id,user_name,course,department,branch,quote,total_mark from quotation where user_id=?";
			preparedStatement = connection.prepareStatement(sql1);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				quotation = new Quotation();
				quotation.setId(resultSet.getInt("quotation_id"));
				quotation.setUser_id(resultSet.getInt("user_id"));
				quotation.setName(resultSet.getString("user_name"));
				quotation.setCourse(resultSet.getString("course"));
				quotation.setDepartmentname(resultSet.getString("department"));
				quotation.setBranchname(resultSet.getString("branch"));
				quotation.setQuote(resultSet.getFloat("quote"));
				quotation.setTotal_mark(resultSet.getInt("total_mark"));
				list.add(quotation);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public String getUsername(int id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String name = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select user_name from quotation where user_id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				name = resultSet.getString("user_name");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(connection, preparedStatement, resultSet);
		}
		return name;
	}

}
