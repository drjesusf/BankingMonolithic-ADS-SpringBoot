package banking.domain.transactions.services;

import banking.domain.accounts.entities.Account;
import banking.domain.transactions.constants.TransactionConstants;
import banking.domain.transactions.contracts.ITransferDomainService;
import seedWork.Notification;
import seedWork.Service;

public class TransferDomainService extends Service implements ITransferDomainService {

	public void performTransfer(Account originAccount, Account destinationAccount, double amount) {
		Notification notification = canPerformTransfer(originAccount,destinationAccount,amount);
		throwExceptionIfAny(notification);
		originAccount.withdrawMoney(amount);
		destinationAccount.depositMoney(amount);
	}

	public Notification canPerformTransfer(Account originAccount, Account destinationAccount, double amount) {
		Notification notification = new Notification();
		if(amount<0) notification.addError(TransactionConstants.AmountMustBeGreaterThanZero);
		if(originAccount == null) notification.addError(TransactionConstants.OriginAccountInvalid);
		if(destinationAccount == null) notification.addError(TransactionConstants.DestinationAccountInvalid);
		
		if (originAccount != null &&
                destinationAccount != null &&
                originAccount.getNumber().equals(destinationAccount.getNumber()))
            {
                notification.addError(TransactionConstants.CannotTransferSameAccounts);
            }
		return notification;
	}

}
