package com.bz.hospitalsystem.dao;

import java.sql.*;
import com.bz.hospitalsystem.connection.ConnectDB;
import com.bz.hospitalsystem.exceptions.PatientNotFoundException;

public class RemovePatientFromDB {

	public static boolean patientExistOrNot(String firstName) throws SQLException {
		Connection connection = ConnectDB.getInstance().getConnection();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement
				.executeQuery("select * from patientDetails where firstName ='" + firstName + "' ;");

		if (resultSet.getRow() == 0) {
			return false;
		}
		return true;
	}

	public void removePatient(String firstName) {

		Connection connection = ConnectDB.getInstance().getConnection();

		try {
			if (!patientExistOrNot(firstName)) {
				throw new PatientNotFoundException(" Entry Details Doesn't Exist ");
			} else {
				PreparedStatement statement = connection
						.prepareStatement("delete from patientDetails where firstName = ?");
				statement.setString(1, firstName);
				int confirm = statement.executeUpdate();
				System.out.println(confirm);
				statement.close();
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
