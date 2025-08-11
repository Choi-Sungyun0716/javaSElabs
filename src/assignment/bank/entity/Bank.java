package assignment.bank.entity;

import java.util.ArrayList;
import java.util.List;

import assignment.bank.exception.AccountNotFoundException;
import assignment.bank.exception.InsufficientBalanceException;

public class Bank {
	
	private List<Account> accounts;
	private int nextAccountNumber;

	public Bank() {
		this.accounts = new ArrayList<>();
		nextAccountNumber = 1000;

	}

	public String createSavingsAccount(String ownerName, double balance, double interestRate) {
		String accountNumber = String.format("AC%d", this.nextAccountNumber);
		SavingsAccount savingsAccount = new SavingsAccount(accountNumber, ownerName, balance, interestRate);
		accounts.add(savingsAccount);
		this.nextAccountNumber += 1;
		return String.format("���� ���°� �����Ǿ����ϴ�. ���¹�ȣ: %s, ������: %s, �ܾ�: %.2f, ������: %.2f%%",
				savingsAccount.getAccountNumber(), savingsAccount.getOwnerName(), savingsAccount.getBalance(),
				savingsAccount.getInterestRate());
	}

	public String createCheckingAccount(String ownerName, double balance, double withdrawalLimit) {
		String accountNumber = String.format("AC%d", this.nextAccountNumber);
		this.nextAccountNumber += 1;
		CheckingAccount checkingAccount = new CheckingAccount(accountNumber, ownerName, balance, withdrawalLimit);
		accounts.add(checkingAccount);

		return String.format("üũ ���°� �����Ǿ����ϴ�. ���¹�ȣ: %s, ������: %s, �ܾ�: %.2f, ��� �ѵ�: %.2f��",
				checkingAccount.getAccountNumber(), checkingAccount.getOwnerName(), checkingAccount.getBalance(),
				checkingAccount.getWithdrawalLimit());
	}

	public Account findAccount(String accountNumber) throws AccountNotFoundException {
	    for (Account account : this.accounts) {
	        if (account.getAccountNumber().equals(accountNumber)) {
	            return account;
	        }
	    }
	    // for�� �� ���Ҵµ� �� ã���� ���� �߻�
	    String errMessage = String.format("���� �߻�: ���¹�ȣ %s�� �ش��ϴ� ���¸� ã�� �� �����ϴ�.", accountNumber);
	    throw new AccountNotFoundException(errMessage);
	}
	
	public void deposit(String accountNumber, double balance) throws AccountNotFoundException{
		Account account = findAccount(accountNumber);
		
		account.deposit(balance);
		
	}
	
	public void withdraw(String accountNumber, double balance) throws AccountNotFoundException, InsufficientBalanceException{
		Account account = findAccount(accountNumber);
		account.withdraw(balance);
	}
	
	public void transfer(String fromAccount, String toAccount, double balance) throws AccountNotFoundException, InsufficientBalanceException{
		Account faccount = findAccount(fromAccount);
		Account taccount = findAccount(toAccount);
		
		faccount.withdraw(balance);
		taccount.deposit(balance);
		System.out.println(balance+ "����"+fromAccount+"����"+toAccount+"�� �۱޵Ǿ����ϴ�.");
		
	}
	public void printAllAccounts() {
		for (Account account : this.accounts) {
	        System.out.println(account.toString());
	        
	    }
	}

}
