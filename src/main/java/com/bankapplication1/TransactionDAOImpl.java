package com.bankapplication1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Connection.util.ConnectionUtil;
import com.bankapplication.BankAppDTO;
import com.bankapplication.BankAppDTO1;

public class TransactionDAOImpl implements TransactionDAO {
	    BankAppDTO bankAppDTO = new BankAppDTO();
		public int deposit(int account,int amount) {
		
			int balance=0;
			int i=0;
			try {
			
				Connection con = ConnectionUtil.getConnection();

				 String selectSQL = "SELECT balance FROM Customer_details WHERE accountNo = ?";
				  PreparedStatement pst = con.prepareStatement(selectSQL);
				  pst.setInt(1, account);
				  
				  ResultSet rs = pst.executeQuery ();
				  while (rs.next()) {
				  	 balance = rs.getInt("balance");
				  	
				  }
				
	            PreparedStatement pst1 = con.prepareStatement("update Customer_details set balance=? where accountNo=?");
			    balance = balance+amount;
			    System.out.println(balance);
			    
			    pst1.setInt(2, account);
			    pst1.setInt(1,balance );
			    
			    pst1.executeUpdate();
			   con.close();
			  
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			return balance;
			
		}
		public int withdrawal(int account, int amount) {
			int balance=0;
			int i=0;
			
			try 
			{
		
			Connection con = ConnectionUtil.getConnection();

			 String selectSQL = "SELECT balance FROM Customer_details WHERE accountNo = ?";
			  PreparedStatement pst = con.prepareStatement(selectSQL);
			  pst.setInt(1, account);
			  ResultSet rs = pst.executeQuery ();
			  while (rs.next()) {
			  	 balance = rs.getInt(1);	
			  	// bankAppDTO.setAccountNo(accountNo);
			 
			  }
			
	        PreparedStatement pst1 =  con.prepareStatement("update Customer_details set balance=? where accountNo=?");
	        if(balance>amount)
	        {
		    balance = balance-amount;
		   pst1.setInt(2, account);
		   pst1.setInt(1,balance );
		    System.out.println(balance);
		   pst1.executeUpdate();
		   con.close();
	        }
	        else
	        {
	        	i=0;
	        }
		  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

			return balance;
		}
		public int showBalance(int account) {
			// TODO Auto-generated method stub
			int currentBalance=0;
			
			try{
				
				Connection con = ConnectionUtil.getConnection();

				 String selectSQL = "SELECT balance FROM Customer_details WHERE accountNo = ?";
				  PreparedStatement pst = con.prepareStatement(selectSQL);
				  pst.setInt(1, account);
				  ResultSet rs = pst.executeQuery ();
				  while (rs.next()) {
				  	 currentBalance = rs.getInt(1);	
				  
				 
				  }
				  con.close();
			}catch (SQLException e) {
			
				e.printStackTrace();
			}
			
		
			return currentBalance;
		}
		public int fundTransfer(BankAppDTO1 transfer) {
			// TODO Auto-generated method stub
			int i=0;
	try {
			
				Connection con = ConnectionUtil.getConnection();
			   String sql = "insert into transaction_details( fromAccount,toAccount,amountTransferred) values (?,?,?)";
			PreparedStatement preparedStatement =  con.prepareStatement(sql);
				int balance1 = showBalance(transfer.getFromAccount());
			 if(balance1>transfer.getAmountTransferred())
			 {
					    preparedStatement.setLong(1,transfer.getFromAccount());
					    preparedStatement.setLong(2,transfer.getToAccount());
					    preparedStatement.setInt(3,transfer.getAmountTransferred());
					   
					   
					   int r =  preparedStatement.executeUpdate();
					   System.out.println("Tr:" + r);
					   
					 int toAcc = transfer.getToAccount();
					  int amount1 = transfer.getAmountTransferred();
					  int fromAcc = transfer.getFromAccount();
					  deposit(toAcc, amount1);
					   
					   withdrawal(fromAcc, amount1);
					
			 
			  }}
			  catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			return 0;
		}
		
		 
	
}




