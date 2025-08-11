package assignment.bank.control;

import assignment.assignment1.student.exception.InvalidGradeException;
import assignment.bank.entity.*;
import assignment.bank.exception.*;

public class BankDemo {
    public static void main(String[] args) {
        Bank bank = new Bank();

        System.out.println("=== ���� ���� ===");
        System.out.println(bank.createSavingsAccount("ȫ�浿", 10000.0, 3.0));
        System.out.println(bank.createCheckingAccount("��ö��", 20000.0, 5000.0));
        System.out.println(bank.createSavingsAccount("�̿���", 30000.0, 2.0));
        System.out.println();

        System.out.println("=== ��� ���� ��� ===");
        bank.printAllAccounts();
        System.out.println("===================\n");

        System.out.println("=== �Ա�/��� �׽�Ʈ ===");
       
        try {
        	bank.deposit("AC1000", 5000);
        	
        	
        } catch (AccountNotFoundException e) {
			System.out.println(e.getMessage());
		}
        
        try {
        	bank.withdraw("AC1001", 3000);
  
        } catch (InsufficientBalanceException | AccountNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
        
        
        System.out.println("=== ���� ���� �׽�Ʈ ===");
        
        try {
        	SavingsAccount sa = (SavingsAccount) bank.findAccount("AC1002");
   
        	System.out.println("���ڰ� ����Ǿ����ϴ�. ���� �� �ܾ�:"+ sa.getBalance());
        	sa.applyInterst();
        	System.out.println("���� �� �ܾ�:"+ sa.getBalance());
        } catch ( AccountNotFoundException e) {
			System.out.println(e.getMessage());
		}
      
        System.out.println();

        
        
        
        
        System.out.println("=== ���� ��ü �׽�Ʈ ===");
        try {
            bank.transfer("AC1002", "AC1001", 5000.0);
        } catch (InsufficientBalanceException | AccountNotFoundException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();

        
        
        
        
        System.out.println("=== ��� ���� ��� ===");
        bank.printAllAccounts();
        System.out.println("===================\n");

        // ���� �׽�Ʈ
        try {
            bank.findAccount("AC1001").withdraw(6000.0);
        } catch (InsufficientBalanceException | AccountNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            bank.transfer("AC1001", "AC1000", 6000.0);
        } catch (InsufficientBalanceException | AccountNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            bank.findAccount("AC9999");
        } catch (AccountNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
