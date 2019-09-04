package com.bankapplication4;

import java.sql.Connection;
import java.util.Scanner;

import com.Connection.util.ConnectionUtil;
import com.bankapplication.BankAppDTO;
import com.bankapplication.BankAppDTO1;
import com.bankapplication1.RegisterLoginImpl;
import com.bankapplication1.TransactionDAOImpl;

public class App {

    public static void main( String[] args )   {
    
    Connection con = ConnectionUtil.getConnection();
	System.out.println(con);
    
	BankAppDTO bankAppDTO = new BankAppDTO();
    	do {
    		System.out.println("\nWELCOME TO BANK ..");
   
    		System.out.println("1.Register\n 2.Login");
       Scanner sc = new Scanner(System.in);
       int i=sc.nextInt();
       switch (i) {
	case 1:  
		
	          System.out.println("Enter name");
	          String Name = sc.next();
	          bankAppDTO.setName(Name);
	          
	          
	          
	          System.out.println("Enter emailid");
	          String emailId = sc.next();
	          bankAppDTO.setEmailId(emailId);
	          
	          System.out.println("Enter password");
	          String password = sc.next();
	          bankAppDTO.setpassword(password);
	          
	        
	          
	          System.out.println("Enter aadhar no");
	          int aadharNo= sc.nextInt();
	          bankAppDTO.setAadharNo(aadharNo);
	          
	         
	          
	          System.out.println("Enter mobile no");
	          int mobileNo=sc.nextInt();
	          bankAppDTO.setMobileNo(mobileNo);
	          System.out.println("Enter Account no");
	          int AccountNo=sc.nextInt();
	          bankAppDTO.setAccountNo(AccountNo);
	          
	          RegisterLoginImpl reg=new RegisterLoginImpl();
	          reg.registration(bankAppDTO);
		       System.out.println("registerd successfully\n  ");     
		break;
	case 2: 
		
		System.out.println("Enter account number");
		int AccountNo1 = sc.nextInt();
		bankAppDTO.setAccountNo(AccountNo1);
		System.out.println("Enter password");
		String enterdpassword = sc.next();
		bankAppDTO.setpassword(enterdpassword);
		RegisterLoginImpl register = new RegisterLoginImpl();
		
		int login=register.login(bankAppDTO);
		if(login==1)
		{
			System.out.println("logged in successfully");
			do
			{
			System.out.println("\n1.Deposit\n2.withdrawal\n3.showbalance\n4.fundtransfer\n5.Exit");
			int l = sc.nextInt();
			TransactionDAOImpl transaction = new TransactionDAOImpl();
			BankAppDTO1 bankAppDTO1 = new BankAppDTO1();
			switch (l) {
			
			case 1:System.out.println("enter the account no");
			      int accountNo =sc.nextInt();
				System.out.println("enter the amount to be deposited");
			      int depositAmount = sc.nextInt();
			      
			     int d= transaction.deposit(accountNo,depositAmount);
			     if(d!=0)
			     {
			    	 System.out.println("deposit done successfully");
			    	 System.out.println("deposit amount  is:"+d);
			     }
			     else
			     {
			    	 System.out.println("failure while updating");
			     }
			     
			     break;
			      
			     
			     
			     
			case 2: System.out.println("Enter the amount for withdrawal");
			
			          int withdrawalamount = sc.nextInt();
			          System.out.println("enter the account no");
				      int accountNo1 =sc.nextInt();
			        int w =   transaction.withdrawal(AccountNo1, withdrawalamount);
			       
				
			        if(w!=1)
			        {
			        	System.out.println("withdrawal done successfully");
			        	System.out.println("Withdrawal amount  is:"+w);
			        }
			        else
			        {
			        	System.out.println("insufficient balance");
			        }
				break;
			case 3: int currentbalance=transaction.showBalance(bankAppDTO.getAccountNo());
                       System.out.println("The available balance in your account is: "+currentbalance);
                break;    
                
			case 4:
				System.out.println("enter the doners account no");
				int fromAccountNo=sc.nextInt();
				bankAppDTO1.setFromAccount(fromAccountNo);
				System.out.println("enter the receipients account no");
				int toAccountNo=sc.nextInt();
				bankAppDTO1.setToAccount(toAccountNo);
				System.out.println("enter the amount to be transferred");
				int transferAmount = sc.nextInt();
				bankAppDTO1.setAmountTransferred(transferAmount);
				int f=transaction.fundTransfer(bankAppDTO1);
			if(transferAmount>fromAccountNo)

			
				 break;
			
			case 5:
				System.exit(0);
				break;
			default:
				break;
			}
			}while(true);
			
			
		}
		else
		{
			System.out.println("login failed\n please enter valid account no and password");
		}
		break;
	case 3:
		System.exit(0);
		break;
	

	default:
		break;
	}
    	}while(true);
    }
}

				 
			


