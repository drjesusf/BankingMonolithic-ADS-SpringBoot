package banking.domain.accounts.entities;

import banking.domain.accounts.constants.AccountConstants;
import banking.domain.customers.entities.Customer;
import seedWork.Entity;
import seedWork.Notification;

public class Account extends Entity{
	private String number;
	private double balance;
	private boolean locked;
	private Customer customer;
	
	public void Lock() {
		if(!locked) locked = true;
	}
	public void UnLock() {
		if(locked) locked = false;
	}
	public boolean hasIdentity() {
		if(number == null) return false;
		return !number.isEmpty();
	} 
	
	public void withdrawMoney(double amount) {
		Notification notification = canWithdrawMoney(amount);
		ThrowExceptionIfAny(notification);
		
		this.balance = this.balance - amount;
	}
	
	private Notification canWithdrawMoney(double amount) {
		Notification notification = new Notification();
		if(amount<=0) notification.addError(AccountConstants.amountMustBeGreaterThanZero);
		if(!hasIdentity()) notification.addError(AccountConstants.accountHasNoIdentity);
		if(locked) notification.addError(AccountConstants.accountIsLocked);
		if(!canBeWithdrawed(amount)) notification.addError(AccountConstants.cannotWithdrawAmountIsGreaterThanBalance);
		
		return notification;
	}
	
	private boolean canBeWithdrawed(double amount) {
		return !locked && balance>= amount;
	}
	
	public void depositMoney(double amount) { 
		Notification notification = canDepositMoney(amount);
		ThrowExceptionIfAny(notification);
		
		balance+=amount;
	}
	private Notification canDepositMoney(double amount) {
		Notification notification = new Notification();
		if(amount<=0) notification.addError(AccountConstants.amountMustBeGreaterThanZero);
		if(!hasIdentity()) notification.addError(AccountConstants.accountHasNoIdentity);
		if(locked) notification.addError(AccountConstants.accountIsLocked);
		
		return notification;
	}
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public boolean isLocked() {
		return locked;
	}
	public void setLocked(boolean locked) {
		this.locked = locked;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
