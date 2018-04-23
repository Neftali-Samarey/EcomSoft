package edu.csi.csc330.classes.connection;

import java.sql.*;

public class MySQLConnection {
	
	public MySQLConnection() {
		
		try {
			   //connection to database
			   Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:8888/EcomsoftDatabase", "root", "root");
			   
			   //create statement 
			   Statement myStmt = myConn.createStatement();
			   
			   //execute sql query
			   ResultSet myRs = myStmt.executeQuery("select * from employees");
			   
			   //results set
			   while (myRs.next()) {
			    System.out.println(myRs.getString("last name")+ " , "+myRs.getString("first name")+ " , "+myRs.getString("email"));
			   }
			  }
			  catch (Exception exc) {
			   exc.printStackTrace();
			  } 
			
		
	}
}
