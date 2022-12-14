package com.abzasg;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;

public class PayRoll {

	public static void main(String[] args) throws SQLException{
		String jdbcUrl = "jdbc:mysql://localhost:3306";
		String userName ="root";
		String password = "root";
//		createPayrollServiceDatabase();
		Connection con;
		con = DriverManager.getConnection(jdbcUrl,userName,password);
		System.out.println("Connection Successful");
		try {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver Loaded");
		
		}catch(ClassNotFoundException e) {
			throw new IllegalStateException("Cannot find driver",e);
		}
		listDrivers();
	}
	
	
	public static void createPayrollServiceDatabase() throws SQLException{
		Connection connect = null;
		try {
		connect = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "root");
		Statement stmt = connect.createStatement();
		stmt.execute("create database PayrollService");		
		
		} catch (SQLException e) {
			System.out.println("unable to connect");
		} finally {
			connect.close();
		}
	}
	
	private static void listDrivers() {
		Enumeration<Driver> driverList = DriverManager.getDrivers();
		while(driverList.hasMoreElements()) {
			Driver driverClass = (Driver) driverList.nextElement();
			System.out.println(driverClass.getClass().getName());
		}
	}

}
