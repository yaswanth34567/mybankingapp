package bankapplication1;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.bankapplication.BankAppDTO;
import com.bankapplication.BankAppDTO1;
import com.bankapplication1.TransactionDAOImpl;

public class TransactionDAOImplTest {
static TransactionDAOImpl transactionDAOImpl;
	

	@Before
	public static void init()
	{
		transactionDAOImpl = new TransactionDAOImpl();
	}

	@Test
	void testDeposit() {
		transactionDAOImpl.deposit(98765444, 500);
		assertEquals(4500, transactionDAOImpl.showBalance(98765444));
		
	}

	@Test
	void testWithdrawal() {
		BankAppDTO bankAppDTO = new BankAppDTO();
		int a = transactionDAOImpl.withdrawal(98765442, 100);
		assertEquals(1,a);
	}

	@Test
	void testShowBalance() {
		assertEquals(1820, transactionDAOImpl.showBalance(98765435));
	}

	@Test
	void testFundTransfer() {
		BankAppDTO1 bankAppDTO1= new BankAppDTO1();
		bankAppDTO1.setFromAccount(98765436);
		bankAppDTO1.setToAccount(98765442);
		bankAppDTO1.setAmountTransferred(10);
		assertEquals(1,transactionDAOImpl.fundTransfer(bankAppDTO1));
	}

}


