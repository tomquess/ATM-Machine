package src.test.java;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import src.main.java.Account;


import static org.junit.jupiter.api.Assertions.*;


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

	@Test
	void calcCheckingDeposit_ShouldReturnTheNewCheckingBalance() {

		//Arrange
		Account account = new Account(1, 4321, 1200.0, 600.0);

		//Act
		account.calcCheckingDeposit(200);

		//Assert
		assertEquals(account.getCheckingBalance(), 1400);

	}


	@ParameterizedTest
	@MethodSource("provideArgumentsForReturnTheNewSavingBalance")
	void calcSavingDeposit_ShouldReturnTheNewSavingBalance(double amount, double result) {

		//Arrange
		Account account = new Account(1, 4321, 1200.0, 600.0);

		//Act
		account.calcCheckingDeposit(amount);

		//Assert
		assertEquals(account.getCheckingBalance(),result);


	}
	// Handling method
	private static Stream<Arguments> provideArgumentsForReturnTheNewSavingBalance() {
		return Stream.of(
				Arguments.of(200, 1400),
				Arguments.of(400, 1600),
				Arguments.of(600, 1800),
				Arguments.of(0, 1200),
				Arguments.of(-550, 650),
				Arguments.of(999999, 1001199),
				Arguments.of(Double.MAX_VALUE, 1.7976931348623157E308)
		);
	}
	@Disabled
	@ParameterizedTest
	@MethodSource("provideArgumentsForCalcCheckTransfer")
	void calcCheckTransfer_ShouldReturnTheNewSavingBalance(double amount, double result1, double result2) {

		//Arrange
		Account account = new Account(1, 4321, 1200.0, 600.0);

		//Act
		account.calcCheckTransfer(amount);

		//Assert
		assertEquals(account.getCheckingBalance(),result1);
		assertEquals(account.getSavingBalance(),result2);



	}
	// Handling method
	private static Stream<Arguments> provideArgumentsForCalcCheckTransfer() {
		return Stream.of(
				Arguments.of(200, 1000,1600),
				Arguments.of(400, 1600),
				Arguments.of(600, 1800),
				Arguments.of(0, 1200),
				Arguments.of(-550, 650),
				Arguments.of(999999, 1001199),
				Arguments.of(Double.MAX_VALUE, 1.7976931348623157E308)
		);
	}

	
}
