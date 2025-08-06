package workshop.account.entity;

import workshop.account.exception.InsufficientBalanceException;

public class Account {

	private String custId;
	private String acctId;
	private int balance;

	public Account() {
		System.out.println("기본생성자 호출됨");
	}
	/*
	 * 
	 * public void setBalance(int newBalance) { this.balance = newBalance; }
	 */

	public Account(String custId, String acctId, int balance) {
		// this.custId = custId;
		// this.acctId = acctId;
		setCustId(custId);
		setAcctId(acctId);
		this.balance = balance;
	}

	public void setAcctId(String acctId) {
		this.acctId = acctId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public int getBalance() {
		return balance;
	}

	public String getAcctId() {
		return acctId;
	}

	public String getCustId() {
		return custId;
	}

	public void deposit(int amount) {
		this.balance += amount;
	}

	public void withdraw(int amount) throws InsufficientBalanceException{
		if(amount > this.balance) {
			String errMessage = String.format("잔액이 부족합니다. (요청 금액: %d, 현재 잔액: %d)", amount, balance);
			throw new InsufficientBalanceException(errMessage);
		}
		this.balance -= amount;
	}
}
