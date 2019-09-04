package com.bankapplication1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.Connection.util.ConnectionUtil;
import com.bankapplication.BankAppDTO;


public class RegisterLoginImpl implements RegisterLogin{
	   BankAppDTO bankAppDTO = new BankAppDTO();

			public  int registration(BankAppDTO register) {
				
				Connection con = ConnectionUtil.getConnection();
				PreparedStatement pst = null;
				ResultSet rs=null;
				try {
				String sql = "insert into customer_details(Name,emailid,Password,aadharNo,mobileNo,balance,accountNo) values ( ?,?,?,?,?,?,?)";
			    pst = con.prepareStatement(sql);
			
			    pst.setString(1, register.getName());
			    pst.setString(2, register.getEmailId());
			    pst.setString(3, register.getpassword());
			    
			    pst.setLong(4, register.getAadharNo());
			   
			    pst.setInt(5, register.getMobileNo());
			    pst.setInt(6,register.getBalance());
			    pst.setInt(7,register.getAccountNo());
			    int rows = pst.executeUpdate();
				return rows;
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					ConnectionUtil.close(con,pst,rs);
				}
				return 0;
			}
		  
	public int login(BankAppDTO login) {
		int i=0;
		 int accountNo=0;
		String password = null;
	

		try {
	
			Connection con = ConnectionUtil.getConnection();
			 String selectSQL = "SELECT accountNo,password FROM Customer_details where accountNo=? and password= ?";
			  PreparedStatement pst = con.prepareStatement(selectSQL);
			 pst.setInt(1, login.getAccountNo());
			pst.setString(2, login.getpassword());
			 
			  ResultSet rs = pst.executeQuery ();
			  while (rs.next()) {
			  	accountNo=rs.getInt(1);
			  	password=rs.getString(2);
			  	//System.out.println("accountNo:" + accountNo + ",password:" + password );
			  	if(accountNo==login.getAccountNo())
			  	{
		  			

			  		if(password.equals(login.getpassword()))
			  		{
			  			i=1;

			  		}
			  	}
			  	
		}
		}catch (SQLException e) {
			
			e.printStackTrace();
		}
	
			return i;
	}


}

