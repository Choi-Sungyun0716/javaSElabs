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
		System.out.println(balance+"���� �Ա޵Ǿ����ϴ�. ���� �ܾ�: "+ this.balance+"��");
	}
	
	public void withdraw (double balance) throws InsufficientBalanceException{
		if(this.balance >= balance) {
			this.balance -= balance;
			System.out.println(balance+"���� ��޵Ǿ����ϴ�. ���� �ܾ�: "+ this.balance+"��");
		} else {
			String errMessage = String.format("���� �߻�: ��� �ѵ��� �ʰ��߽��ϴ�. �ѵ�: %f��", this.balance);
			throw new InsufficientBalanceException(errMessage);
		}
	}

	public abstract String toString ();
}
