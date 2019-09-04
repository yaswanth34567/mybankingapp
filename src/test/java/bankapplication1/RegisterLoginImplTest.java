package bankapplication1;

import static org.junit.Assert.*;

import org.junit.Test;

import com.bankapplication.BankAppDTO;
import com.bankapplication1.RegisterLoginImpl;

class RegisterLoginImplTest {
		
		

		@BeforeAll
		public static void init()
		{
			registerLoginImpl = new RegisterLoginImpl();
		}

		@Test
		void testRegistration() {
			BankAppDTO bankAppDTO = new BankAppDTO();
	
			bankAppDTO.setName("abcdef");
	
			bankAppDTO.setEmailId("abcdef@gmail.com");
			bankAppDTO.setpassword("abcd");
			
			bankAppDTO.setAadharNo(23456789);
		
			bankAppDTO.setMobileNo(567890123);
			bankAppDTO.setBalance(0);
			int a=registerLoginImpl.registration(bankAppDTO);
			
			assertEquals(98765452, a);
		}

		@Test
		void testLogin() {
			BankAppDTO bankAppDTO = new BankAppDTO();
			bankAppDTO.setAccountNo(98765435);
			bankAppDTO.setpassword("harshini");
			assertEquals(1, registerLoginImpl.login(bankAppDTO));

	}

	}

}
