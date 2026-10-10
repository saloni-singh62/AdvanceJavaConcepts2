package com.ibm.jdbc_statement_crud_operation_controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ibm.jdbc_statement_crud_operation_connection.MyJdbcConnection;
import com.ibm.jdbc_statement_crud_operation_dto.Student;


public class DisplayAllstudentController {
	public static void main(String[] args) {
		try (Connection connection = MyJdbcConnection.getMyJdbcConnection();
				Statement statement = connection.createStatement();
		) {
			ResultSet resultSet=statement.executeQuery("select * from student");
			while(resultSet.next()) {
				
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String email = resultSet.getString("email");
				String password = resultSet.getString("password");
				long phone = resultSet.getLong("phone");
				Date dob = resultSet.getDate("dob");
				String address = resultSet.getString("address");
				
				Student student = new Student();
				student.setId(id);
				student.setName(name);
				student.setEmail(email);
				student.setPassword(password);
				student.setPhone(phone);
				student.setAddress(address);
				student.setDob(dob.toLocalDate());
				
				System.out.println(student);
				
				System.out.println("##############################################################");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
