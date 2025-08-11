package assignment.bank.entity;


import assignment.bank.exception.InsufficientBalanceException;

public abstract class Account {
	private String accountNumber;
	private String ownerName;
	private double balance;
	
	
	public Account(String accountNumber, String ownerName, double balance) {
		this.accountNumber = accountNumber;
		this.ownerName = ownerName;
		this.balance = balance;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}

	public String getOwnerName() {
		return ownerName;
	}


	public double getBalance() {
		return balance;
	}
	
	public void deposit(double balance) {
		this.balance += balance;
		System.out.println(balance+"원이 입급되었습니다. 현재 잔액: "+ this.balance+"원");
	}
	
	public void withdraw (double balance) throws InsufficientBalanceException{
		if(this.balance >= balance) {
			this.balance -= balance;
			System.out.println(balance+"원이 출급되었습니다. 현재 잔액: "+ this.balance+"원");
		} else {
			String errMessage = String.format("예외 발생: 출금 한도를 초과했습니다. 한도: %f원", this.balance);
			throw new InsufficientBalanceException(errMessage);
		}
	}

	public abstract String toString ();
}
