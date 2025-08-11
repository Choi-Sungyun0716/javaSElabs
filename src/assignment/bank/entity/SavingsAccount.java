package assignment.bank.entity;

public class SavingsAccount extends Account {
	private double interestRate;
	
	
	public SavingsAccount(String accountNumber, String ownerName, double balance, double interestRate) {
		super(accountNumber, ownerName, balance);
		this.interestRate = interestRate;
	}
	
	public double getInterestRate() {
		return interestRate;
	}
	
	public void applyInterst() {
		double interestAmount = getBalance() * (interestRate/100);
		super.deposit(interestAmount);
	}

	@Override
	public String toString() {
	        return String.format("계좌번호: %s, 소유자: %s, 잔액: %.2f원, 이자율: %.2f %%",
	        		getAccountNumber() ,getOwnerName(), getBalance(), this.interestRate);
	}

}
