package assignment.bank.entity;

import assignment.bank.exception.InsufficientBalanceException;
import assignment.bank.exception.WithdrawalLimitExceededException;

public class CheckingAccount extends Account {
	private double withdrawalLimit;
	
	public CheckingAccount(String accountNumber, String ownerName, double balance, double withdrawalLimit) {
		super(accountNumber, ownerName, balance);
		this.withdrawalLimit = withdrawalLimit;
	}
	
	public double getWithdrawalLimit() {
		return withdrawalLimit;
	}
	@Override
	public void withdraw(double amount) throws InsufficientBalanceException {
	  
	    if (amount > withdrawalLimit) {
	        throw new WithdrawalLimitExceededException("예외 발생: 출금 한도를 초과했습니다. 한도: " + withdrawalLimit + "원");
	    }

	   
	    super.withdraw(amount);
	}
	@Override
	public String toString() {
		return String.format("계좌번호: %s, 소유자: %s, 잔액: %.2f원, 출금한도: %.2f원",
        		getAccountNumber() ,getOwnerName(), getBalance(), this.withdrawalLimit);

	}

}
