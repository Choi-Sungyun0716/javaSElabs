package workshop.account.control;

import workshop.account.entity.Account;
import workshop.account.exception.InsufficientBalanceException;

public class AccountTest {

	public static void main(String[] args) {

		// 1번 기본생성자와 setter 사용
		Account acount = new Account();
		// 고객번호 : “A1100”, 계좌번호 : “221-22-3477”, 잔액 : 100000
		acount.setCustId("A1100");
		acount.setAcctId("221-22-3477");
		acount.deposit(1000);
		
		System.out.println("고객번호" + acount.getCustId());
		System.out.println("계좌번호" + acount.getAcctId());
		System.out.println("잔액" + acount.getBalance());

		// 2번 생성자를 사용하여 초기화
		Account acount2 = new Account("B1100", "331-33-3477", 2000);
		System.out.println("고객번호" + acount2.getCustId());
		System.out.println("계좌번호" + acount2.getAcctId());
		System.out.println("잔액" + acount2.getBalance());
		
		System.out.println("10000원 입금");
		acount2.deposit(10000);
		System.out.println("잔액" + acount2.getBalance());
		
		
		try {
			acount2.withdraw(10000);
			System.out.println("10000원 출금");
			System.out.println("잔액" + acount2.getBalance());
			
			System.out.println("5000원 출금");
			acount2.withdraw(5000);
			System.out.println("잔액" + acount2.getBalance());
			
		} catch (InsufficientBalanceException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		
	}
}
