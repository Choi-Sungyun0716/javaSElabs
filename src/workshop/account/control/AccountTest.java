package workshop.account.control;

import workshop.account.entity.Account;
import workshop.account.exception.InsufficientBalanceException;

public class AccountTest {

	public static void main(String[] args) {

		// 1�� �⺻�����ڿ� setter ���
		Account acount = new Account();
		// ����ȣ : ��A1100��, ���¹�ȣ : ��221-22-3477��, �ܾ� : 100000
		acount.setCustId("A1100");
		acount.setAcctId("221-22-3477");
		acount.deposit(1000);
		
		System.out.println("����ȣ" + acount.getCustId());
		System.out.println("���¹�ȣ" + acount.getAcctId());
		System.out.println("�ܾ�" + acount.getBalance());

		// 2�� �����ڸ� ����Ͽ� �ʱ�ȭ
		Account acount2 = new Account("B1100", "331-33-3477", 2000);
		System.out.println("����ȣ" + acount2.getCustId());
		System.out.println("���¹�ȣ" + acount2.getAcctId());
		System.out.println("�ܾ�" + acount2.getBalance());
		
		System.out.println("10000�� �Ա�");
		acount2.deposit(10000);
		System.out.println("�ܾ�" + acount2.getBalance());
		
		
		try {
			acount2.withdraw(10000);
			System.out.println("10000�� ���");
			System.out.println("�ܾ�" + acount2.getBalance());
			
			System.out.println("5000�� ���");
			acount2.withdraw(5000);
			System.out.println("�ܾ�" + acount2.getBalance());
			
		} catch (InsufficientBalanceException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		
	}
}
