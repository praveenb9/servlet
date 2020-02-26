package com.capg.webapplication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ModelDAO {

	
	public int addUser(User uobject) {
		
	int count=0;
	Connection con=DBUtil.getDBConnection();
	
String insert= "insert into account values(?,?)";

try {
	PreparedStatement pstmt =con.prepareStatement(insert);
	
	pstmt.setString(1, uobject.getUserName());
	
	pstmt.setString(2, uobject.getPassword());
	count=pstmt.executeUpdate();
	
} 
catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	
	return count;
	}
}
