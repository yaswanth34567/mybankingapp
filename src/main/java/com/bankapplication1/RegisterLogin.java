package com.bankapplication1;


	import com.bankapplication.BankAppDTO;

	public interface RegisterLogin {
		
	    int registration(BankAppDTO register)  ;
		
	
		int login(BankAppDTO login);
		


}
