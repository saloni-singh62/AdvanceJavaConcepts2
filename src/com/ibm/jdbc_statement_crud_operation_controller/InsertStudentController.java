package com.ibm.jdbc_statement_crud_operation_controller;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.ibm.jdbc_statement_crud_operation_connection.MyJdbcConnection;

public class InsertStudentController {
	public static void main(String[] args) {

		Connection connection = null;
		Statement statement = null;
		try {
			connection = MyJdbcConnection.getMyJdbcConnection();

			// step-3 create statement by using Statement or PreparedStatement or
			// CallableStatement to send sql to db
			statement = connection.createStatement();

			// step-4 Execute-SQL-Query
			final String INSERT_STUDENT_QUERY = "insert into student(id,name,email,password,dob,phone,address) "
					+ "values(7777,'Dilshad','dilshad@gmail.com','Dilshad@#$!123','1997-10-10',9832543212,'Basti-Uttarpradesh')";

			int a = statement.executeUpdate(INSERT_STUDENT_QUERY);

			String msg = a != 0 ? "student registered" : "something went wrong";

			System.out.println(msg);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			if(statement!=null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(connection!=null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		
		}
	}

}