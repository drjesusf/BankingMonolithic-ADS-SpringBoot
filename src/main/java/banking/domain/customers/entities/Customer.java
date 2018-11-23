package banking.domain.customers.entities;

import java.util.ArrayList;
import java.util.List;

import banking.domain.accounts.entities.Account;
import seedWork.Entity;

public class Customer extends Entity {

	private String _firstName;	
	private String _lastName;
	private String _idenbtityDocument;
	private boolean _active;
	private List<Account> _accounts;
	
	public Customer() {
		_accounts = new ArrayList<Account>();
	}
	public Customer(long id) {
		set_id(id);
	}
	
	public String get_fullname() {
		return String.format("%s %s", _firstName,_lastName);
	}
	
	public String get_firstName() {
		return _firstName;
	}
	public void set_firstName(String _firstName) {
		this._firstName = _firstName;
	}
	public String get_lastName() {
		return _lastName;
	}
	public void set_lastName(String _lastName) {
		this._lastName = _lastName;
	}
	public String get_idenbtityDocument() {
		return _idenbtityDocument;
	}
	public void set_idenbtityDocument(String _idenbtityDocument) {
		this._idenbtityDocument = _idenbtityDocument;
	}
	public boolean is_active() {
		return _active;
	}
	public void set_active(boolean _active) {
		this._active = _active;
	}
	public List<Account> get_accounts() {
		return _accounts;
	}
	public void set_accounts(List<Account> _accounts) {
		this._accounts = _accounts;
	}
}
