package com.abzasg;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;
import java.util.Scanner;

public class PayRoll {
	
//	private PreparedStatement employeePayrollDataStatement;
//	public static PayRoll payRoll ;	
//	private PayRoll() {
//		
//	}
	
//	public static PayRoll getInstance() {
//		if(payRoll == null)
//			payRoll = new PayRoll();
//		return payRoll;
//	}
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
	
	/////////////////////     Uc 5    /////////////////////
	public static void retriveFromPerticularDate() throws SQLException{
		Connection connect = null;
		try {
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/AddressBookService", "root", "root");
			PreparedStatement pStmt = connect.prepareStatement("select * from employee_payroll where date between ? and ?");
			pStmt.setString(1, "2020-04-15");
			pStmt.setString(2, "2022-04-15");
			pStmt.execute();
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			connect.close();
		}

	}
	
	
	
	/////////////////////    Uc 4    /////////////////////////
	public static void updateSalaryWithPreparedStatement() throws SQLException{
		Connection connect = null;
		try {
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/AddressBookService", "root", "root");
			PreparedStatement pStmt = connect.prepareStatement("update employee_payroll set basic_pay = 3000000.00 where name =?;");
			pStmt.setString(1, "terisa");
			pStmt.execute();
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			connect.close();
		}

	}
		
	
	//////////////////////    Uc 3    ///////////////////////////
	public static void updateSalary() throws SQLException{
		Connection connect = null;
		try {
		connect = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "root");
		Statement stmt = connect.createStatement();
		stmt.execute("update employee_payroll set basic_pay =3000000.00 where name ='terisa");		
		
		} catch (SQLException e) {
			System.out.println("unable to connect");
		} finally {
			connect.close();
		}
	}
	
	
	
		///////////////////   Uc 2    ////////////////////////
	public static void retriveData() throws SQLException{
		Connection connect = null;
		try {
		connect = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "root");
		Statement stmt = connect.createStatement();
		ResultSet res = stmt.executeQuery("select * from employee_payroll");	
		
		
		while (res.next()) {
			System.out.println(res.getString(1) + " " + res.getString(2) + " " + res.getString(3) + " "
					+ res.getString(4) + " " + res.getString(5) + " " + res.getDouble(6) + " " + res.getDouble(7) + " "
					+ res.getDouble(8) + " " + res.getDouble(9) + " " + res.getDouble(10)+ " "+res.getDate(11));
		}
		
		} catch (SQLException e) {
			System.out.println("unable to connect");
		} finally {
			connect.close();
		}
	}
	
	
	
	///////////////////////    Uc 1    //////////////////////
	
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
