package com.chainsys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.chainsys.util.ConnectionUtil;

public class MeritDAO {
	public Float viewFees(int branch) {
		float fees = 0;
		try {
			Connection connection = ConnectionUtil.getConnection();
			String sql = "select total_fees from merit where branch_id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, branch);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				fees = resultSet.getFloat("total_fees");
			}
			ConnectionUtil.close(connection, preparedStatement, resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return fees;
	}


}
