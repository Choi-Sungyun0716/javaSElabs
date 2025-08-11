package assignment.bank.exception;

public class WithdrawalLimitExceededException extends InsufficientBalanceException {
	public WithdrawalLimitExceededException(String errMessage) {
		super(errMessage);
	}

}
