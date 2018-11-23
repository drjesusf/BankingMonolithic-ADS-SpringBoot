package banking.domain.accounts.tests;

import static org.junit.jupiter.api.Assertions.assertThrows;

import banking.domain.accounts.entities.Account;
import junit.framework.TestCase;

public class WhenTryDepositAmount extends TestCase{
	private Account _account;
	protected void setUp() {
		int initialBalance = 0;
		_account = new Account();
		_account.setNumber("100001");
		_account.setBalance(initialBalance);
	}
	
	public void testIfAmountIsPositive() {
		
		long amount = 50;
		_account.depositMoney(amount);
		
		assertEquals(50.0, _account.getBalance());
	}
	
	public void testIfAmountIsNegative() {
		long amount = -20;
		assertThrows(IllegalArgumentException.class, ()->{
			_account.depositMoney(amount);
		});		
	}
	
}
