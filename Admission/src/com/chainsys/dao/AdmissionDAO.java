package com.chainsys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.log4j.Logger;
import com.chainsys.model.User;
import com.chainsys.servlet.LoginServlet;
import com.chainsys.util.ConnectionUtil;

/**
 * @author kart2115
 *
 */
public class AdmissionDAO {
	static final Logger log= Logger.getLogger(AdmissionDAO.class);
	/**
	 * @param user
	 * @return boolean
	 */
	public boolean insertUser(User user) {
		boolean success = false;
		try {
			Connection connection = ConnectionUtil.getConnection();
			String sql = "insert into trn_user_reg(user_id,name,email,password) values(user_id_seq.nextval,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getPassword());
			int rows = preparedStatement.executeUpdate();
			log.debug(rows);
			if (rows > 0) {
				success = true;
				String sql1 = "insert into login values(user_id_seq.currval,?,?)";
				PreparedStatement preparedStatement2 = connection.prepareStatement(sql1);
				preparedStatement2.setString(1, user.getEmail());
				preparedStatement2.setString(2, user.getPassword());
				preparedStatement2.executeUpdate();
			}
			ConnectionUtil.close(connection, preparedStatement, null);
		} catch (SQLException e) {
			e.printStackTrace();
			success = false;
		}
		return success;
	}

	public int get_user_id(User user) {
		int id = 0;
		try {
			Connection connection = ConnectionUtil.getConnection();
			String sql = "select login_id from login where user_name=? and password=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user.getEmail());
			preparedStatement.setString(2, user.getPassword());
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				id = resultSet.getInt("login_id");
			}
			ConnectionUtil.close(connection, preparedStatement, resultSet);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return id;
	}

	public String viewUserName(int id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String name = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select name from trn_user_reg where user_id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				name = resultSet.getString("name");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(connection, preparedStatement, resultSet);
		}
		return name;
	}
}
