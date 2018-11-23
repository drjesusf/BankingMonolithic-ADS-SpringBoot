package banking.domain.transactions.tests;

import static org.junit.jupiter.api.Assertions.assertThrows;

import banking.domain.accounts.entities.Account;
import banking.domain.transactions.services.TransferDomainService;
import junit.framework.TestCase;

public class WhenTryTransferMoney extends TestCase{
	public void testIfOriginAccountHasNoBalance() {
		double transferAmount = 30;
		double initialOriginBalance = 0;
		double initialDestinationBalance = 0;
		Account originAccount = new Account();
		originAccount.setBalance(initialOriginBalance);
		originAccount.setNumber("10001");
		Account destinationAccount = new Account();
		destinationAccount.setBalance(initialDestinationBalance);
		destinationAccount.setNumber("10002");
		TransferDomainService transfer = new TransferDomainService();		
		
		assertThrows(IllegalArgumentException.class, ()->{
			transfer.performTransfer(originAccount, destinationAccount, transferAmount);
		});
	}
	public void testIfAccountAreEquals() {
		double transferAmount = 30;
		double initialOriginBalance = 2000;
		double initialDestinationBalance = 0;
		Account originAccount = new Account();
		originAccount.setBalance(initialOriginBalance);
		originAccount.setNumber("10001");
		Account destinationAccount = new Account();
		destinationAccount.setBalance(initialDestinationBalance);
		destinationAccount.setNumber("10001");
		TransferDomainService transfer = new TransferDomainService();		
		
		assertThrows(IllegalArgumentException.class, ()->{
			transfer.performTransfer(originAccount, destinationAccount, transferAmount);
		});
	}
	public void testIfTransferIsCorrect() {
		
		double transferAmount = 30;
		double initialOriginBalance = 50;
		double initialDestinationBalance = 0;
		Account originAccount = new Account();
		originAccount.setBalance(initialOriginBalance);
		originAccount.setNumber("10001");
		Account destinationAccount = new Account();
		destinationAccount.setBalance(initialDestinationBalance);
		destinationAccount.setNumber("10002");
		TransferDomainService transfer = new TransferDomainService();		
		transfer.performTransfer(originAccount, destinationAccount, transferAmount);
		
		assertEquals(initialOriginBalance-transferAmount, originAccount.getBalance());
		assertEquals(initialDestinationBalance+transferAmount, destinationAccount.getBalance());
	}

}
