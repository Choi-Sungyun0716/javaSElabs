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
		return String.format("저축 계좌가 생성되었습니다. 계좌번호: %s, 소유자: %s, 잔액: %.2f, 이자율: %.2f%%",
				savingsAccount.getAccountNumber(), savingsAccount.getOwnerName(), savingsAccount.getBalance(),
				savingsAccount.getInterestRate());
	}

	public String createCheckingAccount(String ownerName, double balance, double withdrawalLimit) {
		String accountNumber = String.format("AC%d", this.nextAccountNumber);
		this.nextAccountNumber += 1;
		CheckingAccount checkingAccount = new CheckingAccount(accountNumber, ownerName, balance, withdrawalLimit);
		accounts.add(checkingAccount);

		return String.format("체크 계좌가 생성되었습니다. 계좌번호: %s, 소유자: %s, 잔액: %.2f, 출금 한도: %.2f원",
				checkingAccount.getAccountNumber(), checkingAccount.getOwnerName(), checkingAccount.getBalance(),
				checkingAccount.getWithdrawalLimit());
	}

	public Account findAccount(String accountNumber) throws AccountNotFoundException {
	    for (Account account : this.accounts) {
	        if (account.getAccountNumber().equals(accountNumber)) {
	            return account;
	        }
	    }
	    // for문 다 돌았는데 못 찾으면 예외 발생
	    String errMessage = String.format("예외 발생: 계좌번호 %s에 해당하는 계좌를 찾을 수 없습니다.", accountNumber);
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
		System.out.println(balance+ "원이"+fromAccount+"에서"+toAccount+"로 송급되었습니다.");
		
	}
	public void printAllAccounts() {
		for (Account account : this.accounts) {
	        System.out.println(account.toString());
	        
	    }
	}

}
