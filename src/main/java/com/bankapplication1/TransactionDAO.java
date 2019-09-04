package com.bankapplication1;

import com.bankapplication.BankAppDTO1;

public interface TransactionDAO {
	int deposit(int account, int amount);
	int withdrawal(int account,int amount);
    int showBalance(int account);
    int fundTransfer(BankAppDTO1 transfer);	
}


