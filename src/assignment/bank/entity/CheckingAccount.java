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
	        throw new WithdrawalLimitExceededException("���� �߻�: ��� �ѵ��� �ʰ��߽��ϴ�. �ѵ�: " + withdrawalLimit + "��");
	    }

	   
	    super.withdraw(amount);
	}
	@Override
	public String toString() {
		return String.format("���¹�ȣ: %s, ������: %s, �ܾ�: %.2f��, ����ѵ�: %.2f��",
        		getAccountNumber() ,getOwnerName(), getBalance(), this.withdrawalLimit);

	}

}
