package com.bankapplication;

public class BankAppDTO1 {
	
	private int transactionId;
	private int fromAccount;
	private int toAccount;
	private int amountTransferred;
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId =  transactionId;
	}
	public int getFromAccount() {
		return fromAccount;
	}
	public void setFromAccount(int fromAccount) {
		this.fromAccount = fromAccount;
	}
	public int getToAccount() {
		return toAccount;
	}
	public void setToAccount(int toAccountNo) {
		this.toAccount = toAccount;
	}
	public int getAmountTransferred() {
		return amountTransferred;
	}
	public void setAmountTransferred(int amountTransferred) {
		this.amountTransferred = amountTransferred;
	}
}
