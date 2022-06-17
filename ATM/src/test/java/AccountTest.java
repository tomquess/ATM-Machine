package src.test.java;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import src.main.java.Account;

public class AccountTest {

	@Test
	void calcCheckingWithdraw_ShouldReturnTheNewCheckingBalanceAfterWithdraw() {
		
		//Arrange
		Account account = new Account(1, 1234, 1250.0, 500.0);
		
		//Act
		account.calcCheckingWithdraw(250);
		
		//Assert
		assertEquals(account.getCheckingBalance(), 1000);
		
	}
	
	@Test
	void calcSavingWithdraw_ShouldReturnTheNewSavingBalanceAfterWithdraw() {
		
		//Arrange
		Account account = new Account(1, 4321, 1200.0, 600.0);
		
		//Act
		account.calcSavingWithdraw(200);
		
		//Assert
		assertEquals(account.getSavingBalance(), 400);
		
	}
	
}
