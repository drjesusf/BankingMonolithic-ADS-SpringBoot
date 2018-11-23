package banking.domain.accounts.contracts;

import banking.domain.accounts.entities.Account;
import seedWork.IRepository;

public interface IAccountRepository extends IRepository<Account>{
	Account getByNumber(String accountNumber);
	Account getByNumberWithUpgradeLock(String accountNumber);
}
