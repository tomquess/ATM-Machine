package src.test.java;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.stream.Stream;

import src.main.java.Account;


import static org.junit.jupiter.api.Assertions.*;


public class AccountTest {

	@Test
	void setCustomerNumber_ShouldReturnCorrectCustomerNumberAfterCustomerNumberChange() {

		//Arrange
		Account account = new Account(1, 1234, 1250.0, 500.0);

		//Act
		account.setCustomerNumber(5);

		//Assert
		assertEquals(account.getCustomerNumber(), 5);

	}

	@Test
	void setPinNumber_ShouldReturnCorrectCustomerNumberAfterCustomerPinChange() {

		//Arrange
		Account account = new Account(1, 1234, 1250.0, 500.0);

		//Act
		account.setPinNumber(4321);

		//Assert
		assertEquals(account.getPinNumber(), 4321);

	}

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

	@ParameterizedTest
	@MethodSource("provideArgumentsForCalcCheckTransfer")
	void calcCheckTransfer_ShouldReturnTheNewSavingBalanceAndNewCheckingBalance(double amount, double result1, double result2) {

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
				Arguments.of(200, 1000, 800),
				Arguments.of(400, 800, 1000),
				Arguments.of(1200, 0, 1800),
				Arguments.of(Double.MAX_VALUE, -1.7976931348623157E308, 1.7976931348623157E308)
		);
	}

	@ParameterizedTest
	@MethodSource("provideArgumentsForCalcSavingTransfer")
	void calcSavingTransfer_ShouldReturnTheNewCheckingBalanceAndNewSavingBalance(double amount, double result1, double result2) {

		//Arrange
		Account account = new Account(1, 4321, 1200.0, 600.0);

		//Act
		account.calcSavingTransfer(amount);

		//Assert
		assertEquals(account.getCheckingBalance(),result1);
		assertEquals(account.getSavingBalance(),result2);



	}
	// Handling method
	private static Stream<Arguments> provideArgumentsForCalcSavingTransfer() {
		return Stream.of(
				Arguments.of(200, 1400, 400),
				Arguments.of(400, 1600, 200),
				Arguments.of(1200, 2400, -600),
				Arguments.of(Double.MAX_VALUE, 1.7976931348623157E308, -1.7976931348623157E308)
		);
	}

//	@Test
//	void getCheckingWithdrawInput_ShouldReturnTheNewCheckingBalance() {
//
//		//Arrange
//		Account account = new Account(1, 4321, 1200.0, 600.0);
//		InputStream sysInBackup = System.in;
//		ByteArrayInputStream in = new ByteArrayInputStream("500".getBytes());
//		System.setIn(in);
//		//Act
//		account.getCheckingWithdrawInput();
//
//		//Assert
//		assertEquals(account.getCheckingBalance(), 1400);
//
//	}

	
}
